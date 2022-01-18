package udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        DatagramPacket outPack = null;

        byte[] buf = new byte[512]; //데이터를 담을 공간

        try {
            InetAddress ip = InetAddress.getByName("localhost");

            String str = "udp network";
            buf = str.getBytes(); // udp network 담겨있음

            socket = new DatagramSocket();
            outPack = new DatagramPacket(buf, buf.length,ip,7777);

            socket.send(outPack);
            System.out.println("UDP 데이터 전송 완료");


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
