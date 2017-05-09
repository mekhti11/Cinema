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
    private int id;
    String film,seans;
    int filmId,seansId,gosterimId;
    Connection connection;
    Statement statement;
    ResultSet result;

    /**
     * Creates new form BiletAl
     */
    public BiletAl(int id) {
        this.setTitle("Buying ticket Page");
        this.id = id;
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

  jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Film Seç");

        jLabel3.setText("Seans Seç");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                            SeansSecBox.setModel(seansName); 
                            str = "SELECT * FROM `Filmler` WHERE `id`="+filmId;
                            result = statement.executeQuery(str);
                            System.out.println(str);
                            while(result.next()){
                                String text = (String) result.getString("filmBilgisi");
                                System.out.println(text);
                                jTextArea1.setText(text);
                            }
                        }catch(SQLException ex){
                            System.out.println("hata");
                        }                           
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filmSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SeansSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(filmSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SeansSecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
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
                gosterimId =result.getInt("GosterimId");
            }
        } catch (SQLException ex) { }
        Salon salon = new Salon(gosterimId,id);
        salon.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SeansSecBox;
    private javax.swing.JComboBox<String> filmSecBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
