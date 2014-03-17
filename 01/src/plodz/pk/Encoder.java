package plodz.pk;

import java.math.BigInteger;

public class Encoder {

	public static Debug LEVEL = Debug.LEVEL3;

	public Encoder() {
	}

	public void encode() {

	}

	/**
	 * EN Permute the key according to some pattern given in PC1. PL Pomieszaj
	 * bity.
	 */
	public BitArray step1(BitArray key) {
		final byte[] PC1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26,
				18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63,
				55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61,
				53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 };

		if (Encoder.LEVEL.getValue() > Debug.LEVEL2.getValue()) {
			System.out.println("64-bitowy klucz: "
					+ key.getBitRepresentation(8));
			System.out.println("Następuje permutacja klucza...");
		}
		BitArray permutedKey = permute(key, PC1);

		if (Encoder.LEVEL.getValue() > Debug.LEVEL1.getValue()) {
			System.out.println("56-bitowy klucz: "
					+ permutedKey.getBitRepresentation(7));
			System.out.println();
		}
		return permutedKey;
	}

	/**
	 * Potnij klucz na kawałki i przesuń w lewo 16 razy, zgodnie z poniższym
	 * zestawieniem/harmonogramem:
	 * 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
	 * 
	 * @param key
	 * @return
	 */
	public BitArray[] step2(BitArray key) {
		BitArray C0 = key.get(0, (key.len()/2));
		BitArray C1 = C0.rotateLeft();
		BitArray C2 = C1.rotateLeft();
		BitArray C3 = C2.rotateLeft().rotateLeft();
		BitArray C4 = C3.rotateLeft().rotateLeft();
		BitArray C5 = C4.rotateLeft().rotateLeft();
		BitArray C6 = C5.rotateLeft().rotateLeft();
		BitArray C7 = C6.rotateLeft().rotateLeft();
		BitArray C8 = C7.rotateLeft().rotateLeft();
		BitArray C9 = C8.rotateLeft();
		BitArray C10 = C9.rotateLeft().rotateLeft();
		BitArray C11 = C10.rotateLeft().rotateLeft();
		BitArray C12 = C11.rotateLeft().rotateLeft();
		BitArray C13 = C12.rotateLeft().rotateLeft();
		BitArray C14 = C13.rotateLeft().rotateLeft();
		BitArray C15 = C14.rotateLeft().rotateLeft();
		BitArray C16 = C15.rotateLeft();

		BitArray D0 = key.get(key.len()/2, key.len());
		BitArray D1 = D0.rotateLeft();
		BitArray D2 = D1.rotateLeft();
		BitArray D3 = D2.rotateLeft().rotateLeft();
		BitArray D4 = D3.rotateLeft().rotateLeft();
		BitArray D5 = D4.rotateLeft().rotateLeft();
		BitArray D6 = D5.rotateLeft().rotateLeft();
		BitArray D7 = D6.rotateLeft().rotateLeft();
		BitArray D8 = D7.rotateLeft().rotateLeft();
		BitArray D9 = D8.rotateLeft();
		BitArray D10 = D9.rotateLeft().rotateLeft();
		BitArray D11 = D10.rotateLeft().rotateLeft();
		BitArray D12 = D11.rotateLeft().rotateLeft();
		BitArray D13 = D12.rotateLeft().rotateLeft();
		BitArray D14 = D13.rotateLeft().rotateLeft();
		BitArray D15 = D14.rotateLeft().rotateLeft();
		BitArray D16 = D15.rotateLeft();

		BitArray[] subkeys = {// concatenate(C0, D0),
				concatenate(C1, D1), concatenate(C2, D2),
				concatenate(C3, D3), concatenate(C4, D4),
				concatenate(C5, D5), concatenate(C6, D6),
				concatenate(C7, D7), concatenate(C8, D8),
				concatenate(C9, D9), concatenate(C10, D10),
				concatenate(C11, D11), concatenate(C12, D12),
				concatenate(C13, D13), concatenate(C14, D14),
				concatenate(C15, D15), concatenate(C16, D16)};

		if (LEVEL.getValue() > Debug.LEVEL1.getValue()) {
			System.out.println("Następuje pocięcie klucza i 16-krotna rotacja...");
			System.out.println("C00: " + C0.getBitRepresentation());
			System.out.println("C01: " + C1.getBitRepresentation());
			System.out.println("C02: " + C2.getBitRepresentation());
			System.out.println("C03: " + C3.getBitRepresentation());
			System.out.println("C04: " + C4.getBitRepresentation());
			System.out.println("C05: " + C5.getBitRepresentation());
			System.out.println("C06: " + C6.getBitRepresentation());
			System.out.println("C07: " + C7.getBitRepresentation());
			System.out.println("C08: " + C8.getBitRepresentation());
			System.out.println("C09: " + C9.getBitRepresentation());
			System.out.println("C10: " + C10.getBitRepresentation());
			System.out.println("C11: " + C11.getBitRepresentation());
			System.out.println("C12: " + C12.getBitRepresentation());
			System.out.println("C13: " + C13.getBitRepresentation());
			System.out.println("C14: " + C14.getBitRepresentation());
			System.out.println("C15: " + C15.getBitRepresentation());
			System.out.println("C16: " + C16.getBitRepresentation());
			System.out.println();
			System.out.println("D00: " + D0.getBitRepresentation());
			System.out.println("D01: " + D1.getBitRepresentation());
			System.out.println("D02: " + D2.getBitRepresentation());
			System.out.println("D03: " + D3.getBitRepresentation());
			System.out.println("D04: " + D4.getBitRepresentation());
			System.out.println("D05: " + D5.getBitRepresentation());
			System.out.println("D06: " + D6.getBitRepresentation());
			System.out.println("D07: " + D7.getBitRepresentation());
			System.out.println("D08: " + D8.getBitRepresentation());
			System.out.println("D09: " + D9.getBitRepresentation());
			System.out.println("D10: " + D10.getBitRepresentation());
			System.out.println("D11: " + D11.getBitRepresentation());
			System.out.println("D12: " + D12.getBitRepresentation());
			System.out.println("D13: " + D13.getBitRepresentation());
			System.out.println("D14: " + D14.getBitRepresentation());
			System.out.println("D15: " + D15.getBitRepresentation());
			System.out.println("D16: " + D16.getBitRepresentation());
			System.out.println();
		}
		return subkeys;
	}

	public BitArray[] step3(BitArray[] keys) {

		final byte[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23,
				19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55,
				30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36,
				29, 32 };

		BitArray[] permutedKeys = new BitArray[keys.length];

		for (int i = 0; i < keys.length; i++) {
			BitArray key = keys[i];
			if (Encoder.LEVEL.getValue() > Debug.LEVEL2.getValue()) {
				System.out.println("56-bitowy klucz: "
						+ key.getBitRepresentation(7));
				System.out.println("Następuje permutacja klucza nr: "+(i+1)+" ...");
			}
			permutedKeys[i] = permute(key, PC2);

			if (Encoder.LEVEL.getValue() > Debug.LEVEL1.getValue()) {
				System.out.println("48-bitowy klucz: "
						+ permutedKeys[i].getBitRepresentation(6));
			}
		}
		return permutedKeys;
	}
	
	/**
	 * Permutuj wiadomość.
	 * @param msg
	 * @return
	 */
	public BitArray step4(BitArray msg) {
		byte[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20,
				12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24,
				16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19,
				11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23,
				15, 7 };
		
		if (Encoder.LEVEL.getValue() > Debug.LEVEL2.getValue()) {
			System.out.println("64-bitowa wiadomość: "
					+ msg.getBitRepresentation(8));
			System.out.println("Następuje permutacja klucza...");
		}
		BitArray permutedMsg = permute(msg, IP);
		if (Encoder.LEVEL.getValue() > Debug.LEVEL1.getValue()) {
			System.out.println("64-bitowa wiadomość: "
					+ permutedMsg.getBitRepresentation(8));
		}
		return permutedMsg;
	}
	
	public BitArray step5(BitArray msg, BitArray[] keys) {
		
		BitArray K1 = keys[0];
		BitArray R0 = msg.get(msg.len()/2, msg.len());
		BitArray ER0 = expandR(R0);
		BitArray xoredK1andER0 = xor(K1, ER0);
		if (Encoder.LEVEL.getValue() > Debug.LEVEL2.getValue()) {
			System.out.println("funkcja F: "
					+ xoredK1andER0.getBitRepresentation(6));
		}
		BitArray f = getS(xoredK1andER0.get(0, 6), 0);
		System.out.println(f.getBitRepresentation());
		
		return msg;
	}
	
	private BitArray getS(BitArray address, int box) {
		byte[] sBox = 
	        {
	            14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, // S1
	            0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8,
	            4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
	            15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13,
	            15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, // S2
	            3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5,
	            0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15,
	            13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9,
	            10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, // S3
	            13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1,
	            13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7,
	            1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12,
	            7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, // S4
	            13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9,
	            10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4,
	            3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14,
	            2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, // S5
	            14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6,
	            4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14,
	            11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3,
	            12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, // S6
	            10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8,
	            9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6,
	            4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13,
	            4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, // S7
	            13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6,
	            1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2,
	            6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12,
	            13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, // S8
	            1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2,
	            7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8,
	            2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11
	        };
		BitArray bitarray = new BitArray(4);
		int row = address.get(0).getValue()*2
				+ address.get(5).getValue()*1;
		int column = address.get(1).getValue()*8
				+ address.get(2).getValue()*4
				+ address.get(3).getValue()*2
				+ address.get(4).getValue()*1;
		byte value = sBox[(box*64)+(row*16)+(column)];
		for (int i=0; i<4; i++) {
			bitarray.set(i, getBitAt(value, i));
		}
		return bitarray;
	}
	
   public static Bit getBitAt(byte data, int poz) 
   {
//        int posByte = poz / 8;                                  
//        int posBit = poz % 8;                                  
//        byte valByte = data[posByte];                        
//        int valInt = data >> (7 - posBit) & 1;
		int valInt = (data >> poz) & 1;
		if (valInt==0)
			return Bit.bit0;
		else
			return Bit.bit1;
   }
	
	private BitArray expandR(BitArray bits) {
		byte[] E = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13,
				12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23,
				24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
		BitArray expandedR = new BitArray(E.length);
		if (Encoder.LEVEL.getValue() > Debug.LEVEL3.getValue()) {
			System.out.println("Standardowe R: "
					+ bits.getBitRepresentation(8));
		}
		expandedR = permute(bits, E);
		if (Encoder.LEVEL.getValue() > Debug.LEVEL3.getValue()) {
			System.out.println("Rozszerzone R: "
					+ expandedR.getBitRepresentation(6));
		}
		return expandedR;
	}
	/**
	 * EN Permute the key according to some pattern.
	 * PL Pomieszaj bity.
	 */
	private BitArray permute(BitArray key, byte[] pattern) {
		BitArray permutedKey = new BitArray(pattern.length);

		for (int i = 0; i < pattern.length; i++) {
			byte index = pattern[i];
			Bit bit = key.get(index - 1);
			permutedKey.set(i, bit);
			if (Encoder.LEVEL.getValue() > Debug.LEVEL3.getValue()) {
				System.out.print("PC1[" + i + "]=" + index + ";\t");
				System.out.print("key[" + (index - 1) + "]="
						+ key.get(index - 1) + ";\t");
				System.out.println("permutedKey[" + i + "]=" + bit);
			}
		}
		return permutedKey;
	}

	private BitArray concatenate(BitArray a, BitArray b) {
		BitArray c = new BitArray(a.len() + b.len());
		for (int i = 0; i < a.len(); i++) {
			c.set(i, a.get(i));
		}
		for (int i = 0; i < b.len(); i++) {
			int index = a.len()+i;
			Bit value = b.get(i);
			c.set(index, value);
		}
		return c;
	}
	
	private BitArray xor(BitArray a, BitArray b) {
		BitArray c = new BitArray(a.len());
		for (int i=0; i<a.len(); i++) {
			int val = a.get(i).getValue() ^ b.get(i).getValue();
			if (val==0)
				c.set(i, Bit.bit0);
			else if (val==1)
				c.set(i, Bit.bit1);
			else
				System.err.println("Coś się wyrypało.");
		}
		return c;
	}
}