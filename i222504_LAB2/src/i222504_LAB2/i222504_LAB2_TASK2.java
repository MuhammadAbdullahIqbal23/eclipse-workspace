package i222504_LAB2;

import java.util.ArrayList;

class Stud {
    private int id;
    private String name;
    private int age;

    public Stud(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

class Enrollment {
    ArrayList<Stud> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();

    void enroll(Stud student, Course course) {
        students.add(student);
        courses.add(course);
    }

    void drop(Stud student, Course course) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == student && courses.get(i) == course) {
                students.remove(i);
                courses.remove(i);
                
            }
        }
    }
}

public class i222504_LAB2_TASK2 {
	private static void displayEnrollment(Enrollment enrollment) {
        for (int i = 0; i < enrollment.students.size(); i++) {
            Stud student = enrollment.students.get(i);
            Course course = enrollment.courses.get(i);
            System.out.println("Student: " + student.getName() + ", Course: " + course.getCourseName());
        }
    }

    public static void main(String[] args) {
        
        Stud student1 = new Stud(2504, "Abdullah", 21);
        Stud student2 = new Stud(2428, "Nawal", 21);
        Stud student3 = new Stud(8761, "Mohammad", 21);

        
        Course c1 = new Course("#123", "OOP");
        Course c2 = new Course("#456", "DS");
        Course c3 = new Course("#789", "DBS");

        Enrollment e1 = new Enrollment();

        e1.enroll(student1, c1);
        e1.enroll(student1, c2);
        e1.enroll(student1, c3);
        e1.enroll(student2, c2);
        e1.enroll(student3, c3);

        System.out.println("Enrolled Students and Courses:");
        displayEnrollment(e1);

        e1.drop(student2, c2);
        e1.drop(student1, c2);

        System.out.println("\nEnrollment after dropping students:");
        displayEnrollment(e1);
    }

    
}
