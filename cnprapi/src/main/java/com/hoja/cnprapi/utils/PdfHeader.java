package com.hoja.cnprapi.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfHeader extends PdfPageEventHelper {

	private String footerText;
//    @Override
//    public void onEndPage(PdfWriter writer, Document document) {
//        try {
//            Rectangle pageSize = document.getPageSize();
//            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format("Page %s", String.valueOf(writer.getCurrentPageNumber()))),
//                    pageSize.getRight(30), pageSize.getTop(30), 0);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//	public void onStartPage(PdfWriter writer, Document document) {
//		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Top Left"), 30, 800, 0);
//		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Top Right"), 550, 800,
//				0);
//	}

	public void onEndPage(PdfWriter writer, Document document) {
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(9.0f);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(footerText, font), 200,
				30, 0);
		//ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT,new Phrase("page " + document.getPageNumber()), 630, 30, 0);
	}

	public PdfHeader(String footerText) {
		super();
		this.footerText = footerText;
	}
}
