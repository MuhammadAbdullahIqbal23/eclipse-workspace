package i222504_G_LAB5;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class i222504_MyClient_TASK1{
	public static void main(String arg[])throws IOException{
		Socket s = new Socket("localhost",4999);
		Scanner myObj = new Scanner(System.in);  
	    System.out.print("Enter any text: ");

	    String text = myObj.nextLine();  
		PrintWriter print = new PrintWriter(s.getOutputStream());
		
		print.println(text);
		print.flush();
	}
}