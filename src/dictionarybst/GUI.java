/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dictionarybst;

import static dictionarybst.DictionaryBST.searchTree;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author mybaby
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    DictionaryBST dictionary = new DictionaryBST();
    List<String> suggests;

    public GUI() {
        dictionary.buildTreeFromFile("src/dictionarybst/dictionary.txt");
        initComponents();
        txt_k.setText("1");
        sugg();

    }

    public List<String> addList() {
        String text = txt.getText();
        String[] words = text.split(" "); // boşluklara göre ayır

        List<String> wordList = Arrays.asList(words); // dizi öğelerini bir liste olarak dönüştür

        return wordList;
    }

    public void sugg() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        lst.setModel(listModel);
        String words = txt.getText().toLowerCase();
        int selectionStart = txt.getSelectionStart();
        int selectionEnd = txt.getSelectionEnd();
        String selectedWord = words.substring(selectionStart, selectionEnd);
        int k = Integer.parseInt(txt_k.getText());
        if (selectionEnd - selectionStart != 0) {
            suggests = searchTree(dictionary, selectedWord, k);
            DefaultListModel<String> jListModel = (DefaultListModel<String>) lst.getModel();
            for (String element : suggests) {
                if (element.equals(selectedWord)) {
                    lbl.setText("Bu kelime doğru yazılmış.");
                    lbl.setForeground(Color.green);
                    break;
                } else {
                    jListModel.addElement(element);
                    lbl.setText("Bu kelime yanlış yazılmış");
                    lbl.setForeground(Color.red);
                }
            }
            lst.setModel(jListModel);
        } else {
            lbl.setText("Düzeltmek istediğiniz kelimeyi seçin.");
            lbl.setForeground(Color.BLACK);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        btn_fix = new javax.swing.JButton();
        btn_sgs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst = new javax.swing.JList<>();
        lbl = new javax.swing.JLabel();
        btn_fixAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_k = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        pnl.setForeground(new java.awt.Color(0, 153, 153));

        btn_fix.setText("Fix");
        btn_fix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fixActionPerformed(evt);
            }
        });

        btn_sgs.setText("Suggestion");
        btn_sgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sgsActionPerformed(evt);
            }
        });

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        jScrollPane2.setViewportView(lst);

        btn_fixAll.setText("Auto Fix All");
        btn_fixAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fixAllActionPerformed(evt);
            }
        });

        jLabel1.setText("Kaç Öneri İstiyorsunuz?");

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_k, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addComponent(btn_sgs)
                                        .addGap(115, 115, 115)
                                        .addComponent(btn_fix))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(btn_fixAll)
                                .addGap(14, 14, 14))))))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_fixAll)
                            .addComponent(btn_fix)))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sgs)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sgsActionPerformed
        String k = txt_k.getText();

        if (k.matches("^[1-9]\\d{0,2}$") && Integer.parseInt(k) <= 1000) {
            sugg();
        } else {
            lbl.setText("Öneri için sadece 1-1000 arsında bır sayı giriniz");
        }
    }//GEN-LAST:event_btn_sgsActionPerformed

    private void btn_fixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fixActionPerformed
        String fixedWord = lst.getSelectedValue();
        String words = txt.getText();
        int selectionStart = txt.getSelectionStart();
        int selectionEnd = txt.getSelectionEnd();
        String selectedWord = words.substring(selectionStart, selectionEnd);
        if (lst.getSelectedValue() != null) {
            if (!selectedWord.equals(fixedWord)) {
                txt.replaceRange(fixedWord, selectionStart, selectionEnd);
                lbl.setText("Basariyla duzeltildi");
            }
        } else {
            List<String> suggs;
            suggs = searchTree(dictionary, selectedWord, 1);
            fixedWord = suggs.get(0);
            String res = "";
            if (!selectedWord.equals(fixedWord)) {
                txt.replaceRange(fixedWord, selectionStart, selectionEnd);
                lbl.setText("Basariyla duzeltildi");
            }
        }
    }//GEN-LAST:event_btn_fixActionPerformed

    private void btn_fixAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fixAllActionPerformed
        List<String> wordList = addList();
        List<String> fixedWords = new ArrayList<>();
        List<String> suggs;

        for (int i = 0; i < wordList.size(); i++) {
            suggs = searchTree(dictionary, wordList.get(i), 1);
            fixedWords.add(suggs.get(0));
        }

        String res = "";
        for (String item : fixedWords) {
            res += item + " ";
        }
        txt.setText(res);
    }//GEN-LAST:event_btn_fixAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_fix;
    private javax.swing.JButton btn_fixAll;
    private javax.swing.JButton btn_sgs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JList<String> lst;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextArea txt;
    private javax.swing.JTextField txt_k;
    // End of variables declaration//GEN-END:variables
}
