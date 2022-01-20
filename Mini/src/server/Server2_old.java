package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server2_old {

    public static Map<String, Socket> list = new HashMap<String, Socket>();

    public static void main(String[] args) {
        //서버 소켓 선언
        ServerSocket serverSocket = null;
        Socket socket = null;

        //서버 소켓 생성
        try {
            serverSocket = new ServerSocket(7777);

            while(true) {

                //서버소켓 대기
                System.out.println("서버 대기중...");

                socket = serverSocket.accept();
                System.out.println("서버 접속 완료");

            }//while 종료 지점
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//main 메소드 종료 지점

}
