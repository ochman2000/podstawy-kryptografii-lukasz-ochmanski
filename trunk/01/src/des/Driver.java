package des;

public class Driver {

	public static void main(String[] args) {
		
//		String plainText = "01234567890ABCDEF";
		String plainText = "hahaha";
		byte[] plainBytes = plainText.getBytes();
		String plainBits = Utils.bytesToBits(plainBytes);
		System.out.println(plainBits);
		String bytes = Utils.bitsToBytes(plainBits);
		System.out.println(bytes);
		
		//teraz odwracamy dla sprawdzenia
		plainBits = Utils.bytesToBits(plainBytes);
		System.out.println(plainBits);
		
		
//		String hexText = Utils.bytesToHex(plainBytes);
//		byte[] tablica = Utils.hexToBytes(hexText);
//		System.out.println(tablica);
		
		
		
	}

}
