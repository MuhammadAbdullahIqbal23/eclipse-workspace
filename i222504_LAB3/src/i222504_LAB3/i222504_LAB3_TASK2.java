package i222504_LAB3;

import java.util.LinkedList;

public class i222504_LAB3_TASK2 {
    public static void main(String[] args) {

    	
    	LinkedList<String>linkedList =new LinkedList<>();
        
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        
        
        int startPosition= 3; 
        
        System.out.println("Elements in the linked list starting from position " +startPosition +":");
        int index = 0;
       
        
        for (String element : linkedList) {
            if (index >=startPosition - 1) {
                System.out.println(element);
            }
            index++;
        }
    }
}
