package cn.javabs.book.servlet;

import cn.javabs.book.entity.Book;
import cn.javabs.book.service.BookService;
import cn.javabs.book.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    Book book = new Book();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String op = request.getParameter("op");

        switch (op){
            case "addBook":
                addBook(request,response);
                break;
            case "deleteBook":
                deleteBook(request,response);
                break;
            case "updateBookUI":
                updateBookUI(request,response);
                break;
            case "updateBook":
                updateBook(request,response);
                break;
            case "findAllBooks":
                findAllBooks(request,response);
                break;
            default:
                System.out.println("前台参数传递错误。");
                break;
        }
    }

    void jieshou(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String bookName = request.getParameter("bookName");
        String bookDescription = request.getParameter("bookDescription");
        String sbookPrice = request.getParameter("bookPrice");
        double bookPrice = Double.parseDouble(sbookPrice);
        String publish = request.getParameter("publish");
        String author = request.getParameter("author");
        String path = request.getParameter("path");
        String photoName = request.getParameter("photoName");

        book.setBookName(bookName);
        book.setBookDescription(bookDescription);
        book.setBookPrice(bookPrice);
        book.setBookPrice(bookPrice);
        book.setPublish(publish);
        book.setAuthor(author);
        book.setPath(path);
        book.setPhotoName(photoName);
    }
    /**
     * 添加图书方法
     * @param request
     * @param response
     * 1.接受前台参数
     * 2.要么直接传给bookService 或者 封装成book 对象 传给 bookService
     * 3.写返回值
     * 4.进行判断rows是否大于0
     */
    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        try {
//            BeanUtils.populate(book,request.getParameterMap());    //只差图片了
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        jieshou(request,response);

        int rows = bookService.addBook(book);

        if (rows > 0){
            request.setAttribute("message","添加图书成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("message","添加图书失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }

    /**
     * 删除图书方法
     * @param request
     * @param response
     */
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        int rows = bookService.deleteBook(id);

        if (rows > 0){
            request.setAttribute("message","删除图书成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("message","删除图书失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }

    /**
     * 修改图书方法  之  数据回显
     * @param request
     * @param response
     */
    private void updateBookUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        Book book = bookService.findBookById(id);

        if (book != null){
            request.setAttribute("book",book);
            request.getRequestDispatcher("/editBookUI.jsp").forward(request,response);
        }else{
            request.setAttribute("message","修改图书失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }

    /**
     * 修改图书方法
     * @param request
     * @param response
     */
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        jieshou(request,response);

        String sid = request.getParameter("id");

//        System.out.println(sid);
        int id = Integer.parseInt(sid);

        book.setId(id);

//        book.setId(id);
//        try {
//            BeanUtils.populate(book, request.getParameterMap());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        int rows = bookService.updateBook(book);

        if (rows > 0){
            request.setAttribute("message","修改图书成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("message","修改图书失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }
    /**
     * 查找全部图书方法
     * @param request
     * @param response
     */
    private void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.findAllBooks();
        if (bookList.size()>0 && bookList != null){
            request.setAttribute("list",bookList);
            request.getRequestDispatcher("/bookList.jsp").forward(request,response);
        }else {
            request.setAttribute("message","查询全部图书失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
}
