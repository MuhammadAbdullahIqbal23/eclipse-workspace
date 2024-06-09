package i222504_G_Lab_Sessional_Q2;
import java.sql.*;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Abdullah";
		String username = "root";
		String password = "abdullahabiiqbalabii54321100";
		System.out.println("Connecting database");
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		     System.out.println("Database connected!");
		     Statement s = connection.createStatement();
             
		     //Inserting Values//
            boolean flag=true;
            Scanner input=new Scanner(System.in);
            String answer;
            int ans;
            int choice;
            while(flag) {
            	System.out.println("Select choices:");
            	System.out.println("1.Add Patient:");
            	System.out.println("2.Delete Patient:");
            	System.out.println("3.Update Patient:");
            	System.out.println("4.View Patient:");
            	System.out.println("5.Add Doctor:");
            	System.out.println("6.Delete Doctor:");
            	System.out.println("7.Update Doctor:");
            	System.out.println("8.View Doctor:");
            	System.out.println("9.Add Appointment:");
            	System.out.println("10.Delete Appointment:");
            	System.out.println("11.Update Appointment:");
            	System.out.println("12.View Appointment:");
            	choice=input.nextInt();
            	switch(choice) {
            	case 1:
            	    s.execute("CREATE TABLE IF NOT EXISTS Patient (patientName VARCHAR(20), age INTEGER, contactInfo INTEGER, symptoms VARCHAR(20))");
            	    Patient p = new Patient();
            	    System.out.println("Enter Name");
            	    input.nextLine(); 
            	    answer = input.nextLine();
            	    p.setName(answer);
            	    System.out.println("Enter Age");
            	    ans = Integer.parseInt(input.nextLine());
            	    p.setAge(ans);
            	    System.out.println("Enter contactInfo");
            	    ans = Integer.parseInt(input.nextLine());
            	    p.setContactInfo(ans);
            	    System.out.println("Enter Symptoms");
            	    answer = input.nextLine();
            	    p.setSymptoms(answer);

            	    String insertPatientQuery = "INSERT INTO Patient (patientName, age, contactInfo, symptoms) VALUES (?, ?, ?, ?)";
            	    PreparedStatement ps = connection.prepareStatement(insertPatientQuery);
            	    ps.setString(1, p.getName());
            	    ps.setInt(2, p.getAge());
            	    ps.setInt(3, p.getContactInfo());
            	    ps.setString(4, p.getSymptoms());
            	    ps.executeUpdate(); // execute the insert query

            	    System.out.println("Patient '" + p.getName() + "' added successfully!");
            	    break;
            	    
            	case 2:
            		//Deleting row
            		System.out.println("Enter Name"); input.nextLine(); // Consume newline character
            		String patientName;
            		patientName=input.nextLine();
            		String deletePatientQuery = "DELETE FROM Patient WHERE patientName = ?";
            		ps = connection.prepareStatement(deletePatientQuery);
            	        ps.setString(1, patientName);
            	    int rowsAffected = ps.executeUpdate();
            	    if(rowsAffected>0) {
            	    	 System.out.println("Patient '" + patientName + "' deleted successfully!");
            	    	 rowsAffected=0;//set
            	    }
            	    else {
            	    	System.out.println("No patient found with the name " + patientName);
            	    }
            	    break;
            	case 3:
            		//Update
            		 String attributeName;
            		    String attributeValue;
            		    int attributeValueInt;
            		    
            		    input.nextLine(); // Consume newline character

            		    System.out.println("Enter Name:");
            		    patientName = input.nextLine();

            		    System.out.println("Enter choice you want to update:");
            		    System.out.println("1. Name");
            		    System.out.println("2. Age");
            		    System.out.println("3. Contact Info");
            		    System.out.println("4. Symptoms");
            		    int choose = input.nextInt();

            		    switch (choose) {
            		        case 1:
            		            attributeName = "patientName";
            		            System.out.println("Enter the new name:");
            		            input.nextLine(); // Consume newline character
            		            attributeValue = input.nextLine();
            		            break;
            		        case 2:
            		            attributeName = "age";
            		            System.out.println("Enter the new age:");
            		            attributeValueInt = input.nextInt();
            		            attributeValue = String.valueOf(attributeValueInt);
            		            break;
            		        case 3:
            		            attributeName = "contactInfo";
            		            System.out.println("Enter the new contact info:");
            		            attributeValueInt = input.nextInt();
            		            attributeValue = String.valueOf(attributeValueInt);
            		            break;
            		        case 4:
            		            attributeName = "symptoms";
            		            System.out.println("Enter the new symptoms:");
            		            input.nextLine(); // Consume newline character
            		            attributeValue = input.nextLine();
            		            break;
            		        default:
            		            System.out.println("Invalid choice.");
            		            return;
            		    }

            		    String updatePatientQuery = "UPDATE Patient SET " + attributeName + " = ? WHERE patientName = ?";
            		    ps = connection.prepareStatement(updatePatientQuery);
            		        ps.setString(1, attributeValue);
            		        ps.setString(2, patientName);
            		        rowsAffected = ps.executeUpdate();
                    	    if(rowsAffected>0) {
                    	    	 System.out.println("Patient '" + patientName + "' updated successfully!");
                    	    	 rowsAffected=0;//set
                    	    }
                    	    else {
                    	    	System.out.println("No patient found with the name " + patientName);
                    	    }
            		        break;
            	case 4:
            	    System.out.println("Enter Name"); 
            	    input.nextLine(); // Consume newline character
            	    patientName = input.nextLine();

            	    String viewQuery = "SELECT * FROM Patient WHERE patientName = ?";
            	    ps = connection.prepareStatement(viewQuery);
            	    ps.setString(1, patientName);
            	    ResultSet rs = ps.executeQuery();

            	    if (rs.next()) {
            	        System.out.println("Name: " + rs.getString("patientName"));
            	        System.out.println("Age: " + rs.getInt("age"));
            	        System.out.println("Contact Info: " + rs.getInt("contactInfo"));
            	        System.out.println("Symptoms: " + rs.getString("symptoms"));
            	    } else {
            	        System.out.println("No patient found with the name " + patientName);
            	    }
            	    break;
            	case 5:
            	    s.execute("CREATE TABLE IF NOT EXISTS Doctor (doctorName VARCHAR(20), speciality VARCHAR(20), contactInfo VARCHAR(20), availability BOOLEAN)");
            	    Doctor d = new Doctor();
            	    System.out.println("Enter Doctor's Name:");
            	    input.nextLine(); 
            	    answer = input.nextLine();
            	    d.setName(answer);
            	    System.out.println("Enter Doctor's Speciality:");
            	    answer = input.nextLine();
            	    d.setSpeciality(answer);
            	    System.out.println("Enter Doctor's Contact Info:");
            	    answer = input.nextLine();
            	    d.setContactInfo(answer);
            	    System.out.println("Is the doctor available? (true/false)");
            	    boolean availability = input.nextBoolean();
            	    d.setAvailability(availability);

            	    String insertDoctorQuery = "INSERT INTO Doctor (doctorName, speciality, contactInfo, availability) VALUES (?, ?, ?, ?)";
            	    ps = connection.prepareStatement(insertDoctorQuery);
            	    ps.setString(1, d.getName());
            	    ps.setString(2, d.getSpeciality());
            	    ps.setString(3, d.getContactInfo());
            	    ps.setBoolean(4, d.isAvailability());
            	    ps.executeUpdate();
            	    System.out.println("Doctor '" + d.getName() + "' added successfully!");
            	    break;

            	case 6:
            		String doctorName;
            	    System.out.println("Enter Doctor's Name to delete:");
            	    input.nextLine(); 
            	    doctorName = input.nextLine();
            	    String deleteDoctorQuery = "DELETE FROM Doctor WHERE doctorName = ?";
            	    ps = connection.prepareStatement(deleteDoctorQuery);
            	    ps.setString(1, doctorName);
            	    rowsAffected = ps.executeUpdate();
            	    if (rowsAffected > 0) {
            	        System.out.println("Doctor '" + doctorName + "' deleted successfully!");
            	        rowsAffected=0;
            	    } else {
            	        System.out.println("No doctor found with the name " + doctorName);
            	    }
            	    break;

            	case 7:
            	    String doctorAttributeName;
            	    String doctorAttributeValue;

            	    input.nextLine(); // Consume newline character
            	    System.out.println("Enter Doctor's Name:");
            	    doctorName = input.nextLine();

            	    System.out.println("Enter choice you want to update:");
            	    System.out.println("1. Name");
            	    System.out.println("2. Speciality");
            	    System.out.println("3. Contact Info");
            	    System.out.println("4. Availability");
            	    choose = input.nextInt();

            	    switch (choose) {
            	        case 1:
            	            doctorAttributeName = "doctorName";
            	            System.out.println("Enter the new name:");
            	            input.nextLine(); // Consume newline character
            	            doctorAttributeValue = input.nextLine();
            	            break;
            	        case 2:
            	            doctorAttributeName = "speciality";
            	            System.out.println("Enter the new speciality:");
            	            input.nextLine(); // Consume newline character
            	            doctorAttributeValue = input.nextLine();
            	            break;
            	        case 3:
            	            doctorAttributeName = "contactInfo";
            	            System.out.println("Enter the new contact info:");
            	            input.nextLine(); // Consume newline character
            	            doctorAttributeValue = input.nextLine();
            	            break;
            	        case 4:
            	            doctorAttributeName = "availability";
            	            System.out.println("Is the doctor available? (true/false):");
            	            boolean newAvailability = input.nextBoolean();
            	            doctorAttributeValue = String.valueOf(newAvailability);
            	            break;
            	        default:
            	            System.out.println("Invalid choice.");
            	            return;
            	    }

            	    String updateDoctorQuery = "UPDATE Doctor SET " + doctorAttributeName + " = ? WHERE doctorName = ?";
            	    ps = connection.prepareStatement(updateDoctorQuery);
            	    ps.setString(1, doctorAttributeValue);
            	    ps.setString(2, doctorName);
            	    rowsAffected = ps.executeUpdate();
            	    if (rowsAffected > 0) {
            	        System.out.println("Doctor '" + doctorName + "' updated successfully!");
            	        rowsAffected=0;
            	    } else {
            	        System.out.println("No doctor found with the name " + doctorName);
            	    }
            	    break;

            	case 8:
            	    System.out.println("Enter Doctor's Name:");
            	    input.nextLine(); // Consume newline character
            	    doctorName = input.nextLine();
            	    String viewDoctorQuery = "SELECT * FROM Doctor WHERE doctorName = ?";
            	    ps = connection.prepareStatement(viewDoctorQuery);
            	    ps.setString(1, doctorName);
            	    rs = ps.executeQuery();
            	    if (rs.next()) {
            	        System.out.println("Name: " + rs.getString("doctorName"));
            	        System.out.println("Speciality: " + rs.getString("speciality"));
            	        System.out.println("Contact Info: " + rs.getString("contactInfo"));
            	        System.out.println("Availability: " + rs.getBoolean("availability"));
            	    } else {
            	        System.out.println("No doctor found with the name " + doctorName);
            	    }
            	    break;
            	case 9:
            		System.out.println("Select a patient:");
            		ResultSet patientResultSet = s.executeQuery("SELECT * FROM Patient");
            		while (patientResultSet.next()) {
            		System.out.println("Name: " + patientResultSet.getString("patientName"));
            		}
            		System.out.println("Enter the patient's name:");
            	    input.nextLine();
            	    String appointmentPatientName = input.nextLine();
            		
            		ResultSet doctorResultSet = s.executeQuery("SELECT * FROM Doctor WHERE availability = true");
            		while (doctorResultSet.next()) {
            		System.out.println("Name: " + doctorResultSet.getString("doctorName"));
            		}
            		
            		 System.out.println("Enter the doctor's name:");
             	    String appointmentDoctorName = input.nextLine();
            	   
            	    System.out.println("Enter the date of the appointment (YYYY-MM-DD):");
            	    String appointmentDate = input.nextLine();
            	    System.out.println("Enter the time of the appointment (HH:MM):");
            	    String appointmentTime = input.nextLine();
            	    System.out.println("Enter the reason for the appointment:");
            	    String appointmentReason = input.nextLine();

            	        String insertAppointmentQuery = "INSERT INTO Appointment (doctorName, patientName, date, time, reason) VALUES (?, ?, ?, ?, ?)";
            	        ps = connection.prepareStatement(insertAppointmentQuery);
            	        ps.setString(1, appointmentDoctorName);
            	        ps.setString(2, appointmentPatientName);
            	        ps.setString(3, appointmentDate);
            	        ps.setString(4, appointmentTime);
            	        ps.setString(5, appointmentReason);
            	        rowsAffected = ps.executeUpdate();
            	        if (rowsAffected > 0) {
            	            System.out.println("Appointment added successfully!");
            	            rowsAffected=0;
            	        } else {
            	            System.out.println("Failed to add appointment.");
            	        }
            	     
            	    break;            	
            	    case 10:
            		patientResultSet = s.executeQuery("SELECT * FROM Appointment");
            		while (patientResultSet.next()) {
            		System.out.println("Name: " + patientResultSet.getString("patientName"));
            		}
            		System.out.println("Enter the name of the patient whose appointment you want to delete:");
            		input.nextLine(); // Consume newline character
            		appointmentPatientName = input.nextLine();
            		String deleteAppointmentQuery = "DELETE FROM Appointment WHERE patientName = ?";
            		ps = connection.prepareStatement(deleteAppointmentQuery);
            		ps.setString(1, appointmentPatientName);
            		rowsAffected= ps.executeUpdate();
            		if(rowsAffected>0) {
           	    	 System.out.println("Patient '" + appointmentPatientName + "' deleted successfully!");
           	    	 rowsAffected=0;//set
           	    }
           	    else {
           	    	System.out.println("No patient found with the name " + appointmentPatientName);
           	    }
            		
            	case 11:
            		patientResultSet = s.executeQuery("SELECT patientName FROM Appointment");
            		while (patientResultSet.next()) {
            		System.out.println("Name: " + patientResultSet.getString("patientName"));
            		}
            		System.out.println("Enter the name of the patient whose appointment you want to update:");
            		input.nextLine(); // Consume newline character
            		String updateAppointmentPatientName = input.nextLine();
            		
            		doctorResultSet = s.executeQuery("SELECT doctorName FROM Appointment");
            		while (patientResultSet.next()) {
            		System.out.println("Name: " + doctorResultSet.getString("doctorName"));
            		}
            		System.out.println("Enter the new Doctor:");
            		String newDoctor = input.nextLine();
            		System.out.println("Enter the new date (YYYY-MM-DD):");
            		String newDate = input.nextLine();
            		System.out.println("Enter the new time (HH:MM):");
            		String newTime = input.nextLine();
            		System.out.println("Enter the new reason:");
            		String newReason = input.nextLine();

            		String updateAppointmentQuery = "UPDATE Appointment SET date = ?, time = ?, reason = ?, doctorName = ? where patientName = ?";
            		ps = connection.prepareStatement(updateAppointmentQuery);
            		ps.setString(1, newDate);
            		ps.setString(2, newTime);
            		ps.setString(3, newReason);
            		ps.setString(4, newDoctor);
            		ps.setString(5, updateAppointmentPatientName);
            		rowsAffected= ps.executeUpdate();
            		if(rowsAffected>0) {
           	    	 System.out.println("Patient '" + updateAppointmentPatientName + "' deleted successfully!");
           	    	 rowsAffected=0;//set
           	    }
           	    else {
           	    	System.out.println("No patient found with the name " + updateAppointmentPatientName);
           	    }
            	case 12:
            		patientResultSet = s.executeQuery("SELECT patientName FROM Appointment");
            		while (patientResultSet.next()) {
            		System.out.println("Name: " + patientResultSet.getString("patientName"));}
            		System.out.println("Enter the patient's name:");
            	    input.nextLine();
            	    String patientAppointment = input.nextLine();
            	    String patientAppointmentQuery = "SELECT * FROM Appointment WHERE patientName = ?";
            	    ps = connection.prepareStatement(patientAppointmentQuery);
            	    ps.setString(1, patientAppointment);
            	    rs = ps.executeQuery();
            		if (rs.next()) {
                        System.out.println("Patient Name: " + rs.getString("patientName"));
                        System.out.println("Doctor Name: " + rs.getString("doctorName"));
                        System.out.println("Date: " + rs.getString("date"));
                        System.out.println("Time: " + rs.getString("time"));
                        System.out.println("Reason: " + rs.getString("reason"));
                    }
            	    break;
            	}
            	
            }
	            s.close(); // close the Statement to let the database know we're done with it  
	            connection.close(); // close the Connection to let the database know we're done with it
		     
		 } catch (SQLException e) {
		     throw new IllegalStateException("Cannot connect the database!", e);
		 }
	}

}