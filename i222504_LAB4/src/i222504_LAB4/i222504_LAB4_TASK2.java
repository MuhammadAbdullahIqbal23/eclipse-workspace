package i222504_LAB4;

import java.sql.*;

public class i222504_LAB4_TASK2 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Abdullah";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abdullahabiiqbalabii54321100";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            createTable(connection);
            insertData(connection);
            showData(connection);
            deleteRecord(connection, 1);
            updateRecord(connection, 2, "B+");
            showData(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Students (id INT PRIMARY KEY, name VARCHAR(255), age INT, grade VARCHAR(2))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String insertDataSQL = "INSERT INTO Students (id, name, age, grade) VALUES "
                                   + "(1, 'John', 20, 'A'), "
                                   + "(2, 'Alice', 21, 'B'), "
                                   + "(3, 'Bob', 22, 'C')";
            statement.executeUpdate(insertDataSQL);
            System.out.println("Data inserted successfully");
        }
    }

    private static void showData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String selectSQL = "SELECT * FROM Students";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            System.out.println("Records from Students table:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
            }
        }
    }

    private static void deleteRecord(Connection connection, int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE id = ?")) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record with ID " + id + " deleted successfully");
            } else {
                System.out.println("No record found with ID " + id);
            }
        }
    }

    private static void updateRecord(Connection connection, int id, String newGrade) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Students SET grade = ? WHERE id = ?")) {
            statement.setString(1, newGrade);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record with ID " + id + " updated successfully");
            } else {
                System.out.println("No record found with ID " + id);
            }
        }
    }
}
	