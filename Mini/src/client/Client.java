package client;

import vo.MemberVO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream oos = null;
        MemberVO mvo = new MemberVO();

        try {
            socket = new Socket("192.168.0.106",7777);
            System.out.println("서버 접속 완료");

            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(mvo);
            oos.flush();

            oos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
