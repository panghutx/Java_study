package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer1{
    Map<String,String> map = new HashMap<>();
    public UdpDictServer(int port) throws SocketException {
        super(port);
        map.put("bird","小鸟");
        map.put("dog","小狗");
        map.put("cat","小猫");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request,"找不到！！！");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server  = new UdpDictServer(9090);
        server.start();
    }
}
