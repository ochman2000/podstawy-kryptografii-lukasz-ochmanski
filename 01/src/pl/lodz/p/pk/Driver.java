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
		
		BitArray key = new BitArray(kBits);
		System.out.println("K: "+key.getBitRepresentation(8));
		
//		byte[] msg = Auxx.hexToBytes(mHex);
		byte[] msg = "AAAAAAAA".getBytes();
		BitArray tekst = new BitArray(msg);
		System.out.println("M: "+tekst.getBitRepresentation(8));
		
		Encoder encoder = new Encoder();
		tekst = encoder.encodeBlock(key, tekst);
		System.out.println(tekst.getHexRepresentation());
		
	}
	
}
