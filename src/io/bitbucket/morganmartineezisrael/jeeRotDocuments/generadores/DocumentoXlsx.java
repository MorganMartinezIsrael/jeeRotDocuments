package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DocumentoXlsx {
	public static void generateXls(HttpServletResponse response, String inputText, String textEncrypted)
			throws IOException {
	
		XSSFWorkbook libroTrabajo = new XSSFWorkbook();
		XSSFSheet hoja = libroTrabajo.createSheet("Encriptado");
		
		/* Primera fila */
		int numeroFila = 0;
		XSSFRow fila = hoja.createRow(numeroFila);
		
		String[] cabeceras = {"Plano","Encriptado"};
		int numeroCabecera = 0;
		for (String cabecera : cabeceras) {
			XSSFCell celdaCabecera = fila.createCell(numeroCabecera);
			celdaCabecera.setCellValue(cabecera);
			numeroCabecera += 1;
		}
		
		/* Siguiente fila */
		numeroFila += 1;
		
		
		fila = hoja.createRow(numeroFila);
		fila.createCell(0).setCellValue(inputText);
		fila.createCell(1).setCellValue(textEncrypted);

		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=libros.xlsx");
		ServletOutputStream salida = response.getOutputStream();
		libroTrabajo.write(salida);
		
		libroTrabajo.close();
		
		// salida.close();
		
	}
}
