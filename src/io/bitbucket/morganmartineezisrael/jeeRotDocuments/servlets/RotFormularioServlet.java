package io.bitbucket.morganmartineezisrael.jeeRotDocuments.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoCsv;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoHtml;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoJson;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores.DocumentoXml;
import io.bitbucket.morganmartineezisrael.jeeRotDocuments.utilerias.Encryption;



/**
 * Servlet implementation class RotFormularioServlet
 */
@WebServlet(
			urlPatterns= {
					"/RotFormularioServlet",
					"/index.html"
			}
		)
public class RotFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String inputStringGlobal;
    private String textEncryptedGlobal;
public void displayForm(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	//Configure response
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	
    	//Define objects 
    	PrintWriter out = response.getWriter();
    	StringBuffer htmlDocument = new StringBuffer();
    	
    	//Add html format
    	htmlDocument.append("<!DOCTYPE html>");
    	htmlDocument.append("<html>");
    	htmlDocument.append("<head>");
    	htmlDocument.append("<meta charset=\"UTF-8\">");
    	htmlDocument.append("<title>ROT Formulario</title>");
    	htmlDocument.append("</head");
    	
    	htmlDocument.append("<body>");
    	htmlDocument.append("<div class=\"contenedor-principal\">");
    	htmlDocument.append("<h1>Encryptar texto plano</h1>");
    	htmlDocument.append("<hr>");
    	htmlDocument.append("<form method=\"POST\" action=\"RotFormularioServlet\" class=\"formulario\">");
    	htmlDocument.append("<fiedset>");
    	htmlDocument.append("<div>");
        //htmlDocument.append("<label for=\"input-texto-plano\">Texto plano</label>");
        htmlDocument.append("<textarea id=\"input-texto-plano\" name=\"input-texto-plano\" ");
        htmlDocument.append("value=\"\" placeholder=\"Escriba el texto aqui\"></textarea>");
        htmlDocument.append("</div>");
        htmlDocument.append("<div>");
       
        htmlDocument.append("<button type=\"submit\" id=\"submit-button\" name=\"submit-button\" value=\"submit button\">Convertir</button>");
    	htmlDocument.append("</fielset>");
    	htmlDocument.append("</form>");
    	htmlDocument.append("</div>");
    	htmlDocument.append("</body");
    	htmlDocument.append("</html>");
    	
    	
    	//out html
    	out.println(htmlDocument.toString());
    }
    
    
    public void processForm(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	//Configure response
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	
    	//Define objects
    	PrintWriter out = response.getWriter();
    	StringBuffer htmlDocument = new StringBuffer();
    	
    	//Add html format
    	htmlDocument.append("<!DOCTYPE html>");
    	htmlDocument.append("<html>");
    	htmlDocument.append("<head>");
    	htmlDocument.append("<meta charset=\"UTF-8\">");
    	htmlDocument.append("<title>Rot</title>");
    	htmlDocument.append("</head");
    	
    	
    	String inputText = request.getParameter("input-texto-plano");
    	String textEncrypted = Encryption.rot13Encryption(inputText); 
    	
    	System.out.println("Input text: " + inputText);
    	System.out.println("Text processed : " + textEncrypted);
    	
    	htmlDocument.append("<body>");
    	
    	if(textEncrypted.equals("")) {
    		htmlDocument.append("<h3>Please enter text</h3>");
    	}else {
    		//same form
	    	htmlDocument.append("<div class=\"contenedor-principal\">");
	    	htmlDocument.append("<form method=\"POST\" action=\"RotFormularioServlet\" class=\"formulario\">");
	    	htmlDocument.append("<fiedset>");
	    	htmlDocument.append("<div>");
	        //htmlDocument.append("<label for=\"input-texto-plano\">Texto plano</label>");
	        htmlDocument.append("<textarea  id=\"input-texto-plano\" name=\"input-texto-plano\" ");
	        htmlDocument.append("value=\""+ inputText +"\""+ "placeholder=\"Escriba texto aqui\" >"+ inputText+"</textarea>");
	        htmlDocument.append("</div>");
	        htmlDocument.append("<button type=\"submit\" id=\"submit-button\" name=\"submit-button\" value=\"submit button\">Convertir</button>");
	        htmlDocument.append("<div>");
	        //htmlDocument.append("<label for=\"input-texto-encryptado\">Texto encryptado</label>");
	        htmlDocument.append("<textarea id=\"input-texto-encryptado\" name=\"input-texto-encryptado\" ");
	        htmlDocument.append("value=\""+textEncrypted+ "\""+" placeholder=\"Escriba texto aqui\" >"+textEncrypted+"</textarea>");
	        htmlDocument.append("</div>");
	    	htmlDocument.append("</fielset>");
	    	htmlDocument.append("</form>");
	    	
	    	//links as buttons inside forms
	    	htmlDocument.append("<form method=\"POST\" action=\"GenerateDocumentServlet?formato=csv\" class=\"formularioButton\">");
	    	htmlDocument.append("<input type=\"hidden\" name=\"input-hidden-plain\" value=\""+inputText+ "\""+ ">");
	    	htmlDocument.append("<input type=\"hidden\" name=\"input-hidden-encript\" value=\""+textEncrypted+ "\""+ ">");
	    	htmlDocument.append("<button type=\"submit\" id=\"submit-button-csv\" name=\"submit-button-csv\" value=\"submit button\">CSV</button>");
	    	htmlDocument.append("</form>");
	    	
	    	
	    	htmlDocument.append("<form method=\"POST\" action=\"GenerateDocumentServlet?formato=xml\" class=\"formularioButton\">");
	    	htmlDocument.append("<input type=\"hidden\" name=\"input-hidden-plain\" value=\""+inputText+ "\""+ ">");
	    	htmlDocument.append("<input type=\"hidden\" name=\"input-hidden-encript\" value=\""+textEncrypted+ "\""+ ">");
	    	htmlDocument.append("<button type=\"submit\" id=\"submit-button-csv\" name=\"submit-button-xml\" value=\"submit button\">XML</button>");
	    	htmlDocument.append("</form>");
	    	
	    	htmlDocument.append("<form method=\"POST\" action=\"GenerateDocumentServlet?formato=json\" class=\"formularioButton\">");
	    	htmlDocument.append("<input type=\"hidden\" name=\"input-hidden-plain\" value=\""+inputText+ "\""+ ">");
	    	htmlDocument.append("<input type=\"hidden\" name=\"input-hidden-encript\" value=\""+textEncrypted+ "\""+ ">");
	    	htmlDocument.append("<button type=\"submit\" id=\"submit-button-csv\" name=\"submit-button-xml\" value=\"submit button\">JSON</button>");
	    	htmlDocument.append("</form>");
	    	
	        
    	}
			
    	htmlDocument.append("<hr>");
    	htmlDocument.append("<a href=\"/pw02/RotFormularioServlet\">Nuevo.</>");
    	htmlDocument.append("</div>");	
    	htmlDocument.append("</body>");
    	htmlDocument.append("</html>");
    	
    	//out
    	out.println(htmlDocument.toString());
    	
    	
    }
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       
				
		
				// TODO Auto-generated method stub
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				this.displayForm(request, response);
							
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processForm(request, response);
	}

}
