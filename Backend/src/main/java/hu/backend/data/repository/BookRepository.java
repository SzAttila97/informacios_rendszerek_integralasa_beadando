package hu.backend.data.repository;

import hu.backend.data.model.Book;
import hu.backend.data.model.BookStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findAllByStatus(BookStatus bookStatus);
}
