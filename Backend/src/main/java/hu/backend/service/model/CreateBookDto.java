package hu.backend.service.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateBookDto {

    @NotNull
    @NotEmpty
    private String recordIdentifier;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    private Date releaseDate;

    public CreateBookDto() {
    }

    public CreateBookDto(@NotNull @NotEmpty String recordIdentifier, @NotNull @NotEmpty String title, @NotNull @NotEmpty String author, @NotNull Date releaseDate) {
        this.recordIdentifier = recordIdentifier;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
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
}
