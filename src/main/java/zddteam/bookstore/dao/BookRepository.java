package zddteam.bookstore.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import zddteam.bookstore.domain.Book;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends PagingAndSortingRepository <Book, String> {
    Book findByName(String name);
    Page<Book> findAllByCategoryId(Pageable pageable,String category_id);
}
