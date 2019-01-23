package newJerseyRestProj.WebServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentMapper {
	public Student GettingStudentDet(int Id) {
	Student sd=new Student();
	try{

		String q="select * from student where id="+Id;
		AllDbmsConnections con=new AllDbmsConnections();
		PreparedStatement pstmt=con.getConnectionObj().prepareStatement(q);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			sd.setId(rs.getInt(1));
			sd.setName(rs.getString(2));
			sd.setAge(rs.getInt(3));
			sd.setCountry(rs.getString(4));
			//System.out.println(rs.getInt(1));
			//System.out.println(rs.getString(2));
		}
	//
	}
	catch(Exception ex){
		System.out.println("Exception"+ex);
	}
	return sd;
	}
}
