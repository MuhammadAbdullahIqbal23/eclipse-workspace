package i222504_LAB3;

import java.util.LinkedList;

public class i222504_LAB3_TASK1 {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(4);
        list.addLast(5);

        System.out.println("Linked list after inserting at last positions:");
        display(list);

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("Linked list after inserting at first positions:");
        display(list);
    }

    static void display(LinkedList<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
