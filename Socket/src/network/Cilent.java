package network;

import javax.print.attribute.standard.Severity;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cilent {
    //클라이언트
    public static void main(String[] args) {

       //소켓 선언
       Socket socket = null;

       // 소켓 생성
        try {
            socket = new Socket("localhost",7777); //127.0.0.1 루프백
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
