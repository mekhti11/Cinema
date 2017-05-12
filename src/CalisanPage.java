
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;



/**
 *
 * @author mekhti
 */
public class CalisanPage extends javax.swing.JFrame {
    
    private int id;
    private String sql;
    Connection connection;
    Statement statement;
    ResultSet result;
    /**
     * Creates new form CalisanPage
     */
    public CalisanPage(int id) throws SQLException {
        this.id = id;
        initComponents();
        setNameLabel();
        setSeansComboBox();
        setSalonComboBox();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        seansComboBox = new javax.swing.JComboBox<>();
        salonComboBox = new javax.swing.JComboBox<>();
        salonGoruntuleButon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gorevButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        salonGoruntuleButon.setText("Salon Goruntule");
        salonGoruntuleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salonGoruntuleButonActionPerformed(evt);
            }
        });

        jLabel1.setText("Seans seç");

        jLabel2.setText("Salon No seç");

        gorevButon.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        gorevButon.setText("Görevli Olduğum Yerler");
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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(seansComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(salonComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addComponent(salonGoruntuleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(gorevButon, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seansComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(salonGoruntuleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addComponent(gorevButon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
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
    
    private void setNameLabel() throws SQLException{
        sql = "SELECT * FROM `Calisan` WHERE `id` = "+id ;
        connection = ConnectDB();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        String name="";
        if(result.next()){
            name += (String) result.getString("isim");
            name += " ";
            name += (String) result.getString("soyisim");
        }
        nameLabel.setText(name);
               
    }
    
    private void setSeansComboBox() throws SQLException{
        final DefaultComboBoxModel seansName = new DefaultComboBoxModel();
        int count = 0;
        sql = "SELECT COUNT(*) FROM `Seans` WHERE 1";
        connection = ConnectDB();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        if(result.next())
            count = result.getInt("COUNT(*)");
        for(int i=1;i<=count;i++){
            sql = "SELECT * FROM `Seans` WHERE `id` = "+i;
            result = statement.executeQuery(sql);
            if(result.next()){
                String s = result.getString("time");
                seansName.addElement(s);
            }
        }
        seansComboBox.setModel(seansName);
    }
    
    private void setSalonComboBox() throws SQLException{
        final DefaultComboBoxModel salonName = new DefaultComboBoxModel();
        sql = "SELECT * FROM `Salon` WHERE 1";
        result = statement.executeQuery(sql);
        while(result.next()){
                String s = result.getString("SalonNo");
                salonName.addElement(s);
        }
        salonComboBox.setModel(salonName);
        
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
    
    private void salonGoruntuleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonGoruntuleButonActionPerformed
        String seans =(String) seansComboBox.getSelectedItem();
        int seansId = seansId(seans);
        int salonNo = 0;
        int gosterimId = 0;
        String salon = (String) salonComboBox.getSelectedItem();
        salonNo = Integer.parseInt(salon);
        if(seansId == 0 || salonNo ==0 ){
            JOptionPane.showMessageDialog(null,"Seans veya Salon Giriniz ");
            return;
        }
        try {
            String str = "SELECT * FROM `Gosterim` WHERE `salonNo` = "+salonNo+" AND `seansId` = "+seansId;
            ConnectMySql conn = new ConnectMySql();
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(str);
            while(result.next()){
                gosterimId =result.getInt("GosterimId");
            }
        } catch (SQLException ex) { }
        if(gosterimId ==0){
            JOptionPane.showMessageDialog(null,"Gosterim Bulunamadi");
            return;
        }
        SalonCalisan sc = new SalonCalisan(gosterimId);
        sc.setVisible(true);
    }//GEN-LAST:event_salonGoruntuleButonActionPerformed

    private void gorevButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gorevButonActionPerformed
        CalisanGorev cg = null;
        try {
            cg = new CalisanGorev(id);
        } catch (SQLException ex) {}
        cg.setVisible(true);
    }//GEN-LAST:event_gorevButonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gorevButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> salonComboBox;
    private javax.swing.JButton salonGoruntuleButon;
    private javax.swing.JComboBox<String> seansComboBox;
    // End of variables declaration//GEN-END:variables
}
