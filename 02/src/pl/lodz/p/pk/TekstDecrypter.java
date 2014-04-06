package pl.lodz.p.pk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TekstDecrypter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea area2;
	private KluczArea area1;

	public TekstDecrypter() {
		super("Odszyfrowanie tekstu");
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
		
		area1= new KluczArea("Twój klucz publiczny");
		this.add(area1);
		
		area2	= new JTextArea();
		area2.setLayout(null);
		area2.setLocation(50, 160);
		area2.setSize(300, 150);
		area2.setVisible(true);
		this.add(area2);
		
		JButton a = new JButton("Odszyfruj");
		a.setLocation(400, 160);
		a.setSize(100, 30);
		a.setVisible(true);
		OdkodujHandler zh = new OdkodujHandler();
		a.addActionListener(zh);
		this.add(a);
	}

	private class OdkodujHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String m = TekstDecrypter.this.area2.getText();
			String k = TekstDecrypter.this.area1.getText();
			Encoder encoder = new Encoder();
//			String c = encoder.decrypt(k, m);
//			TekstDecrypter.this.area2.setText(c);		
		}
	}
}
