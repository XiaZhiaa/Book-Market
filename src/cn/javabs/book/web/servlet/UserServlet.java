package cn.javabs.book.web.servlet;

import cn.javabs.book.entity.User;
import cn.javabs.book.service.UserService;
import cn.javabs.book.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    UserService userService = new userServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = "utf-8";
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        String op = request.getParameter("op");

        switch (op){
            case "userReg":
//                userReg(request,response);
                break;
            case "userLogin":
                userLogin(request,response);
                break;
            case "userLogout":
                userLogout(request,response);
                break;
        }
    }

    private void userLogout(HttpServletRequest request, HttpServletResponse response) {

    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.userLogin(username,password);

        if (user != null){
            HttpSession session= request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }else {
            request.setAttribute("message","用户登录失败");
            request.getRequestDispatcher("userMessage.jsp").forward(request,response);
        }
    }
}
