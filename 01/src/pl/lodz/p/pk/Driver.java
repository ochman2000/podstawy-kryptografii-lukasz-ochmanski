package pl.lodz.p.pk;



public class Driver {
	
	public static void main(String[] args) {
		
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "0123456789ABCDEF";

		
		Encoder encoder = new Encoder();
		tekst = encoder.encrypt(key, tekst);
		
		
	}
	
}
