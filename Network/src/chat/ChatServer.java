package chat;

import java.net.ServerSocket;

public class ChatServer {
    //서버
    public static void main(String[] args) {
        //서버 소켓 선언
        ServerSocket serverSocket = null;

        //서버 소켓 생성 (bind까지 같이 포함)
        serverSocket = new ServerSocket("127.0.0.1",7777);


        //서버 소켓 대기 상태(accept)
    }
}
