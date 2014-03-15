package des;

import java.math.BigInteger;

public class Driver {
	
	public static void main(String[] args) {
		
		String mHex = "0123456789ABCDEF";
		String kHex = "133457799BBCDFF1";
		BitSet key = BitSet.valueOfHex(kHex);
		BigInteger key2 = new BigInteger(kHex, 16);
		
		if (Encoder.DEBUG) {
			System.out.println("Poniżej klucz BigInteger bez pierwszych trzech zer:");
			System.out.println(key2.toString(2));
			System.out.println("Poniżej jest iteracja tego badziewia z użyciem BigInteger:");
			for (int i=0; i<key.length(); i++) {
				if (key2.testBit(i))
					System.out.print(1);
				else
					System.out.print(0);
				if (i%8==7)
					System.out.print(" ");
			}
			System.out.println();
		}
//		Input input = new Input();
//		input.setHexText(mHex);
//		System.out.println(key.getHexRepresentation());
		System.out.println("Poniżej moja metoda BitSet.getBitRepresentation:");
		System.out.println(key.getBitRepresentation());
//		Output output = Utils.encode(input, key);

		new Encoder().step1(key);
	}
}
