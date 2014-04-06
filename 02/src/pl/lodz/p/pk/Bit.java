package pl.lodz.p.pk;

public enum Bit {
	bit0(0), bit1(1);
	 
	private int value;

    private Bit(int value) {
            this.setValue(value);
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
