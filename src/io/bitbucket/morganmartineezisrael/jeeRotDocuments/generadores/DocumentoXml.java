package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;




public final class DocumentoXml {
	public static String generateXml(String plainText, String cyphText) {
		StringBuffer documento = new StringBuffer();
		documento.append("<texto>");
		documento.append("<textoplano>" + plainText + "</textoplano>");
		documento.append("<textocifrado>"+ cyphText + "</textocifrado>");
		documento.append("</texto>");
		
		return documento.toString();
	}
}