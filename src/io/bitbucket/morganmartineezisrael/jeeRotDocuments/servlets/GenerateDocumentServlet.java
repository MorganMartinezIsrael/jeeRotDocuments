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
		PrintWriter out = response.getWriter();
		
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
			System.out.println("formato csv solicitado");
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "inline; filename=\"encrip.csv\"");
			// response.setHeader("Content-Disposition", "attachment; filename=\"libros.csv\"");
			out.println(DocumentoCsv.generateCsv(inputText, textEncrypted));
			break;
		case "xml":
			System.out.println("formato xml solicitado");
			response.setContentType("application/xml");
			response.setHeader("Content-Disposition", "inline; filename=\"encrip.xml\"");
			// response.setHeader("Content-Disposition", "attachment; filename=\"libros.xml\"");
			out.println(DocumentoXml.generateXml(inputText, textEncrypted));
			break;
		case "json":
			System.out.println("formato json solicitado");
			response.setContentType("application/json");
			response.setHeader("Content-Disposition", "inline; filename=\"encrip.json\"");
			// response.setHeader("Content-Disposition", "attachment; filename=\"libros.json\"");
			out.println(DocumentoJson.genarateJson(inputText, textEncrypted));
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
