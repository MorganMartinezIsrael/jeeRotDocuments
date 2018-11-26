package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


public class DocumentoPdf {
	public static void generatePdf(HttpServletResponse response, String inputText, String textEncrypted)
			throws IOException {

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=encrypted.pdf");
		ServletOutputStream salida = response.getOutputStream();
		PdfDocument archivoPdf = new PdfDocument(new PdfWriter(salida));
		
		Document documentoPdf = new Document(archivoPdf);

		String in = inputText;
		String en = textEncrypted;
		documentoPdf.add(new Paragraph("Texto plano: " + inputText).add("  Texto encriptado: "+ textEncrypted));
		documentoPdf.close();
		
		salida.close();
	}
}
