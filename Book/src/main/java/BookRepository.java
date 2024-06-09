import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            Query query = (Query) entityManager.createQuery("SELECT b FROM Book b");
            books = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return books;
    }

    public Book getBookById(Long id) {
        Book book = new Book();
        try {
            entityManager.getTransaction().begin();
            book = entityManager.find(Book.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return book;
    }

    public void saveBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            Book existingBook = entityManager.find(Book.class, book.getId());
            if (existingBook != null) {
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
                existingBook.setIsbn(book.getIsbn());
                existingBook.setAvailableCopies(book.getAvailableCopies());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteBook(Long id) {
        try {
            entityManager.getTransaction().begin();
            Book book = entityManager.find(Book.class, id);
            if (book != null) {
                entityManager.remove(book);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}