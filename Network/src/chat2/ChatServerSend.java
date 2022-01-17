package chat2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerSend implements Runnable{

    private Socket socket;

    public ChatServerSend(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);

        try {
            dos = new DataOutputStream(socket.getOutputStream());

            while(true){
                System.out.print("보낼 내용 입력 : ");
                String sendMsg = sc.nextLine();

                dos.writeUTF(sendMsg);
                dos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
