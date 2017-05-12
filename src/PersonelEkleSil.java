import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;

/**
 *
 * @author mekhti
 */
public class PersonelEkleSil extends javax.swing.JFrame {


    Connection connection;
    Statement statement;
    ResultSet result;
    String sql;
    int calisanId=0;
    /**
     * Creates new form PersonelEkleSil
     */
    public PersonelEkleSil() throws SQLException {
        initComponents();
        set();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        soyisimTextField = new javax.swing.JTextField();
        isimTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameComboBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Sil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        usernameTextField.setText("username");

        passwordTextField.setText("password");


        soyisimTextField.setText("soyisim");


        isimTextField.setText("isim");


        jButton2.setText("Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(isimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(soyisimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameComboBox)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soyisimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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

    public void set() throws SQLException{
        final DefaultComboBoxModel name = new DefaultComboBoxModel();
        ArrayList al = new ArrayList<>();
        int count;
        String isim;
        connection = ConnectDB();
        statement = connection.createStatement();
        sql = "SELECT * FROM `Calisan` WHERE `adminlik` = "+0;
        result = statement.executeQuery(sql);
        while(result.next()){
            count = result.getInt("id");
            al.add(count);
        }
        al.sort(null);
        for(Object o : al){
            sql = "SELECT * FROM `Calisan` WHERE `id` = "+(int) o;
            result = statement.executeQuery(sql);
            if(result.next()){
                isim = result.getString("username");
                name.addElement(isim);
            }
        }
        usernameComboBox.setModel(name);
    }
    private void usernameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameComboBoxActionPerformed
        sql = "SELECT * FROM `Calisan` WHERE `username` = '" +(String) usernameComboBox.getSelectedItem()+"'";
        String isim = "";
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if(result.next()){
                isim += result.getString("isim");
                isim +=" ";
                isim += result.getString("soyisim");
            }
            jLabel1.setText(isim);          
        }catch(Exception e){System.out.println(sql);}

    }//GEN-LAST:event_usernameComboBoxActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sql = "SELECT * FROM `Calisan` WHERE `username` = '" +(String) usernameComboBox.getSelectedItem()+"'";
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if(result.next())
                calisanId = result.getInt("id");
            sql = "DELETE FROM `Calisan` WHERE `id` = "+calisanId;
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Personel Silindi");
            sql = "DELETE FROM `Gorev` WHERE `CalisanId` = "+calisanId;
            statement.execute(sql);
            PersonelEkleSil p = new PersonelEkleSil();
            p.setVisible(true);
            this.setVisible(false);           
        }catch(Exception e){System.out.println(sql);}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            sql = "INSERT INTO `Calisan`( `username`, `password`, `isim`, `soyisim`) VALUES ( '"+usernameTextField.getText()+"' , '"+
            passwordTextField.getText()+"','"+isimTextField.getText()+"','"+soyisimTextField.getText()+"')";
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Personel Eklendi");
            PersonelEkleSil p = new PersonelEkleSil();
            p.setVisible(true);
            this.setVisible(false);
        }catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PersonelEkleSil().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonelEkleSil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField isimTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField soyisimTextField;
    private javax.swing.JComboBox<String> usernameComboBox;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
