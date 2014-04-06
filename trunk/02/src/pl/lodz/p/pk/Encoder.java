package pl.lodz.p.pk;

import java.math.BigInteger;

import pl.lodz.p.tewi.Auxx;

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

	public BigInteger[] decryptToBigInt(BigInteger[] cipher, Key klucz) {
		BigInteger[] wynik = new BigInteger[cipher.length];
		for (int i = 0; i < cipher.length; i++)
			wynik[i] = cipher[i].modPow(klucz.getA(), klucz.getN());
		return wynik;
	}
}