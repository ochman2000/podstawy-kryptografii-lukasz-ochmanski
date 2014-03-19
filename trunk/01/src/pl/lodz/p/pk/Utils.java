package pl.lodz.p.pk;

public class Utils {

	public static Bit getBitAt(byte data, int poz) {
		int valInt = (data >> poz) & 1;
		if (valInt == 0)
			return Bit.bit0;
		else
			return Bit.bit1;
	}

	public static BitArray[] reverse(BitArray[] array) {
		for (int i = 0; i < array.length; i++) {
			BitArray bitArray = array[i];
			array[i]=array[array.length-i-1];
			array[array.length-i-1]=bitArray;
		}
		return array;
	}
}
