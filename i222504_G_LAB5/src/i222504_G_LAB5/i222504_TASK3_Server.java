package i222504_G_LAB5;

import java.io.*;
import java.net.*;

public class i222504_TASK3_Server {
    public static void main(String[] args) throws IOException {

        try (
		ServerSocket ss = new ServerSocket(4999)) {
			System.out.println("Server started and listening on port " + 4999);

			
			Socket s = ss.accept();
			System.out.println("Client connected");

			File storageDirectory = new File("server_files");
			if (!storageDirectory.exists()) {
			    storageDirectory.mkdir();
			}


			DataInputStream dataIn = new DataInputStream(s.getInputStream());

			String receivedFilename = dataIn.readUTF();
			long fileSize = dataIn.readLong();

			File receivedFile = new File(storageDirectory, receivedFilename);
			FileOutputStream fileOut = new FileOutputStream(receivedFile);
			BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut);

			byte[] dataBuffer = new byte[1024];
			int bytesRead;
			long totalBytesReceived = 0;

			while ((bytesRead = dataIn.read(dataBuffer)) != -1) {

				totalBytesReceived += bytesRead;
			    bufferedOut.write(dataBuffer, 0, bytesRead);

			    if (totalBytesReceived == fileSize) {
			        break;
			    }
			}

			bufferedOut.close();
			fileOut.close();
			dataIn.close();
			
			System.out.println("File received: " + receivedFilename + " (" + fileSize + " bytes)");
		}
    }
}
