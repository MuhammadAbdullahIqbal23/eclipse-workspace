package i222504_G_LAB5;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class i222504_TASK3_Client {
    public static void main(String[] args) throws IOException {

		try (Socket s = new Socket("localhost",4999)) {
            System.out.println("Connected to server: " + "localhost" + ":" + 4999);

            try (Scanner myObj = new Scanner(System.in)) {
                System.out.print("Enter the path of the file to send: ");
                
                String filePath = myObj.nextLine();

                File fileToSend = new File(filePath);
                if (!fileToSend.exists()) {
                    System.out.println("Error: File does not exist.");
                    return;
                }

                DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
                dataOut.writeUTF(fileToSend.getName());
                dataOut.writeLong(fileToSend.length());
                FileInputStream fileIn = new FileInputStream(fileToSend);
                BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);

                byte[] dataBuffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = bufferedIn.read(dataBuffer)) != -1) {
                    dataOut.write(dataBuffer, 0, bytesRead);
                }

                bufferedIn.close();
                fileIn.close();
                dataOut.close();

                System.out.println("File sent: " + fileToSend.getName());
            }
        }
    }
}
