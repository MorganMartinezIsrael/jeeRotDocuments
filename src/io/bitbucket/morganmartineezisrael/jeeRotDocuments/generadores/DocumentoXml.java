package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;




public final class DocumentoXml {
	public static String generateXml(String plainText, String cyphText) {
		StringBuffer documento = new StringBuffer();
		documento.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		documento.append("<ROT13>");
		documento.append("<texto>");
		documento.append("<textoplano>" + plainText + "</textoplano>");
		documento.append("<textocifrado>"+ cyphText + "</textocifrado>");
		documento.append("</texto>");
		documento.append("</ROT13>");
		
		return documento.toString();
	}
}