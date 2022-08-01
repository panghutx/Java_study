package view;

import common.Util;
import dao.Blog;
import dao.BlogDao;
import dao.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog_list.html")
public class BlogListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //判断是否为登录状态
        User user = Util.checkLogin(req,resp);
        if(user==null){
            resp.sendRedirect("login.html");
            return;
        }

        //1.从数据库获取文章
        BlogDao blogDao = new BlogDao();
        List<Blog> blogs = blogDao.selectAll();

        //2.进行模板渲染
        ServletContext context = this.getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        WebContext webContext = new WebContext(req,resp,context);
        webContext.setVariable("blogs",blogs);
        webContext.setVariable("user",user);
        String html = engine.process("blog_list", webContext);
        resp.getWriter().write(html);
    }
}
