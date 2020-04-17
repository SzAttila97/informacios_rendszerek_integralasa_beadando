package hu.backend.service.component;

import hu.backend.service.exception.NotFoundException;
import hu.backend.service.model.CreateBookDto;
import hu.backend.service.model.BookDto;

import java.util.List;

public interface BookService {

    BookDto addBook(CreateBookDto createBookDto);

    void rentBook(long id) throws NotFoundException;

    void returnBook(long id) throws NotFoundException;

    List<BookDto> getAllBook();
}
