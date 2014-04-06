package pl.lodz.p.pk;

import java.math.BigInteger;

public class Driver {
	
	public static void main(String[] args) {
		
		new MainFrame();

		//A MESSAGE
		String tekst = "1";

		RSAKey klucz  = new RSAKey();
		System.out.println("Klucz prywatny: "+ klucz.getPrywatny());
		System.out.println("Klucz publiczny: "+ klucz.getPubliczny());

		Encoder en = new Encoder();
		BigInteger[] szyfrogram = en.szyfruj(tekst.getBytes(), klucz.getPrywatny());
		System.out.println("Plain tekst: "+ tekst);
		
		BigInteger[] tekstb = new BigInteger[] {new BigInteger(tekst)};
		System.out.println("Plain tekst: "+ tekstb);
		
		System.out.println("Szyfrogram:  "+ szyfrogram.toString());
		
		BigInteger[] plainTekst = en.decryptToBigInt(szyfrogram, klucz.getPubliczny());
		System.out.println("Odszyfrowany: "+ plainTekst);
		
	}
}
