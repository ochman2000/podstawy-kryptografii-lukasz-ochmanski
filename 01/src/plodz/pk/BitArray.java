package plodz.pk;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

import des.BitSet;
import des.Encoder;

public class BitArray {

	ArrayList<Bit> list;
	int len;
	
	public BitArray(int[] array) {
		list = new ArrayList<Bit>(array.length);
		this.len = array.length;
		for (int i : array) {
			if (i==0)
				list.add(Bit.bit0);
			else
				list.add(Bit.bit1);
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
		this.len = size;
	}
	
//	public String getBitRepresentation(int n) {
//		String plainBits;
//		for (Bit bit : list) {
//			if (bit)
//		}
//	}
	
	public String getBitRepresentation(int separator) {
		String plainBits = "";
		for (int i=0; i<list.size(); i++) {
			if (list.get(i)==Bit.bit0)
				plainBits=plainBits+1;
			else
				plainBits=plainBits+0;
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
//		ArrayList<Bit> bitArray = new ArrayList<>(to-from);
		int size = to-from;
		int currentIndex=0;
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
