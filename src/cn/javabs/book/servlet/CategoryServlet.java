package cn.javabs.book.servlet;

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

        String op = request.getParameter("op");
        switch (op){
            case "addCategory":
                addCategory(request,response);
                break;
            case "deleteCategory":
                deleteCategory(request,response);
                break;
            case "updateCategory":
                updateCategory(request,response);
                break;
            case "findAllCategories":
                findAllCategories(request,response);
                break;
            case "editCategoryUI":
                editCategoryUI(request,response);
                break;
        }
    }

    private void editCategoryUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        Integer id = Integer.parseInt(sid);

        Category category = categoryService.findCategoryById(id);
        if (category!=null){
            request.setAttribute("category",category);
            request.getRequestDispatcher("editCategoryUI.jsp").forward(request,response);
        }else {
            request.setAttribute("message","修改分类失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }

    }

    private void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.findAllCategories();
        if (list.size() > 0 && list != null){
            request.setAttribute("CategoryList",list);
            request.getRequestDispatcher("categoryList.jsp").forward(request,response);
        }else{
            request.setAttribute("message","查询全部分类失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        Integer id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Category category = new Category(id,name,description);
        System.out.println(category.toString());
        int row = categoryService.updateCategory(category);

        if (row>0){
            request.setAttribute("message","修改分类成功");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }else{
            request.setAttribute("message","修改分类失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }


    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        Integer id = Integer.parseInt(sid);

        int row = categoryService.deleteCategory(id);

        if (row>0){
            request.setAttribute("message","删除分类成功");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }else{
            request.setAttribute("message","删除分类失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }

    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Category category = new Category(name,description);

        int row = categoryService.addCategory(category);

        if (row>0){
            request.setAttribute("message","添加分类成功");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }else{
            request.setAttribute("message","添加分类失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }
}
