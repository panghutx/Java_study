package network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpThreadServer {
    ServerSocket server = null;

    public TcpThreadServer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void start() throws IOException {
        while(true){
            //建立连接
            Socket client = server.accept();
            Thread t = new Thread(()->{
                try {
                    processConnection(client);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();

        }


    }

    public void processConnection(Socket client) throws IOException {
        System.out.printf("[%s,%d]客户端建立连接\n",client.getInetAddress(),client.getPort());
        try(InputStream inputStream = client.getInputStream()){
            try(OutputStream outputStream = client.getOutputStream()){
                while(true){
                    Scanner scanner = new Scanner(inputStream);

                    if(!scanner.hasNext()){
                        System.out.printf("[%s,%d]客户端断开连接",client.getInetAddress(),client.getPort());
                        break;
                    }
                    String req = scanner.nextLine();
                    System.out.println(req);
                    //2.构造响应
                    String resp = process(req);
                    //3.返回响应
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(resp);
                    printWriter.flush();
                    System.out.printf("req:%s,resp:%s\n",req,resp);
                }
            }
        }finally {
            client.close();
        }
    }

    private String process(String req) {
        return req;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadServer server = new TcpThreadServer(9090);
        server.start();
    }
}
