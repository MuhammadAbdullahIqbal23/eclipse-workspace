package i222504_G_LAB_Sessional_Q3;

import java.net.*;
import java.util.Scanner;

public class i222504_G_Q3_Client {
    public static void main(String[] args) {
        try (DatagramSocket s = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5212;

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Enter a message to send to the server: ");
                    String messageToServer = scanner.nextLine();
                    byte[] buffer = messageToServer.getBytes();
                    DatagramPacket pac = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
                    s.send(pac);
                    buffer = new byte[1024];
                    DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                    s.receive(responsePacket);
                    String receivedData = new String(responsePacket.getData(), 0, responsePacket.getLength());
                    System.out.println("Server response: " + receivedData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
