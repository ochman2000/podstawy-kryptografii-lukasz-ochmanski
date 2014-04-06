package pl.lodz.p.pk;

import javax.swing.JTextArea;

public class KluczArea extends JTextArea {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KluczArea(String title) {
		super(title);
		this.setLineWrap(true);
		this.setLayout(null);
		this.setLocation(50, 70);
		this.setSize(300, 70);
		this.setVisible(true);
	}
}
