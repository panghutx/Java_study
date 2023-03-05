package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 回显客户端
 * 1.构造请求
 * 2.发送请求
 * 3.接收响应
 */
public class UdpEchoClient1 {
    private DatagramSocket client = null;
    private String Ip;
    private int port;

    public UdpEchoClient1(String ip, int port) throws SocketException {
        this.client = new DatagramSocket();
        Ip = ip;
        this.port = port;
    }

    public void start() throws IOException {
        while(true){
            //1.构造请求
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(Ip),port);
            //2.发送请求
            client.send(requestPacket);
            //3.接收响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
            client.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //4.打印日志
            System.out.printf("req:%s,resp:%s",request,response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient1 client1 = new UdpEchoClient1("127.0.0.1",9090);
        client1.start();
    }
}
