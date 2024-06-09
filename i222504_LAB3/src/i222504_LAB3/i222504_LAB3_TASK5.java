package i222504_LAB3;

import java.util.HashMap;

public class i222504_LAB3_TASK5 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap1 = new HashMap<>();

        hashMap1.put("A", 1);
        hashMap1.put("B", 2);
        hashMap1.put("C", 3);


        String Removekey = "B";
        
        if (hashMap1.containsKey(Removekey)) {
        	 
            hashMap1.remove(Removekey);
            
            System.out.println("Element with key '" + Removekey + "' removed successfully.");
        
        } else {
        
        	System.out.println("Element with key '" + Removekey + "' does not exist in the HashMap.");
        }

        System.out.println("HashMap after removal: " + hashMap1);
    }
}
