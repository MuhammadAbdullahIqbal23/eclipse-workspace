package i222504_G_QUIZ1;

import java.util.Scanner;

public class i222504_G_QUIZ1 {
public static void main(String[] args) {
	

	  Scanner myObj = new Scanner(System.in);
	    System.out.println("Enter number of first row");

	    Integer x = myObj.nextInt();   

	for (int i = x; i > 0; i--) {
		for(int j = i;j<x;j--) {
		System.out.print("*");
			}	
		System.out.println();
		}
	}
}
