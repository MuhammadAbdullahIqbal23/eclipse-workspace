package i222504_G_LAB11_Task2.i222504_G_LAB11_Task2;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KalaamApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("KALAAM_beans.xml");
        MP3Player player = context.getBean("mp3Player", MP3Player.class);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMP3 Player Menu");
            System.out.println("1. Play Hamd");
            System.out.println("2. Play Naat");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    player.setKalaam(context.getBean("hamd", Kalaam.class));
                    player.playKalaam();
                    break;
                case 2:
                    player.setKalaam(context.getBean("naat", Kalaam.class));
                    player.playKalaam();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    context.close();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }
}