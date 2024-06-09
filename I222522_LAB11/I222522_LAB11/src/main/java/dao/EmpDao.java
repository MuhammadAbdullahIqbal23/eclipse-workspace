package dao;

// Libraries that were imported
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import bean.Emp; 

// Employee's DAO Class
public class EmpDao 
{

	JdbcTemplate template;    
    
	// A Setter to set the JDBC Template
	public void setTemplate(JdbcTemplate template) 
	{    
	    this.template = template;    
	}    
	
	// A method responsible for saving the data in the database
	public int save(Emp p)
	{    
	    String sql="insert into Emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";    
	    return template.update(sql);    
	}
	
	// A method that is responsible for updating the data in the database
	public int update(Emp p)
	{    
	    String sql="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";    
	    return template.update(sql);    
	}    
	
	// A method that is responsible for deleting the data from the database
	public int delete(int id)
	{    
	    String sql="delete from Emp99 where id="+id+"";    
	    return template.update(sql);    
	}    
	
	// A method that is responsible of getting data of any one employee by their ID
	public Emp getEmpById(int id)
	{    
	    String sql="select * from Emp99 where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));    
	}    
	
	// A method that is responsible for getting the data of all of the employees
	public List<Emp> getEmployees()
	{    
	    return template.query("select * from Emp99",new RowMapper<Emp>()
	    {    
	        public Emp mapRow(ResultSet rs, int row) throws SQLException 
	        {    
	            Emp e=new Emp();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getFloat(3));    
	            e.setDesignation(rs.getString(4));    
	            return e;    
	        }    
	    });    
	}    
	
}
