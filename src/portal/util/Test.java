package portal.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {

	public static void main(String[] args) {
		System.out.println(getMD5String("ROOTROOT"));
	}
	
	public static String getMD5String(String texto) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(texto.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			return number.toString(16).toUpperCase();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
