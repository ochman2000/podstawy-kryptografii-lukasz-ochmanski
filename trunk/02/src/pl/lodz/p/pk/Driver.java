package pl.lodz.p.pk;

public class Driver {
	
	public static void main(String[] args) {
		
		new MainFrame();

		//A MESSAGE
		String tekst = "01234567";

		RSAKey klucz  = new RSAKey();
		System.out.println("Klucz prywatny: "+ klucz.getPrywatny());
		System.out.println("Klucz publiczny: "+ klucz.getPubliczny());

	}
}
