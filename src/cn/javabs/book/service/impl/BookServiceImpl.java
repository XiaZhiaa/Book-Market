package cn.javabs.book.service.impl;

import cn.javabs.book.dao.BookDao;
import cn.javabs.book.dao.impl.BookDaoImpl;
import cn.javabs.book.entity.Book;
import cn.javabs.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }
}
