package zddteam.bookstore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zddteam.bookstore.dao.BookRepository;
import zddteam.bookstore.domain.Book;

@Component
public class BookDaoImpl {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book findBook(String name) {
        return bookRepository.findByName(name);
    }
}
