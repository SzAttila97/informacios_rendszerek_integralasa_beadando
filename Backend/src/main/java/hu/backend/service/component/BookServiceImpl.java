package hu.backend.service.component;

import hu.backend.data.model.Book;
import hu.backend.data.model.BookStatus;
import hu.backend.data.repository.BookRepository;
import hu.backend.service.exception.NotFoundException;
import hu.backend.service.model.CreateBookDto;
import hu.backend.service.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(CreateBookDto createBookDto) {
        Book book = new Book();
        book.setRecordIdentifier(createBookDto.getRecordIdentifier());
        book.setAuthor(createBookDto.getAuthor());
        book.setTitle(createBookDto.getTitle());
        book.setReleaseDate(createBookDto.getReleaseDate());
        book.setStatus(BookStatus.ELÉRHETŐ);

        book = bookRepository.save(book);

        return mapBookToBookDto(book);
    }

    @Override
    public void rentBook(long id) throws NotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setStatus(BookStatus.KÖLCSÖNZÖTT);

            bookRepository.save(book);
        } else {
            throw new NotFoundException("Book not found by the given id: " + id);
        }
    }

    @Override
    public void returnBook(long id) throws NotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setStatus(BookStatus.ELÉRHETŐ);

            bookRepository.save(book);
        } else {
            throw new NotFoundException("Book not found by the given id: " + id);
        }
    }

    @Override
    public List<BookDto> getAllBook() {
        List<Book> bookList = this.bookRepository.findAll();

        return mapBookListToBookDtoList(bookList);
    }

    private List<BookDto> mapBookListToBookDtoList(List<Book> bookList) {
        List<BookDto> bookDtoList = new ArrayList<BookDto>();
        for(Book book : bookList) {
            bookDtoList.add(mapBookToBookDto(book));
        }

        return bookDtoList;
    }

    private BookDto mapBookToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setRecordIdentifier(book.getRecordIdentifier());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setReleaseDate(book.getReleaseDate());
        bookDto.setStatus(book.getStatus());

        return bookDto;
    }
}
