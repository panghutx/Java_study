package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 面向连接的回显服务器
 * 1.建立连接
 * 2.接收请求
 * 3.构造响应
 * 4.发送响应
 */
public class TcpEchoServer1 {
    public ServerSocket socket = null;

    public TcpEchoServer1(int port) throws IOException {
        this.socket = new ServerSocket(9090);
    }

    public void start() throws IOException {
        System.out.println("服务器启动成功");
        while(true){
            //接受客户端的连接
            Socket clientSocket = socket.accept();
            //todo 这里存在问题，考虑用多线程或线程池
            processConnection(clientSocket);
        }
    }

    public void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s,%d]客户端建立连接",clientSocket.getInetAddress(),clientSocket.getPort());
        try(InputStream inputStream = clientSocket.getInputStream()) {
            try(OutputStream outputStream = clientSocket.getOutputStream()){
                while(true){
                    //1.循环读取每个请求
                    Scanner scanner = new Scanner(inputStream);
                    if(!scanner.hasNext()){
                        System.out.printf("[%s,%d]客户端断开连接",clientSocket.getInetAddress(),clientSocket.getPort());
                        break;
                    }
                    //1.接收请求
                    String request = scanner.next();
                    //2.构造响应
                    String response = process(request);
                    //3.发送响应
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    printWriter.flush();
                    //4.打印日志
                    System.out.println();
                    System.out.printf("[%s:%d] req: %s, resp: %s\n", clientSocket.getInetAddress().toString(),
                            clientSocket.getPort(), request, response);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            clientSocket.close();
        }

    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer1 tcpEchoServer1 = new TcpEchoServer1(9090);
        tcpEchoServer1.start();
    }
}
