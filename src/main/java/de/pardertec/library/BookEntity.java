package de.pardertec.library;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "Book")
public class BookEntity {

    private Long id;
    private String title;
    private LocalDate publishingDate;
    private Locale language;
    private long authorId;
    private long publisherId;
    private long dataVersion;
    private String isbnNumber;

    public BookEntity() {
    }

    public BookEntity(Long id, String title, LocalDate publishingDate, Locale language, long authorId, long publisherId) {
        this.id = id;
        this.title = title;
        this.publishingDate = publishingDate;
        this.language = language;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Version
    public long getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(long dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookEntity)) return false;
        BookEntity that = (BookEntity) o;
        return authorId == that.authorId &&
                publisherId == that.publisherId &&
                dataVersion == that.dataVersion &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(publishingDate, that.publishingDate) &&
                Objects.equals(language, that.language) &&
                Objects.equals(isbnNumber, that.isbnNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, publishingDate, language, authorId, publisherId, dataVersion, isbnNumber);
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
                ", dataVersion=" + dataVersion +
                ", isbnNumber='" + isbnNumber + '\'' +
                '}';
    }
}
