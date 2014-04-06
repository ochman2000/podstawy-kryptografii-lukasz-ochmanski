package pl.lodz.p.pk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyGenerator extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea area2;
	private JTextArea area1;
	private JLabel url;

	public KeyGenerator() {
		super("Generowanie kluczy RSA");
		this.setLayout(null);
		this.setSize(600, 400);
		this.setLocation(375, 100);
		this.setVisible(true);
		this.initGUI();
	}
	
private void initGUI() {
		
		JLabel tytul = new JLabel("Tutaj możesz wygenerować klucz RSA");
		tytul.setLayout(null);
		tytul.setLocation(100, 10);
		tytul.setSize(200, 20);
		tytul.setVisible(true);
		this.add(tytul);
		
		JLabel publicL = new JLabel("Klucz publiczny:");
		publicL.setLayout(null);
		publicL.setLocation(50, 60);
		publicL.setSize(200,20);
		publicL.setVisible(true);
		this.add(publicL);
		
		area1	= new JTextArea("pusty");
		area1.setLineWrap(true);
		area1.setLayout(null);
		area1.setLocation(50, 80);
		area1.setSize(300, 100);
		area1.setVisible(true);
		this.add(area1);
		
		JLabel privateL = new JLabel("Klucz prywatny:");
		privateL.setLayout(null);
		privateL.setLocation(50, 200);
		privateL.setSize(200,20);
		privateL.setVisible(true);
		this.add(privateL);
		
		area2	= new JTextArea("pusty");
		area2.setLineWrap(true);
		area2.setLayout(null);
		area2.setLocation(50, 220);
		area2.setSize(300, 100);
		area2.setVisible(true);
		this.add(area2);
			
		JButton a = new JButton("Generuj");
		a.setLocation(400, 120);
		a.setSize(100, 23);
		a.setVisible(true);
		GenerujHandler gh = new GenerujHandler();
		a.addActionListener(gh);
		this.add(a);
	}

	private class GenerujHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			RSAKey kluczRSA = new RSAKey();
			KeyGenerator.this.area1.setText(kluczRSA.getPubliczny().getA().toString());
			KeyGenerator.this.area2.setText(kluczRSA.getPrywatny().getA().toString());
		}
	}
}
