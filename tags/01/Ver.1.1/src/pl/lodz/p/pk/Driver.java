package pl.lodz.p.pk;



public class Driver {
	
	public static void main(String[] args) {
		
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "01234567";

		Encoder encoder = new Encoder();
		String szyfr = encoder.encrypt(key, tekst);
		
		tekst = encoder.decrypt(key, szyfr);		
	}
}
