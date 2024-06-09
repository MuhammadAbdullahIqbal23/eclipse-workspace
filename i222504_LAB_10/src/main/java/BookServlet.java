

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		ArrayList<Book> ListOfBooks = new ArrayList<>();
    		ListOfBooks.add(new Book("Khuda Aur Mohabbat", "Hashim Nadeem", "Urdu Fiction", 500.00)); 
    		ListOfBooks.add(new Book("Jauga Kahani", "Shaukat Siddiqui", "Urdu Short Stories", 300.00)); 
    		ListOfBooks.add(new Book("The Party Worker", "Omar Shahid Hamid", "English Crime Fiction", 799.00)); 
    		ListOfBooks.add(new Book("Karachi, You're Killing Me!", "Fatima Bhutto", "English Humor", 599.00)); 
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		
    		for (Book selectedBook : ListOfBooks) {
    		    out.println("<tr>");
    		    out.println("<td>" + selectedBook.getTitle() + "</td>");
    		    out.println("<td>" + selectedBook.getAuthor() + "</td>");
    		    out.println("<td>" + selectedBook.getGenre() + "</td>");
    		    out.println("<td>" + selectedBook.getPrice() + "</td>");
    		    out.println("</tr>");
    		}

    	}

    	class Book {
    	    private String title;
    	    private String author;
    	    private String genre;
    	    private double price;

    	    public Book(String title, String author, String genre, double price) {
    	        this.title = title;
    	        this.author = author;
    	        this.genre = genre;
    	        this.price = price;
    	    }

    	    public String getTitle() {
    	        return title;
    	    }

    	    public void setTitle(String title) {
    	        this.title = title;
    	    }

    	    public String getAuthor() {
    	        return author;
    	    }

    	    public void setAuthor(String author) {
    	        this.author = author;
    	    }

    	    public String getGenre() {
    	        return genre;
    	    }

    	    public void setGenre(String genre) {
    	        this.genre = genre;
    	    }

    	    public double getPrice() {
    	        return price;
    	    }

    	    public void setPrice(double price) {
    	        this.price = price;
    	    }
    	}
}
