package pl.lodz.p.pk;

import java.math.BigInteger;

public class Encoder {

	public static Debug LEVEL = Debug.LEVEL1;

	public Encoder() {

	}

	/**
	 * Tutaj dokonują się wszsytkie obliczenia.
	 * Niestety jednak okazało się, że próba potęgowania liczb większych niż 64 bajty,
	 * kończy się katastrofą. Zatem, należy użyć pętlę i robić to na kawałkach, które,
	 * potem się łączy.
	 * 
	 * @param msg
	 * @param klucz
	 * @return
	 * @throws BigIntegerLengthException 
	 */
	public BigInteger szyfruj(BigInteger msg, Key klucz) throws BigIntegerLengthException {
		if (msg.bitLength()>512)
			throw new BigIntegerLengthException(msg);
		else
			return msg.modPow(klucz.getA(), klucz.getN());
	}
	
	public BigInteger deszyfruj(BigInteger msg, Key klucz) throws BigIntegerLengthException {
		if (msg.bitLength()>512)
			throw new BigIntegerLengthException(msg);
		else
			return msg.modPow(klucz.getA(), klucz.getN());
	}

	public byte[] szyfruj(byte[] msg, Key kluczPubliczny) {
		msg = padArray(msg);
		BigInteger bigint = new BigInteger(msg);
		try {
			bigint = szyfruj(bigint, kluczPubliczny);
		} catch (BigIntegerLengthException e) {
			System.err.println("Błąd podczas szyfrowania: \n"+e.getMessage());
//			e.printStackTrace();
			return null;
		}		
		return bigint.toByteArray();
	}
	

	public byte[] deszyfruj(byte[] msg, Key kluczPrywatny) {
		BigInteger bigint = new BigInteger(msg);
		try {
			bigint = deszyfruj(bigint, kluczPrywatny);
		} catch (BigIntegerLengthException e) {
			System.err.println("Błąd podczas deszyfrowania: \n"+e.getMessage());
//			e.printStackTrace();
			return null;
		}		
		return unpadArray(bigint.toByteArray());
	}

	public String szyfruj(String msg, Key kluczPubliczny) {
		BigInteger kryptogr = new BigInteger(msg.getBytes());
		try {
			kryptogr = szyfruj(kryptogr, kluczPubliczny);
		} catch (BigIntegerLengthException e) {
			System.err.println("Błąd podczas szyfrowania: \n"+e.getMessage());
//			e.printStackTrace();
			return null;
		}
		return kryptogr.toString(16);
	}
	
	public String deszyfruj(String msg, Key kluczPrywatny) {
		BigInteger kryptogr = new BigInteger(msg, 16);
		try {
			kryptogr = deszyfruj(kryptogr, kluczPrywatny);
		} catch (BigIntegerLengthException e) {
			System.err.println("Błąd podczas deszyfrowania: \n"+e.getMessage());
//			e.printStackTrace();
			return null;
		}
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