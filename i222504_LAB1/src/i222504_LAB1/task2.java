package i222504_LAB1;

import java.util.Scanner;

public class task2 {
    private String title;
    private String author;
    private int pubYear;

    public task2(String title, String author, int pubYear) {
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + pubYear);
    }

    public static void comparePubYears(task2 book1, task2 book2) {
        if (book1.getPubYear() > book2.getPubYear()) {
            System.out.println(book1.getTitle() + " is came later than " + book2.getTitle());
        } else if (book1.getPubYear() < book2.getPubYear()) {
            System.out.println(book1.getTitle() + " is came before " + book2.getTitle());
        } else {
            System.out.println(book1.getTitle() + " and " + book2.getTitle() + " were published in the same year.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter details for book 1:");
			System.out.print("Title: ");
			String title1 = scanner.nextLine();
			System.out.print("Author: ");
			String author1 = scanner.nextLine();
			System.out.print("Publication Year: ");
			int year1 = scanner.nextInt();
			scanner.nextLine(); 

			System.out.println("Enter details for book 2:");
			System.out.print("Title: ");
			String title2 = scanner.nextLine();
			System.out.print("Author: ");
			String author2 = scanner.nextLine();
			System.out.print("Publication Year: ");
			int year2 = scanner.nextInt();

			task2 book1 = new task2(title1, author1, year1);
			task2 book2 = new task2(title2, author2, year2);
			System.out.println();

			task2.comparePubYears(book1, book2);
			System.out.println();

			System.out.println("BOOK 1 Info");
			book1.displayDetails();
			System.out.println();

			System.out.println("BOOK 2 Info");
			book2.displayDetails();
		}
    }
}