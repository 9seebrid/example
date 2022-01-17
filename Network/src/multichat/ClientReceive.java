package multichat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceive extends Thread{
    private Socket socket;

    public ClientReceive(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(socket.getInputStream());

            while(true) {
                String msg = dis.readUTF();
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();

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
}
