package pl.lodz.p.pk;

import java.math.BigInteger;

public class Driver {
	
	public static void main(String[] args) {
		
		new MainFrame();

		//A MESSAGE
		BigInteger tekst = new BigInteger("2345");
		

		RSAKey klucz  = new RSAKey();
		System.out.println("Klucz prywatny: "+ klucz.getPrywatny());
		System.out.println("Klucz publiczny: "+ klucz.getPubliczny());

		System.out.println("Plain tekst: "+ tekst);
		
		Encoder en = new Encoder();
		BigInteger szyfrogram = en.szyfruj(tekst, klucz.getPrywatny());
		System.out.println("Zaszyfrowany:  "+ szyfrogram.toString());
		
		BigInteger plainTekst = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		System.out.println("Odszyfrowany: "+ plainTekst);
		
	}
}
