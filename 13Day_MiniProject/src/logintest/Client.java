package logintest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
//        DataOutputStream dos = null; 하나씩 구분해서 보내야 하기 때문에 안씀
        ObjectOutputStream oos = null;
        try {
            socket = new Socket("localhost",7777);
            System.out.println("서버 접속 완료");

            //로그인 화면
            String id ="admin";
            String pwd ="1234";

            LoginVO vo = new LoginVO();

            vo.setId(id);
            vo.setPwd(pwd);


//            dos = new DataOutputStream(socket.getOutputStream());
//            dos.writeUTF();

            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(vo);
            oos.flush();

            MessageVO mvo = new MessageVO();
            mvo.setNo(1);
            mvo.setSendName("sender");
            mvo.setReceiveName("receiver");
            mvo.setMessage("hi");

            oos.writeObject(mvo);
            oos.flush();

            oos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
