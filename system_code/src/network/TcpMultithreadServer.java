package network;


import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpMultithreadServer extends TcpEchoServer1{
    public TcpMultithreadServer(int port) throws IOException {
        super(port);
    }

    @Override
    public void start() throws IOException {
        System.out.println("服务器启动成功");
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            //接受客户端的连接
            Socket clientSocket = socket.accept();
//            Thread t = new Thread(()->{
//                try {
//                    processConnection(clientSocket);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            t.start();
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) throws IOException {
        TcpMultithreadServer server = new TcpMultithreadServer(9090);
        server.start();
    }
}
