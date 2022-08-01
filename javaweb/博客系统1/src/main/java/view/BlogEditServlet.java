package view;

import common.Util;
import dao.Blog;
import dao.BlogDao;
import dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/edit")
public class BlogEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //验证是否登录
        User user = Util.checkLogin(req,resp);
        if(user==null){
            String html = "<h3>当前状态未登录</h3>";
            resp.getWriter().write(html);
        }
        assert user != null;
        int userID = user.getUserID();
        //1.获取浏览器的内容
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        //这里需要验证title和content是否为空，先忽略TODO
        //2.存入数据库
        BlogDao blogDao = new BlogDao();
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blog.setTitle(title);
        blog.setUserID(userID);
        blogDao.insert(blog);
        //3.重定向
        resp.sendRedirect("blog_list.html");
    }
}
