package i222504_G_LAB5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class i222504_TASK4_Server {
    
    public static void main(String arg[]) throws IOException {
        DatagramSocket dataSocket = new DatagramSocket();
        System.out.println("Server working");
        try {
            int basePort = 1314; 
            while(true) {
                for (int i = 0; i < 5; i++) { 
                    Thread.sleep(2000);
                    String time = new Date().toString();
                    byte[] b = time.getBytes();
                    DatagramPacket dataPacket = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), basePort + i);
                    
                    dataSocket.send(dataPacket);
                }
            }
        } catch(IOException | InterruptedException e) {
            System.out.println("Some exception");
        }
        dataSocket.close();
    }
}
