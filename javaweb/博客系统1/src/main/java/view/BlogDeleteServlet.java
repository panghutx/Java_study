package view;

import common.Util;
import dao.BlogDao;
import dao.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blog_delete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //验证登录状态
        User user = Util.checkLogin(req,resp);
        if(user==null){
            String html = "<h3>未登录状态</h3>";
            resp.getWriter().write(html);
            return;
        }
        //获取浏览器参数
        int blogID = Integer.parseInt(req.getParameter("blogID"));
        //验证操作者与文章作者是否一致

        BlogDao blogDao = new BlogDao();
        UserDao userDao = new UserDao();
        int author = blogDao.selectOne(blogID).getUserID();
        if(user.getUserID()!=author){
            String html = "<h3>操作异常</h3>";
            resp.getWriter().write(html);
            return;
        }
        //执行删除操作
        blogDao.delete(blogID);
        //重定向
        resp.sendRedirect("blog_list.html");
    }
}
