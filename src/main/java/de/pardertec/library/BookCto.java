package de.pardertec.library;

import java.util.Objects;

public class BookCto {
    private BookEto book;
    private AuthorEto author;
    private PublisherEto publisher;

    public BookCto(BookEto bookEto, AuthorEto authorEto, PublisherEto publisherEto) {
        this.book = bookEto;
        this.author = authorEto;
        this.publisher = publisherEto;
    }

    public BookCto() {
    }

    public BookEto getBook() {
        return book;
    }

    public void setBook(BookEto book) {
        this.book = book;
    }

    public AuthorEto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEto author) {
        this.author = author;
    }

    public PublisherEto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEto publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCto)) return false;
        BookCto bookCto = (BookCto) o;
        return Objects.equals(book, bookCto.book) &&
                Objects.equals(author, bookCto.author) &&
                Objects.equals(publisher, bookCto.publisher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(book, author, publisher);
    }

    @Override
    public String toString() {
        return "BookCto{" +
                "book=" + book +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
