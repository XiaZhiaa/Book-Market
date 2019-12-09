package cn.javabs.book.service;

import cn.javabs.book.entity.Book;
import cn.javabs.book.util.Page;

import java.util.List;

public interface BookService {

    int addBook(Book book);

    int deleteBook(Integer id);

    int updateBook(Book book);

    Book findBookById(Integer id);

    List<Book> findAllBooks();

    /**
     * 查询所有图书
     * @param currentPageNum 当前页码
     * @return
     */
    Page findAllBooks(int currentPageNum);

    /**
     *
     * @param currentPageNum
     * @param categoryId
     * @return
     */
    Page findAllBookPageRecords(int currentPageNum,int categoryId);

}
