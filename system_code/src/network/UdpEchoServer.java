package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 回显服务器：
 * 1.接收请求
 * 2.根据请求构造响应
 * 3.发送响应
 */
public class UdpEchoServer {
    private DatagramSocket server = null;

    public UdpEchoServer(int port) throws SocketException {
        server = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动成功");
        while(true){
            //1.接收客户端发来的请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            server.receive(requestPacket);
            //2.将请求解析成String
            String request = new String(requestPacket.getData(),0,requestPacket.getLength(),"UTF-8");
            //3.处理请求
            String response = process(request);

            //4.发送响应
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            server.send(responsePacket);

            System.out.printf("[%s:%d] req: %s, resp: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }
    public String process(String request){
        return request;
    }


}
