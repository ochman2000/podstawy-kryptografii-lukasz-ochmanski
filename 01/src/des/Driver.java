package des;

import java.math.BigInteger;

public class Driver {
	
	public static void main(String[] args) {
		
		String mHex = "0123456789ABCDEF";
		String kHex = "133457799BBCDFF1";
		BitSet key = BitSet.valueOfHex(kHex);
		BigInteger key2 = new BigInteger(kHex, 16);
		System.out.println(key2.toString(2));
//		Input input = new Input();
//		input.setHexText(mHex);
//		System.out.println(key.getHexRepresentation());
		System.out.println(key.getBitRepresentation());
//		Output output = Utils.encode(input, key);

		new Encoder().step1(key);
	}
}
