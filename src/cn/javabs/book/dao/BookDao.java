package cn.javabs.book.dao;
/**
 * 重点  ★
 * 一共有 7 个方法
 */

import cn.javabs.book.entity.Book;
import java.util.List;

public interface BookDao {

    int addBook(Book book);

    int deleteBook(Integer id);

    int updateBook(Book book);

    Book findBookById(Integer id);

    List<Book> findAllBooks();

    Book getBookById(Integer id);

    /**
     * 查询全部图书记录
     * @param startIndex    开始索引
     * @param pageSize      每页个数
     * @return
     */
    List<Book> getAllBookRecords(int startIndex,int pageSize);

    int getPageBooksNumber(int CategoryId);

    /**
     *
     * @param startIndex
     * @param pageSize
     * @param CategoryId
     * @return
     */
    List<Book> getPageBooks(int startIndex,int pageSize,int CategoryId);



}
