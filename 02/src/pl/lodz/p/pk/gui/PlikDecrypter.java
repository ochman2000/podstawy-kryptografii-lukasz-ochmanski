package pl.lodz.p.pk.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pl.lodz.p.pk.Encoder;
import pl.lodz.p.pk.Key;
import pl.lodz.p.pk.Szyfrogram;

public class PlikDecrypter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField area2;
	private KluczArea area1;
	private JLabel url;

	public PlikDecrypter() {
		super("Odszyfrowanie pliku");
		this.setLayout(null);
		this.setSize(600, 400);
		this.setLocation(375, 100);
		this.setVisible(true);
		this.initGUI();
	}
	
	private void initGUI() {
		
		JLabel tytul = new JLabel("Plik:");
		tytul.setLayout(null);
		tytul.setLocation(50, 162);
		tytul.setSize(100,23);
		tytul.setVisible(true);
		this.add(tytul);
		
		area1= new KluczArea("Twój klucz publiczny");
		this.add(area1);
		
		area2	= new JTextField("C:\\");
		area2.setLayout(null);
		area2.setLocation(80, 160);
		area2.setSize(270, 23);
		area2.setVisible(true);
		this.add(area2);
		
		JButton b = new JButton("Wybierz...");
		b.setLocation(400, 160);
		b.setSize(100, 23);
		b.setVisible(true);
		WybierzHandler wh = new WybierzHandler();
		b.addActionListener(wh);
		this.add(b);
		
		JButton a = new JButton("Odszyfruj");
		a.setLocation(220, 300);
		a.setSize(140, 23);
		a.setVisible(true);
		OdkodujHandler zh = new OdkodujHandler();
		a.addActionListener(zh);
		this.add(a);
		
		url = new JLabel("");
		url.setLayout(null);
		url.setLocation(50, 160);
		url.setSize(200,100);
		url.setVisible(true);
		this.add(url);
		
	}

	private class WybierzHandler implements ActionListener {
		private String nazwa_pliku;

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser(".");
			int returnVal = chooser.showOpenDialog(PlikDecrypter.this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			   nazwa_pliku = chooser.getSelectedFile().getAbsolutePath();
			}
			PlikDecrypter.this.area2.setText(nazwa_pliku);			
		}
	}

	private class OdkodujHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			String nazwa_pliku=PlikDecrypter.this.area2.getText();
			String destination="out/odszyfrowany.jpg";
			
			//POBIERZ KLUCZ I ODPOWIEDNIO SFORMATUJ
			String k = PlikDecrypter.this.area1.getText();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(k);
			String k1 = sc.next();
			String k2 = sc.next();
			Key klucz = new Key(k1, k2);
			
			//WCZYTAJ PLIK
			Szyfrogram s = null;
	        try {
			    FileInputStream fis = new FileInputStream(nazwa_pliku);
		        ObjectInputStream in = new ObjectInputStream(fis);
		        s = (Szyfrogram) in.readObject();
		        in.close();
		        fis.close();
			} catch (IOException | ClassNotFoundException e2) {
				e2.printStackTrace();
			}

	        //PRZEPROCESUJ
			Encoder encoder = new Encoder();
			byte[] c = encoder.deszyfruj(s, klucz);
			
			//ZAPISZ PLIK
	        FileOutputStream fos;
			try {
				fos = new FileOutputStream(destination);
		        fos.write(c);
		        fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			//WYŚWIETL GDZIE SIĘ ZAPISAŁ
			PlikDecrypter.this.url.setText(destination);		
		}
	}
}
