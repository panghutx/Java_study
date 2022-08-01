package api;

import dao.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //1.获取浏览器中的参数
        String username =req.getParameter("username");
        String password = req.getParameter("password");
        if(username==null||username.equals("")||password==null||password.equals("")){
            String html = "<h3>账号或密码为空</h3>";
            resp.getWriter().write(html);
            return;
        }
        //2.获取数据库中在用户
        UserDao userDao = new UserDao();
        User user = userDao.selectByUsername(username);
        if(user==null){
            String html = "<h3>用户不存在</h3>";
            resp.getWriter().write(html);
            return;
        }
        //3.匹配用户名、密码
        if(!password.equals(user.getPassword())){
            String html = "<h3>用户名或密码错误</h3>";
            resp.getWriter().write(html);
            return;
        }
        //4.将用户存入session
        HttpSession session = req.getSession(true);
        session.setAttribute("user",user);
        //4.重定向
        resp.sendRedirect("blog_list.html");
    }
}
