package pl.lodz.p.pk;

import pl.lodz.p.tewi.Auxx;

public class Driver {
	
	public static void main(String[] args) {
		
		//ENCODING A KEY
		String kHex = "133457799BBCDFF1";
		int[] kBits = {
				0,0,0,1,0,0,1,1,	0,0,1,1,0,1,0,0,	0,1,0,1,0,1,1,1,	0,1,1,1,1,0,0,1,
				1,0,0,1,1,0,1,1,	1,0,1,1,1,1,0,0,	1,1,0,1,1,1,1,1,	1,1,1,1,0,0,0,1};

		String mHex = "0123456789ABCDEF";
		int[] mBits = {
				0,0,0,0,0,0,0,1,	0,0,1,0,0,0,1,1,	0,1,0,0,0,1,0,1,	0,1,1,0,0,1,1,1,
				1,0,0,0,1,0,0,1,	1,0,1,0,1,0,1,1,	1,1,0,0,1,1,0,1,	1,1,1,0,1,1,1,1};
		
		byte[] key = Auxx.hexToBytes(mHex);
		BitArray klucz = new BitArray(key);
		System.out.println("K: "+klucz.getBitRepresentation(8));
		
		byte[] msg = Auxx.hexToBytes(mHex);
		BitArray tekst = new BitArray(msg);
		System.out.println("M: "+tekst.getBitRepresentation(8));
		
		Encoder encoder = new Encoder();
		encoder.encodeBlock(klucz, tekst);
	}
	
}
