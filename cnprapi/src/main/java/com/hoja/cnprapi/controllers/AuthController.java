package com.hoja.cnprapi.controllers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CandidatSubscription;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.models.PrixTypePermisAutoEcole;
import com.hoja.cnprapi.models.ViewUser;
import com.hoja.cnprapi.repository.ViewUserRepository;
import com.hoja.cnprapi.services.AutoEcoleServiceImpl;
import com.hoja.cnprapi.services.CandidatServiceImpl;
import com.hoja.cnprapi.services.CandidatSubscriptionServiceImpl;
import com.hoja.cnprapi.services.EmailService;
import com.hoja.cnprapi.services.PrixPermisTypeAutoEcoleServiceImpl;
import com.hoja.cnprapi.utils.PdfHeader;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/api")
public class AuthController {

	@Autowired
    private EmailService emailService;
	
	@Autowired
	ViewUserRepository vwUserRepo;

	@Autowired
	CandidatServiceImpl candidatService;
	
	@Autowired
	CandidatSubscriptionServiceImpl candidatSubscriptionService;
	
	@Autowired
	PrixPermisTypeAutoEcoleServiceImpl prixTypeAutoEcoleServiceImpl;

	@Autowired
	AutoEcoleServiceImpl autoEcoleServiceImpl;

	@PostMapping("/auth")
	public ResponseEntity<ViewUser> createAutoEcole(@RequestBody ViewUser login) {
		// bcrypted password 12345=?
		// $2a$10$YmXE9lJhYOi7xt9CGISPeuR1XWtBdmFTeYaP/7UZ6Sj8HDgfE3nxy
		// List<ViewUser> foundUserList =
		// vwUserRepo.findByusernameAndEnabled(login.getUsername(),true);
		List<ViewUser> foundUserList = vwUserRepo.findByusername(login.getUsername());
		// System.out.println("Found user list size : "+foundUserList.size());
		if (foundUserList.size() > 0) {

			ViewUser successLogin = foundUserList.get(0);
			return new ResponseEntity<>(successLogin, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/subscribe")
	public ResponseEntity<Candidat> subscribe(@RequestBody Candidat candidat, HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			
			boolean candaidatExist = candidatService.findCandidatByPhoneNumber(candidat.getPhone());
			if(candaidatExist) {
				
				candidat = new Candidat();
				candidat.setPhone("exists");
			}else {
				System.out.println("auto ecole id : "+candidat.getCnprAutoEcole().getId());
				CnprAutoEcole autoEcole = autoEcoleServiceImpl.getAutoEcoleById(1);
				// CnprAutoEcole autoEcole = new CnprAutoEcole();
				// autoEcole.setId(1);
				
				candidat.setCnprAutoEcole(autoEcole);
				candidat.setLieuNaissance("Na");

				CnprUser user = new CnprUser();
				user.setId(3);
				candidat.setCreatedBy(user);

//				Candidat candidat = candidatService.getCandidatById(id);
//				candidat.setRecyclageValide(true);

				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				String currentDateTime = dateFormatter.format(new Date());

				LocalDate currentdate = LocalDate.now();
				Month currentMonth = currentdate.getMonth();

				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);

				String codeUnique = "" + year;// 202521133656
				String times = "" + currentMonth.getValue() + day + hour + min + sec;
				codeUnique = autoEcole.getCodeUnique() + "-" + year + candidatService.shuffleString(times);
				candidat.setReference(codeUnique);

				Candidat registeredCandidat = this.candidatService.saveOrUpdateCandidat(candidat);
				
				List<PrixTypePermisAutoEcole> listPrixPermis = prixTypeAutoEcoleServiceImpl.getSingleActivePrixTypePermisAutoEcoleByTypePermisAndAutoEcole(registeredCandidat.getCnprAutoEcole().getId(), candidat.getTypePermisId()); 
				PrixTypePermisAutoEcole prixTypePermis = listPrixPermis.get(0);
				
				CandidatSubscription candidatSubscription = new CandidatSubscription();
				candidatSubscription.setMontantAPayer(prixTypePermis.getPrix());
				candidatSubscription.setDevise(prixTypePermis.getDevise());
				candidatSubscription.setPaymentStatus(false);
				candidatSubscription.setCandidat(registeredCandidat);
				
				
				candidatSubscriptionService.saveOrUpdateCandidatSubscription(candidatSubscription);
				

				session.setAttribute("monCodeUnique", candidat.getReference());
				//session.setAttribute("ajaxData", "Some data from AJAX response");
			}
//			
			return new ResponseEntity<>(candidat, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	 @PostMapping("/send")
	    public String sendEmail(@RequestParam String to, 
	                            @RequestParam String subject, 
	                            @RequestParam String body) {
	        emailService.sendEmail(to, subject, body);
	        return "Email sent successfully!";
	    }

	@CrossOrigin(origins = "*")
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadPdf(@RequestParam String key) throws DocumentException, IOException{
		try {
			Candidat candidat = candidatService.findCandidatByCodeUnique(key).get();
			
			//List<PrixTypePermisAutoEcole> prixTypePermisAutoEcoleList = prixTypeAutoEcoleServiceImpl.getSingleActivePrixTypePermisAutoEcoleByTypePermisAndAutoEcole(candidat.getCnprAutoEcole().getId(),candidat.get);
			
			List<Candidat> candidatList  = new ArrayList<Candidat>();
			candidatList.add(candidat);
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document(PageSize.A4.rotate());
			PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
			PdfHeader event = new PdfHeader(
					"COMMISSION NATIONALE DE PREVENTION ROUTIERE");
			writer.setPageEvent(event);

			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			document.open();

			String currDir = "";

			String os = System.getProperty("os.name").toLowerCase();
			if (os.contains("win")) {
				// Operating system is based on Windows
				currDir = "/cnpr/logo/cnpr.png";

//    				Image To_be_Added = Image.getInstance(currDir);
//    				// To_be_Added.setAbsolutePosition(0f, 0f);
//    				To_be_Added.setAlignment(Image.RIGHT);
//    				To_be_Added.scaleAbsolute(75, 75);
				//
//    				 To_be_Added.setAlignment(Image.RIGHT | Image.TEXTWRAP);
//    				 To_be_Added.setBorder(Image.BOX);
//    				 To_be_Added.setBorderWidth(15);
				//
//    				document.add(To_be_Added);
			}

			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(33f);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.setWidths(new float[] { 10.0f });
			table.setSpacingAfter(30);

			PdfPCell cell = null;
			font.setSize(10);

			Image img = Image.getInstance(currDir);
			img.setAlignment(Image.ALIGN_LEFT);//
			img.scaleAbsolute(50f, 50f);
			cell = new PdfPCell(img);
			// cell.setVerticalAlignment(Element.ALIGN_RIGHT);
			// cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(0);
			table.addCell(cell);

			document.add(table);

			//////////////////
			font.setSize(14);
			Paragraph p = new Paragraph("BORDEREAU DE PAIEMENT", font);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(p);

			font.setSize(12);
			p = new Paragraph("------------------------", font);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(p);

			table = new PdfPTable(1);
			table.setWidthPercentage(33f);
			cell = new PdfPCell(new Phrase("Client : "+candidat.getNom()+" "+candidat.getPostnom()+" "+candidat.getPrenom(), font));
			// cell.setVerticalAlignment(Element.ALIGN_RIGHT);
			// cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(0);
			table.addCell(cell);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.setWidths(new float[] { 10.0f });
			table.setSpacingBefore(20);

			document.add(table);
			
			table = new PdfPTable(3);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 3f, 3f, 3f});
			table.setSpacingBefore(10);

			writeTableHeader(table);
			writeTableData(table,candidatList);

			document.add(table);
			
			document.add(new Paragraph("* Veuillez vous rendre avec ce bordereau dans l'un de nos points de paiement pour payer le montant.", font));
			document.add(new Paragraph("* Kende na mukanda oyo na bisika na biso pona ko futa mbongo.", font));
			
			String qrText = candidat.getReference();
			Image qrImage = generateQRCodeImage(qrText, 200, 200);
			
			document.add(qrImage);
			
			document.close();

			// Convert to byte array
			byte[] pdfBytes = byteArrayOutputStream.toByteArray();

			// Set response headers
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bordereau_"+candidat.getReference()+".pdf");
			headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	public void writeTableHeader(PdfPTable table) {

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(9.0f);
		PdfPCell cell = new PdfPCell();
		// cell.setBackgroundColor(Color.BLUE);
		// cell.setPadding(5);

		/////////////////////////////////////////////////////////////

		// font.setColor(Color.WHITE);

		cell = new PdfPCell();
		cell.setPhrase(new Phrase("REFERENCE", font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
	
		cell = new PdfPCell();
		cell.setPhrase(new Phrase("MONTANT A PAYER", font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell();
		cell.setPhrase(new Phrase("STATUT DE PAIEMENT", font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table, List<Candidat> list) {
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(9.0f);
		PdfPCell cell = null;
		long count = 1;
		for (Candidat maj : list) {

			cell = new PdfPCell();
			cell.setPhrase(new Phrase(maj.getReference()));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			
			cell = new PdfPCell();
			cell.setPhrase(new Phrase("30.000 FC", font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell();
			cell.setPhrase(new Phrase("En attente", font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			count++;
		}
	}

	private static Image generateQRCodeImage(String text, int width, int height) 
            throws WriterException, IOException, BadElementException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        // Convert BitMatrix to BufferedImage
        BufferedImage qrBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                qrBufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }

        // Convert BufferedImage to ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(qrBufferedImage, "png", baos);
        byte[] qrImageData = baos.toByteArray();

        // Convert ByteArray to iText Image
        return Image.getInstance(qrImageData);
    }
}
