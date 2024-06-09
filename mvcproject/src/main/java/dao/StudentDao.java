package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import bean.Student;

public class StudentDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Student s) {
        String sql = "insert into Student(name, major, gpa) values('" + s.getName() + "','" + s.getMajor() + "'," + s.getGpa() + ")";
        return template.update(sql);
    }

    public int update(Student s) {
        String sql = "update Student set name='" + s.getName() + "', major='" + s.getMajor() + "', gpa=" + s.getGpa() + " where id=" + s.getId();
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from Student where id=" + id;
        return template.update(sql);
    }

    public Student getStudentById(int id) {
        String sql = "select * from Student where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }

    public List<Student> getStudents() {
        System.out.println("Fetching students");
        return template.query("select * from Student", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int row) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setMajor(rs.getString(3));
                s.setGpa(rs.getDouble(4));
                System.out.println("Student: " + s);
                return s;
            }
        });
    }
}