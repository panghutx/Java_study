package view;

import common.Util;
import dao.Blog;
import dao.BlogDao;
import dao.User;
import dao.UserDao;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blog_detail.html")
public class BlogDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //判断是否为登录状态
        User loginUser = Util.checkLogin(req,resp);
        if(loginUser==null){
            resp.sendRedirect("login.html");
            return;
        }
        //1.获取浏览器上的blogID
        int blogID = Integer.parseInt(req.getParameter("blogID"));
        //2.查找数据库
        UserDao userDao = new UserDao();
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(blogID);
        if(blog==null||"".equals(blog)){
            String html = "<h3>博客不存在</h3>";
            resp.getWriter().write(html);
        }

        int userID = blog.getUserID();
        User user = userDao.selectByID(userID);

        //3.模板渲染
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");

        WebContext webContext = new WebContext(req,resp,context);
        webContext.setVariable("blog",blog);
        webContext.setVariable("user",user);
        webContext.setVariable("isShow",loginUser.getUserID()==blog.getUserID());
        String html = engine.process("blog_detail",webContext);
        resp.getWriter().write(html);
    }
}
