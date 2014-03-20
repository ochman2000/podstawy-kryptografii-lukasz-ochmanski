package pl.lodz.p.pk;


public class Driver {
	
	public static void main(String[] args) {
		
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "AAAAA";

		
		Encoder encoder = new Encoder();
		tekst = encoder.encrypt(key, tekst);
		System.out.println(tekst);
		
	}
	
}
