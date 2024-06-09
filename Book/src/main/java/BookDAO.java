import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> getAllBooks() {
        try {
            entityManager.getTransaction().begin();
            List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
            entityManager.getTransaction().commit();
            return books;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Book getBookById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Book book = entityManager.find(Book.class, id);
            entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
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