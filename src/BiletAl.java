import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mekhti
 */
public class BiletAl extends javax.swing.JFrame {

    String film,seans;
    int filmId,seansId,salonNo;
    Connection connection;
    Statement statement;
    ResultSet result;

    /**
     * Creates new form BiletAl
     */
    public BiletAl() {
        initComponents();
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
    public int filmSay(){
        int filmSay = 0;
        try {
        //Database'den film sayisini alir
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(*) FROM Filmler";
            result = statement.executeQuery(sql);
            while(result.next()){
                filmSay = result.getInt("COUNT(*)");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return filmSay;
    }    
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        String sql;
        final DefaultComboBoxModel filmsName = new DefaultComboBoxModel();
        final JComboBox SeansSecBox = new JComboBox<>();  
        jButton1 = new javax.swing.JButton();
       
        int filmSay = filmSay();
       
        for(int i=1;i<=filmSay;i++)
            filmsName.addElement(filmAdlari(i));
    
        final JComboBox filmSecBox = new JComboBox<>(filmsName);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filmSecBox.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int seansSay=0;
                        final DefaultComboBoxModel seansName = new DefaultComboBoxModel();
                        JComboBox combo = (JComboBox)e.getSource();
                        film = (String)combo.getSelectedItem();
                        filmId = filmId(film);
                        try{
                            String str = "SELECT COUNT(*) FROM Gosterim WHERE `filmId` = "+filmId;
                            ConnectMySql conn = new ConnectMySql();
                            connection = conn.ConnectDB();
                            statement = connection.createStatement();
                            result = statement.executeQuery(str);
                            while(result.next()){
                                seansSay =result.getInt("COUNT(*)");
                            }
                            int[] ids = new int[seansSay];
                            int i=0;
                            str = "SELECT * FROM Gosterim WHERE `filmId` = "+filmId;
                            result = statement.executeQuery(str);
                            while(result.next()){
                                seansId = result.getInt("SeansId");
                                ids[i] = seansId;
                                i++;
                            }
                            for(i=0;i<seansSay;i++){
                                str = "SELECT * FROM Seans WHERE `id` = "+ids[i];
                                result = statement.executeQuery(str);
                                while(result.next()){
                                    String s = result.getString("time");
                                    seansName.addElement(s);
                                }
                            }    
                        }catch(SQLException ex){
                            System.out.println("hata");
                         }  
                       SeansSecBox.setModel(seansName);                            
                    }
                }            
        );
        

        SeansSecBox.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        seans = (String) combo.getSelectedItem();
                        seansId = seansId(seans);
                    }
                }            
        );


        jButton1.setText("Salon Goruntule");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filmSecBox, 0, 200, Short.MAX_VALUE)
                            .addComponent(SeansSecBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(filmSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(SeansSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String str = "SELECT * FROM `Gosterim` WHERE `filmId` = "+filmId+" AND `seansId` = "+seansId;
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(str);
            while(result.next()){
                salonNo =result.getInt("SalonNo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiletAl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(salonNo);
        //Salon salon = new Salon();
        //salon.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> SeansSecBox;
    private javax.swing.JComboBox<String> filmSecBox;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
