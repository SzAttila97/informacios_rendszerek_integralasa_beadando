package hu.backend.service.model;

import hu.backend.data.model.BookStatus;

import java.util.Date;

public class BookDto {

    private long id;

    private String recordIdentifier;

    private String title;

    private String author;

    private Date releaseDate;

    private BookStatus status;

    public BookDto() {
    }

    public BookDto(long id, String recordIdentifier, String title, String author, Date releaseDate, BookStatus status) {
        this.id = id;
        this.recordIdentifier = recordIdentifier;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecordIdentifier() {
        return recordIdentifier;
    }

    public void setRecordIdentifier(String recordIdentifier) {
        this.recordIdentifier = recordIdentifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
