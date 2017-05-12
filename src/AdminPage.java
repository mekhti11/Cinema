import java.sql.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

/**
 *
 * @author mekhti
 */
public class AdminPage extends javax.swing.JFrame {
    
    private int id;
    String sql;
    String name = "";
    Connection connection;
    Statement statement;
    ResultSet result;
    
    /**
     * Creates new form AdminPage
     */
    public AdminPage(int id) throws SQLException {
        this.id = id;
        this.setTitle("Admin Page");
        initComponents();
        set();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filmButon = new javax.swing.JButton();
        gosterimButon = new javax.swing.JButton();
        salonButon = new javax.swing.JButton();
        personelButon = new javax.swing.JButton();
        gorevButon = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filmButon.setText("Film ekle/sil");
        filmButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmButonActionPerformed(evt);
            }
        });

        gosterimButon.setText("Gosterim ekle/sil");
        gosterimButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gosterimButonActionPerformed(evt);
            }
        });

        salonButon.setText("Salon ekle");
        salonButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salonButonActionPerformed(evt);
            }
        });

        personelButon.setText("Personel ekle/sil");
        personelButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelButonActionPerformed(evt);
            }
        });

        gorevButon.setText("Gorev ekle");
        gorevButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gorevButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(filmButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gosterimButon, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salonButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(gorevButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(personelButon, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salonButon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gosterimButon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filmButon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gorevButon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personelButon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(225, 225, 225))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filmButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmButonActionPerformed
        FilmEkleSil f = null;
        try {
            f = new FilmEkleSil();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setVisible(true);
    }//GEN-LAST:event_filmButonActionPerformed

    private void gosterimButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gosterimButonActionPerformed
        GosterimEkleSil g = new GosterimEkleSil();
        g.setVisible(true);
    }//GEN-LAST:event_gosterimButonActionPerformed

    private void salonButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonButonActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "45 Koltuk Kapasiteli Salon Eklenecektir Onayliyor musunuz?");
        if(a==0){
            sql = "INSERT INTO `Salon` VALUES ";
            try{
                connection = ConnectDB();
                statement = connection.createStatement();
                statement.execute(sql);
            }catch(Exception e){}
            JOptionPane.showMessageDialog(null,"Salon Eklendi");
        }
    }//GEN-LAST:event_salonButonActionPerformed

    private void personelButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personelButonActionPerformed
        PersonelEkleSil p = null;
        try {
            p = new PersonelEkleSil();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
    }//GEN-LAST:event_personelButonActionPerformed

    private void gorevButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gorevButonActionPerformed
        GorevEkle g = null;
        try {
            g = new GorevEkle();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.setVisible(true);
    }//GEN-LAST:event_gorevButonActionPerformed
    
    private void set() throws SQLException{
        connection = ConnectDB();
        statement = connection.createStatement();
        sql = "SELECT * FROM Calisan WHERE `id` = "+id;
        result = statement.executeQuery(sql);
        if(result.next()){
            name += (String) result.getString("isim");
            name +=" ";
            name += (String) result.getString("soyisim");
        }
        nameLabel.setText(name);
    }

    public static Connection ConnectDB(){
        try{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/Cinema","root","mekhti");
        //JOptionPane.showMessageDialog(null, "Connected to Database");
        return connect;

        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        return null;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton filmButon;
    private javax.swing.JButton gorevButon;
    private javax.swing.JButton gosterimButon;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton personelButon;
    private javax.swing.JButton salonButon;
    // End of variables declaration//GEN-END:variables
}
