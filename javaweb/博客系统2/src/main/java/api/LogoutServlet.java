package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.登录才能注销 先检测是否登录
        HttpSession session = req.getSession(false);
        if(session==null){
            String html = "<h3>当前尚未登录</h3>";
            resp.getWriter().write(html);
            return;
        }
        //2.删除session中的user
        session.removeAttribute("user");
        //3.重定向
        resp.sendRedirect("login.html");
    }
}
