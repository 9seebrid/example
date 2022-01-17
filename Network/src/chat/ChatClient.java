package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    //클라이언트
    public static void main(String[] args) {
        //소켓 선언 (서버와 연결하기 위한 소켓)
        Socket socket = null;

        //소켓 생성 (현재는 생성과 동시에 연결)
        DataOutputStream dos = null; // 서버로 데이터 보내기
        DataInputStream dis = null; //서버에서 보낸 데이터 받기
        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket("127.0.0.1",7777);

            System.out.println("접속 완료");

            OutputStream os = socket.getOutputStream();
            dos = new DataOutputStream(os); //서버로 내용을 보내기 위한 스트림
            dis = new DataInputStream(socket.getInputStream()); //서버에서 내용을 받기 위한 스트림


            while(true) {
                System.out.print("입력 >>");
                String sendMsg = sc.nextLine();

                dos.writeUTF(sendMsg);
                dos.flush();

                String receiveMsg = dis.readUTF();
                System.out.println("출력 >>" + receiveMsg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                dos.close();
                dis.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
