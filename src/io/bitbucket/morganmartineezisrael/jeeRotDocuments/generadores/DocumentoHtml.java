package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;

public final class DocumentoHtml {

	public static String deError() {
		StringBuffer documento = new StringBuffer();
		
		documento.append("<!DOCTYPE html>");
		documento.append("<html>");
		documento.append("<head>");
		documento.append("<meta charset=\"UTF-8\">");
		documento.append("<title>ServletSerializacionDatosTextoPlano</title>");
		documento.append("<link rel=\"stylesheet\" href=\"assets/css/normalize.css\">");
		documento.append("<link rel=\"stylesheet\" href=\"assets/css/main.css\">");
		documento.append("</head>");
		documento.append("<body>");
		documento.append("<div class=\"contenedor\">");
		documento.append("<div class=\"cabecera\">");
		documento.append("<h1>ServletSerializacionDatosTextoPlano</h1>");
		documento.append("</div>");
		documento.append("<div class=\"menu\">");
		documento.append("<ul>");
		documento.append("<li><a href=\".\">Inicio</a></li>");
		documento.append("</ul>");
		documento.append("</div>");
		documento.append("<div class=\"cuerpo\">");
		documento.append("<p><strong>¡El formato solicitado no es reconocido!</strong></p>");
		documento.append("</div>");
		documento.append("</div>");
		documento.append("</body>");
		documento.append("</html>");
		
		return documento.toString();
	}
}
