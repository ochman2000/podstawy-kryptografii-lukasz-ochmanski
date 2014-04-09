package pl.lodz.p.pk;

import java.io.Serializable;
import java.util.ArrayList;

public class Szyfrogram implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12996975162279485L;

	private ArrayList<Byte[]> szyfrogram;
	
	public Szyfrogram() {
		this.szyfrogram = new ArrayList<>();
	}

	public ArrayList<Byte[]> getSzyfrogram() {
		return szyfrogram;
	}

	public void setSzyfrogram(ArrayList<Byte[]> szyfrogram) {
		this.szyfrogram = szyfrogram;
	}
	
	public void add(byte[] array) {
		Byte[] a = new Byte[array.length];
		for (int i=0; i<array.length; i++) {
			a[i]=array[i];
		}
		this.getSzyfrogram().add(a);
	}
}
