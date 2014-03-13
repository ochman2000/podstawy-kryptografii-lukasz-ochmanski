package des;

public class Driver {
	
	public static void main(String[] args) {
		
		String mHex = "0123456789ABCDEF";
		String kHex = "133457799BBCDFF1";
		Key key = new Key();
		key.setHexText(kHex);
//		Input input = new Input();
//		input.setHexText(mHex);
//		System.out.println(key.getHexRepresentation());
		System.out.println(key.getBitRepresentation());
//		Output output = Utils.encode(input, key);

		new Encoder().step1(key);
	}
}
