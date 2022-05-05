import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

//创建一个成员属性和jackson中的key一样的类
class JacksonData{
    public int userId;
    public int userName;
}

@WebServlet("/postParameterJson")
public class postParameterJson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html.charset=utf-8");
        //读到请求
        String body = readBody(req);
        //解析请求
        //1.创建一个ObjectMapper的对象，这个是JackSon的核心类
        ObjectMapper objectMapper = new ObjectMapper();
        //2.通过ObjectMapper的readValue方法将body字符串转换成JacksonDate对象
        JacksonData jacksonData = objectMapper.readValue(body,JacksonData.class);
        //resp.getWriter().write(body);
        resp.getWriter().write(String.format("userId:%d,userName:%d",jacksonData.userId,jacksonData.userName));
    }
    //读出请求中的body
    private String readBody(HttpServletRequest req) throws IOException {
        InputStream inputStream = req.getInputStream(); //得到输入流
        int length = req.getContentLength(); //得到请求长度
        byte[] buffer = new byte[length];
        inputStream.read(buffer);//将请求读到buffer缓冲区
        return new String(buffer,"utf-8"); //将缓冲区用字符串返回给body
    }
}
