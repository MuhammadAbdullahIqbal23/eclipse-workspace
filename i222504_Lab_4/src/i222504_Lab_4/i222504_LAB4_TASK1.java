package i222504_Lab_4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class i222504_LAB4_TASK1 {
    public static void main(String[] args) {
        try {
            FileWriterExample.writeToFile();
            FileReaderExample.readFromFile(); // Added this line to invoke reading from the file
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
