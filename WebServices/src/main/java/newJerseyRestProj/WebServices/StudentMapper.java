package newJerseyRestProj.WebServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentMapper {
	AllDbmsConnections con=new AllDbmsConnections();
	public void AddingStudent(Student p1) {
		try{
			
			String query="insert into Student values (?,?,?,?)";
			PreparedStatement pstmt=con.getConnectionObj().prepareStatement(query);
			
			
			pstmt.setInt(1,p1.getId());
			pstmt.setString(2,p1.getName());
			pstmt.setInt(3,p1.getAge());
			pstmt.setString(4,p1.getCountry());
			
			int i=pstmt.executeUpdate();
			if(i!=0){
				System.out.println("student details entered");
			}
			}catch(Exception ex){
				System.out.println("Exception raised");
			}
	}
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
