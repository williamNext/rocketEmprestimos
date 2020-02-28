package br.com.compasso.rocketEmprestimos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografador {

	public static String gerarHashMD5(String texto) {
		return stringHexa(gerarHash(texto, "MD5"));
	}
	
	private static byte[] gerarHash(String texto, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(texto.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	private static String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			
			if (parteAlta == 0) {
				s.append('0');
			}

			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		
		return s.toString();
	}

}
