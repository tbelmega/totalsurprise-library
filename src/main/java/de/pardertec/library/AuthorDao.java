package de.pardertec.library;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class AuthorDao {

    @PersistenceContext
    private EntityManager em;

    public Optional<AuthorEntity> findById(long authorId) {
        AuthorEntity result = em.find(AuthorEntity.class, authorId);
        return Optional.ofNullable(result);
    }
}
