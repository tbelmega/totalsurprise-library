package de.pardertec.library;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BooksBS {

    @Inject
    private BookDao bookDao;

    @Inject
    private AuthorDao authorDao;

    @Inject
    private PublisherDao publisherDao;

    @Inject
    private BooksMapperFactory factory;

    public List<BookCto> findAll() {
        List<BookEntity> books = bookDao.findAll();

        List<BookCto> result = new ArrayList<>();

        for (BookEntity book : books) {
            BookEto bookEto = factory.bookMapper().map(book);
            AuthorEto authorEto = findAuthorById(book.getAuthorId())
                    .orElseThrow(() -> new IllegalArgumentException("Book refers to author that does not exist."));

            PublisherEto publisherEto = findPublisherById(book.getPublisherId())
                    .orElseThrow(() -> new IllegalArgumentException("Book refers to publisher that does not exist."));

            BookCto cto = new BookCto(bookEto, authorEto, publisherEto);
            result.add(cto);
        }

        return result;
    }

    private Optional<PublisherEto> findPublisherById(long publisherId) {
        Optional<PublisherEntity> publisherEntity = publisherDao.findById(publisherId);
        return publisherEntity.map(publisher -> factory.publisherMapper().map(publisher));
    }

    private Optional<AuthorEto> findAuthorById(long authorId) {
        return authorDao
                .findById(authorId)
                .map(factory.authorMapper()::map);
    }

    public BookEto createNewBook(BookEto book) {
        BookEntity bookEntity = factory.bookMapper().mapReverse(book);
        bookEntity = bookDao.persist(bookEntity);
        book.setId(bookEntity.getId());
        return book;
    }

    public Optional<BookEto> findBookById(Long bookId) {
        return bookDao.findById(bookId).map(factory.bookMapper()::map);
    }

    public BookEto updateBook(BookEto book) {
        BookEntity bookEntity = bookDao.update(factory.bookMapper().mapReverse(book));
        return factory.bookMapper().map(bookEntity);
    }
}
