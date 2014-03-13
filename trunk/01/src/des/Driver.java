package des;

public class Driver {

	public static void main(String[] args) {
		
		String message = "hahaha";
		String hex = "686168616861";
		
		Input input = new Input();
		input.setPlainText(message);
		System.out.println(input.getHexRepresentation());
		System.out.println(input.getBitRepresentation());

		input.setHexText(hex);
		System.out.println(input.getHexRepresentation());
		System.out.println(input.getBitRepresentation());
		
		
	}
}
