package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket= null;
        DatagramPacket inpack = null;


        byte[] buf = new byte[51];
        try {
            socket = new DatagramSocket(7777);
            inpack = new DatagramPacket(buf,buf.length);

            while(true) {
                System.out.println("UDP 서버 준비중....");
                socket.receive(inpack);

                System.out.println(new String(inpack.getData()));
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
