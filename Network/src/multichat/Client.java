package multichat;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client(){
        //소켓 선언
        Socket socket = null;
//        Scanner sc = new Scanner(System.in);
        DataOutputStream dos = null;

        try {

            ClientFrame cf = new ClientFrame(); //따로 쓰레드로 실행 되는 중

//            System.out.println("ID 입력 : ");
//            String id = sc.nextLine();

            //소켓 생성
            socket = new Socket("192.168.0.106",7777); //서버 접속 완료

            System.out.println("서버 접속 완료");


//            Thread sendThread = new ClientSend(socket, id, cf);
            Thread receiveThread = new ClientReceive(socket,cf);

            dos = new DataOutputStream(socket.getOutputStream());
            cf.setDos(dos);

            String id = cf.getId();

            cf.sendMsg(id + "님이 접속하였습니다");

//            dos.writeUTF(id + "님이 접속하였습니다");
//            dos.flush();

//            sendThread.start();
            receiveThread.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client();
    }

}
