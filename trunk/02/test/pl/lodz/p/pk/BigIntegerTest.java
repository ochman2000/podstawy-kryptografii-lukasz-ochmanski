package pl.lodz.p.pk;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

public class BigIntegerTest {
	
	@Test
	public void test01() {
		String s= "1";
		for (int i = 1; i < 1000; i++) {
			BigInteger bigint = new BigInteger(s);
			s=s+"1";
			System.out.println("1. Liczba znaków: \t"+s.length()+"\tBitLength: "
					+bigint.bitLength()+"\tbitCount(): "+bigint.bitCount());
		}		
	}
	
	@Test
	public void test02() {
		byte[] a = {1};
		for (int i=1; i<1000; i++) {
			a= new byte[i];
			byte val = 1;
			Arrays.fill(a, val);
			BigInteger bigint = new BigInteger(a);
			System.out.println("2. Liczba bajtów: \t"+a.length+"\tBitLength: "
					+bigint.bitLength()+"\tbitCount(): "+bigint.bitCount());
		}
	}
	
	@Test
	public void test03() {
		byte[] a = {1};
		for (int i=1; i<1000; i++) {
			a= new byte[i];
			byte val = 1;
			Arrays.fill(a, val);
			BigInteger bigint = new BigInteger(a);
			int len = bigint.toString(2).length();
			System.out.println("3. Liczba bajtów: \t"+a.length+"\tLiczba znaków: "
				+len);
		}
	}
	
}
