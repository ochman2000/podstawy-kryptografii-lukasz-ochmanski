package pl.lodz.p.pk;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encoder {

	private static final int CHUNK_SIZE = 64;
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
		if (msg.bitLength()>(CHUNK_SIZE*8))
			throw new BigIntegerLengthException(msg);
		else
			return msg.modPow(klucz.getA(), klucz.getN());
	}
	
	public BigInteger deszyfruj(BigInteger msg, Key klucz) throws BigIntegerLengthException {
		if (msg.bitLength()>(CHUNK_SIZE*8))
			throw new BigIntegerLengthException(msg);
		else
			return msg.modPow(klucz.getA(), klucz.getN());
	}

	private byte[] szyfrujKawałek(byte[] msg, Key kluczPubliczny) {
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
	

	public Szyfrogram szyfruj(byte[] msg, Key kluczPubliczny) {
		int chunk = CHUNK_SIZE-1;
		Szyfrogram s = new Szyfrogram();
		for (int i=0; i<msg.length; i+=chunk) {
			int	to = ((i+chunk)<msg.length) ? i+chunk : msg.length;
			byte[] kawałek = Arrays.copyOfRange(msg, i, to);
			byte[] zaszyfrowanyKawałek = szyfrujKawałek(kawałek, kluczPubliczny);
			s.add(zaszyfrowanyKawałek);
		}
		return s;
	}
	
	public byte[] deszyfruj(Szyfrogram s, Key kluczPrywatny) {
		ArrayList<Byte> encrypted = new ArrayList<Byte>();
		ArrayList<Byte[]> szyfrogram = s.getSzyfrogram();
		for (Byte[] kawałek : szyfrogram) {
			byte[] a = new byte[kawałek.length];
			for (int i=0; i<a.length; i++) {
				a[i]=kawałek[i];
			}
			
			byte[] d = deszyfrujKawałek(a, kluczPrywatny);
			encrypted.addAll(toByteArray(d));
		}
		return toByteArray(encrypted);
	}
	
	private byte[] deszyfrujKawałek(byte[] msg, Key kluczPrywatny) {
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
	
	public static byte[] toByteArray(List<Byte> in) {
	    final int n = in.size();
	    byte ret[] = new byte[n];
	    for (int i = 0; i < n; i++) {
	        ret[i] = in.get(i);
	    }
	    return ret;
	}
	
	public static List<Byte> toByteArray(byte[] in) {
	    final int n = in.length;
	    List<Byte> ret = new ArrayList<Byte>();
	    for (int i = 0; i < n; i++) {
	        ret.add(in[i]);
	    }
	    return ret;
	}
}