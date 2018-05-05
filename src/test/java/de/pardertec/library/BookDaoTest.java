package de.pardertec.library;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

import static junit.framework.Assert.assertNotSame;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class BookDaoTest {

    private static EntityManager em;

    private BookDao bookDao = new BookDao();

    @BeforeClass
    public static void setup() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("TestDS");
        em = emFactory.createEntityManager();
    }

    @Before
    public void startTransaction() {
        bookDao.em = em;
        em.getTransaction().begin();
        em.getTransaction().setRollbackOnly();

    }

    @After
    public void rollbackTransaction() {
        em.getTransaction().rollback();
    }

    @Test
    public void testThat_bookEntityPersisted() throws Exception {
        //arrange
        BookEntity entity = persistBook(Locale.GERMAN);
        em.flush();

        //assert
        assertNotSame(entity.getId(), null);
    }

    @Test
    public void testThat_findAll_returnsAllBooks() throws Exception {
        //arrange
        BookEntity entity1 = persistBook(Locale.GERMAN);
        BookEntity entity2 = persistBook(Locale.ENGLISH);
        em.flush();

        //act
        List<BookEntity> result = bookDao.findAll();


        //assert
        assertThat(result, containsInAnyOrder(entity1, entity2));
    }

    @Test
    public void testThat_findByLanguageDE_returnsOnlyGermanBooks() throws Exception {
        //arrange
        BookEntity entity1 = persistBook(Locale.GERMAN);
        BookEntity entity2 = persistBook(Locale.ENGLISH);
        em.flush();

        //act
        List<BookEntity> result = bookDao.findByLanguage(Locale.GERMAN);


        //assert
        assertThat(result, containsInAnyOrder(entity1));
        assertThat(result, not(containsInAnyOrder(entity2)));
    }

    private BookEntity persistBook(Locale german) {
        BookEntity entity = new BookEntity();
        entity.setLanguage(german);
        em.persist(entity);
        return entity;
    }


}
