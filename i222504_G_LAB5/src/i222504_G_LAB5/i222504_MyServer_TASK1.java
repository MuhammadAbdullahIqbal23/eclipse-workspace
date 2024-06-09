
package i222504_G_LAB5;
import java.net.*;
import java.io.*;
public class i222504_MyServer_TASK1{
	public static void main(String arg[] )throws IOException{
		ServerSocket ss = new ServerSocket(4999);
		Socket s = ss.accept();
		System.out.println("Client Connected");
		
		InputStreamReader in  = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
			 
		String text = bf.readLine();
		int count=0;
		for (char c : text.toCharArray()) {
            if (c == 'a' || c == 'A' || c == 'e' || c == 'e' ||c == 'I' || c == 'i' || c == 'O' ||c == 'o' || c == 'U' ||c == 'u') {
                count++;
            }
        }

		System.out.println("client's message is : \""+ text +"\" And number of vowlels are "+ count);
		
	}
} 