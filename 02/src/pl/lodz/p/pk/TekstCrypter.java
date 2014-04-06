package pl.lodz.p.pk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TekstCrypter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea area2;
	private JTextField area1;

	public TekstCrypter() {
		super("Szyfrowanie tekstu");
		this.setLayout(null);
		this.setSize(600, 400);
		this.setLocation(375, 100);
		this.setVisible(true);
		this.initGUI();
	}
	
private void initGUI() {
		
		JLabel tytul = new JLabel("Wpisz tekst");
		tytul.setLayout(null);
		tytul.setLocation(100, 00);
		tytul.setSize(200,100);
		tytul.setVisible(true);
		this.add(tytul);
		
		area1	= new JTextField("133457799BBCDFF1");
		area1.setLayout(null);
		area1.setLocation(50, 120);
		area1.setSize(300, 20);
		area1.setVisible(true);
		this.add(area1);
		
		area2	= new JTextArea();
		area2.setLayout(null);
		area2.setLocation(50, 160);
		area2.setSize(300, 150);
		area2.setVisible(true);
		this.add(area2);
		
		JButton a = new JButton("Zakoduj");
		a.setLocation(400, 160);
		a.setSize(100, 30);
		a.setVisible(true);
		ZakodujHandler zh = new ZakodujHandler();
		a.addActionListener(zh);
		this.add(a);
	}

	private class ZakodujHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String m = TekstCrypter.this.area2.getText();
			String k = TekstCrypter.this.area1.getText();
			Encoder encoder = new Encoder();
			String c = encoder.encrypt(k, m);
			TekstCrypter.this.area2.setText(c);		
		}
	}
}
