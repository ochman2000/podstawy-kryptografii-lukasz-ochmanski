package pl.lodz.p.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pl.lodz.p.pk.BitArray;
import pl.lodz.p.pk.Encoder;
import pl.lodz.p.tewi.Auxx;

public class EncryptTest {

	@Test
	public void test01() {
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "01234567";

		Encoder encoder = new Encoder();
		String szyfr = encoder.encrypt(key, tekst);
		assertTrue(szyfr.equalsIgnoreCase("6CBD22858BCEDB79"));
	}
	
	@Test
	public void test02() {

		int[] kBits = {
				0,0,0,1,0,0,1,1,	0,0,1,1,0,1,0,0,	0,1,0,1,0,1,1,1,	0,1,1,1,1,0,0,1,
				1,0,0,1,1,0,1,1,	1,0,1,1,1,1,0,0,	1,1,0,1,1,1,1,1,	1,1,1,1,0,0,0,1};

		int[] mBits = {
				0,0,0,0,0,0,0,1,	0,0,1,0,0,0,1,1,	0,1,0,0,0,1,0,1,	0,1,1,0,0,1,1,1,
				1,0,0,0,1,0,0,1,	1,0,1,0,1,0,1,1,	1,1,0,0,1,1,0,1,	1,1,1,0,1,1,1,1};
		
		BitArray klucz = new BitArray(kBits);
		BitArray tekst = new BitArray(mBits);

		Encoder encoder = new Encoder();
		String kod = encoder.encodeBlock(klucz, tekst).getHexRepresentation();
		assertTrue(kod.equalsIgnoreCase("85E813540F0AB405"));
	}
	
	@Test
	public void test03() {

		String kHex = "133457799BBCDFF1";
		String mHex = "0123456789ABCDEF";
		
		byte[] key = Auxx.hexToBytes(kHex);
		BitArray klucz = new BitArray(key);

		byte[] msg = Auxx.hexToBytes(mHex);
		BitArray tekst = new BitArray(msg);
		
		Encoder encoder = new Encoder();
		encoder.encodeBlock(klucz, tekst);
		
		String kod = encoder.encodeBlock(klucz, tekst).getHexRepresentation();
		assertTrue(kod.equalsIgnoreCase("85E813540F0AB405"));
	}
	
	@Test
	public void test04() {
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "A";

		Encoder encoder = new Encoder();
		String szyfr = encoder.encrypt(key, tekst);
		assertTrue(szyfr.equalsIgnoreCase("024C142A621E999E"));
	}
	
	@Test
	public void test05() {
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "123456789";

		Encoder encoder = new Encoder();
		String szyfr = encoder.encrypt(key, tekst);
		assertTrue(szyfr.equalsIgnoreCase("8B96B79529CCA21830948DABF73EA8A0"));
	}
	
	@Test
	public void test10() {
		//A KEY
		String key = "133457799BBCDFF1";
		
		//A MESSAGE
		String tekst = "6CBD22858BCEDB79";

		Encoder encoder = new Encoder();

		
		byte[] data = tekst.getBytes();

		byte[] szyfr = encoder.decrypt(key, data);
		
		byte[] data2 = encoder.encrypt(key, szyfr);


		assertTrue("Równa się.", Arrays.equals(data, data2));
	}
}
