package i222504_G_LAB5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class i222504_TASK4_Client {

    public static void main(String[] args) {
        final int NUM_CLIENTS = 5; 

        for (int i = 0; i < NUM_CLIENTS; i++) {
            final int port = 1314 + i; 

            new Thread(() -> {
                try {
                    DatagramPacket dataPacket;
                    try (DatagramSocket dataSocket = new DatagramSocket(port)) {
                        byte[] b = new byte[64];
                        System.out.println("Client working on port: " + port);

                        while (true) {
                            dataPacket = new DatagramPacket(b, b.length);

                            dataSocket.receive(dataPacket);
                            String dataReceived = new String(dataPacket.getData(), 0, dataPacket.getLength());
                            System.out.println("Received on port " + port + ": " + dataReceived);
                        }
                    }
                } catch (SocketException e) {
                    System.out.println("Socket Exception: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IO Exception: " + e.getMessage());
                }
            }).start();
        }
    }
}
