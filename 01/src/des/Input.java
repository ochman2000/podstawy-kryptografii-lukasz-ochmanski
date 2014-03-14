package des;

import java.math.BigInteger;


public class Input {
	private BigInteger value;
	
	public Input() {	}

	public void setValue(byte[] value) {
		this.value = new BigInteger(value);
	}
	
	public void setPlainText(String text) {
		value = new BigInteger(text.getBytes());
	}
	
	public void setHexText(String text) {
		value = new BigInteger(Utils.hexToBytes(text));
	}

	public byte[] getBytes() {
		return value.toByteArray();
	}
	
	public String getHexRepresentation() {
		String plainBits = Utils.bytesToBits(value.toByteArray());
		String bytes = Utils.bitsToBytes(plainBits);
		return bytes;
	}
	
	public String getBitRepresentation() {
		String plainBits = Utils.bytesToBits(value.toByteArray());
		return plainBits;
	}
}
