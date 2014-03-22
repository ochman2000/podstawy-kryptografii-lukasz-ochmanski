package pl.lodz.p.tewi;

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class TripleDESFrame extends JInternalFrame implements InternalFrameListener{
    private TripleDES tripledes=new TripleDES();
    private byte tekstJawny[];
    private byte szyfrogram[];
    private byte deszyfrogram[];
    private File plikKlucza, plikOdczytuTekstu, plikzapisuTekstu, plikOdczytuszyfr, plikzapisuSzyfr;
 
    class TripleDESFilter extends javax.swing.filechooser.FileFilter 
    {
        
        String ext;
        
        public TripleDESFilter ()
        {
            ext=".3desKey";
        }
       
        @Override
        public boolean accept(File file)
        {  if (file.isDirectory()) return true;
    
            return file.getName().endsWith(ext);
        }
        
        @Override
        public String getDescription()
        {
            return "Plik klucza algorytmu TripleDES";
        }
    }
    
    public TripleDESFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) 
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
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        wczytaj_plik_tekst_jawny = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 560));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Klucz"));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 150));

        jLabel3.setText("Wartość I klucza");

        jTextField3.setToolTipText("");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        generuj_klucz.setText("Generuj klucze");
        generuj_klucz.setName("generuj_klucz"); // NOI18N
        generuj_klucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generuj_kluczActionPerformed(evt);
            }
        });

        jLabel4.setText("Wygeneruj wartość klucza");

        jTextField4.setText("Nazwa pliku kluczy");

        jLabel7.setText("Wczytaj klucze z pliku");

        wczytaj_klucz.setText("Wczytaj");
        wczytaj_klucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytaj_kluczActionPerformed(evt);
            }
        });

        jLabel8.setText("Zapisz klucze do pliku");

        jTextField7.setText("Nazwa pliku kluczy");

        zapisz_klucz.setText("Zapisz");
        zapisz_klucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapisz_kluczActionPerformed(evt);
            }
        });

        jLabel9.setText("Wartość II klucza");

        jLabel10.setText("Wartość III klucza");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(96, 96, 96)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wczytaj_klucz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(zapisz_klucz)))
                        .addGap(180, 180, 180))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generuj_klucz, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {wczytaj_klucz, zapisz_klucz});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField4, jTextField7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField3, jTextField8, jTextField9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generuj_klucz)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wczytaj_klucz)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zapisz_klucz)))
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

        jTextField2.setText("Nazwa pliku z szyfrogramem");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wczytaj_plik_tekst_jawny))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zapisz_plik_tekst_jawny, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addComponent(szyfruj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deszyfruj, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zapisz_plik_szyfrogram, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wczytaj_plik_szyfrogram, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {wczytaj_plik_szyfrogram, wczytaj_plik_tekst_jawny, zapisz_plik_szyfrogram, zapisz_plik_tekst_jawny});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wczytaj_plik_tekst_jawny)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wczytaj_plik_szyfrogram))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zapisz_plik_tekst_jawny)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zapisz_plik_szyfrogram))
                .addGap(93, 93, 93))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(szyfruj)
                .addGap(9, 9, 9)
                .addComponent(deszyfruj)
                .addGap(26, 26, 26)
                .addComponent(jRadioButton1)
                .addGap(1, 1, 1)
                .addComponent(jRadioButton2)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
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
        try{ tripledes.s_key1=jTextField3.getText();
             tripledes.s_key2=jTextField8.getText();
             tripledes.s_key3=jTextField9.getText();
             if(jRadioButton1.isSelected())//plik
                 if(tekstJawny.length>0)szyfrogram=tripledes.encode3DES(tekstJawny);else throw new Exception("Wybierz plik zawierający tekst jawny!");
             else  szyfrogram=tripledes.encode3DES(jTextArea1.getText().getBytes());
            jTextArea2.setText(Auxx.bytesToHex(szyfrogram));
           } catch(DES.DESKeyException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z kluczem", JOptionPane.ERROR_MESSAGE); }
             catch(Exception ex){JOptionPane.showMessageDialog(null, "Wybierz plik zawierający tekst jawny!", "Wybierz plik", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_szyfrujActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void generuj_kluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generuj_kluczActionPerformed
        jTextField3.setText("0123456789ABCDEF");
        jTextField8.setText("1133557799BBDDFF");
        jTextField9.setText("0022446688AACCEE");
        
    }//GEN-LAST:event_generuj_kluczActionPerformed

    private void wczytaj_kluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytaj_kluczActionPerformed
        JFileChooser fch = new JFileChooser();
       fch.setFileFilter(new TripleDESFilter()); 
    int wybor =fch.showOpenDialog(this);
    if (wybor == JFileChooser.APPROVE_OPTION) 
    {   String pom=fch.getSelectedFile().getPath();
        plikKlucza=new File(pom);
        jTextField4.setText(pom);
        try
        {  String tab[]=(new String(Auxx.wczytajZPliku(pom))).split("\n");   
            jTextField3.setText(tab[0]);
            jTextField8.setText(tab[1]);
            jTextField9.setText(tab[2]);
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Problem z otworzeniem pliku"+pom, "Problem z otworzeniem pliku", JOptionPane.ERROR_MESSAGE); };
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
             tripledes.s_key1=jTextField3.getText();
             tripledes.s_key2=jTextField8.getText();
             tripledes.s_key3=jTextField9.getText();
             if(jRadioButton1.isSelected())//plik
                deszyfrogram=tripledes.decode3DES(szyfrogram);
            else deszyfrogram=tripledes.decode3DES(Auxx.hexToBytes(jTextArea2.getText()));
           jTextArea1.setText(new String(deszyfrogram));
          } catch(DES.DESKeyException e){JOptionPane.showMessageDialog(null, e.getMessage(), "Problem z kluczem", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_deszyfrujActionPerformed

    private void zapisz_kluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapisz_kluczActionPerformed
          JFileChooser fch = new JFileChooser();
          fch.setFileFilter(new TripleDESFilter());
          int wybor =fch.showSaveDialog(this);
            if (wybor == JFileChooser.APPROVE_OPTION) 
            {   String pom=fch.getSelectedFile().getPath();
                if (pom.lastIndexOf('.')==-1)pom+=".3desKey";
                plikKlucza=new File(pom);
                jTextField7.setText(pom);
               try
                { String spom=jTextField3.getText()+'\n'+jTextField8.getText()+'\n'+jTextField9.getText();
                    Auxx.zapiszDoPliku(spom.getBytes(), pom);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton szyfruj;
    private javax.swing.JButton wczytaj_klucz;
    private javax.swing.JButton wczytaj_plik_szyfrogram;
    private javax.swing.JButton wczytaj_plik_tekst_jawny;
    private javax.swing.JButton zapisz_klucz;
    private javax.swing.JButton zapisz_plik_szyfrogram;
    private javax.swing.JButton zapisz_plik_tekst_jawny;
    // End of variables declaration//GEN-END:variables
}