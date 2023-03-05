import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class TcpServer {

    private ServerSocket server;
    private Socket socket;

    void getServer(){
        try {
            server=new ServerSocket(9090);        //实例化Socket对象
            out.println("服务器套接字已创建成功");

            while(true) {
                out.println("等待客户机的连接");
                socket=server.accept();           //accept()方法会返回一个和客户端Socket对象相连的Socket对象


                getClientMessage();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //读取客户端发送过来的信息
    private void getClientMessage() {

            while(true) {
                //获得客户端信息
                try(InputStream inputStream = socket.getInputStream()){
                    Scanner scanner = new Scanner(inputStream);
                    String req = scanner.next();
                    //根据请求构造响应
                    String resp = process(req);
                    //写回响应
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream);
                    writer.println(resp);
                    writer.flush();
                    out.println("客户机："+req);
                    out.println("回应："+resp);
                }catch(Exception e) {
                    e.printStackTrace();
                 }finally {
                        try {
                             socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }

    }

    private String process(String req) {
        return req;
    }


    public static void main(String[] args) {
        TcpServer tcp=new TcpServer();
        tcp.getServer();
    }

}