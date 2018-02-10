package de.pardertec.library;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AuthorDao {

    @PersistenceContext
    private EntityManager em;

    public AuthorEntity findById(long authorId) {
        return em.find(AuthorEntity.class, authorId);
    }
}
