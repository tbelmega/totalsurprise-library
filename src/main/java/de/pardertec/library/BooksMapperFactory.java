package de.pardertec.library;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDate;

public class BooksMapperFactory {

    private final BoundMapperFacade<BookEntity, BookEto> bookMapper;
    private final BoundMapperFacade<AuthorEntity, AuthorEto> authorMapper;
    private final BoundMapperFacade<PublisherEntity, PublisherEto> publisherMapper;

    public BooksMapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDate.class));
        bookMapper = mapperFactory.getMapperFacade(BookEntity.class, BookEto.class);
        authorMapper = mapperFactory.getMapperFacade(AuthorEntity.class, AuthorEto.class);
        publisherMapper = mapperFactory.getMapperFacade(PublisherEntity.class, PublisherEto.class);
    }

    public BoundMapperFacade<BookEntity, BookEto> bookMapper() {
        return bookMapper;
    }

    public BoundMapperFacade<AuthorEntity, AuthorEto> authorMapper() {
        return authorMapper;
    }

    public BoundMapperFacade<PublisherEntity, PublisherEto> publisherMapper() {
        return publisherMapper;
    }
}
