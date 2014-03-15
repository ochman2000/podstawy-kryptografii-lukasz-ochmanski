package des;

import java.math.BigInteger;

public class Driver {
	
	public static void main(String[] args) {
		
		String mHex = "0123456789ABCDEF";
		String kHex = "133457799BBCDFF1";
		byte[] kBits = {
				0,0,0,1,0,0,1,1,	0,0,1,1,0,1,0,0,	0,1,0,1,0,1,1,1,	0,1,1,1,1,0,0,1,
				1,0,0,1,1,0,1,1,	1,0,1,1,1,1,0,0,	1,1,0,1,1,1,1,1,	1,1,1,1,0,0,0,1};
		BitSet key = BitSet.valueOfBits(kBits);

		new Encoder().step1(key);
	}
}
