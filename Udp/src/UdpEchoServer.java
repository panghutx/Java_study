import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UdpEchoServer {
    /**
     * 服务器端：
     * 1.接受客户端传来的请求
     * 2.根据请求做出响应
     * 3.将响应传给客户端
     */
    //DatagramSocket 是UDP Socket，用于发送和接收UDP数据报。
    private DatagramSocket socket=null;
    //UdpEchoServer的构造方法，需要传入一个端口号，通过端口号来决定将数据传给哪个进程
    public UdpEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);

    }
    //启动服务器
    public void start() throws IOException {
        System.out.println("服务器上线");
        while(true){
            //1、取请求
            //服务器不知道什么时候能接受到客户端放来的请求，没有收到请求时receive一直处于堵塞状态
            //DatagramPacket构造的时候需要一个缓冲区来存放请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //将读到的请求提取出来，作为字符串
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            //做出响应
            String response = process(request);
            //发出响应
            //读取请求要构造一个DatagramPacket，发出请求同样需要构造一个DatagramPacket
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //打印日志
            String log = String.format("%s,%d,req:%s,resp:%s",requestPacket.getAddress().toString(),requestPacket.getPort(),request,response);
            System.out.println(log);
        }
    }
    private String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
