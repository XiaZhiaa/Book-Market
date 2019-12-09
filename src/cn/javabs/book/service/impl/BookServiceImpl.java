package cn.javabs.book.service.impl;

import cn.javabs.book.dao.BookDao;
import cn.javabs.book.dao.impl.BookDaoImpl;
import cn.javabs.book.entity.Book;
import cn.javabs.book.service.BookService;
import cn.javabs.book.util.Page;

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

    /**
     * 以前的
     * @param id
     * @return
     */
    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    /**
     * 以前的
     * @return
     */
    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }

    /**
     *
     * @param currentPageNum 当前页码    前台传入的
     * @return
     */
    @Override
    public Page findAllBooks(int currentPageNum) {
        //只有类才可以判断是不是空的，基础数据类型不能这么判断
        //                                              |---  只能够将其转换为   引用数据类型
//        Integer number = currentPageNum;
//        if (number != null){
//
//        }
        if (currentPageNum == 0){
            currentPageNum = 1;
        }
        //  1.查询数据库有多少条
        int booksNumber = bookDao.getBooksNumber();
        //  2.实例化Page对象
        Page page = new Page(currentPageNum,booksNumber);

        //  3.在 Page 类中 有一个 构造方法 ， 里面有计算  开始索引的公式
        int startIndex = page.getStartIndex();
        //  3.在 Page 类中 有一个 定义好的变量  每页显示几条   |   固定的值 为 3
        int pageSize = page.getPageSize();

        //  4.查询所有条数  因为要分页，需要 索引值 和 条数
        List<Book> list = bookDao.getAllBookRecords(startIndex,pageSize);

        //  5.将已经查询到的所有数据放到 Page 类中
        page.setRecords(list);

        //6.看一下
//        System.out.println(page);

        return page;
    }

    @Override
    public Page findAllBookPageRecords(int currentPageNum, int categoryId) {
        if (currentPageNum == 0){
            currentPageNum = 1;
        }
        //  1.查询数据库有多少条
        int booksNumber = bookDao.getBooksNumber();
        //  2.实例化Page对象
        Page page = new Page(currentPageNum,booksNumber);

        //  3.在 Page 类中 有一个 构造方法 ， 里面有计算  开始索引的公式
        int startIndex = page.getStartIndex();
        //  3.在 Page 类中 有一个 定义好的变量  每页显示几条   |   固定的值 为 3
        int pageSize = page.getPageSize();

        //  4.查询所有条数  因为要分页，需要 索引值 和 条数
        List<Book> list = bookDao.getPageBooks(startIndex,pageSize,categoryId);

        //  5.将已经查询到的所有数据放到 Page 类中
        page.setRecords(list);

        //6.看一下
//        System.out.println(page);

        return page;
    }
}
