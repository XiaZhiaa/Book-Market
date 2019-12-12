package cn.javabs.book.web.servlet;

import cn.javabs.book.entity.Category;
import cn.javabs.book.service.CategoryService;
import cn.javabs.book.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");

        switch (method){
            case "addCategory":
                addCategory(request,response);
                break;
            case "deleteCategory":
                delCategory(request,response);
                break;
            case "updateCategory":
                updateCategory(request,response);
                break;
            case "findCategoryById":
                findCategoryById(request,response);
                break;
            case "findAllCategories":
                findAllCategories(request,response);
                break;
            default:
                System.out.println("前台参数传递错误。");
        }
    }

    /**
     * 查询全部分类
     * @param request
     * @param response
     */
    private void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.findAllCategories();
        if (list.size() >= 0 && list != null){
            request.setAttribute("data",list);
            request.getRequestDispatcher("/categoryList.jsp").forward(request,response);
        }else {
            request.setAttribute("message","查询全部分类失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 通过id查询
     * @param request
     * @param response
     */
    private void findCategoryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Category category = categoryService.findCategoryById(id);
        if (category != null){
            request.setAttribute("data",category);
            request.getRequestDispatcher("/editCategoryUI.jsp").forward(request,response);
        }else {
            request.setAttribute("message","失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 修改分类
     * @param request
     * @param response
     */
    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Category category = new Category(id,name,description);
        int rows = categoryService.updateCategory(category);
        if (rows > 0){
            request.setAttribute("message","修改分类成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else {
            request.setAttribute("message","修改分类成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 删除分类
     * @param request
     * @param response
     */
    private void delCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        int rows = categoryService.deleteCategory(id);
        if (rows > 0){
            request.setAttribute("message","删除分类成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else {
            request.setAttribute("message","删除分类失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 添加分类
     * @param request
     * @param response
     */
    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(name,description);
        int rows = categoryService.addCategory(category);
        if (rows > 0){
            request.setAttribute("message","添加分类成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else {
            request.setAttribute("message","添加分类失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
}
