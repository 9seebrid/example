package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //서버
    public static void main(String[] args) {

        //서버소켓 선언
        ServerSocket serverSocket = null;


        try {
            //서버소켓 생성
            serverSocket = new ServerSocket(7777); //포트번호만 적어서 생성성

            System.out.println("서버 대기 중...");

            //서버소켓 accept (대기상태)
            Socket socket = serverSocket.accept();

            System.out.println("클라이언트 연결 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
