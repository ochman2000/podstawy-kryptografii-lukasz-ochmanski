package pl.lodz.p.tewi;

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class AESFrame extends JInternalFrame implements InternalFrameListener
{
    private AES aes=new AES();
    private byte tekstJawny[];
    private byte szyfrogram[];
    private byte deszyfrogram[];
    private File plikKlucza, plikOdczytuTekstu, plikzapisuTekstu, plikOdczytuszyfr, plikzapisuSzyfr;
 
    class AESFilter extends javax.swing.filechooser.FileFilter 
    {
        
        String ext;
        
        public AESFilter()
        {
            ext=".aesKey";
        }
       
        @Override
        public boolean accept(File file)
        {  if (file.isDirectory()) return true;
    
            return file.getName().endsWith(ext);
        }
        
        @Override
        public String getDescription()
        {
            return "Plik klucza algorytmu AES";
        }
    }

    public AESFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) 
    {
       super(title, resizable, closable, maximizable, iconifiable);
        
       
        this.addInternalFrameListener(this);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        generuj_klucz = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        wczytaj_klucz = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        zapisz_klucz = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        wczytaj_plik_tekst_jawny = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        wczytaj_plik_szyfrogram = new javax.swing.JButton();
        zapisz_plik_szyfrogram = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        zapisz_plik_tekst_jawny = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        szyfruj = new javax.swing.JButton();
        deszyfruj = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 560));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Klucz"));

        jLabel3.setText("Wartość klucza heksadecymalnie");

        jTextField3.setToolTipText("");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        generuj_klucz.setText("Generuj klucz");
        generuj_klucz.setName("generuj_klucz"); // NOI18N
        generuj_klucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generuj_kluczActionPerformed(evt);
            }
        });

        jLabel4.setText("Wygeneruj wartość klucza");

        jTextField4.setText("Nazwa pliku klucza");

        jLabel7.setText("Wczytaj klucz z pliku");

        wczytaj_klucz.setText("Wczytaj");
        wczytaj_klucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytaj_kluczActionPerformed(evt);
            }
        });

        jLabel8.setText("Zapisz klucz do pliku");

        jTextField7.setText("Nazwa pliku klucza");

        zapisz_klucz.setText("Zapisz");
        zapisz_klucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapisz_kluczActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wczytaj_klucz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zapisz_klucz))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(generuj_klucz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {wczytaj_klucz, zapisz_klucz});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField4, jTextField7});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generuj_klucz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wczytaj_klucz)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zapisz_klucz))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Szyfrowanie / Deszyfrowanie"));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

        jTextField1.setText("Nazwa pliku z tekstem jawnym");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Otwórz plik zawierający tekst jawny");

        wczytaj_plik_tekst_jawny.setText("Otwórz");
        wczytaj_plik_tekst_jawny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytaj_plik_tekst_jawnyActionPerformed(evt);
            }
        });

        jLabel2.setText("Otwórz plik zawierający szyfrogram");

        jTextField2.setText("Nazwa pliku z szyfrogramem");

        wczytaj_plik_szyfrogram.setText("Otwórz");
        wczytaj_plik_szyfrogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytaj_plik_szyfrogramActionPerformed(evt);
            }
        });

        zapisz_plik_szyfrogram.setText("Zapisz");
        zapisz_plik_szyfrogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapisz_plik_szyfrogramActionPerformed(evt);
            }
        });

        jLabel5.setText("Zapisz plik zawierający tekst jawny");

        jTextField5.setText("Nazwa pliku z tekstem jawnym");

        jTextField6.setText("Nazwa pliku z szyfrogramem");

        jLabel6.setText("Zapisz plik zawierający szyfrogram");

        zapisz_plik_tekst_jawny.setText("Zapisz");
        zapisz_plik_tekst_jawny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapisz_plik_tekst_jawnyActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Tu podaj tekst jawny");
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Tu podaj szyfrogram");
        jScrollPane2.setViewportView(jTextArea2);

        szyfruj.setText("Szyfruj->");
        szyfruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szyfrujActionPerformed(evt);
            }
        });

        deszyfruj.setText("<-Deszyfruj");
        deszyfruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deszyfrujActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Plik");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Okno");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wczytaj_plik_tekst_jawny))
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(deszyfruj))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(szyfruj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zapisz_plik_tekst_jawny)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zapisz_plik_szyfrogram))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wczytaj_plik_szyfrogram)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {wczytaj_plik_szyfrogram, wczytaj_plik_tekst_jawny, zapisz_plik_szyfrogram, zapisz_plik_tekst_jawny});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField5, jTextField6});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deszyfruj, szyfruj});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wczytaj_plik_szyfrogram)
                    .addComponent(wczytaj_plik_tekst_jawny)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(szyfruj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deszyfruj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zapisz_plik_tekst_jawny))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zapisz_plik_szyfrogram)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wczytaj_plik_tekst_jawnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytaj_plik_tekst_jawnyActionPerformed
    JFileChooser fch = new JFileChooser();
    int wybor =fch.showOpenDialog(this);
    if (wybor == JFileChooser.APPROVE_OPTION) 
    {   String pom=fch.getSelectedFile().getPath();
        plikOdczytuTekstu=new File(pom);
        jTextField1.setText(pom);
       try
        {tekstJawny=Auxx.wczytajZPliku(pom);
         jTextArea1.setText(new String(tekstJawny));
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z otworzeniem pliku"+pom, "Problem z otworzeniem pliku", JOptionPane.ERROR_MESSAGE); };
    }
    }//GEN-LAST:event_wczytaj_plik_tekst_jawnyActionPerformed

    private void wczytaj_plik_szyfrogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytaj_plik_szyfrogramActionPerformed
    JFileChooser fch = new JFileChooser();
    int wybor =fch.showOpenDialog(this);
    if (wybor == JFileChooser.APPROVE_OPTION) 
    {   String pom=fch.getSelectedFile().getPath();
        plikOdczytuszyfr=new File(pom);
        jTextField2.setText(pom);
        try
        {szyfrogram=Auxx.wczytajZPliku(pom);
         jTextArea2.setText(new String(szyfrogram));
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z otworzeniem pliku"+pom, "Problem z otworzeniem pliku", JOptionPane.ERROR_MESSAGE); };

    }
    }//GEN-LAST:event_wczytaj_plik_szyfrogramActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void szyfrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szyfrujActionPerformed
        try{
            aes.testKey(Auxx.hexToBytes(jTextField3.getText()));
             if(jRadioButton1.isSelected())//plik
                 if(tekstJawny.length>0)szyfrogram=aes.encode(tekstJawny,Auxx.hexToBytes(jTextField3.getText()));else throw new Exception("Wybierz plik zawierający tekst jawny!");
             else  szyfrogram=aes.encode(jTextArea1.getText().getBytes(),Auxx.hexToBytes(jTextField3.getText()));
            jTextArea2.setText(Auxx.bytesToHex(szyfrogram));
           } catch(AES.AESKeyException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z kluczem", JOptionPane.ERROR_MESSAGE); }
             catch(AES.AESException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z tekstem do szyfrowania", JOptionPane.ERROR_MESSAGE); }
             catch(Exception ex){JOptionPane.showMessageDialog(null, "Wybierz plik zawierający tekst jawny!", "Wybierz plik", JOptionPane.ERROR_MESSAGE); }
          
    }//GEN-LAST:event_szyfrujActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void generuj_kluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generuj_kluczActionPerformed
        jTextField3.setText("0123456789ABCDEF0123456789ABCDEF");
        
    }//GEN-LAST:event_generuj_kluczActionPerformed

    private void wczytaj_kluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytaj_kluczActionPerformed
        JFileChooser fch = new JFileChooser();
        fch.setFileFilter(new AESFilter()); 
        int wybor =fch.showOpenDialog(this);
        if (wybor == JFileChooser.APPROVE_OPTION) 
        {   String pom=fch.getSelectedFile().getPath();
            plikKlucza=new File(pom);
            jTextField4.setText(pom);
            try
            {jTextField3.setText(new String(Auxx.wczytajZPliku(pom)));
            }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z otworzeniem pliku"+pom, "Problem z otworzeniem pliku", JOptionPane.ERROR_MESSAGE); };
            try{
                aes.testKey(Auxx.hexToBytes(jTextField3.getText()));
            } catch(AES.AESKeyException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z kluczem", JOptionPane.ERROR_MESSAGE); };

        }

    }//GEN-LAST:event_wczytaj_kluczActionPerformed

    private void zapisz_plik_szyfrogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapisz_plik_szyfrogramActionPerformed
       JFileChooser fch = new JFileChooser();
       int wybor =fch.showSaveDialog(this);
       if (wybor == JFileChooser.APPROVE_OPTION) 
        {   String pom=fch.getSelectedFile().getPath();
            plikzapisuSzyfr=new File(pom);
            jTextField6.setText(pom);
            try{ 
                if(jRadioButton1.isSelected())//plik
                Auxx.zapiszDoPliku(szyfrogram, pom);
                else  Auxx.zapiszDoPliku(jTextArea2.getText().getBytes(), pom);
               }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z zapisem do pliku"+pom, "Problem z zapisem do pliku", JOptionPane.ERROR_MESSAGE); };         

        }
    }//GEN-LAST:event_zapisz_plik_szyfrogramActionPerformed

    private void zapisz_plik_tekst_jawnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapisz_plik_tekst_jawnyActionPerformed
       JFileChooser fch = new JFileChooser();
       int wybor =fch.showSaveDialog(this);
       if (wybor == JFileChooser.APPROVE_OPTION) 
        {   String pom=fch.getSelectedFile().getPath();
            plikzapisuTekstu=new File(pom);
            jTextField5.setText(pom);
            try{ 
                 if(jRadioButton1.isSelected())//plik
                    if(deszyfrogram.length>0)Auxx.zapiszDoPliku(deszyfrogram, pom);
                    else Auxx.zapiszDoPliku(tekstJawny, pom);
                 else
                Auxx.zapiszDoPliku(jTextArea1.getText().getBytes(), pom);
               }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z zapisem do pliku"+pom, "Problem z zapisem do pliku", JOptionPane.ERROR_MESSAGE); };         

        }
    }//GEN-LAST:event_zapisz_plik_tekst_jawnyActionPerformed

    private void deszyfrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deszyfrujActionPerformed
        try{
           aes.testKey(Auxx.hexToBytes(jTextField3.getText()));
            if(jRadioButton1.isSelected())//plik
                deszyfrogram=aes.decode(szyfrogram,Auxx.hexToBytes(jTextField3.getText()));
            else deszyfrogram=aes.decode(Auxx.hexToBytes(jTextArea2.getText()),Auxx.hexToBytes(jTextField3.getText()));
           jTextArea1.setText(new String(deszyfrogram));
           } catch(AES.AESException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z szyfrogramem", JOptionPane.ERROR_MESSAGE); }
            catch(AES.AESKeyException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z kluczem", JOptionPane.ERROR_MESSAGE); };

       
    }//GEN-LAST:event_deszyfrujActionPerformed

    private void zapisz_kluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapisz_kluczActionPerformed
          JFileChooser fch = new JFileChooser();
          fch.setFileFilter(new AESFilter());
          int wybor =fch.showSaveDialog(this);
          if (wybor == JFileChooser.APPROVE_OPTION) 
            {   String pom=fch.getSelectedFile().getPath();
                if (pom.lastIndexOf('.')==-1)pom+=".desKey";
                plikKlucza=new File(pom);
                jTextField7.setText(pom);
               try
                {Auxx.zapiszDoPliku(jTextField3.getText().getBytes(), pom);
                }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z otworzeniem pliku"+pom, "Problem z otworzeniem pliku", JOptionPane.ERROR_MESSAGE); };
            }
    }//GEN-LAST:event_zapisz_kluczActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

        
    @Override
    public void internalFrameActivated(InternalFrameEvent e) {};
    
    @Override
    public void internalFrameClosed(InternalFrameEvent e) {};
    
    @Override
    public void internalFrameClosing(InternalFrameEvent e) 
    {
       this.dispose();
        
    };
    
    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {};
    
    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {};
    
    @Override
    public void internalFrameIconified(InternalFrameEvent e) {};
    
    @Override
    public void	internalFrameOpened(InternalFrameEvent e) {};            
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deszyfruj;
    private javax.swing.JButton generuj_klucz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton szyfruj;
    private javax.swing.JButton wczytaj_klucz;
    private javax.swing.JButton wczytaj_plik_szyfrogram;
    private javax.swing.JButton wczytaj_plik_tekst_jawny;
    private javax.swing.JButton zapisz_klucz;
    private javax.swing.JButton zapisz_plik_szyfrogram;
    private javax.swing.JButton zapisz_plik_tekst_jawny;
    // End of variables declaration//GEN-END:variables
}
