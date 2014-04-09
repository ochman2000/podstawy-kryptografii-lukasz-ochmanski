package pl.lodz.p.pk;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class EncoderTest {

	private byte[] getBytes(int i) {
		byte[] dane = null;
		try {
		    FileInputStream fis = new FileInputStream("out\\picture.jpg");
	        int ileWPliku = fis.available();
	        dane = new byte[ileWPliku];
			fis.read(dane);
	        fis.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		return Arrays.copyOf(dane, i);
	}
	
	@Test
	public void test01() {
		byte[] dane = getBytes(63);
		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();		
		
		String a = Arrays.toString(dane);
//		System.out.println("A: "+a);
		
		Szyfrogram szyfrogram = en.szyfruj(dane, klucz.getPrywatny());
//		String b = Arrays.toString(szyfrogram);
//		System.out.println("B: "+b);
		
		byte[] dane2 = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		String c = Arrays.toString(dane2);
//		System.out.println("C: "+c);
				
		assertTrue(a.equals(c));
		
	}
	
	@Test
	public void test02() {
		byte[] dane = getBytes(64);
		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();		
		
		String a = Arrays.toString(dane);
		System.out.println("A: "+a);
		
		Szyfrogram szyfrogram = en.szyfruj(dane, klucz.getPrywatny());
//		String b = Arrays.toString(szyfrogram);
//		System.out.println("B: "+b);
		
		byte[] dane2 = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		String c = Arrays.toString(dane2);
		System.out.println("C: "+c);
				
		assertTrue(a.equals(c));
		
	}
	

}
