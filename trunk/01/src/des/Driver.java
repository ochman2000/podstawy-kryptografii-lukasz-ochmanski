package des;

public class Driver {

	public static void main(String[] args) {
		
		String M = "0123456789ABCDEF";
		byte[] hexBytes = M.getBytes();
		byte[] plainBytes = Utils.hexToBytes(M);
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
