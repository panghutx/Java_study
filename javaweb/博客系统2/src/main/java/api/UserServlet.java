package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Util;
import dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        //检测登陆状态
        User user = Util.checkLogin(req,resp);
        if(user==null){
            String html = "<h3>未登录状态</h3>";
            resp.getWriter().write(html);
            return;
        }
        //获取blogID
        String blogID = req.getParameter("blogID");
        if(blogID==null){
            //更改列表页用户
            String userJson = objectMapper.writeValueAsString(user.getUsername());
            resp.getWriter().write(userJson);

        }else {
            //更改详情页用户信息
            BlogDao blogDao = new BlogDao();
            Blog blog = blogDao.selectOne(Integer.parseInt(blogID));
            if(blog==null){
                String html = "<h3>博文不存在</h3>";
                resp.getWriter().write(html);
                return;
            }
            UserDao userDao = new UserDao();
            User author = userDao.selectByID(blog.getUserID());
            String authorJson = objectMapper.writeValueAsString(author);
            resp.getWriter().write(authorJson);
        }

    }
}
