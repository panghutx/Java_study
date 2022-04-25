import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**   服务器端，想想我都需要做什么
 * 1.接受客户端传来的相应
 * 2.根据相应做出回应
 * 3.将回应传给客服端
 */

public class UdpEchoServer {
    //服务器在启动的时候，需要绑定端口号
    private DatagramSocket socket = null;
    //UdpEchoSever构造方法
    public UdpEchoServer(int port) throws SocketException, IOException {
        socket = new DatagramSocket(port);
    }
    //启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动");

        //接收响应
        while (true) {
            //1.读取请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //把读取的内容取出来作为一个字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2.根据请求做出相应
            String response = process(request);
            //3.将响应传给客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4.打印日志
            String log = String.format("[%s,%d] req:%s  resp:%s", responsePacket.getAddress().toString(), requestPacket.getPort(), request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
