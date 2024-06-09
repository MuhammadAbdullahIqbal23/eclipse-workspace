package i222504_LAB4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class i222504_Task1_File1 {
    public static void main(String[] args) {
        try {
            FileWriterExample.writeToFile();
            FileReaderExample.readFromFile(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileWriterExample {
    public static void writeToFile() throws IOException {
        File file = new File("Data.txt");
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(file))) {
            writer.write("ABdullah Iqbal");
            writer.newLine();
            writer.write("22i-2504");
            writer.newLine();
            writer.write("Male");
            writer.newLine();
            writer.write("3.5");
            writer.newLine();
            writer.write("16/02/2024");
            writer.newLine();
        }
    }
}

class FileReaderExample {
    public static void readFromFile() {
        File file = new File("Data.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
