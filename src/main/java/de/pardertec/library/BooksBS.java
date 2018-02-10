package de.pardertec.library;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
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

    public List<BookCto> findAll() {
        List<BookEntity> books = bookDao.findAll();

        List<BookCto> result = new ArrayList<>();

        for (BookEntity book : books) {
            BookEto bookEto = new BookEto(book.getId(), book.getTitle(), book.getPublishingDate(), book.getLanguage(), book.getAuthorId(), book.getPublisherId());

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

        return publisherEntity.map(publisher -> new PublisherEto(
                publisher.getId(),
                publisher.getName(),
                publisher.getCity(),
                publisher.getCountry()
        ));
    }

    private Optional<AuthorEto> findAuthorById(long authorId) {
        Optional<AuthorEntity> authorEntity = authorDao.findById(authorId);

        return authorEntity.map(author -> new AuthorEto(
                author.getId(),
                author.getFirstname(),
                author.getLastname(),
                author.getDateOfBirth()
        ));
    }

    public BookEto createNewBook(BookEto book) {
        BookEntity bookEntity = new BookEntity(null, book.getTitle(), book.getPublishingDate(), book.getLanguage(), book.getAuthorId(), book.getAuthorId());
        bookEntity = bookDao.persist(bookEntity);
        book.setId(bookEntity.getId());
        return book;
    }
}
