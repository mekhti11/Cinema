/**
 * 
 * 
 * @author mekhti
 */



import java.sql.Connection;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

public class KoltukOlustur{
  public static Connection connection;
  public static Statement statement; 

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
  
  public static void main(String[] args) {
    ConnectMySql conn = new ConnectMySql();
    connection = ConnectDB();
    Random rand = new Random();
    String sql;
    int rndm;
    try{
      for(int i=1;i<=21;i++)
        for(int j=1;j<=5;j++)
          for(int k=1;k<=9;k++){
            rndm =rand.nextInt(3);
              System.out.println(rndm);
            sql = "INSERT INTO `Koltuk`(`GosterimId`, `row`, `sutun`, `value`) VALUES ("+i+","+j+","+k+","+rndm+")";
            statement = connection.createStatement();   
            statement.execute(sql);
          }       
      
    }catch(Exception e){
      System.out.println(e);
    }

  }
  

}