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
public class GorevEkle extends javax.swing.JFrame {

    /**
     * Creates new form GorevEkle
     */
    String sql;
    Connection connection;
    Statement statement;
    ResultSet result;
    public GorevEkle() throws SQLException {
        initComponents();
        set();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isimComboBox = new javax.swing.JComboBox<>();
        seansComboBox = new javax.swing.JComboBox<>();
        salonComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Gorev Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(isimComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(seansComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(salonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isimComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(seansComboBox)
                    .addComponent(salonComboBox))
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
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
        ArrayList al = new ArrayList<>();
        final DefaultComboBoxModel seansName = new DefaultComboBoxModel();
        final DefaultComboBoxModel salonName = new DefaultComboBoxModel();
        final DefaultComboBoxModel name = new DefaultComboBoxModel();
        int count = 0;
        String isim = "";
        sql = "SELECT * FROM `Seans` WHERE 1";
        connection = ConnectDB();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        while(result.next()){
            count = result.getInt("id");
            al.add(count);
        }
        al.sort(null);
        for(Object o : al){
            sql = "SELECT * FROM `Seans` WHERE `id` = "+(int) o;
            result = statement.executeQuery(sql);
            if(result.next()){
                String s = result.getString("time");
                seansName.addElement(s);
            }
        }
        seansComboBox.setModel(seansName);
        //done
        al.clear();
        sql = "SELECT * FROM `Salon` WHERE 1";
        result = statement.executeQuery(sql);
        while(result.next()){
            String s = result.getString("SalonNo");
            salonName.addElement(s);
        }
        salonComboBox.setModel(salonName);
        //done
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
        isimComboBox.setModel(name);
    }


    public boolean kontrol(){
        //Eklenecek
        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username =(String) isimComboBox.getSelectedItem();
        int calisanId =0;
        String time =(String) seansComboBox.getSelectedItem();
        int seansId =0;
        String sNo =(String) salonComboBox.getSelectedItem();
        int salonNo = Integer.parseInt(sNo);
        int gosterimId = 0;
        try{
            sql = "SELECT * FROM Calisan WHERE `username` = '"+username+"'";
            System.out.println(sql);
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if(result.next())
                calisanId = result.getInt("id");
            sql = "SELECT * FROM Seans WHERE `time` = '"+time+"'";
            System.out.println(sql);
            result = statement.executeQuery(sql);
            if(result.next())
                seansId = result.getInt("id");
                
            sql = "SELECT * FROM Gosterim WHERE `SeansId` = "+seansId + " AND `SalonNo` = "+salonNo;
            System.out.println(sql);
            result = statement.executeQuery(sql);
            if(result.next())
                gosterimId = result.getInt("GosterimId");
            else{
                JOptionPane.showMessageDialog(null, "Gosterim Bulunamadi !!!");
                return;
            }
            
            sql = "INSERT INTO `Gorev`(`CalisanId`, `GosterimId`) VALUES ( "+calisanId +" , "+gosterimId+")" ;
            System.out.println(sql);
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Gorev Eklendi");
        }catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GorevEkle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GorevEkle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> isimComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> salonComboBox;
    private javax.swing.JComboBox<String> seansComboBox;
    // End of variables declaration//GEN-END:variables
}
