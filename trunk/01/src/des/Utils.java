package des;

import java.security.Key;

import javax.swing.JOptionPane;

public class Utils {

	/**
	 * Konwertuje ciąg znaków w systemie szesnastkowym na tablicę bajtów.
	 * @param hex
	 * @return
	 */
	public static byte[] hexToBytes(String hex) {
		if (hex == null) {
			return null;
		} else if (hex.length() < 2) {
			return null;
		} else {
			if (hex.length() % 2 != 0)
				hex += '0';
			int dl = hex.length() / 2;
			byte[] wynik = new byte[dl];
			for (int i = 0; i < dl; i++) {
				try {
					wynik[i] = (byte) Integer.parseInt(
							hex.substring(i * 2, i * 2 + 2), 16);
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(
									null,
									"Problem z przekonwertowaniem HEX->BYTE.\n Sprawdź wprowadzone dane.",
									"Problem z przekonwertowaniem HEX->BYTE",
									JOptionPane.ERROR_MESSAGE);
				}
			}
			return wynik;
		}
	}
	/**
	 * Konewertuje bajty na ciąg znaków w systemie szesnastkowym.
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte bytes[]) 
    {
        byte rawData[] = bytes;
        StringBuilder hexText = new StringBuilder();
        String initialHex = null;
        int initHexLength = 0;

        for (int i = 0; i < rawData.length; i++) 
        {
            int positiveValue = rawData[i] & 0x000000FF;
            initialHex = Integer.toHexString(positiveValue);
            initHexLength = initialHex.length();
            while (initHexLength++ < 2) 
            {
                hexText.append("0");
            }
            hexText.append(initialHex);
        }
        System.out.println(hexText);
        System.out.println(hexText.toString());
        return hexText.toString();
    }
	
	public static String bytesToBits(byte[] b) {
		String bits="";
		for (byte c : b) {
			String bit = "00000000"+Integer.toBinaryString((c+256)%256);
			bit=bit.substring(bit.length()-8, bit.length());
			bits=bits+" "+bit;
		}
		return bits;
	}
	
	public static String bitsToBytes(String bits) {
		String bytes="";
		bits = bits.replaceAll(" ", "");
		for (int i=0; i<bits.length(); i=i+8) {
			int poczatek = i;
			int koniec = i+8;
			bytes=bytes+" "+Integer.parseInt(bits.substring(poczatek, koniec), 2);
		}
		return bytes;
	}
	
	public static Output encode(Input input, Key key) {
		return null;
	}
	
	public static Output decode(Input input, Key key) {
		return null;
	}

}
