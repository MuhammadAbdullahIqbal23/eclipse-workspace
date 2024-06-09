package i222504_G_LAB_Sessional_Q3;

import java.net.*;
import java.util.Scanner;

public class i222504_Q3_Server {
    public static void main(String[] args) {
        try (DatagramSocket s = new DatagramSocket(5212)) {
            System.out.println("Server is running...");
            byte[] buffer = new byte[1024];
            DatagramPacket pac = new DatagramPacket(buffer, buffer.length);
            try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
				    s.receive(pac);
				    String messageFromClient = new String(pac.getData(), 0, pac.getLength());
				    System.out.println("Received from client: " + messageFromClient);
				    if (messageFromClient.equalsIgnoreCase("Goodbye")) {
				        System.out.println("Client said Goodbye. Ending conversation.");
				        break;
				    }
				    System.out.print("Enter a message to send to the client: ");
				    String messageToClient = scanner.nextLine();
				    byte[] responseDataBytes = messageToClient.getBytes();
				    InetAddress clientAddress = pac.getAddress();
				    int clientPort = pac.getPort();
				    DatagramPacket responsePacket = new DatagramPacket(responseDataBytes, responseDataBytes.length, clientAddress, clientPort);
				    s.send(responsePacket);
				}
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped.");
    }
}
