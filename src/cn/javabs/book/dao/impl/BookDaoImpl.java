package cn.javabs.book.dao.impl;

import cn.javabs.book.dao.BookDao;
import cn.javabs.book.entity.Book;
import cn.javabs.book.exception.BookDaoImplException;
import cn.javabs.book.util.DbcpUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {

    QueryRunner qrBook = new QueryRunner(DbcpUtils.getDataSource());

    /**
     * 添加图书
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        try {
            return qrBook.update("insert into book (bookName,bookDescription,bookPrice,publish,author,path,photoName) values (?,?,?,?,?,?,?)",
                    book.getBookName(),
                    book.getBookDescription(),
                    book.getBookPrice(),
                    book.getPublish(),
                    book.getAuthor(),
                    book.getPath(),
                    book.getPhotoName());
//                    book.getCategory().getId());
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 删除图书
     * @param id
     * @return
     */
    @Override
    public int deleteBook(Integer id) {
        try {
            return qrBook.update("delete from book where id = ?",id);
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 修改图书
     * @param book
     * @return
     */
    @Override
    public int updateBook(Book book) {
        try {
            return qrBook.update("update book set bookName=?,bookDescription=?,bookPrice=?,publish=?,author=?,path=?,photoName=?,categoryId = ? where id = ?",
                    book.getBookName(),book.getBookDescription(),book.getBookPrice(),book.getPublish(),book.getAuthor(),book.getPath(),book.getPhotoName(),book.getCategory().getId(),book.getId());
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 根据Id查询图书
     * @param id
     * @return
     */
    @Override
    public Book findBookById(Integer id) {
        try {
            return qrBook.query("select * from book where id = ? ",new BeanHandler<Book>(Book.class),id);
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 查询全部图书
     * @return
     */
    @Override
    public List<Book> findAllBooks() {
        try {
            return qrBook.query("select * from book",new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    @Override
    public Book getBookById(Integer id) {
        try {
            return qrBook.query("select * from book where id = ?",new BeanHandler<Book>(Book.class),id);
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 查询图书条数的方法
     * @return  总图书条数
     */
    @Override
    public int getBooksNumber() {
        try{
            Object obj = qrBook.query("select count(*) from book" ,new ScalarHandler<Book>(1));
            Long num = (Long) obj;
            int number = num.intValue();
            return number;
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 分页查询
     * @param startIndex    开始索引
     * @param pageSize      每页个数，要查询的条数
     * @return 集合bookList
     */
    @Override
    public List<Book> getAllBookRecords(int startIndex, int pageSize) {
        try {
            List<Book> bookList =  qrBook.query("select * from book limit ? , ? ",new BeanListHandler<Book>(Book.class),startIndex,pageSize);
            return bookList;
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 根据分类id  查询有多少条记录
     * @param CategoryId
     * @return
     */
    @Override
    public int getPageBooksNumber(int CategoryId) {
        try {
            Object obj = qrBook.query("select count(*) from book where categoryId = ?" ,new ScalarHandler<Book>(1));
            Long num = (Long) obj;
            int number = num.intValue();
            return number;
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }

    /**
     * 根据分页，从哪里开始，要显示多少条，要显示的分类的id
     * @param startIndex
     * @param pageSize
     * @param CategoryId
     * @return
     */
    @Override
    public List<Book> getPageBooks(int startIndex, int pageSize, int CategoryId) {
        try {
            List<Book> bookList = qrBook.query("select * from book where categoryId = ? limit ?,?" ,new BeanListHandler<Book>(Book.class),CategoryId,startIndex,pageSize);
            return bookList;
        } catch (SQLException e) {
            throw new BookDaoImplException(e);
        }
    }
}
