package des;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {

		// create 2 BigInteger objects
		BigInteger bi1, bi2;

		// assign value to bi1
		bi1 = new BigInteger("8");// 1000

		// perform flipbit operation on bi1 with index 1
		bi2 = bi1.flipBit(3);

		String str = "Flipbit operation on " + bi1 + " 00001000 at index 3 gives " + bi2;

		// print bi2 value
		System.out.println(str);

		// assign value to bi1
		bi1 = new BigInteger("8");// 1000

		// perform flipbit operation on bi1 with index 1
		bi2 = bi1.setBit(3);

		str = "Setbit operation on " + bi1 + "00001000 at index 3 gives " + bi2;

		// print bi2 value
		System.out.println(str);

		// assign value to bi1
		bi1 = new BigInteger("8");// 1000

		// perform flipbit operation on bi1 with index 1
		bi2 = bi1.clearBit(3);

		str = "Clearbit operation on " + bi1 + "00001000 at index 3 gives " + bi2;

		// print bi2 value
		System.out.println(str);
	}
}