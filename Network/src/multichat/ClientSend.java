package multichat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread{
    private Socket socket;
    private String id;
    private ClientFrame cf;

    public ClientSend(Socket socket, String id, ClientFrame cf){
        this.socket = socket;
        this.id = id;
        this.cf = cf;
    }

    @Override
    public void run() {
        super.run();
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            cf.setDos(dos);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        Scanner sc = new Scanner(System.in);
//
//        try {
//            dos = new DataOutputStream(socket.getOutputStream());
//
//            while(true) {
//
//                System.out.print("보낼 내용 입력 : ");
//                String msg = sc.nextLine();
//
//                dos.writeUTF(id + ":" + msg);
//                dos.flush(); //보낼 때 남는 값 없이 보내도록 설정
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                dos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
