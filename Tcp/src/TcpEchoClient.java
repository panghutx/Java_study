import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private String serverIp;
    private int serverPort;
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new Socket(serverIp,serverPort);
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            while(true) {
                System.out.println("-->");
                String request = scanner.next();
                if (request.equals("exit")) {
                    break;
                }
                //1.发送请求
                PrintWriter writer = new PrintWriter(outputStream);
                writer.print(request);
                writer.flush();
                //2.接受响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                //3.打印日志
                String log = String.format("req:%s,resp:%s", request, response);
                System.out.println(log);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }

}
