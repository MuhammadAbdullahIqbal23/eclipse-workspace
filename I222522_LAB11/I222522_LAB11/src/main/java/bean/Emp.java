package bean;

// Employee Class
public class Emp 
{
	// Data Members
	private int id;    
	private String name;    
	private float salary;    
	private String designation;    
	    
	// <----- Getters & Setters ----->
	
	// A Getter to get the ID of Employee
	public int getId()
	{    
	    return id;    
	}    
	
	// A Setter to set the ID of Employee
	public void setId(int id) 
	{    
	    this.id = id;    
	}    
	
	// A Getter to get the Name of Employee
	public String getName()
	{    
	    return name;    
	}    
	
	// A Setter to set the Name of Employee
	public void setName(String name) 
	{    
	    this.name = name;    
	}    
	
	// A Getter to get the Salary of Employee
	public float getSalary()
	{    
	    return salary;    
	}
	
	// A Setter to set the Salary of Employee
	public void setSalary(float salary)
	{    
	    this.salary = salary;    
	}    
	
	// A Getter to get the Designation of Employee
	public String getDesignation() 
	{    
	    return designation;    
	} 
	
	// A Setter to set the Designation of Employee
	public void setDesignation(String designation) 
	{    
	    this.designation = designation;    
	}    
}
