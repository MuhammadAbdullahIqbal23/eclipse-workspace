package i222504_LAB2;

import java.util.ArrayList;

public class i222504_LAB2_TASK1 {

	public static void main(String[] args) {
		 Student student = new Student("Ahmed", "xyz");
		 Professor professor = new Professor("Ali", "abc");
		 professor.addCourseTaught("Math");
		 professor.addCourseTaught("physics");
		 professor.addCourseTaught("BIO");
		 professor.addCourseTaught("Islamiat");
		 
	        student.addCourseWithGrade("Math", 90);
	        student.addCourseWithGrade("English", 85);
	        student.addCourseWithGrade("History", 92);

	        System.out.println("Student Information:");
	        System.out.println("Name: " + student.name);
	        System.out.println("Address: " + student.address);
	        System.out.println("Courses and Grades:");
	        student.print();
	        System.out.println("Professer Information:");
	        System.out.println("Name: " + professor.name);
	        System.out.println("Address: " + professor.address);
	        professor.printCoursesTaught();
	        professor.removeCourseTaught("BIO");
	        System.out.println("\nAfter removing BIO from courses\n");
	        professor.printCoursesTaught();
	        
	        }

	}
	class Person{
		String name;
		String address;
		
		public Person(String name, String address) {
	        this.name = name;
	        this.address = address;
	    }
		
	}
	class Student extends Person{
		 ArrayList<String> Courses = new ArrayList<String>();
		 ArrayList<Integer> Grades = new ArrayList<Integer>();
		 int numberOfCourses = 0;
		 
		public Student(String name, String address) {
	        super(name, address);
	        this.Courses = new ArrayList<>();
	    }
		 public void addCourseWithGrade(String courseName, int grade) {
			 if (Courses.size()<30) {
				 if(Grades.size()<30) {
					 Courses.add(numberOfCourses, courseName);
					 Grades.add(numberOfCourses, grade);
					 numberOfCourses++;
				 }
			 }
			 
			 
		 }
		 public void print() {
			    for (int i = 0; i < numberOfCourses; i++) {
			        System.out.println("Course: " + Courses.get(i) + ", Grade: " + Grades.get(i));
			    }
			}

		
		
		
		
	}
	class Professor extends Person{
		 private ArrayList<String> coursesTaught;
		 int numOfCoursesTaught = 0;
		    public Professor(String name, String address) {
		        super(name, address);
		        this.coursesTaught = new ArrayList<>();
		    }

		    public void addCourseTaught(String courseName) {
		        if (coursesTaught.size() < 5) {
		        	
		            coursesTaught.add(courseName);
		            numOfCoursesTaught++;
		        } else {
		            System.out.println("Cannot teach more than 5 courses concurrently");
		        }
		    }

		    public void removeCourseTaught(String courseName) {
		        coursesTaught.remove(courseName);
		        numOfCoursesTaught--;
		    }

		    public void printCoursesTaught() {
		    	for (int i = 0; i < numOfCoursesTaught; i++) {
			        System.out.println("Course: " + coursesTaught.get(i));
			    }
		    }
		
	}



