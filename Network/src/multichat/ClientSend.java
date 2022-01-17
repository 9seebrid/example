package multichat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread{
    private Socket socket;

    public ClientSend(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);

        try {
            dos = new DataOutputStream(socket.getOutputStream());

            while(true) {

                System.out.print("보낼 내용 입력 : ");
                String msg = sc.nextLine();

                dos.writeUTF(msg);
                dos.flush(); //보낼 때 남는 값 없이 보내도록 설정

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
