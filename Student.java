import java.lang.*;

public class Student{
	private int Id;
	private String Name;
	private double Cgpa;
	
	public void setId(int id){
		Id = id;
	}
	public void setName(String name){
		Name = name;
	}
	public void setCgpa(double cgpa){
		Cgpa = cgpa;
	}
	
	public int getId(){
		return Id;
	}
	public String getName(){
		return Name;
	}
	public double getCgpa(){
		return Cgpa;
	}	
	
	public static void main(String[] args){
		Student s= new Student();
		s.setId(23513531); 
		s.setName("Shamiul Islam");
		s.setCgpa(3.5);

		System.out.println("My Id: " + s.getId());
		System.out.println("My Name: " + s.getName());
		System.out.println("My Cpga: " + s.getCgpa());
	}
}