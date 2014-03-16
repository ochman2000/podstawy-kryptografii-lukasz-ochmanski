package plodz.pk;

public class Encoder {

	public static Debug LEVEL = Debug.LEVEL3;

	public Encoder() {
	}

	public void encode() {

	}

	/**
	 * 1. Rearrange K using P10: 1000001100 2. Left shift by 1 position both the
	 * left and right halves: 00001 11000 3. Rearrange the halves with P8 to
	 * produce K1: 10100100 4. Left shift by 2 positions the left and right
	 * halves: 00100 00011 5. Rearrange the halves with P8 to produce K2:
	 * 01000011 K1 and K2 are used as inputs in the encryption and decryption
	 * stages. Assume a 8-bit plaintext, P: 01110010 Then the steps for
	 * encryption are: 1. Apply the initial permutation, IP, on P: 10101001 2.
	 * Assume the input from step 1 is in two halves, L and R: L=1010, R=1001 3.
	 * Expand and permutate R using E/P: 11000011 4. XOR input from step 3 with
	 * K1: 10100100 XOR 11000011 = 01100111 5. Input left halve of step 4 into
	 * S-Box S0 and right halve into S-Box S1: a. For S0: 0110 as input: b1,b4
	 * for row, b2,b3 for column b. Row 00, column 11 -> output is 10 c. For S1:
	 * 0111 as input: d. Row 01, column 11 -> output is 11 6. Rearrange outputs
	 * from step 5 (1011) using P4: 0111 7. XOR output from step 6 with L from
	 * step 2: 0111 XOR 1010 = 1101 8. Now we have the output of step 7 as the
	 * left half and the original R as the right half. Switch the halves and
	 * move to round 2: 1001 1101 9. E/P with right half: E/P(1101) = 11101011
	 * 10. XOR output of step 9 with K2: 11101011 XOR 01000011 = 10101000 11.
	 * Input to s-boxes: a. For S0, 1010 b. Row 10, column 01 -> output is 10
	 * c.c. For S1, 1000 d. Row 10, column 00 -> output is 11 12. Rearrange
	 * output from step 11 (1011) using P4: 0111 13. XOR output of step 12 with
	 * left halve from step 8: 0111 XOR 1001 = 1110 14. Input output from step
	 * 13 and right halve from step 8 into inverse IP a. Input us 1110 1101 b.
	 * Output is: 01110111 So our encrypted result of plaintext 01110010 with
	 * key 1010000010 is: 01110111 Other examples (encrypt or decrypt) could be:
	 * · Plaintext: 11010101; Key: 0111010001; Ciphertext: 01110011 · Plaintext:
	 * 01001100; Key: 1111111111; Ciphertext: 00100010 · Plaintext: 00000000;
	 * Key: 0000000000; Ciphertext: 11110000 · Plaintext: 11111111; Key:
	 * 1111111111; Ciphertext: 00001111 S-
	 */

	/**
	 * EN Permute the key according to some pattern given in PC1. PL Pomieszaj
	 * bity.
	 */
	public BitArray step1(BitArray key) {
		final byte[] PC1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26,
				18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63,
				55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61,
				53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 };
		BitArray permutedKey = new BitArray(PC1.length);
		if (Encoder.LEVEL.getValue() > Debug.LEVEL1.getValue()) {
			System.out.println("64-bitowy klucz: "+key.getBitRepresentation(8));
		}

		for (int i = 0; i < PC1.length; i++) {
			byte index = PC1[i];
			Bit bit = key.get(index - 1);
			permutedKey.set(i, bit);
			if (Encoder.LEVEL.getValue() > Debug.LEVEL3.getValue()) {				
				System.out.println("PC1[" + i + "]=" + index);
				System.out.println("key[" + (index - 1) + "]="+ key.get(index - 1));
				System.out.println("permutedKey[" + i + "]=" + bit);
			}
		}
		if (Encoder.LEVEL.getValue() > Debug.LEVEL1.getValue()) {
			System.out.println("Następuje permutacja klucza...");
			System.out.println("56-bitowy klucz: "+permutedKey.getBitRepresentation(7));
		}
		return permutedKey;
	}

	/**
	 * Potnij klucz na kawałki i przesuń w lewo 16 razy.
	 * 
	 * @param key
	 * @return
	 */
	public BitArray step2(BitArray key) {
//		int[] shiftSchedule = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
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
		
		BitArray D0 = key.get(key.len() / 2, key.len());
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

		if (LEVEL.getValue() > Debug.LEVEL2.getValue()) {
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
		}

		return null;
	}
}