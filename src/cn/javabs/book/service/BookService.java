package cn.javabs.book.service;

import cn.javabs.book.entity.Book;

import java.util.List;

public interface BookService {

    int addBook(Book book);

    int deleteBook(Integer id);

    int updateBook(Book book);

    Book findBookById(Integer id);

    List<Book> findAllBooks();


}
