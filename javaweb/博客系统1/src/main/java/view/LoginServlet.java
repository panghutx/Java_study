package view;

import dao.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //1.从浏览器获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.从数据库获取用户名和密码
        UserDao userDao = new UserDao();
        User user = userDao.selectByUsername(username);
        //3.判断二者是否正确
        if(user==null){
            String html = "<h3>用户名错误</h3>";
            resp.getWriter().write(html);
            return;
        }
        //4.登陆成功，将user对象存入到session中
        if(user.getPassword().equals(password)){
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            resp.sendRedirect("blog_list.html");

        }else {
            String html = "<h3>用户名或密码错误</h3>";
            resp.getWriter().write(html);
        }

    }


}
