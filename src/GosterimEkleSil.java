import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


/**
 *
 * @author mekhti
 */
public class GosterimEkleSil extends javax.swing.JFrame {

    /**
     * Creates new form GosterimEkleSil
     */
    String sql;
    Connection connection;
    Statement statement;
    ResultSet result;
    public GosterimEkleSil() {
        initComponents();
        set();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gosterimComboBox = new javax.swing.JComboBox<>();
        seansLabel = new javax.swing.JLabel();
        filmLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        salonLabel = new javax.swing.JLabel();
        filmComboBox1 = new javax.swing.JComboBox<>();
        seansComboBox2 = new javax.swing.JComboBox<>();
        salonComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        seansLabel1 = new javax.swing.JLabel();
        filmLabel1 = new javax.swing.JLabel();
        salonLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        gosterimComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gosterimComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Gosterim id");

        jButton2.setText("Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Film Sec");

        jLabel8.setText("Salon Sec");

        jLabel9.setText("Seans Sec");

        jButton3.setText("Sil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        seansLabel1.setText("Seans");

        filmLabel1.setText("Film Adi");

        salonLabel1.setText("Salon No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(gosterimComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seansLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(salonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seansLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filmLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filmComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seansComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salonComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seansLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filmLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gosterimComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seansLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filmComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seansComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salonComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String filmAdlari(int i){
        String film = null;
        try{
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            String sql = "SELECT * FROM Filmler WHERE `id`="+i;
            result = statement.executeQuery(sql);
            while(result.next()){
                film =(String) result.getString("filmAd");
            }
            
        }catch(SQLException ex){
            
        }
        return film;
    }

    public int filmId(String name){
        int id =0;
        String str ="SELECT * FROM `Filmler` WHERE `filmAd` = "+'"' +name+'"';
        try{
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(str);
            while(result.next()){
                id = result.getInt("id");
            }
                      
       }catch(SQLException ex){}  
       return id;                                           
    }

    public int seansId(String name){
        int id =0;
        String str ="SELECT * FROM `Seans` WHERE `time` = "+'"' +name+'"';
        try{
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(str);
            while(result.next()){
                id = result.getInt("id");
               
            }
                      
       }catch(SQLException ex){}  
       return id;                                           
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

    public void set(){
        ArrayList al = new ArrayList<>();
        final DefaultComboBoxModel seansName = new DefaultComboBoxModel();
        final DefaultComboBoxModel salonName = new DefaultComboBoxModel();
        final DefaultComboBoxModel filmName = new DefaultComboBoxModel();
        final DefaultComboBoxModel gosterimName = new DefaultComboBoxModel();
        sql = "SELECT * FROM Filmler WHERE 1";
        try{    
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                int a = result.getInt("id");
                al.add(a);
            }
            al.sort(null);
            for(Object o : al){
                filmName.addElement(filmAdlari((int) o));
            }
            filmComboBox1.setModel(filmName);

            al.clear();
            sql = "SELECT * FROM `Seans` WHERE 1";
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                int count = result.getInt("id");
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
            seansComboBox2.setModel(seansName);
            
            sql = "SELECT * FROM `Salon` WHERE 1";
            result = statement.executeQuery(sql);
            while(result.next()){
                String a = result.getString("SalonNo");
                salonName.addElement(a);
            }
            salonComboBox3.setModel(salonName);

            sql = "SELECT * FROM Gosterim WHERE 1";
            result = statement.executeQuery(sql);
            while(result.next()){
                String a = result.getString("GosterimId");
                gosterimName.addElement(a);
            }
            gosterimComboBox.setModel(gosterimName);

        }catch(Exception e){System.out.println(e);}

    }

    private void gosterimComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gosterimComboBoxActionPerformed
        int seansId=0,filmId=0;
        String salonNo="";
        int gosterimId = Integer.valueOf((String) gosterimComboBox.getSelectedItem());
        sql = "SELECT * FROM Gosterim WHERE `GosterimId` = " + gosterimId;
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if(result.next()){
                seansId = result.getInt("SeansId");
                filmId = result.getInt("FilmId");
                salonNo = result.getString("SalonNo");
            }
            salonLabel.setText((String) salonNo);
            sql = "SELECT * FROM Seans WHERE `id` = "+seansId;
            result = statement.executeQuery(sql);
            if(result.next())
                seansLabel.setText(result.getString("time"));
            filmLabel.setText(filmAdlari(filmId));
        }catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_gosterimComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filmId = filmId((String) filmComboBox1.getSelectedItem());
        int seansId = seansId((String) seansComboBox2.getSelectedItem());
        int salonNo = Integer.valueOf((String) salonComboBox3.getSelectedItem());
        sql = "SELECT * FROM Gosterim WHERE `SeansId` = "+seansId + " AND `SalonNo` = "+salonNo;
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if(result.next() ){
                JOptionPane.showMessageDialog(null, "Secili Seansda Secili Salon Dolu");
                return;
            }
            sql = "INSERT INTO `Gosterim`( `FilmId`, `SeansId`, `SalonNo`) VALUES ("+filmId+","+seansId+","+salonNo+")";
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Gosterim Basariyla Eklendi");
             new GosterimEkleSil().setVisible(true);
             this.setVisible(false);
        }catch(Exception exception){System.out.println(exception);}
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int gosterimId = Integer.valueOf((String) gosterimComboBox.getSelectedItem());
        
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            sql = "DELETE FROM `Gosterim` WHERE `GosterimId` = " + gosterimId;
            statement.execute(sql);  
            sql = "DELETE FROM `Gorev` WHERE `GosterimId` = " + gosterimId;
            statement.execute(sql);  
             sql = "DELETE FROM `Koltuk` WHERE `GosterimId` = " + gosterimId;
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Silme Islemi Basarili");
            new GosterimEkleSil().setVisible(true);
            this.setVisible(false);
        }catch(Exception e){System.out.println(e);} 
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GosterimEkleSil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filmComboBox1;
    private javax.swing.JLabel filmLabel;
    private javax.swing.JLabel filmLabel1;
    private javax.swing.JComboBox<String> gosterimComboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> salonComboBox3;
    private javax.swing.JLabel salonLabel;
    private javax.swing.JLabel salonLabel1;
    private javax.swing.JComboBox<String> seansComboBox2;
    private javax.swing.JLabel seansLabel;
    private javax.swing.JLabel seansLabel1;
    // End of variables declaration//GEN-END:variables
}
