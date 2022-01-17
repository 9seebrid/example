package chat2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClientReceive implements Runnable{

    private Socket socket;

    public ChatClientReceive(Socket socket){
        this.socket = socket;
    }
    //메세지를 받는 역할만 하는 쓰레드
    @Override
    public void run() {
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(socket.getInputStream());

            while(true){ //받고 출력 반복
                String receiveMsg = dis.readUTF();
                System.out.println("");
                System.out.println("Server >>" + receiveMsg);
                System.out.print("보낼 내용 입력 : ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
