package multichat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceive extends Thread{
    private Socket socket;
    private ClientFrame cf;

    public ClientReceive(Socket socket, ClientFrame cf){
        this.socket = socket;
        this.cf = cf;
    }

    @Override
    public void run() {
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(socket.getInputStream());

            while(true) {
                String msg = dis.readUTF();
//                System.out.println(msg);
                cf.appendMsg(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                dis.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
////                try {
//                    dis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }

    }
}
