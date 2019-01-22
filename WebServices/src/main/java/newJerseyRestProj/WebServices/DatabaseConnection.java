package newJerseyRestProj.WebServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String s="root";
			String pass="12345678";
			String url="jdbc:mysql://localhost:3306/DigitalShoppingCart";
			String q="select * from demo ";
			//
			Connection con=DriverManager.getConnection(url,s,pass);
			PreparedStatement pstmt=con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}
		//
		}
		catch(Exception ex){
			System.out.println("Exception"+ex);
		}
	}

}
