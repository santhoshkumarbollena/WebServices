package newJerseyRestProj.WebServices;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "got it";
    }
    @GET
	@Path("/GetStudentDetailsWithId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentWithId(@PathParam("id") String Id)
	{
    	Student sd=new Student();
    	try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String s="root";
			String pass="12345678";
			String url="jdbc:mysql://localhost:3306/Acheron";
			String q="select * from student where id="+Id;
			//
			Connection con=DriverManager.getConnection(url,s,pass);
			PreparedStatement pstmt=con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				sd.setId(rs.getInt(1));
				sd.setName(rs.getString(2));
				sd.setAge(rs.getInt(3));
				sd.setCountry(rs.getString(4));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		//
		}
		catch(Exception ex){
			System.out.println("Exception"+ex);
		}
		return sd;
		
	}
}
