package de.pardertec.library;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class BookDao {

    @PersistenceContext
    private EntityManager em;

    public List<BookEntity> findAll() {
        String qlString = "SELECT b FROM BookEntity b";
        TypedQuery<BookEntity> query = em.createQuery(qlString, BookEntity.class);
        return query.getResultList();
    }

    public BookEntity persist(BookEntity bookEntity) {
        em.persist(bookEntity);
        return bookEntity;
    }

    public Optional<BookEntity> findById(Long bookId) {
        BookEntity bookEntity = em.find(BookEntity.class, bookId);
        return Optional.ofNullable(bookEntity);
    }

    public BookEntity update(BookEntity bookEntity) {
        BookEntity mergedEntity = em.merge(bookEntity);
        return mergedEntity;
    }
}
