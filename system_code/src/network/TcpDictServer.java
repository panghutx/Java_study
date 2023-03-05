package network;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TcpDictServer extends TcpEchoServer1{
    Map<String,String> map = new HashMap<>();
    public TcpDictServer(int port) throws IOException {
        super(port);
        map.put("cat","小猫");
        map.put("dog","小狗");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request,"字典未收录");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer tcpDictServer = new TcpDictServer(9090);
        tcpDictServer.start();
    }
}
