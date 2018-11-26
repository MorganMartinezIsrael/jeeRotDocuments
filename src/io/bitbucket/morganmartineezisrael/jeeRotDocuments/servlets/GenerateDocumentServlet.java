package io.bitbucket.morganmartineezisrael.jeeRotDocuments.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoCsv;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoJson;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoPdf;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoXlsx;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoXml;

/**
 * Servlet implementation class GenerateDocumentServlet
 */
@WebServlet("/GenerateDocumentServlet")
public class GenerateDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateDocumentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		
		
		String inputText = request.getParameter("input-hidden-plain");
		String textEncrypted = request.getParameter("input-hidden-encript");
		//format
    	String formatoSolicitado = request.getParameter("formato");
		if (formatoSolicitado == null) {
			formatoSolicitado = "";
			System.out.println("formato null");
		}
		
		//data
		switch (formatoSolicitado) {
		case "csv":
			PrintWriter outCsv = response.getWriter();
			System.out.println("formato csv solicitado");
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "inline; filename=\"encrip.csv\"");
			// response.setHeader("Content-Disposition", "attachment; filename=\"libros.csv\"");
			outCsv.println(DocumentoCsv.generateCsv(inputText, textEncrypted));
			break;
		case "xml":
			System.out.println("formato xml solicitado");
			String textaux = inputText;
	    	for(int i = 0; i<textaux.length();){
				if(inputText.charAt(i) == '<'){
					inputText = inputText.replace("<", "&lt");
					textEncrypted = textEncrypted.replace("<", "&lt");
					System.out.println("has an < character!");
					System.out.println("now word is: " + textEncrypted);
					i+=2;
				}else if(inputText.charAt(i) == '>'){
					inputText = inputText.replace(">", "&gt");
					textEncrypted = textEncrypted.replace(">", "&gt");
					i+=2;
				}else if(inputText.charAt(i) == '&'){
					inputText = inputText.replace("&", "&amp");
					textEncrypted = textEncrypted.replace("&", "&amp");
					i+=3;
				}
			}
	    	PrintWriter outXml = response.getWriter();
			response.setContentType("application/xml");
			response.setHeader("Content-Disposition", "inline; filename=\"encrip.xml\"");
			// response.setHeader("Content-Disposition", "attachment; filename=\"libros.xml\"");
			outXml.println(DocumentoXml.generateXml(inputText, textEncrypted));
			break;
		case "json":
			System.out.println("formato json solicitado");
			PrintWriter outJson = response.getWriter();
			response.setContentType("application/json");
			response.setHeader("Content-Disposition", "inline; filename=\"encrip.json\"");
			// response.setHeader("Content-Disposition", "attachment; filename=\"libros.json\"");
			outJson.println(DocumentoJson.genarateJson(inputText, textEncrypted));
			break;
			
		case "pdf":
			DocumentoPdf.generatePdf(response, inputText, textEncrypted);
			break;
			
		case "xlsx":
			DocumentoXlsx.generateXls(response, inputText, textEncrypted);
			break;
		default:
			System.out.println("Nothing");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
