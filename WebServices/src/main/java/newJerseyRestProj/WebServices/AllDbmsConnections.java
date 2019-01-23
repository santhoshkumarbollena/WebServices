package newJerseyRestProj.WebServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class AllDbmsConnections {
	Connection con;
	public Connection getConnectionObj()
	{
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String s="root";
		String pass="12345678";
		String url="jdbc:mysql://localhost:3306/Acheron";
		
		//System.out.println(q);
		 con=DriverManager.getConnection(url,s,pass);
		return con;
	}catch(Exception ex) {
		
	}
	return con;
	}
}
