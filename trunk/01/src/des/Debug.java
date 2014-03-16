package des;

public enum Debug {
	 LEVEL0(0), LEVEL1(1), LEVEL2(2), LEVEL3(3), LEVEL4(4);
	 
	 private int value;

     private Debug(int value) {
             this.setValue(value);
     }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	 
}
