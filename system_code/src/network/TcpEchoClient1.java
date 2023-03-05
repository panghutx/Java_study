package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

/**
 * 面向连接的客户端
 * 1.构造请求
 * 2.发送请求
 * 3.接收响应
 */
public class TcpEchoClient1 {
    private Socket socket =  null;

    public TcpEchoClient1(String ip,int port) throws IOException {
        //该步代表与服务器建立连接
        this.socket = new Socket(ip,port);
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){

                while(true){
                    //1.构造请求
                    String request = scanner.next();
                    //2.发送请求
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush();
                    //3.接收响应
                    Scanner respScan = new Scanner(inputStream);
                    String response = respScan.next();
                    //4.把结果显示到控制台上.
                    System.out.printf("req: %s, resp: %s\n", request, response);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient1 tcpEchoClient1 = new TcpEchoClient1("101.42.247.231",9090);
        tcpEchoClient1.start();
    }
}
