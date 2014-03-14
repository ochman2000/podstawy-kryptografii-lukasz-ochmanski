package des;

import java.util.BitSet;

public class Key extends BitSet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Key() {
		super();
	}
	
	public static BitSet setPlainText(String text) {
		return BitSet.valueOf(text.getBytes());
	}
	
	public static BitSet setHexText(String text) {
		return BitSet.valueOf(Utils.hexToBytes(text));
	}
	
	public static String getHexRepresentation(BitSet bits) {
		String plainBits = Utils.bytesToBits(bits.toByteArray());
		String bytes = Utils.bitsToBytes(plainBits);
		return bytes;
	}
	
	public static String getBitRepresentation(BitSet bits) {
		String plainBits = Utils.bytesToBits(bits.toByteArray());
		return plainBits;
	}


}
