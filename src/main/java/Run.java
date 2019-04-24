import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        // 1-Creates an instance of book
        //Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);
        // 2-Obtains an entity manager and a transaction
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // 3-Persists the book to the database
        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        entityManager.persist(book);
//        tx.commit();
        // 4-Executes the named query for single book
//        book = entityManager.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        //System.out.println(book.toString());
        // Executes the named query for all books
        List<Book> books = entityManager.createNamedQuery("findAllBooks", Book.class).getResultList();
        for (Book oneBook: books) {
            System.out.println(oneBook);
        }
        // 5-Closes the entity manager and the factory
        entityManager.close();
        entityManagerFactory.close();
    }

}
