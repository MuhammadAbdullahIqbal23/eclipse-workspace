package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import bean.Professor;

public class ProfessorDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Professor p) {
        String sql = "insert into Professor(name, courseCode, credits) values('" + p.getName() + "','" + p.getCourseCode() + "'," + p.getCredits() + ")";
        return template.update(sql);
    }

    public int update(Professor p) {
        String sql = "update Professor set name='" + p.getName() + "', courseCode='" + p.getCourseCode() + "', credits=" + p.getCredits() + " where id=" + p.getId();
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from Professor where id=" + id;
        return template.update(sql);
    }

    public Professor getProfessorById(int id) {
        String sql = "select * from Professor where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Professor>(Professor.class));
    }

    public List<Professor> getProfessors() {
        System.out.println("Fetching professors");
        return template.query("select * from Professor", new RowMapper<Professor>() {
            public Professor mapRow(ResultSet rs, int row) throws SQLException {
                Professor p = new Professor();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setCourseCode(rs.getString(3));
                p.setCredits(rs.getInt(4));
                System.out.println("Professor: " + p);
                return p;
            }
        });
    }
}

