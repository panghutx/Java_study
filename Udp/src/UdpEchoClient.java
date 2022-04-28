import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    /**
     * 客户端：
     * 1.发送请求
     * 2.接受响应
     */
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            //读入一个请求
            System.out.println(">>");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                System.out.println("exit!");
                return;
            }
            //发出请求
            //UDP请求不仅需要知道请求的内容，还要知道把请求发给谁，也就是需要知道ip和端口号
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length
            , InetAddress.getByName(serverIp),serverPort);

            socket.send(requestPacket);
            //接受响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //打印日志
            String log = String.format("req:%s resp:%s",request,response);
            System.out.println(log);
        }

    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
