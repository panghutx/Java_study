package network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    private int port;
    private String ip;
    Socket client = null;

    public TcpClient(String ip,int port) throws IOException {
        this.port = port;
        this.ip = ip;
        this.client = new Socket(ip,port);
    }

    public void start(){

        try(InputStream inputStream = client.getInputStream()) {
            try(OutputStream outputStream = client.getOutputStream()){

                while(true){
                    //1.构造请求
                    Scanner scanner = new Scanner(System.in);
                    String req = scanner.next();
                    //2.发送请求
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(req);
                    printWriter.flush();
                    //3.接收响应
                    Scanner respScan = new Scanner(inputStream);
                    String resp = respScan.next();
                    System.out.println("resp:"+resp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient("127.0.0.1",9090);
        client.start();
    }
}
