package i222504_LAB1;

import java.util.Scanner;

public class task1 {

	public static void main(String[] args) { 
		
		Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the size of the arr:");
    	int size = scanner.nextInt();
    int[] arr = new int[size];
    
    System.out.println("Enter the elements of the arr:");
    for (int i = 0; i < size; i++) {
        arr[i] = scanner.nextInt();
    }
    
    int positives = 0;
    		int negatives = 0;
    		int zeros = 0;
    for (int num : arr) {
        if (num > 0) {
            positives++;
        } 
        else if (num < 0) {
            negatives++;
        }
        else {
            zeros++;
        }
    }
    
    System.out.println("Total number of positive numbers: " + positives);
    System.out.println("toal number of negative numbers: " + negatives);
    System.out.println("Total number of zeros: " + zeros);
    
    scanner.close();
}
}
