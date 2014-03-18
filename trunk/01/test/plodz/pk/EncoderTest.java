package plodz.pk;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncoderTest {

	byte b = 8;
	@Test
	public void testGetBitAt0() {
		Bit a = Encoder.getBitAt(b, 0);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt1() {
		Bit a = Encoder.getBitAt(b, 1);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt2() {
		Bit a = Encoder.getBitAt(b, 2);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt3() {
		Bit a = Encoder.getBitAt(b, 3);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt4() {
		Bit a = Encoder.getBitAt(b, 4);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt5() {
		Bit a = Encoder.getBitAt(b, 5);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt6() {
		Bit a = Encoder.getBitAt(b, 6);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt7() {
		Bit a = Encoder.getBitAt(b, 7);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt8() {
		Bit a = Encoder.getBitAt(b, 8);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
}
