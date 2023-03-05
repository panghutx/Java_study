package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpEchoServer1 {
    private DatagramSocket socket = null;

    public UdpEchoServer1(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动成功");
        while(true){
            //1.接收请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength(),"UTF-8");
            //2.根据请求构造响应
            String response = process(request);
            //3.发送响应
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),0,response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4.打印日志
            System.out.printf("[%s:%d] req: %s, resp: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer1 server1 = new UdpEchoServer1(9090);
        server1.start();
    }
}
