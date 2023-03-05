package network;



import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;
    private String serverIp;
    private int serverPort;

    public TcpEchoClient(String serverIp,int serverPort) {
       socket = new Socket();
       this.serverIp = serverIp;
       this.serverPort = serverPort;
    }
    public void start(){
        //1.构造请求
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream() ) {
            try(OutputStream outputStream = socket.getOutputStream()){
                //1.读取字符串
                String request = scanner.nextLine();
                //2.将请求发给服务器
                PrintWriter printWriter = new PrintWriter(outputStream);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
