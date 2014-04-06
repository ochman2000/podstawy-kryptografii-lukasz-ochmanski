package pl.lodz.p.pk;

import javax.swing.JTextArea;

public class KluczArea extends JTextArea {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KluczArea(String title) {
		super(title);
		this.setLayout(null);
		this.setLocation(50, 90);
		this.setSize(300, 50);
		this.setVisible(true);
	}
}
