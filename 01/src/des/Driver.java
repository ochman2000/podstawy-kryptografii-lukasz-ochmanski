package des;

import java.util.BitSet;

public class Driver {
	
	public static void main(String[] args) {
		
		String mHex = "0123456789ABCDEF";
		String kHex = "133457799BBCDFF1";
		BitSet key = Key.setHexText(kHex);
//		Input input = new Input();
//		input.setHexText(mHex);
//		System.out.println(Key.getHexRepresentation(key));
		System.out.println(Key.getBitRepresentation(key));
//		Output output = Utils.encode(input, key);

		new Encoder().step1(key);
	}
}
