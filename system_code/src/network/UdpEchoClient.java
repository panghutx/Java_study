package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 回显客户端
 * 1.构建请求
 * 2.发送请求
 * 3.接收响应
 */
public class UdpEchoClient {
    private DatagramSocket socket=null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        //1.构造请求
        Scanner scanner = new Scanner(System.in);
        String request = scanner.next();
        DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                InetAddress.getByName(serverIp),serverPort);
        //2.发送请求
        socket.send(requestPacket);
        //3.接收响应
        DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
        socket.receive(responsePacket);
        String response = new String(responsePacket.getData(),0,responsePacket.getLength(),"UTF-8");
        //4.打印显示结果
        System.out.printf("req: %s, resp: %s\n", request, response);

    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
