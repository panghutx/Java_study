import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 客户端
 * 1.发出请求
 * 2.接收响应
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = null;
    private  int serverPort = 0;
    //构造方法
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new DatagramSocket();
    }
    public void start() throws IOException {
        //输入请求
        System.out.println("--->");
        Scanner scanner = new Scanner(System.in);
        String request = scanner.next();
        if(request.equals("exit")){
            System.out.println("exit!");
            return;
        }
        //发送请求
        DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,InetAddress.getByName(serverIp),serverPort);
        socket.send(requestPacket);
        //从服务器接收响应
        DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
        socket.receive(responsePacket);
        String response = new String(responsePacket.getData(),0,responsePacket.getData().length);
        //打印日志
        String log = String.format("req:%s res:%s",request,response);
        System.out.println(log);

    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }

}
