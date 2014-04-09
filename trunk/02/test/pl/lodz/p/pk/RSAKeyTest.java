package pl.lodz.p.pk;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;

public class RSAKeyTest {

	@Test
	public void test01() {
		BigInteger tekst = new BigInteger("2345");

		RSAKey klucz = new RSAKey();
//		System.out.println("Klucz prywatny: " + klucz.getPrywatny());
//		System.out.println("Klucz publiczny: " + klucz.getPubliczny());

//		System.out.println("Plain tekst: " + tekst);

		Encoder en = new Encoder();
		BigInteger szyfrogram = null;
		try {
			szyfrogram = en.szyfruj(tekst, klucz.getPrywatny());
		} catch (BigIntegerLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Zaszyfrowany:  " + szyfrogram.toString());

		BigInteger plainTekst = null;
		try {
			plainTekst = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		} catch (BigIntegerLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Odszyfrowany: " + plainTekst);
		
		assertTrue("Dla "+tekst+" nie zgadza się.", tekst.equals(plainTekst));
	}
	
	@Test
	public void test02() {
		BigInteger tekst = new BigInteger("2");
		
		byte[] pośredni = tekst.toByteArray();
		BigInteger tekst2 = new BigInteger(pośredni);
		assertTrue(tekst.toString()+".equals("+tekst2.toString()+")", tekst.equals(tekst2));
	}
	
	@Test
	public void test03() {

		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();
//		System.out.println("Klucz prywatny: "+ klucz.getPrywatny());
//		System.out.println("Klucz publiczny: "+ klucz.getPubliczny());
		
		byte[] tekst1b = "HAHAHA".getBytes(Charset.defaultCharset());
//		String tekst = Arrays.toString(tekst1b);
//		System.out.println("Plain tekst: "+ tekst);
		
		byte[] szyfrogram = en.szyfruj(tekst1b, klucz.getPrywatny());
//		System.out.println("Zaszyfrowany:  "+ Arrays.toString(szyfrogram));
		
		byte[] tekst2b = en.deszyfruj(szyfrogram, klucz.getPubliczny());
//		String tekst2 = Arrays.toString(tekst2b);
//		System.out.println("Odszyfrowany: "+ tekst2);
		
		assertTrue(tekst1b+".equals("+tekst2b+")", Arrays.equals(tekst1b, tekst2b));
	}
	
	@Test
	public void test04() {

		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();
//		System.out.println("Klucz prywatny: "+ klucz.getPrywatny());
//		System.out.println("Klucz publiczny: "+ klucz.getPubliczny());
		
		String tekst1 = "HAHHAH";
//		System.out.println("Plain tekst: "+ tekst1);
		
		String szyfrogram = en.szyfruj(tekst1, klucz.getPrywatny());
//		System.out.println("Zaszyfrowany:  "+ szyfrogram);
		
		String tekst2 = en.deszyfruj(szyfrogram, klucz.getPubliczny());
//		System.out.println("Odszyfrowany: "+ tekst2);
		
		assertTrue(tekst1+".equals("+tekst2+")", tekst1.equals(tekst2));
	}
	
	@Test
	public void test05() {
		String msg = "ABCD";
		BigInteger kryptogr = new BigInteger(msg.getBytes());
		String bigint = new String(kryptogr.toByteArray()); 
		assertTrue(bigint, bigint.equals(msg));
	}
	
	@Test
	public void test06() {		
        byte[] msg = {0,1,2,3,4};
		BigInteger bigint = new BigInteger(1, msg);	
		String a = Arrays.toString(msg);
		String b = Arrays.toString(bigint.toByteArray());
//		System.out.println("A: "+a);
//		System.out.println("B: "+bigint.toString(2));
//		System.out.println("B: "+b);
		assertFalse(b, a.equals(b));
	}
	
	@Test
	public void test07() {		
        byte[] msg = {-1,1,1,2,3,4};
		BigInteger bigint = new BigInteger(msg);	
		String a = Arrays.toString(msg);
		String b = Arrays.toString(bigint.toByteArray());
		assertTrue(b, a.equals(b));
	}
	
	@Test
	public void test08() {		
        byte[] msg = {1,2,3,4,0};
		BigInteger bigint = new BigInteger(msg);	
		String a = Arrays.toString(msg);
		String b = Arrays.toString(bigint.toByteArray());
		assertTrue(b, a.equals(b));
	}
	
	@Test
	public void test09() {
		
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

        //PRZEPROCESUJ
        byte[] msg = dane;
		BigInteger bigint = new BigInteger(msg);	
		String a = Arrays.toString(dane);
		String b = Arrays.toString(bigint.toByteArray());
//		System.out.println("A: "+a);
//		System.out.println("B: "+b);
		assertFalse(a.equals(b));
	}
	
	@Test
	public void test10() {
		
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

        //PRZEPROCESUJ
        byte[] msg = dane;
		BigInteger bigint = new BigInteger(msg);
		byte[] bytes = bigint.toByteArray();
		byte[] padded = new byte[bytes.length+1];
		System.arraycopy(bytes, 0, padded, 1, bytes.length);
		padded[0] = dane[0];

		String a = Arrays.toString(dane);
		String b = Arrays.toString(padded);

//		System.out.println("B: "+b);
		assertTrue(a.equals(b));
	}
	
	@Test
	public void test11() {
		byte[] a = new byte[] {0,1,2,3,4};
		Encoder en = new Encoder();
		byte[] b = en.padArray(a);
//		String a1 = Arrays.toString(a);
		String b1 = Arrays.toString(b);
//		System.out.println("A: "+a1);
//		System.out.println("padded: "+b1);
		
		byte[] c = {1,0,1,2,3,4};
		String c1 = Arrays.toString(c);
		assertTrue(b1.equals(c1));	
	}
	
	@Test
	public void test12() {
		byte[] a = new byte[] {0,1,2,3,4};
		Encoder en = new Encoder();
		byte[] b = en.unpadArray(a);
//		String a1 = Arrays.toString(a);
		String b1 = Arrays.toString(b);
//		System.out.println("A: "+a1);
//		System.out.println("unpadded: "+b1);
		
		byte[] c = {1,2,3,4};
		String c1 = Arrays.toString(c);
		assertTrue(b1.equals(c1));
	}
	
	@Test
	public void test13() {
		
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

        //PRZEPROCESUJ
		Encoder en = new Encoder();
        byte[] msg = en.padArray(dane);
		BigInteger bigint = new BigInteger(msg);	
		String a = Arrays.toString(dane);
		String b = Arrays.toString(en.unpadArray(bigint.toByteArray()));
//		System.out.println("A: "+a);
//		System.out.println("B: "+b);
		assertTrue(a.equals(b));
	}
	
	@Test
	public void test14() {
		
		byte[] dane = new byte[] {-128,-3,-2,-1,0,1,2,3,4};

		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();		
		
		String a = Arrays.toString(dane);
//		System.out.println("A: "+a);
		
		byte[] szyfrogram = en.szyfruj(dane, klucz.getPrywatny());
//		String b = Arrays.toString(szyfrogram);
//		System.out.println("B: "+b);
		
		byte[] dane2 = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		String c = Arrays.toString(dane2);
//		System.out.println("C: "+c);
				
		assertTrue(a.equals(c));
	}
	
	@Test
	public void test15() {
		
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

		Encoder en = new Encoder();
		RSAKey klucz  = new RSAKey();		
		
		String a = Arrays.toString(dane);
		System.out.println("A: "+a);
		
		byte[] szyfrogram = en.szyfruj(dane, klucz.getPrywatny());
//		String b = Arrays.toString(szyfrogram);
//		System.out.println("B: "+b);
		
		byte[] dane2 = en.deszyfruj(szyfrogram, klucz.getPubliczny());
		String c = Arrays.toString(dane2);
		System.out.println("C: "+c);
				
		assertTrue(a.equals(c));
	}
}
