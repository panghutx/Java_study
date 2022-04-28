import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    private ServerSocket listenSocket = null;

    public TcpEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
            //建立连接
            Socket clientSocket = listenSocket.accept();
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        //1.读取请求
        String log = String.format("%s,%d 服务器上线",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        System.out.println(log);
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()) {
            while(true){
                Scanner scanner = new Scanner(inputStream);
                if(!scanner.hasNext()){
                    log = String.format("%s %d 服务器下线",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                String request = scanner.next();

                //2.根据请求做出响应
                String response = process(request);
                //3.发送响应
                PrintWriter writer = new PrintWriter(outputStream);
                writer.print(response);
                writer.flush();
                //4.打印日志
                log = String.format("%s %d,req:%s,resp:%s",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
                System.out.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            clientSocket.close();
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }

}
