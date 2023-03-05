package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

    private static DatagramSocket socket = null;

    public UdpServer(int port) throws SocketException {
        System.out.println("服务器已上线");
        socket = new DatagramSocket(port);
    }

    public void start(){

        try {
            while(true){
                //1.接收请求
                DatagramPacket reqPacket = new DatagramPacket(new byte[1024],1024);
                socket.receive(reqPacket);
                String req = new String(reqPacket.getData(),0,reqPacket.getLength(),"utf8");

                //2.构造响应
                String resp = process(req);
                DatagramPacket respPacket = new DatagramPacket(resp.getBytes(),resp.getBytes().length,reqPacket.getSocketAddress());

                //验证resp内容
                //String r = new String(respPacket.getData(),0,respPacket.getLength());

                //3.发送响应
                socket.send(respPacket);
                //4.打印日志
                System.out.printf("[%s:%d] req: %s, resp: %s\n",
                        reqPacket.getAddress().toString(), reqPacket.getPort(), req, resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String process(String req) {
        return req;
    }

    public static void main(String[] args) throws SocketException {
        UdpServer server = new UdpServer(9090);
        server.start();
    }
}
