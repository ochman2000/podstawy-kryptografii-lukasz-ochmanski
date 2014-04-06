package pl.lodz.p.pk;

import static org.junit.Assert.assertTrue;

public class Driver {
	
	public static void main(String[] args) {
		
		new MainFrame();

		//A MESSAGE
		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();
		System.out.println("Klucz prywatny: "+ klucz.getPrywatny());
		System.out.println("Klucz publiczny: "+ klucz.getPubliczny());
		
		String tekst1 = "HAHHAH";
		System.out.println("Plain tekst: "+ tekst1);
		
		String szyfrogram = en.szyfruj(tekst1, klucz.getPrywatny());
		System.out.println("Zaszyfrowany:  "+ szyfrogram);
		
		String tekst2 = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		System.out.println("Odszyfrowany: "+ tekst2);
		
		assertTrue(tekst1+".equals("+tekst2+")", tekst1.equals(tekst2));
		
	}
}
