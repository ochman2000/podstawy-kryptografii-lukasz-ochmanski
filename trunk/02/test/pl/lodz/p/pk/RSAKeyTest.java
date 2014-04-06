package pl.lodz.p.pk;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;

public class RSAKeyTest {

	@Test
	public void test() {
		BigInteger tekst = new BigInteger("2345");

		RSAKey klucz = new RSAKey();
//		System.out.println("Klucz prywatny: " + klucz.getPrywatny());
//		System.out.println("Klucz publiczny: " + klucz.getPubliczny());

//		System.out.println("Plain tekst: " + tekst);

		Encoder en = new Encoder();
		BigInteger szyfrogram = en.szyfruj(tekst, klucz.getPrywatny());
//		System.out.println("Zaszyfrowany:  " + szyfrogram.toString());

		BigInteger plainTekst = en.deszyfruj(szyfrogram, klucz.getPubliczny());
//		System.out.println("Odszyfrowany: " + plainTekst);
		
		assertTrue("Dla "+tekst+" nie zgadza się.", tekst.equals(plainTekst));
	}
	
	@Test
	public void test2() {
		BigInteger tekst = new BigInteger("2");
		
		byte[] pośredni = tekst.toByteArray();
		BigInteger tekst2 = new BigInteger(pośredni);
		assertTrue(tekst.toString()+".equals("+tekst2.toString()+")", tekst.equals(tekst2));
	}
	
	@Test
	public void test3() {

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
		String tekst2 = Arrays.toString(tekst2b);
//		System.out.println("Odszyfrowany: "+ tekst2);
		
		assertTrue(tekst1b+".equals("+tekst2b+")", Arrays.equals(tekst1b, tekst2b));
	}
	
	@Test
	public void test4() {

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
	public void test5() {
		String msg = "ABCD";
		BigInteger kryptogr = new BigInteger(1, msg.getBytes());
		String bigint = new String(kryptogr.toByteArray()); 
		assertTrue(bigint, bigint.equals(msg));
	}
}
