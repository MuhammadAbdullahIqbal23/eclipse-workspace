package i222504_LAB3;

import java.util.LinkedList;
import java.util.Queue;

public class i222504_LAB3_TASK4 {
	
    public static void main(String[] args) {
    	
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Rear element: "+ ((LinkedList<Integer>) queue).getLast());
        
        System.out.println("Is queue empty? "+ queue.isEmpty());
        System.out.println("Front element: " +queue.peek());

        while (!queue.isEmpty()) {
        	
            int element = queue.poll();
            if (queue.isEmpty()) {
            	
                System.out.println("Rear element: " + element);
            } else {
                System.out.println("Dequeued element: " + element);
            }
        }
    }
}
