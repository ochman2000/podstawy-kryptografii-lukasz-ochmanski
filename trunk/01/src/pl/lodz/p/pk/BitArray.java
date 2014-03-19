package pl.lodz.p.pk;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;

import pl.lodz.p.tewi.Auxx;

public class BitArray {

	ArrayList<Bit> list;
	private int len;
	
	public BitArray(int[] array) {
		list = new ArrayList<Bit>(array.length);
		this.len = array.length;
		for (int i : array) {
			if (i==0)
				list.add(Bit.bit0);
			else if (i==1)
				list.add(Bit.bit1);
			else
				throw new NumberFormatException();
		}
	}
	
	public BitArray(byte bajt) {
		list = new ArrayList<Bit>(8);
		this.len = 8;
		for (int i=0; i<8; i++) {
			if (Utils.getBitAt(bajt, i).getValue()==0)
				list.add(Bit.bit0);
			else
				list.add(Bit.bit1);
		}
	}
	/**
	 * Proszę tu nie wrzucać HEXa!!!
	 * Tylko czyste bajty.
	 * @param bajty
	 */
	public BitArray(byte[] bajty) {
		list = new ArrayList<Bit>(bajty.length*8);
		this.len = bajty.length*8;
		for (byte b : bajty) {
			for (int i=0; i<8; i++) {
				if (Utils.getBitAt(b, 7-i).getValue()==0)
					list.add(Bit.bit0);
				else
					list.add(Bit.bit1);
			}
		}
	}
	
	public ArrayList<Bit> getList() {
		return list;
	}

	public void setList(ArrayList<Bit> list) {
		this.list = list;
	}

	public BitArray(int size) {
		this.list = new ArrayList<>(size);
		for (int i=0; i<size; i++) {
			list.add(Bit.bit0);
		}
		this.len = size;
	}
	
	public String getBitRepresentation(int separator) {
		String plainBits = "";
		for (int i=0; i<list.size(); i++) {
			if (list.get(i)==Bit.bit0)
				plainBits=plainBits+0;
			else
				plainBits=plainBits+1;
			if (i%separator==separator-1)
				plainBits=plainBits+" ";
		}
		if (Encoder.LEVEL.getValue()>Debug.LEVEL3.getValue()) {
			return plainBits.trim() + " ("+list.size()+" "+this.len()+")";
		}
		else
			return plainBits.trim();
	}
	
	public String getBitRepresentation() {
		return getBitRepresentation(Integer.MAX_VALUE);
	}
	
	public String getHexRepresentation() {
		String output = "";
		int h=0;
		for (int i=0; i<this.len(); i+=4) {
			h = this.get(i).getValue()*8+
			this.get(i+1).getValue()*4+
			this.get(i+2).getValue()*2+
			this.get(i+3).getValue()*1;
			output+=Integer.toHexString(h);
		}
		return output.toUpperCase();
	}
	
	public Bit get(int index) {
		return this.list.get(index);
	}
	
	public void set(int index, Bit element) {
		this.list.set(index, element);
	}

	public int len() {
		return len;
	}
	
	public BitArray get(int from, int to) {
		int size = to-from;
		int currentIndex=from;
		BitArray bitArray = new BitArray(size);
		for (int i=0; i<size; i++) {
			bitArray.set(i, list.get(currentIndex));
			currentIndex++;
		}
		return bitArray;
	}
	
	public BitArray rotateLeft() {
		BitArray bitset = new BitArray(this.len());
		Bit first = list.get(0);
		for (int i=0; i<this.len()-1; i++) {
			Bit next = this.get(i+1);
			bitset.set(i, next);
		}
		bitset.set(this.len()-1, first);
		return bitset;
	}
}
