package newJerseyRestProj.WebServices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {
	public Student() {
		
	}
	int Id;
	String Name="";
	int Age;
	String Country="";
	@XmlElement(name="Id")
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@XmlElement(name="Name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@XmlElement(name="Age")
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@XmlElement(name="Country")
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
}
