package network.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {

    private final int port; //服务器端口号
    private final String ip; //服务器ip地址
    private DatagramSocket socket = null;

    public UdpClient(String ip,int port) throws SocketException {
        this.socket = new DatagramSocket();
        this.ip = ip;
        this.port = port;
    }
    public void start(){

        try {
            while(true){
                //1.发送请求
                System.out.println("请输入请求：");
                Scanner scanner = new Scanner(System.in);
                String req = scanner.nextLine();
                SocketAddress socketAddress = new InetSocketAddress(ip,port);
                DatagramPacket reqPacket = new DatagramPacket(req.getBytes(),req.getBytes().length, socketAddress);
                socket.send(reqPacket);
                //2.接收响应
                DatagramPacket respPacket = new DatagramPacket(new byte[1024],1024);
                socket.receive(respPacket);
                String resp = new String(respPacket.getData(),0,respPacket.getLength());
                System.out.println("resp："+resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SocketException {
        UdpClient client = new UdpClient("127.0.0.1",9090);
        client.start();
    }
}
