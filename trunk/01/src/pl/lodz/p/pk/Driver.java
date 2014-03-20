package pl.lodz.p.pk;



public class Driver {
	
	public static void main(String[] args) {
		
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "0123456789ABCDEF";

		
		Encoder encoder = new Encoder();
		String szyfr = encoder.encrypt(key, tekst);
		
		tekst = encoder.decrypt(key, szyfr);
		
	}
	
}
