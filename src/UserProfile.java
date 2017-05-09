import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author mekhti
 */
public class UserProfile extends javax.swing.JFrame {
    private int id;
    Connection connection;
    Statement statement;
    ResultSet result ;


    public UserProfile(int id) {
        this.id = id;
        initComponents();
        set();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        takvimButon = new javax.swing.JButton();
        biletAlButon = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();
        puanLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        takvimButon.setText("Takvim Görüntüle");
        takvimButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takvimButonActionPerformed(evt);
            }
        });

        biletAlButon.setText("Bilet Al");
        biletAlButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biletAlButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(puanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(212, 212, 212)))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(biletAlButon, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(takvimButon, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(puanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(biletAlButon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(takvimButon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void set(){
        ImageIcon icon = new ImageIcon("/home/mekhti/NetBeansProjects/Cinema/images/users1.png");
        iconLabel.setIcon(icon);
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            String sql = "SELECT * FROM `Users` WHERE `id` = " +id;
            result = statement.executeQuery(sql);
            String username = "@";
            String name = null;
            while(result.next()){
                username += (String) result.getString("username");
                name = (String) result.getString("Name");
                name +=" ";
                name += (String) result.getString("Surname");
            }
            usernameLabel.setText(username);
            nameLabel.setText(name);
        }catch(Exception e){
            System.out.println(e+"\n***UserProfile***");
        }
    }

    private void biletAlButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biletAlButonActionPerformed
        BiletAl ba = new BiletAl(id);
        ba.setVisible(true);
    }//GEN-LAST:event_biletAlButonActionPerformed

    private void takvimButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takvimButonActionPerformed
        JOptionPane.showMessageDialog(null, "Daha Eklenmedi");
    }//GEN-LAST:event_takvimButonActionPerformed


    public Connection ConnectDB(){
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
    private javax.swing.JButton biletAlButon;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel puanLabel;
    private javax.swing.JButton takvimButon;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
