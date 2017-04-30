import java.sql.Connection;
import java.sql.Statement;

public class KoltukOlustur{
  private Connection conn;
  private Statement statement; 
  
  public static void main(String[] args) {
    ConnectMySql cMySql = new ConnectMySql();
    String sql;
    conn = cMySql.ConnectDB();
    try{

      
      
    }catch(Exception e){
      System.out.println(e);
    }

  }

}