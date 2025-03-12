package com.hoja.cnprapi.utils;

import com.hoja.cnprapi.models.Candidat;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
public class PdfUtilsBordereau {

	private List<Candidat> majList;
	private String title;
	private String departenement;
	private String typeMaj;

	public PdfUtilsBordereau(List<Candidat> majList, String title, String departenement,
			String typeMaj) {
		// super();
		this.majList = majList;
		this.title = title;
		this.departenement = departenement;
		this.typeMaj = typeMaj;

	}

	private void writeTableHeader(PdfPTable table) {

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(9.0f);
		PdfPCell cell = new PdfPCell();
		// cell.setBackgroundColor(Color.BLUE);
		// cell.setPadding(5);


		/////////////////////////////////////////////////////////////

		// font.setColor(Color.WHITE);

		cell = new PdfPCell();
		cell.setPhrase(new Phrase("REFERENCE.", font));
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

	private void writeTableData(PdfPTable table) {
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(9.0f);
		PdfPCell cell = null;
		long count = 1;
		for (Candidat maj : majList) {

			cell = new PdfPCell();
			cell.setPhrase(new Phrase(maj.getReference()));
			table.addCell(cell);

			cell = new PdfPCell();
			cell.setPhrase(new Phrase("10.000 FC", font));
			table.addCell(cell);

			cell = new PdfPCell();
			cell.setPhrase(new Phrase("En attente", font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			
			count++;
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document(PageSize.A4.rotate());
			PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
			PdfHeader event = new PdfHeader(
					"COMMISSION NATIONALE DE PREVENTION ROUTIERE * REPUBLIQUE DEMOCRATIQUE DU CONGO");
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
			Paragraph p = new Paragraph("COMMISSION NATION DE PREVENTION ROUTIERE (CNPR)", font);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(p);

			font.setSize(12);
			p = new Paragraph("------------------------", font);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(p);

			table = new PdfPTable(1);
			table.setWidthPercentage(33f);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.setWidths(new float[] { 10.0f });
			table.setSpacingBefore(20);

			document.add(table);
			
			table = new PdfPTable(3);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 3f, 3f, 3f});
			table.setSpacingBefore(10);

			writeTableHeader(table);
			writeTableData(table);

			document.add(table);
			
			document.add(new Paragraph("Hello, this is a generated PDF using iText 5.5!"));
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	public static ByteArrayOutputStream generatePdfStream(List<Map<String, Object>> queryResults)
//			throws DocumentException {
//		Document document = new Document();
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		PdfWriter.getInstance(document, outputStream);
//		document.open();
//		// Write column names
//		Map<String, Object> firstRow = queryResults.get(0);
//		for (String column : firstRow.keySet()) {
//			Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//			Paragraph paragraph = new Paragraph(column, boldFont);
//			document.add(paragraph);
//		}
//		document.add(new Paragraph("\n"));
//		// Write data rows
//		for (Map<String, Object> row : queryResults) {
//			for (Object value : row.values()) {
//				Paragraph paragraph = new Paragraph(value.toString());
//				document.add(paragraph);
//			}
//			document.add(new Paragraph("\n"));
//		}
//		document.close();
//		return outputStream;
//	}
}
