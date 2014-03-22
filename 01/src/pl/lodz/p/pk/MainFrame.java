package pl.lodz.p.pk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(){
		super("Witaj w programie do szyfrowania DES");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(600, 400);
		this.setLocation(375, 100);
		this.setVisible(true);
		this.initGUI();
	}

	private void initGUI() {
		
		JLabel tytul = new JLabel("Co chcesz zakodować?");
		tytul.setLayout(null);
		tytul.setLocation(100, 20);
		tytul.setSize(200,100);
		tytul.setVisible(true);
		this.add(tytul);
		
		JButton a = new JButton("Tekst");
		a.setLocation(100, 120);
		a.setSize(200, 30);
		a.setVisible(true);
		TekstHandler th = new TekstHandler();
		a.addActionListener(th);
		this.add(a);
		
		JButton b = new JButton("Plik");
		b.setLocation(100, 170);
		b.setSize(200, 30);
		b.setVisible(true);
		PlikHandler ph = new PlikHandler();
		b.addActionListener(ph);
		this.add(b);
	}
	private class TekstHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new TekstCrypter();
		}
	}
	
	private class PlikHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new PlikCrypter();
		}
	}
}
