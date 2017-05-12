
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
public class FilmEkleSil extends javax.swing.JFrame {

    /**
     * Creates new form FilmEkleSil
     */
    int filmId;
    ArrayList ids;
    Connection connection;
    Statement statement;
    ResultSet result;
    public FilmEkleSil() throws SQLException {
        initComponents();
        set();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filmComboBox = new javax.swing.JComboBox<>();
        silButon = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        ekleButon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bilgiText = new javax.swing.JTextArea();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        silButon.setText("Sil");
        silButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    silButonActionPerformed(evt);
                }catch(Exception e){}
            }
        });

        jTextField1.setText("Film ismi");

        ekleButon.setText("Ekle");
        ekleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButonActionPerformed(evt);
            }
        });

        bilgiText.setColumns(20);
        bilgiText.setRows(5);
        bilgiText.setText("Film Bilgileri");
        jScrollPane1.setViewportView(bilgiText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ekleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(silButon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(silButon))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ekleButon)
                .addGap(160, 160, 160))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



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

    private void set() throws SQLException{
        final DefaultComboBoxModel filmsName = new DefaultComboBoxModel();
        int filmSay = filmSay();
        ids = new ArrayList<>();

        String sql = "SELECT * FROM Filmler WHERE 1";
        ConnectMySql conn = new ConnectMySql();
        connection = conn.ConnectDB();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        int i=0;
        while(result.next()){
            i =(Integer) result.getInt("id");
            ids.add(i);
        }
        ids.sort(null);
        for(Object in : ids)
            filmsName.addElement(filmAdlari((int) in));
        filmComboBox.setModel(filmsName);
    }
    private void silButonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{//GEN-FIRST:event_silButonActionPerformed
        ConnectMySql conn = new ConnectMySql();
        connection = conn.ConnectDB();
        statement = connection.createStatement();
        String film = (String)filmComboBox.getSelectedItem();
        filmId = filmId(film);
        int a = JOptionPane.showConfirmDialog(null,"Seçilen Film Silinecektir . Onaylıyor musunuz?" );
        if(a==0){
            String sql = "DELETE FROM `Filmler` WHERE `id` = "+filmId;
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Film Silindi");
            FilmEkleSil f = new FilmEkleSil();
            f.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_silButonActionPerformed

    private void ekleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButonActionPerformed
        String sql = "INSERT INTO `Filmler`( `filmAd`, `filmBilgisi`) VALUES ('"+jTextField1.getText()+"','"+bilgiText.getText()+"')";
        ConnectMySql conn = new ConnectMySql();
        try{
            connection = conn.ConnectDB();
            statement = connection.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Film Eklendi");
             FilmEkleSil f = new FilmEkleSil();
            f.setVisible(true);
            this.setVisible(false);
        }catch(Exception e){}
    }//GEN-LAST:event_ekleButonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bilgiText;
    private javax.swing.JButton ekleButon;
    private javax.swing.JComboBox<String> filmComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton silButon;
    // End of variables declaration//GEN-END:variables
}
