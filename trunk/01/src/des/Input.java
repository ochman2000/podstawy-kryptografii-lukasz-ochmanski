package des;

import java.math.BigInteger;

public class Input {
	private byte[] value;
	
	public Input() {	}

	public void setValue(byte[] value) {
		this.value = value;
	}
	
	public void setPlainText(String text) {
		value = text.getBytes();
	}
	
	public void setHexText(String text) {
		value = Utils.hexToBytes(text);
	}

	public byte[] getBytes() {
		return value;
	}
	
	public String getHexRepresentation() {
		String plainBits = Utils.bytesToBits(value);
		String bytes = Utils.bitsToBytes(plainBits);
		return bytes;
	}
	
	public String getBitRepresentation() {
		String plainBits = Utils.bytesToBits(value);
		return plainBits;
	}
}
