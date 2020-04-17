package hu.backend.web;

import hu.backend.service.component.BookService;
import hu.backend.service.exception.NotFoundException;
import hu.backend.service.model.CreateBookDto;
import hu.backend.service.model.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("book")
@CrossOrigin
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	public BookDto add(@RequestBody @NotNull @Valid CreateBookDto createBookDto) {
		return this.bookService.addBook(createBookDto);
	}

	@GetMapping("/rent/{id}")
	public void rent(@PathVariable @NotNull @Positive long id) throws NotFoundException {
		this.bookService.rentBook(id);
	}

	@GetMapping("/return/{id}")
	public void return2(@PathVariable @NotNull @Positive long id) throws NotFoundException {
		this.bookService.returnBook(id);
	}

	@GetMapping("getAll")
	public List<BookDto> getAll() {
		return this.bookService.getAllBook();
	}

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
		return new ResponseEntity<Object>("Hibás kérés!\nA megadott feltételekhez nem található könyv..", new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}


