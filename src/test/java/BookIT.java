import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.*;

import java.util.List;


import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class BookIT {


    // ======================================
    // =             Attributes             =
    // ======================================

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStoreTest");
    private EntityManager em;
    private EntityTransaction tx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @Before
    public void initEntityManager() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() {
        if (em != null) em.close();
    }

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldFindJavaEE7Book() {
        Book book = em.find(Book.class, 1001L);
        assertEquals("Beginning Java EE 7", book.getTitle());
    }

    @Test
    public void shouldCreateH2G2Book() {

        // Creates an instance of book
        Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

        // Persists the book to the database
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID should not be null", book.getId());

        // Retrieves all the books from the database
        List<Book> books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
        System.out.println(books.get(0));
        assertEquals(1, books.size());
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        assertEquals("The Hitchhiker's Guide to the Galaxy", book.getDescription());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {
        Book book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);
        em.persist(book);
    }
}
