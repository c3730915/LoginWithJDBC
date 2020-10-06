package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
        System.out.println("LoginServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装user对象
        User loginUser = new User();
        loginUser.setPassword(password);
        loginUser.setUsername(username);
        //调用UserDao Login 方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //判断user
        if (user == null){
            //登陆失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {

            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }



        System.out.println("LoginServlet");
    }
}
