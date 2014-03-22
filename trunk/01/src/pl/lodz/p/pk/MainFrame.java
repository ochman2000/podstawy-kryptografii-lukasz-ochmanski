package pl.lodz.p.pk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(){
		super("Witaj w programie do szyfrowania DES");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(600, 400);
		this.setLocation(375, 100);
		this.setVisible(true);
		this.initGUI();
		this.repaint();
	}

	private void initGUI() {
		
		JLabel tytul = new JLabel("Co chcesz zrobić?");
		tytul.setLayout(null);
		tytul.setLocation(100, 20);
		tytul.setSize(200,100);
		tytul.setVisible(true);
		this.add(tytul);
		
		JButton a = new JButton("Zaszyfruj tekst");
		a.setLocation(80, 120);
		a.setSize(200, 30);
		a.setVisible(true);
		TekstCryptHandler tch = new TekstCryptHandler();
		a.addActionListener(tch);
		this.add(a);
		
		
		JButton b = new JButton("Odszyfruj tekst");
		b.setLocation(300, 120);
		b.setSize(200, 30);
		b.setVisible(true);
		TekstDecryptHandler tdh = new TekstDecryptHandler();
		b.addActionListener(tdh);
		this.add(b);
		
		JButton c = new JButton("Zaszyfruj Plik");
		c.setLocation(80, 170);
		c.setSize(200, 30);
		c.setVisible(true);
		PlikCryptHandler pch = new PlikCryptHandler();
		c.addActionListener(pch);
		this.add(c);
		
		JButton d = new JButton("Odszyfruj Plik");
		d.setLocation(300, 170);
		d.setSize(200, 30);
		d.setVisible(true);
		PlikDecryptHandler pdh = new PlikDecryptHandler();
		d.addActionListener(pdh);
		this.add(d);
	}
	
	private class TekstCryptHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new TekstCrypter();
		}
	}
	
	private class PlikCryptHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new PlikCrypter();
		}
	}
	private class TekstDecryptHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new TekstCrypter();
		}
	}
	
	private class PlikDecryptHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new PlikCrypter();
		}
	}
}
