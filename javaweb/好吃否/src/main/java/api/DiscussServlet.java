package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Discuss;
import dao.DiscussDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/discuss")
public class DiscussServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //插入一个评论
        String score = req.getParameter("score");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(score==null|title==null||content==null||score.equals("")
                ||title.equals("")||content.equals("")){
            String html = "输入不合法";
            resp.getWriter().write(html);

        }
        //2.放进数据库
        DiscussDao dao =new DiscussDao();
        Discuss discuss = new Discuss();
        discuss.setScore(Integer.parseInt(score));
        discuss.setTitle(title);
        discuss.setContent(content);
        discuss.setPostTime(new Timestamp(System.currentTimeMillis()));
        dao.insert(discuss);
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        DiscussDao dao = new DiscussDao();
        List<Discuss> list = dao.selectAll();
        String listJson = objectMapper.writeValueAsString(list);
        resp.getWriter().write(listJson);
    }
}
