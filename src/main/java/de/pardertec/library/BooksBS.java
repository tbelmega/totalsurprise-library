package de.pardertec.library;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BooksBS {

    @Inject
    private BookDao bookDao;

    @Inject
    private AuthorDao authorDao;

    public List<BookCto> findAll() {
        List<BookEntity> books = bookDao.findAll();

        List<BookCto> result = new ArrayList<>();

        for (BookEntity book: books) {
            BookEto bookEto = new BookEto(book.getId(), book.getTitle(), book.getPublishingDate(), book.getLanguage(), book.getAuthorId(), book.getPublisherId());

            AuthorEto authorEto = findAuthorById(book.getAuthorId());
            PublisherEto publisherEto = findPublisherById(book.getPublisherId());
            BookCto cto = new BookCto(bookEto, authorEto, publisherEto);
            result.add(cto);
        }

        return result;
    }

    private PublisherEto findPublisherById(long publisherId) {
        return new PublisherEto(publisherId, "Awesome Books Inc.", "Berlin", "Germany");
    }

    private AuthorEto findAuthorById(long authorId) {
        AuthorEntity authorEntity = authorDao.findById(authorId);

        if (authorEntity == null) return null;

        return new AuthorEto(authorEntity.getId(), authorEntity.getFirstname(), authorEntity.getLastname(), authorEntity.getDateOfBirth());
    }

    public BookEto createNewBook(BookEto book) {
        BookEntity bookEntity = new BookEntity(null, book.getTitle(), book.getPublishingDate(), book.getLanguage(), book.getAuthorId(), book.getAuthorId());
        bookEntity = bookDao.persist(bookEntity);
        book.setId(bookEntity.getId());
        return book;
    }
}
