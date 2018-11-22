package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;

public final class DocumentoCsv {

	public static String generateCsv(String plainText, String cyphText) {
		StringBuffer documento = new StringBuffer();		
		
		documento.append("texto plano, texto cifrado");
		documento.append(""+plainText + "," + cyphText);
		
		return documento.toString();
	}
}
