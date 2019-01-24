package newJerseyRestProj.WebServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentMapper {
	DBServices con=new DBServices();
	//Adding student details to DB using POST request
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
	//Getting student details using ID of the student on GET request
	public Student GettingStudentDet(int Id) {
	Student sd=new Student();
	try{

		String q="select * from student where id="+Id;
		DBServices con=new DBServices();
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
	//deleting student details
	public void deleteStudentDetails(int id) {
		try{
			String query="delete from Student where id="+id;
			PreparedStatement pstmt=con.getConnectionObj().prepareStatement(query);
			boolean f=pstmt.execute();
			System.out.println(f);
		}catch(Exception ex){
			System.out.println("Exception in Student mapper in deleteStudent"+ex);
		}
		
		
	}
	//updating student details based on ID
	public void updateDetailsOfTheStudent(Student s1, int id) {
		try{
			
			String query="update Student set Id='"+s1.getId()+"',name='"+s1.getName()+"',age='"+s1.getAge()+"',country='"+s1.getCountry()+"' where Id='"+id+"';";
				PreparedStatement pstmt=con.getConnectionObj().prepareStatement(query);
				int i=pstmt.executeUpdate();
				if(i==1)
				{
					System.out.println("updated succesfully");
				}
			}catch(Exception ex){
				System.out.println("error in updatedetails of Student"+ex);
			}
			
		}
		
	
}
