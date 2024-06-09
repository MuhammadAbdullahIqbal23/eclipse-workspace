package i222504_G_LAB5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class i222504_Server_TASK2 {
	
	public static void main(String arg[]) throws IOException {
		DatagramSocket dataSocket =new DatagramSocket();
		System.out.println("Server working");
		try {
			while(true) {
				
			
			Thread.sleep(2000);
			String time = new Date().toString();
			byte[] b = time.getBytes();
			DatagramPacket dataPacket =new DatagramPacket(b,b.length,InetAddress.getLocalHost(),1314);
			
			dataSocket.send(dataPacket);
				}
			}catch(IOException |InterruptedException e) {
			System.out.println("Some exception");
		}
		dataSocket.close();
	}
}
