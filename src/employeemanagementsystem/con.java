
package employeemanagementsystem;
import java.sql.*;
public class con {

    Connection c;
    Statement st;
    //Connection c;
    public con(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","123456");
            st=c.createStatement();
        }
        catch(Exception e){
            
        }
        
    }
    
}
