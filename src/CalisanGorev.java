
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
public class CalisanGorev extends javax.swing.JFrame {
    int count =0;
    int id;
    int[] gosterim;
    private String sql;
    Connection connection;
    Statement statement;
    ResultSet result;
    /**
     * Creates new form CalisanGorev
     */
    public CalisanGorev(int id) throws SQLException {
        this.id = id;
        initComponents();
        setSeansComboBox();
        getGosterimId();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seansComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        seansComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    seansComboBoxActionPerformed(evt);
                }catch(Exception e){}
            }
        });

        jLabel1.setText("Seans Sec");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel2.setText("Görevli Olduğun SalonNo :");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seansComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seansComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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
    
    private void seansComboBoxActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_seansComboBoxActionPerformed
        String seans =(String) seansComboBox.getSelectedItem();
        int seansId = seansId(seans);
        int a = 0;
        int i=0;
        connection = ConnectDB();
        statement = connection.createStatement();
        for(i=0;i<count;i++){
            sql = "SELECT * FROM `Gosterim` WHERE `GosterimId` = "+gosterim[i];
            result = statement.executeQuery(sql);
            if(result.next()){
                a = (Integer) result.getInt("SeansId");
            }
            if(seansId == a){
                sql = "SELECT * FROM `Gosterim` WHERE `GosterimId` = "+gosterim[i];
                result = statement.executeQuery(sql);
                if(result.next()){
                    String sNo = (String) result.getString("SalonNo");
                    jLabel3.setText(sNo);
                } 
                return;  
            }
        }
        if(i==count){
            jLabel3.setText("Yok");
        }
        
    }//GEN-LAST:event_seansComboBoxActionPerformed

    private void getGosterimId() throws SQLException{
        sql = "SELECT COUNT(*) FROM `Gorev` WHERE `CalisanId` = "+id;
        connection = ConnectDB();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        if(result.next())
            count = result.getInt("COUNT(*)");
        gosterim = new int[count];
        sql = "SELECT * FROM `Gorev` WHERE `CalisanId` = "+id;
        connection = ConnectDB();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        int i=0;
        while(result.next()){
            gosterim[i] = (Integer) result.getInt("GosterimId");
            i++;    
        }   
        System.out.println(count);     
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> seansComboBox;
    // End of variables declaration//GEN-END:variables
}
