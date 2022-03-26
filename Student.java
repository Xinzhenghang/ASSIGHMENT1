import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
	  public static final String URL = "jdbc:mysql://localhost:3306/pdoposts";
	    public static final String USER = "root";
	    public static final String PASSWORD = "";

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		  //1.load the driver
        Class.forName("com.mysql.jdbc.Driver");
        //2. Gain the database connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.operate the database
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id_customers, first_name FROM customers");
        //，rs.next() return true
             while(true){
            
            if(rs.next()){
                
                System.out.println("ID: "+rs.getString("id_customers")+" Age："+rs.getString("first_name"));
                
                break;
            }
          
        }
    }
		
	

}
