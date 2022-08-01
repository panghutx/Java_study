package api;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    //JSON库的核心类
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        //检测登陆状态，如果未登录，不能进入列表页和详情页
        User user = Util.checkLogin(req,resp);
        if(user==null){
            resp.setStatus(403);
            String html = "<h3>当前用户未登录</h3>";
            resp.getWriter().write(html);
            return;
        }

        String blogID = req.getParameter("blogID");
        //将数据库内容返回给前端页面
        BlogDao blogDao = new BlogDao();
        if(blogID==null){
            //请求的是列表页
            List<Blog> blogs = blogDao.selectAll();
            String blogsJson = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(blogsJson);
        }else{
            //请求的是详情页
            Blog blog = blogDao.selectOne(Integer.parseInt(blogID));
            String blogsJson = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(blogsJson);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //判断登录状态
        User user = Util.checkLogin(req,resp);
        if(user==null){
            String html = "<h3>当前用户未登录</h3>";
            resp.getWriter().write(html);
            return;
        }
        //获取参数
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title==null||title.equals("")||content==null||content.equals("")){
            String html = "<h3>当前提交的博客标题或者正文缺失!</h3>";
            resp.getWriter().write(html);
            return;
        }
        //构造blog
        Blog blog = new Blog();
        blog.setUserID(user.getUserID());
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
        resp.sendRedirect("blog_list.html");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
