package pl.lodz.p.pk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TekstCrypter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea area2;
	private KluczArea area1;

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
		
		area1= new KluczArea("Twój klucz prywatny");
		this.add(area1);
		
		area2	= new JTextArea();
		area2.setLayout(null);
		area2.setLocation(50, 160);
		area2.setSize(300, 150);
		area2.setVisible(true);
		this.add(area2);
		
		JButton a = new JButton("Zaszyfruj");
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
			String k = TekstCrypter.this.area1.getText();
			String m = TekstCrypter.this.area2.getText();
			Encoder encoder = new Encoder();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(k);
			String k1 = sc.next();
			String k2 = sc.next();
			Key klucz = new Key(k1, k2);
			String c = encoder.szyfruj(m, klucz);
			TekstCrypter.this.area2.setText(c);		
		}
	}
}
