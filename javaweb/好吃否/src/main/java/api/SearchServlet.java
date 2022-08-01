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
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取传来的参数
        String title = req.getParameter("title");
        if(title==null||title.equals("")){
            String html = "参数不合法";
            resp.getWriter().write(html);
        }
        resp.sendRedirect("detail.html");
        System.out.println(title);
        DiscussDao dao = new DiscussDao();
        List<Discuss> list;
        list = dao.selectOne(title);
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
        resp.getWriter().write(json);
    }

}
