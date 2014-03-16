package plodz.pk;

public class Driver {
	
	public static void main(String[] args) {
		
		String mHex = "0123456789ABCDEF";
		String kHex = "133457799BBCDFF1";
		int[] kBits = {
				0,0,0,1,0,0,1,1,	0,0,1,1,0,1,0,0,	0,1,0,1,0,1,1,1,	0,1,1,1,1,0,0,1,
				1,0,0,1,1,0,1,1,	1,0,1,1,1,1,0,0,	1,1,0,1,1,1,1,1,	1,1,1,1,0,0,0,1};
		BitArray key = new BitArray(kBits);
		Encoder encoder = new Encoder();
		key = encoder.step1(key);
		BitArray[] keys = encoder.step2(key);
		keys = encoder.step3(keys);
	}
}
