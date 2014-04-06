package pl.lodz.p.pk;

import java.math.BigInteger;

import pl.lodz.p.tewi.Auxx;

public class Encoder {

	public static Debug LEVEL = Debug.LEVEL1;

	public Encoder() {
		
		
	}
	
	public BigInteger[] szyfruj(byte[] message, Key klucz) {
		int liczbaZnakow = klucz.getLiczbaZnakow();
		int chunks = message.length / liczbaZnakow;
		BigInteger[] szyfrogram = new BigInteger[chunks];
		for (int i = 0; i < chunks; i++) {
			int from = liczbaZnakow*i;
			int to = liczbaZnakow*(i + 1);
			byte[] pom = Auxx.podtablica(message, from, to);
			szyfrogram[i] = new BigInteger(1, pom);
			szyfrogram[i] = szyfrogram[i].modPow(klucz.getA(), klucz.getN());
		}
		return szyfrogram;
	}
	
    public BigInteger[] decryptToBigInt(BigInteger[] cipher, Key klucz) 
    {
      BigInteger[] wynik = new BigInteger[cipher.length];
      for (int i = 0; i < cipher.length; i++) 
          wynik[i] = cipher[i].modPow(klucz.getA(), klucz.getN());
      return wynik;
    }
}