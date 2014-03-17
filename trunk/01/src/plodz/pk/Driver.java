package plodz.pk;

public class Driver {
	
	public static void main(String[] args) {
		Encoder encoder = new Encoder();
		
		//ENCODING A KEY
		String kHex = "133457799BBCDFF1";
		int[] kBits = {
				0,0,0,1,0,0,1,1,	0,0,1,1,0,1,0,0,	0,1,0,1,0,1,1,1,	0,1,1,1,1,0,0,1,
				1,0,0,1,1,0,1,1,	1,0,1,1,1,1,0,0,	1,1,0,1,1,1,1,1,	1,1,1,1,0,0,0,1};
		
		BitArray key = new BitArray(kBits);
		key = encoder.step1(key);
		BitArray[] keys = encoder.step2(key);
		keys = encoder.step3(keys);
		
		//ENCODING A MESSAGE
		String mHex = "0123456789ABCDEF";
		int[] mBits = {
				0,0,0,0,0,0,0,1,	0,0,1,0,0,0,1,1,	0,1,0,0,0,1,0,1,	0,1,1,0,0,1,1,1,
				1,0,0,0,1,0,0,1,	1,0,1,0,1,0,1,1,	1,1,0,0,1,1,0,1,	1,1,1,0,1,1,1,1};
		
		BitArray msg = new BitArray(mBits);
		msg = encoder.step4(msg);
		msg = encoder.step5(msg, keys);
	}
}
