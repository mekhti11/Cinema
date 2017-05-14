import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author mekhti
 */
public class Biletlerim extends javax.swing.JFrame {

    int id;
    String sql,str;
    String film,seans;
    int filmId,seansId,salonNo;
    Connection connection;
    Statement statement,statement2;
    ResultSet result,rSet;
    Object[][] objects;
    String[] columns = new String[] {
        "Seans","Film adi","Salon NO","Koltuk id" 
    };
    public Biletlerim(int id) throws SQLException {
        this.id = id;
        set();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(objects,columns);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleParent(jTable1);
        jTable1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
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
    public String seansAdlari(int i){
        String seans = null;
        try{
            connection = ConnectDB();
            statement = connection.createStatement();
            String sql = "SELECT * FROM Seans WHERE `id`="+i;
            result = statement.executeQuery(sql);
            while(result.next()){
                seans =(String) result.getString("time");
            }
            
        }catch(SQLException ex){
            
        }
        return seans;
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

    private void set() throws SQLException{
        int i=0,count=0;
        int gosterimId;
        int[] gosterimIds;
        sql = "SELECT COUNT(*) FROM Koltuk WHERE `userId` = "+id;
        connection = ConnectDB();
        statement2 = connection.createStatement();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        if(result.next())
            count = result.getInt("COUNT(*)");
        gosterimIds= new int[count];
        objects = new Object[count][4];
        sql = "SELECT * FROM Koltuk WHERE `userId` = "+id;
        result = statement.executeQuery(sql);
        while(result.next()){
            int kid = result.getInt("koltukId");
            kid = kid % 45;
            if(kid == 0)
                kid =45;
            objects[i][3] = kid;//kid = koltukId
            gosterimId = result.getInt("GosterimId");
            gosterimIds[i]= gosterimId;
            System.out.println("Biletlerim.set()");
            i++;
        }
        for(i=0;i<count;i++){
            str = "SELECT * FROM Gosterim WHERE `GosterimId` = "+gosterimIds[i];
            rSet = statement2.executeQuery(str);
            while(rSet.next()){
                objects[i][2] = rSet.getInt("SalonNo");
                objects[i][0] = seansAdlari(rSet.getInt("SeansId"));
                objects[i][1] = filmAdlari(rSet.getInt("FilmId"));
            }
        }        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
