package plodz.pk;

public class Encoder {

	public static Debug LEVEL = Debug.LEVEL2;

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
	 * @param key
	 * @return
	 */
	public BitArray step4(BitArray key) {
		
		return key;
	}

	/**
	 * EN Permute the key according to some pattern.
	 * PL Pomieszaj bity.
	 */
	public BitArray permute(BitArray key, byte[] pattern) {
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
}