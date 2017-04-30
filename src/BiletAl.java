
/**
 *
 * @author mekhti
 */
public class BiletAl extends javax.swing.JFrame {

    /**
     * Creates new form BiletAl
     */
    public BiletAl() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        filmSecBox = new javax.swing.JComboBox<>();
        SeansBox = new javax.swing.JComboBox<>();
        salonGoruntuleButton = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filmSecBox.setSelectedIndex(-1);
        filmSecBox.setToolTipText("Film Sec");
        filmSecBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmSecBoxActionPerformed(evt);
            }
        });

        SeansBox.setSelectedIndex(-1);
        SeansBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeansBoxActionPerformed(evt);
            }
        });

        salonGoruntuleButton.setText("Salon Goruntule");
        salonGoruntuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salonGoruntuleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filmSecBox, 0, 200, Short.MAX_VALUE)
                    .addComponent(SeansBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(salonGoruntuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(filmSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(SeansBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(salonGoruntuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        filmSecBox.getAccessibleContext().setAccessibleName("Film Secin");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filmSecBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmSecBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filmSecBoxActionPerformed

    private void SeansBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeansBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeansBoxActionPerformed

    private void salonGoruntuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonGoruntuleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salonGoruntuleButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BiletAl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SeansBox;
    private javax.swing.JComboBox<String> filmSecBox;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton salonGoruntuleButton;
    // End of variables declaration//GEN-END:variables
}
