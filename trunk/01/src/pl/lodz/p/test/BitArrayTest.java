package pl.lodz.p.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.lodz.p.pk.BitArray;

public class BitArrayTest {

	@Test
	public void testBitArrayByte() {
		BitArray ba = new BitArray((byte)1);
		boolean condition = ba.getBitRepresentation().equals("00000001");
		assertTrue(ba.getBitRepresentation(), condition);
	}

	@Test
	public void testBitArrayByteArray() {
		byte[] a = {1,1};
		BitArray ba = new BitArray(a);
		boolean condition = ba.getBitRepresentation(8).equals("00000001 00000001");
		assertTrue(ba.getBitRepresentation(8), condition);
	}

	@Test
	public void testToByteArray01() {
		byte[] a = {0,4,3,2,1};
		BitArray ba = new BitArray(a);
		byte[] b = ba.toByteArray();
		assertTrue(""+b[0], a[0]==b[0]);
	}
	
	@Test
	public void testToByteArray02() {
		byte[] a = {4,3,2,1};
		BitArray ba = new BitArray(a);
		byte[] b = ba.toByteArray();
		assertTrue(""+b[1], a[1]==b[1]);
	}
	
	@Test
	public void testToByteArray03() {
		byte[] a = {4,3,2,1};
		BitArray ba = new BitArray(a);
		byte[] b = ba.toByteArray();
		assertTrue(""+b[2], a[2]==b[2]);
	}
	
	@Test
	public void testToByteArray04() {
		byte[] a = {0,4,3,127,1,0,0};
		BitArray ba = new BitArray(a);
		byte[] b = ba.toByteArray();
		assertTrue(""+b[3], a[3]==b[3]);
	}

}
