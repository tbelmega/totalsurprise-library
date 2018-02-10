package de.pardertec.library;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class PublisherDao {

    @PersistenceContext
    private EntityManager em;


    public Optional<PublisherEntity> findById(long publisherId) {
        PublisherEntity publisherEntity = em.find(PublisherEntity.class, publisherId);
        return Optional.ofNullable(publisherEntity);
    }
}
