package zddteam.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import zddteam.bookstore.domain.Book;

public interface BookRepository extends CrudRepository <Book, String> {

    Book findByName(String name);
}
