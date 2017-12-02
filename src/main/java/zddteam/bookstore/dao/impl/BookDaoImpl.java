package zddteam.bookstore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import zddteam.bookstore.dao.BookRepository;
import zddteam.bookstore.domain.Book;

import java.util.List;

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

    public Page <Book> getPageData(int pageNumber, int pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        return this.bookRepository.findAll(request);
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize) {
        return new PageRequest(pageNumber - 1, pageSize);
    }

    public Page <Book> getPageDataByCategoryId(int pageNumber, int pageSize, String category_id) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        return this.bookRepository.findAllByCategoryId(request, category_id);
    }
}
