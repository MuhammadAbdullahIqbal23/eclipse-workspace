package i222504_LAB3;

import java.util.Stack;

public class i222504_LAB3_TASK3 {

    public static void main(String[] args) {
    	
        Stack<Integer> stack1= new Stack<>();
        
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);
        stack1.push(50);

        System.out.println("Top element of the stack: "+ stack1.peek());
        System.out.println("Bottom element of the stack: "+ findBottomElement(stack1));
    }

    public static int findBottomElement(Stack<Integer> stack) {
    	

        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        
        }
        int bottom = 0;
        
        while (!stack.isEmpty()) {
        	
            bottom = stack.pop();
        }
        
        return bottom;
    }
}
