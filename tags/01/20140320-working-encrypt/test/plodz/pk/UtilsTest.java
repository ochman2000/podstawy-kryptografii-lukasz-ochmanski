package plodz.pk;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.lodz.p.pk.Bit;
import pl.lodz.p.pk.Utils;

public class UtilsTest {

	byte b = 8;
	@Test
	public void testGetBitAt0() {
		Bit a = Utils.getBitAt(b, 0);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt1() {
		Bit a = Utils.getBitAt(b, 1);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt2() {
		Bit a = Utils.getBitAt(b, 2);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt3() {
		Bit a = Utils.getBitAt(b, 3);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt4() {
		Bit a = Utils.getBitAt(b, 4);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt5() {
		Bit a = Utils.getBitAt(b, 5);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt6() {
		Bit a = Utils.getBitAt(b, 6);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt7() {
		Bit a = Utils.getBitAt(b, 7);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
	@Test
	public void testGetBitAt8() {
		Bit a = Utils.getBitAt(b, 8);
		assertTrue("Wartość: "+a.getValue(), a.getValue()==0);
	}
}
