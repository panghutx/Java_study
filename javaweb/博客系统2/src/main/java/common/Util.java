package common;

import dao.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//检测是否为登录状态
public class Util {
    public static User checkLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);

        if(session==null){
            //未登录
            return null;

        }
        User user = (User) session.getAttribute("user");
        if(user==null){
            //未登录
            return null;
        }
        return user;
    }
}
