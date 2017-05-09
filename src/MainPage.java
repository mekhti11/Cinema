
import java.awt.Color;

/**
 *
 * @author mekhti
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        this.setTitle("Ana Sayfa");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uyeButon = new javax.swing.JButton();
        personelButon = new javax.swing.JButton();
        adminButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uyeButon.setText("Üye Girişi / Kayıtı");
        uyeButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeButonActionPerformed(evt);
            }
        });

        personelButon.setText("Personel Girişi");
        personelButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelButonActionPerformed(evt);
            }
        });

        adminButon.setText("Admin Girişi");
        adminButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uyeButon, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(personelButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(uyeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(personelButon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminButon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uyeButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeButonActionPerformed
        LoginUye lu = new LoginUye();
        lu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_uyeButonActionPerformed

    private void personelButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personelButonActionPerformed
       CalisanLogin cl = new CalisanLogin();
       cl.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_personelButonActionPerformed

    private void adminButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButonActionPerformed
        AdminLogin al = new AdminLogin();
        al.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_adminButonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButon;
    private javax.swing.JButton personelButon;
    private javax.swing.JButton uyeButon;
    // End of variables declaration//GEN-END:variables
}
