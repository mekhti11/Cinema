
import java.sql.*;
import javax.swing.*;

public class ConnectMySql{
  
  private Connection connect = null;

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
}