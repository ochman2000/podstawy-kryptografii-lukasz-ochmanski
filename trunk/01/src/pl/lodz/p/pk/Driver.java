package pl.lodz.p.pk;

import java.util.Arrays;

import pl.lodz.p.tewi.Auxx;
import pl.lodz.p.tewi.DES;
import pl.lodz.p.tewi.DES.DESKeyException;



public class Driver {
	
	public static void main(String[] args) {
		
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "01234567";
		System.out.println(Arrays.toString(tekst.getBytes()));

		Encoder encoder = new Encoder();
//		String szyfr = encoder.encrypt(key, tekst);
//		tekst = encoder.decrypt(key, szyfr);
		
		byte[] data = tekst.getBytes();
		byte[] szyfr = encoder.encrypt(key, data);
		System.out.println("Moja metoda:");
		System.out.println(Arrays.toString(szyfr));
		
		DES des = new DES();
		try {
			des.setKeyHex(key);
		} catch (DESKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		szyfr = des.encode(data);
		System.out.println("Tewi:");
		System.out.println(Arrays.toString(szyfr));	
	}
}
