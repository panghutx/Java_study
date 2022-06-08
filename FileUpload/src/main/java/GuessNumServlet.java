import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/guess")
public class GuessNumServlet extends HttpServlet {
    public int num;
    public int count;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成一个随机数
        Random random = new Random();
        //随机数范围在[1,100]
        num = random.nextInt(100)+1; //得到一个1-100之间的随机数
        //设置响应的类型格式
        resp.setContentType("text/html;charset=utf-8");
        //字符串拼接响应页面
        StringBuilder html = new StringBuilder();
        html.append("<form action=\"guess\" method=\"post\">\n" +
                "        <input type=\"text\" name=\"guessNum\">\n" +
                "        <input type=\"submit\" value=\"确认输入\">\n" +
                "    </form>");
        //返回响应
        resp.getWriter().write(html.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应格式
        resp.setContentType("text/html;charset=utf-8");
        //得到用户猜的数字
        int guessNum = Integer.parseInt(req.getParameter("guessNum"));
        String result ="";
        //比较用户输入的数字和生成的随机数
        if(guessNum<num){
            result="猜小了";
        }else if(guessNum>num){
            result="猜大了";
        }else {
            result="猜对了";
        }
        count++;
        //字符串拼接响应界面
        StringBuilder html = new StringBuilder();
        html.append("<form action=\"guess\" method=\"post\">\n" +
                "        <input type=\"text\" name=\"guessNum\">\n" +
                "        <input type=\"submit\" value=\"确认输入\">\n" +
                "    </form>");
        html.append("<div>"+result+"</div>");
        html.append("<div>"+"猜的次数："+count+"</div>");
        //返回响应界面
        resp.getWriter().write(html.toString());
    }
}
