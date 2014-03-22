package pl.lodz.p.pk;

import javax.swing.JOptionPane;

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
	
	public static byte[] concat(byte[] A, byte[] B) {
		if (A==null){
			return B;
		}
		else if (B==null) {
			return A;
		}
		   int aLen = A.length;
		   int bLen = B.length;
		   byte[] C= new byte[aLen+bLen];
		   System.arraycopy(A, 0, C, 0, aLen);
		   System.arraycopy(B, 0, C, aLen, bLen);
		   return C;
		}
	
	public static String convertBytesToHex(byte bytes[]) 
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
    
    public static byte[] convertHexToBytes(String tekst) 
    {
        if (tekst == null) { return null;} 
        else if (tekst.length() < 2) { return null;}
        else { if (tekst.length()%2!=0)tekst+='0';
                int dl = tekst.length() / 2;
                byte[] wynik = new byte[dl];
                for (int i = 0; i < dl; i++) 
                { try{
                    wynik[i] = (byte) Integer.parseInt(tekst.substring(i * 2, i * 2 + 2), 16);
                     }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Problem z przekonwertowaniem HEX->BYTE.\n Sprawdź wprowadzone dane.", "Problem z przekonwertowaniem HEX->BYTE", JOptionPane.ERROR_MESSAGE); }
                }
                return wynik;
             }
    }
}
