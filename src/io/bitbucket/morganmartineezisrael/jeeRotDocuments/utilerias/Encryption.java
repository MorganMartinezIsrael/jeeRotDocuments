package io.bitbucket.morganmartineezisrael.jeeRotDocuments.utilerias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encryption {
		
	
	private static Character arrayAlphabet[] = {'a','á','ä','b','c','d','e','é','ë','f','g','h','i','í','ï','j','k','l','m','n','ñ','o','ó','ö','p','q','r','s','t','u','ú','ü','v','w','x','y','z'};
	private static String alfabeto = "aáäbcdeéëfghiíïjklmnñoóöpqrstuúüvwxyz";
	
	private static ArrayList<Character> listAlphabet = new ArrayList<Character>(Arrays.asList(arrayAlphabet));
	
	
	public Encryption() {}
	
	public static String rot13Encryption(String param) {
		String wordNotEncrypted = param;
		String wordEncrypted = "";
		char letter = ' ';
		char newLetter = ' ';
		int contador = 0;
		if(param == null || param.isEmpty() || param.contentEquals(" ")) {
			return wordEncrypted;
		}else {
			for(int index=0;index< wordNotEncrypted.length();index++) {
				letter = param.charAt(index);
				String str = String.valueOf(Character.toLowerCase(letter));
				if(str.matches("[aáäbcdeéëfghiíïjklmnñoóöpqrstuúüvwxyz]")) {
					contador = listAlphabet.indexOf(Character.toLowerCase(letter));
					contador +=13;
					System.out.println("Contador value is : " + contador);
					if(contador >= alfabeto.length()) {
						contador = contador - (alfabeto.length());
						//System.out.println("Greater than now contador has : " + contador);
						newLetter = alfabeto.charAt(contador);
					}else {
						newLetter = alfabeto.charAt(contador);
					}
					
					if(Character.isLowerCase(letter)) {
						newLetter = Character.toLowerCase(newLetter);
					}else if(Character.isUpperCase(letter)) {
						newLetter = Character.toUpperCase(newLetter);
					}
					//System.out.println("newLetter added is: " + newLetter);
					wordEncrypted+=(String.valueOf(newLetter));
				}else {
					wordEncrypted+= (String.valueOf(letter));
				}
				
			}
		}
		
		return wordEncrypted;
		
		
	}
}

