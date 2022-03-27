import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	    public static final String URL = "jdbc:mysql://localhost:3306/pdoposts";
	    public static final String USER = "root";
	    public static final String PASSWORD = "";

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	    Scanner input = new Scanner(System.in);
	    Class.forName("com.mysql.jdbc.Driver");
        //2. Gain the database connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.operate the database
        Statement stmt = conn.createStatement();
        
     
        while(true) {
        System.out.println("Please enter ur number");
        
        int number3 = input.nextInt();
        
        switch(number3) {
        
        case 1:
        	
        	show_view(stmt);
        	
        	break;
        	
        case 2:	
       
            System.out.println("Please enter the students id:");
            
            int number = input.nextInt();
            
            String number1=new String();//enter the string value
            
            System.out.println("Please enter the students firstname:");
            
            number1=input.next();
        	
        	insert_value(stmt,conn,number,number1);
        	
        	break;
        	
        case 3:
        	
        	  System.out.println("Please enter the deleted students id:");
              
              int number2 = input.nextInt();
              
        	   delete_value(stmt,conn,number2);
        	
        	break;
        	
        case 4:
        	
        	   System.out.println("Please enter the students id:");
               
               int number4 = input.nextInt();
               
               String number5=new String();//enter the string value
               
               System.out.println("Please enter the students firstname:");
               
               number5=input.next();
           	
           	   update_value(stmt,conn,number4,number5);
           	
           	break;
        	
        	
        }
         
        }
    }
		
	//show value of database
	public static void show_view(Statement stmt) throws ClassNotFoundException, SQLException {
		
		  
	        ResultSet rs = stmt.executeQuery("SELECT id_students, first_name FROM customers");
	        //，rs.next() return true
	        while(rs.next()){//view the data
	            
	       System.out.println("ID: "+rs.getString("id_students")+" Age："+rs.getString("first_name"));
	                
	              
	        }
		
	}
	
	//insert value of database
	public static void insert_value(Statement stmt,Connection conn,int number,String number1) throws ClassNotFoundException, SQLException {
	
       
      String sql="INSERT INTO customers(id_students,first_name)VALUES(?,?)";
 
      PreparedStatement preparedStatement = conn.prepareStatement(sql);
 
      preparedStatement.setInt(1, number);
 
     preparedStatement.setString(2, number1);
 
     preparedStatement.executeUpdate();
      
     System.out.println("Inserted records into the table...");  
 		
		
	}
	//delete value of database(According to id_customer)
	public static void delete_value (Statement stmt,Connection conn,int number) throws ClassNotFoundException, SQLException {
		
		
	
	      
	      String sql="DELETE FROM customers WHERE id_students=?";
	      
	      PreparedStatement preparedStatement = conn.prepareStatement(sql);
	      
	      preparedStatement.setInt(1, number);
	      
	      preparedStatement.executeUpdate();
	      
	      System.out.println("Delete records into the table successfully");  
		
	}
	
	public static void update_value (Statement stmt,Connection conn,int number,String number1) throws ClassNotFoundException, SQLException {
		
		
		String sql="UPDATE customers set first_name=? WHERE id_students=?";
		
		 PreparedStatement preparedStatement = conn.prepareStatement(sql);
		 
		 preparedStatement.setString(1, number1);
		 
		 preparedStatement.setInt(2, number);
	 
	     preparedStatement.executeUpdate();
	      
	     System.out.println("Updated records into the table...");  
		
		
	}
	
	
	
	
}
