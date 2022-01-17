package multichat;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        //소켓 선언
        Socket socket = null;

        //소켓 생성
        try {
            socket = new Socket("192.168.0.106",7777); //서버 접속 완료

            System.out.println("서버 접속 완료");

            Thread sendThread = new ClientSend(socket);
            Thread recevieThread = new ClientReceive(socket);

            sendThread.start();
            recevieThread.start();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
