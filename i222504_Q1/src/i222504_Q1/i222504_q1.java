package i222504_Q1;


import java.io.*;

public class i222504_q1 {
    public static void main(String[] args) {
        String dataToWrite = "Name: Muhammad Abdullah iqbal\nAge: 21";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Muhammad_Abdullah_iqbal.txt"))) {
            writer.write(dataToWrite);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to Muhammad_Abdullah_iqbal.txt: " + e.getMessage());
        }

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("Muhammad_Abdullah_iqbal.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println(" error in reading from Muhammad_Abdullah_iqbal.txt: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("i222504.txt"))) {
            writer.write(fileContent.toString());
        } catch (IOException e) {
            System.out.println(" error in writing to i222504.txt: " + e.getMessage());
        }
    }
}