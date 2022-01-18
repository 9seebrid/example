package logintest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream ois = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버 대기중....");
            socket = serverSocket.accept();
            System.out.println("클라이언트 접속 완료");

            ois = new ObjectInputStream(socket.getInputStream());
            LoginVO vo = (LoginVO)ois.readObject();

            System.out.println(vo.getId());
            System.out.println(vo.getPwd());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
