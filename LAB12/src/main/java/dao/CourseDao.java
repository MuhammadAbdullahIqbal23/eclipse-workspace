package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bean.Course;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Course course) {
        String sql = "INSERT INTO Course (title, credits, instructor) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, course.getTitle(), course.getCredits(), course.getInstructor());
    }

    public Course getById(int id) {
        String sql = "SELECT * FROM Course WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Course.class));
    }

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM Course";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
    }

    public int update(Course course) {
        String sql = "UPDATE Course SET title=?, credits=?, instructor=? WHERE id=?";
        return jdbcTemplate.update(sql, course.getTitle(), course.getCredits(), course.getInstructor(), course.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Course WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
