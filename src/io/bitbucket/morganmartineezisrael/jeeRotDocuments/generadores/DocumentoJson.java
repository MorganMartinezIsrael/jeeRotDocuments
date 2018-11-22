package io.bitbucket.morganmartineezisrael.jeeRotDocuments.generadores;

import java.util.List;



public final class DocumentoJson {
	public static String genarateJson(String plainText, String cyphText) {
		StringBuffer documento = new StringBuffer();
		
		documento.append("{");
		documento.append("\"Textoplano\": ");
		documento.append(""+plainText + ",");
		documento.append("\"Textocifrado\": ");
		documento.append(""+cyphText);
		documento.append("}");
		
		return documento.toString();
	}
}

