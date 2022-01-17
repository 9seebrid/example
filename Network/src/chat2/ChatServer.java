package chat2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    //서버
    public static void main(String[] args) {
        //서버 소켓 선언
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);


        //서버 소켓 생성 (bind까지 같이 포함)
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버 준비중...");
        //서버 소켓 대기 상태(accept)
            socket = serverSocket.accept();

            System.out.println("클라이언트 접속 완료");

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            //receive
            Thread receiveT = new Thread(new ChatServerReceive(socket));

            //send
            Thread sendT = new Thread(new ChatServerSend(socket));

            receiveT.start();
            sendT.start();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                dis.close();
//                dos.close();
//                socket.close();
//                serverSocket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }


    }
}
