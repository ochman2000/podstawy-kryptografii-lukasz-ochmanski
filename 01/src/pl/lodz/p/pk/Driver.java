package pl.lodz.p.pk;

public class Driver {
	
	public static void main(String[] args) {
		
		new MainFrame();
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "01234567";

		Encoder encoder = new Encoder();
//		String szyfr = encoder.encrypt(key, tekst);
//		tekst = encoder.decrypt(key, szyfr);
		
		byte[] data = tekst.getBytes();
//		System.out.println(Arrays.toString(data));
		
		byte[] szyfr = encoder.encrypt(key, data);
//		System.out.println("Moja metoda:");
//		System.out.println(Arrays.toString(szyfr));
		
		data = encoder.decrypt(key, szyfr);
//		System.out.println(Arrays.toString(data));

	}
}
