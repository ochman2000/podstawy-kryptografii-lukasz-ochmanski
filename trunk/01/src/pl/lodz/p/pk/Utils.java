package pl.lodz.p.pk;

public class Utils {

	public static Bit getBitAt(byte data, int poz) {
		int valInt = (data >> poz) & 1;
		if (valInt == 0)
			return Bit.bit0;
		else
			return Bit.bit1;
	}

	
}
