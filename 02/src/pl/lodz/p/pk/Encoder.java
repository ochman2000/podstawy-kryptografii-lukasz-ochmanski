package pl.lodz.p.pk;

import java.math.BigInteger;
import java.util.Collections;

public class Encoder {

	public static Debug LEVEL = Debug.LEVEL1;

	public Encoder() {

	}

	public BigInteger szyfruj(BigInteger msg, Key klucz) {
		return msg.modPow(klucz.getA(), klucz.getN());
	}
	
	public BigInteger deszyfruj(BigInteger msg, Key klucz) {
		return msg.modPow(klucz.getA(), klucz.getN());
	}

	public byte[] szyfruj(byte[] msg, Key kluczPubliczny) {
		msg = padArray(msg);
		BigInteger bigint = new BigInteger(msg);
		bigint = szyfruj(bigint, kluczPubliczny);		
		return bigint.toByteArray();
	}
	
	public byte[] deszyfruj(byte[] msg, Key kluczPrywatny) {
		BigInteger bigint = new BigInteger(msg);
		bigint = deszyfruj(bigint, kluczPrywatny);		
		return unpadArray(bigint.toByteArray());
	}
	
	public String szyfruj(String msg, Key kluczPubliczny) {
		BigInteger kryptogr = new BigInteger(msg.getBytes());
		kryptogr = szyfruj(kryptogr, kluczPubliczny);
		return kryptogr.toString(16);
	}
	
	public String deszyfruj(String msg, Key kluczPrywatny) {
		BigInteger kryptogr = new BigInteger(msg, 16);
		kryptogr = deszyfruj(kryptogr, kluczPrywatny);
		return new String(kryptogr.toByteArray());
	}
	
	public byte[] padArray(byte[] a) {
		byte[] padded = new byte[a.length+1];
		System.arraycopy(a, 0, padded, 1, a.length);
		padded[0] = 1;
		return padded;
	}
	
	public byte[] unpadArray(byte[] padded) {
		byte[] a = new byte[padded.length-1];
		System.arraycopy(padded, 1, a, 0, a.length);
		return a;
	}
}