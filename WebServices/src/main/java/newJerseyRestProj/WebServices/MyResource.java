package newJerseyRestProj.WebServices;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	public Student getStudentWithId(@PathParam("id") int Id)
	{
    	StudentMapper studentobj=new StudentMapper();
    	return studentobj.GettingStudentDet(Id);
	}
	@POST
	@Path("/StudentDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	public void AddingToCart(Student p1) {
		
		StudentMapper st=new StudentMapper();
		 st.AddingStudent(p1);
		
	}
}
