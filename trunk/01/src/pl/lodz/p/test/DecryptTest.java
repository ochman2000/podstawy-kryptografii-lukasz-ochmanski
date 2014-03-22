package pl.lodz.p.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import pl.lodz.p.pk.BitArray;
import pl.lodz.p.pk.Encoder;
import pl.lodz.p.tewi.Auxx;
import pl.lodz.p.tewi.DES;
import pl.lodz.p.tewi.DES.DESKeyException;

public class DecryptTest {

	@Test
	public void test05() {
		
		String plainTekst = "01234567";
		String klucz = "133457799BBCDFF1";
		String szyfr = "6CBD22858BCEDB79";
		Encoder encoder = new Encoder();
		
		//A KEY
		String kHex = klucz;
		byte[] kBytes = Auxx.hexToBytes(kHex);

		//A MESSAGE
//		byte[] msg = szyfr.getBytes();
		byte[] msg = Auxx.hexToBytes(szyfr);

		assertTrue(Arrays.toString(msg), true);
	}
	
	@Test
	public void test06() {
		
		String plainTekst = "01234567";
		String klucz = "133457799BBCDFF1";
		String szyfr = "6CBD22858BCEDB79";
		Encoder encoder = new Encoder();
		
		//A KEY
		String kHex = klucz;
		byte[] kBytes = Auxx.hexToBytes(kHex);
		BitArray key = new BitArray(kBytes);
		
		//A MESSAGE
		byte[] msg = Auxx.hexToBytes(szyfr);
		BitArray tekst = new BitArray(msg);

		DES des = new DES();
		try {
			des.setKeyHex(key.getHexRepresentation());
		} catch (pl.lodz.p.tewi.DES.DESKeyException e) {
			e.printStackTrace();
		}
		
		BitArray c = new BitArray(des.decode(msg));
		String wiadomosc = new String(Auxx.hexToBytes(c.getHexRepresentation()));
		assertTrue("", wiadomosc.equalsIgnoreCase(plainTekst));
	}
	
	@Test
	public void test08() {
		
		String msg = "01234567";
		String key = "133457799BBCDFF1";
		String szyfr = "6CBD22858BCEDB79";
		Encoder encoder = new Encoder();
		
		String tekst = encoder.decrypt(key, szyfr);
		assertTrue(tekst, tekst.equalsIgnoreCase(msg));
	}
	
	@Test
	public void test09() {
		
		String msg = "01234567";
		String key = "133457799BBCDFF1";
		String szyfr = "6CBD22858BCEDB79";
		DES des = new DES();
		try {
			des.setKeyHex(key);
		} catch (DESKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] deszyfrogram=des.decode(Auxx.hexToBytes(szyfr));
		String m = new String(deszyfrogram);
		assertTrue(m, msg.equalsIgnoreCase(m));
	}
	
	@Test
	public void test10() {
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "01234567";

		Encoder encoder = new Encoder();
//				String szyfr = encoder.encrypt(key, tekst);
//				tekst = encoder.decrypt(key, szyfr);
		
		byte[] data = tekst.getBytes();
//				System.out.println(Arrays.toString(data));
		
		byte[] szyfr = encoder.encrypt(key, data);
//				System.out.println("Moja metoda:");
//				System.out.println(Arrays.toString(szyfr));
		
		byte[] data2 = encoder.decrypt(key, szyfr);
//				System.out.println(Arrays.toString(data));
		assertTrue("Równa się.", Arrays.equals(data, data2));
	}
}
