package de.pardertec.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "Book")
public class BookEntity {

    private long id;
    private String title;
    private LocalDate publishingDate;
    private Locale language;
    private long authorId;
    private long publisherId;

    public BookEntity() {
    }

    public BookEntity(long id, String title, LocalDate publishingDate, Locale language, long authorId, long publisherId) {
        this.id = id;
        this.title = title;
        this.publishingDate = publishingDate;
        this.language = language;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookEntity)) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id &&
                authorId == that.authorId &&
                publisherId == that.publisherId &&
                Objects.equals(title, that.title) &&
                Objects.equals(publishingDate, that.publishingDate) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, publishingDate, language, authorId, publisherId);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishingDate=" + publishingDate +
                ", language=" + language +
                ", authorId=" + authorId +
                ", publisherId=" + publisherId +
                '}';
    }
}