package i222504_G_LAB5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class i222504_Client_TASK2 {

	public static void main(String[] args) throws SocketException {
		DatagramPacket dataPacket;
		DatagramSocket dataSocket = new DatagramSocket(1314);
		
		byte [] b= new byte[64];
		System.out.println("Client working");
		try {
		while(true) {
			dataPacket = new DatagramPacket(b,b.length);
			
			dataSocket.receive(dataPacket);
			String dataRecieved = new String(dataPacket.getData(),0,dataPacket.getLength());
			System.out.println("Recieved: "+ dataRecieved);
		}}catch(IOException i){
			System.out.println("Some exception");
		}
		dataSocket.close();
	}

}
