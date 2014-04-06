package pl.lodz.p.pk;

import java.math.BigInteger;

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
		BigInteger bigint = new BigInteger(msg);
		bigint = szyfruj(bigint, kluczPubliczny);		
		return bigint.toByteArray();
	}
	
	public byte[] deszyfruj(byte[] msg, Key kluczPrywatny) {
		BigInteger bigint = new BigInteger(msg);
		bigint = deszyfruj(bigint, kluczPrywatny);		
		return bigint.toByteArray();
	}
	
	public String szyfruj(String msg, Key kluczPubliczny) {
		BigInteger kryptogr = new BigInteger(1, msg.getBytes());
		kryptogr = szyfruj(kryptogr, kluczPubliczny);
		return kryptogr.toString(16);
	}
	
	public String deszyfruj(String msg, Key kluczPrywatny) {
		BigInteger kryptogr = new BigInteger(msg, 16);
		kryptogr = deszyfruj(kryptogr, kluczPrywatny);
		return new String(kryptogr.toByteArray());
	}
}