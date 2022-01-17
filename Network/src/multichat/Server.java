package multichat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static Map<Socket, DataOutputStream> list = new HashMap<Socket, DataOutputStream>();


    public static void main(String[] args) {
        //서버 소켓 선언
        ServerSocket serverSocket = null;
        Socket socket = null;
        //서버 소켓 생성
        try {
            serverSocket = new ServerSocket(7777);

            while(true) {
                System.out.println("서버 대기 중....");
                //서버 소켓 대기
                socket = serverSocket.accept();


                list.put(socket,new DataOutputStream(socket.getOutputStream()));

                //ServerEcho Thread 실행
                Thread echoThread = new Thread(new ServerEcho(socket));
                echoThread.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } //main 메소드 종료
} //class 종료
