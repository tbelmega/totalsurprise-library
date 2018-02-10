package de.pardertec.library;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BooksBS {
    public List<BookCto> findAll() {
        BookEntity demoBook = new BookEntity(1, "Clean Code", LocalDate.now(), Locale.GERMAN, 2, 3);

        BookEto bookEto = new BookEto(demoBook.getId(), demoBook.getTitle(), demoBook.getPublishingDate(), demoBook.getLanguage(), demoBook.getAuthorId(), demoBook.getPublisherId());

        AuthorEto authorEto = new AuthorEto(2, "Robert", "Martin", LocalDate.of(2000, 1, 1));
        PublisherEto publisherEto = new PublisherEto(3, "MyBooks", "Berlin", "Germany");
        BookCto cto = new BookCto(bookEto, authorEto, publisherEto);

        return Arrays.asList(cto);
    }
}
