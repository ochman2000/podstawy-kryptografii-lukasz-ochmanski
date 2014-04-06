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
import javax.swing.JTextField;

public class PlikCrypter extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField area2;
	private JTextField area1;
	private JLabel url;

	public PlikCrypter() {
		super("Szyfrowanie pliku");
		this.setLayout(null);
		this.setSize(600, 400);
		this.setLocation(375, 100);
		this.setVisible(true);
		this.initGUI();
	}
	
private void initGUI() {
		
		JLabel tytul = new JLabel("Wybierz ścieżkę URL");
		tytul.setLayout(null);
		tytul.setLocation(100, 00);
		tytul.setSize(200,100);
		tytul.setVisible(true);
		this.add(tytul);
		
		area1	= new JTextField("133457799BBCDFF1");
		area1.setLayout(null);
		area1.setLocation(50, 120);
		area1.setSize(300, 23);
		area1.setVisible(true);
		this.add(area1);
		
		area2	= new JTextField();
		area2.setLayout(null);
		area2.setLocation(50, 160);
		area2.setSize(300, 23);
		area2.setVisible(true);
		this.add(area2);
		
		JButton b = new JButton("Wybierz...");
		b.setLocation(400, 160);
		b.setSize(100, 23);
		b.setVisible(true);
		WybierzHandler wh = new WybierzHandler();
		b.addActionListener(wh);
		this.add(b);
		
		JButton a = new JButton("Zakoduj");
		a.setLocation(400, 200);
		a.setSize(100, 23);
		a.setVisible(true);
		ZakodujHandler zh = new ZakodujHandler();
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
			int returnVal = chooser.showOpenDialog(PlikCrypter.this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			   nazwa_pliku = chooser.getSelectedFile().getAbsolutePath();
			}
			PlikCrypter.this.area2.setText(nazwa_pliku);			
		}		
	}

	private class ZakodujHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			String nazwa_pliku=PlikCrypter.this.area2.getText();
			String destination="out/zaszyfrowany.plik";
			byte[] dane = null;
			
			//WCZYTAJ PLIK
	        try {
			    FileInputStream fis = new FileInputStream(nazwa_pliku);
		        int ileWPliku = fis.available();
		        dane = new byte[ileWPliku];
				fis.read(dane);
		        fis.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

	        //PRZEPROCESUJ
	        byte[] m = dane;
			String k = PlikCrypter.this.area1.getText();
			Encoder encoder = new Encoder();
			byte[] c = encoder.encrypt(k, m);
			
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
			PlikCrypter.this.url.setText(destination);		
		}
	}
}
