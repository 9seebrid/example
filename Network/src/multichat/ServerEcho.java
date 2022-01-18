package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

public class ServerEcho implements Runnable{

    private Socket socket;

    public ServerEcho(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            dis = new DataInputStream(socket.getInputStream());

            while(true) {
                String msg = dis.readUTF();

                System.out.println(msg); //서버 로그용

                Iterator<Socket> it = Server.list.keySet().iterator();
                while(it.hasNext()) {
                    Socket client = it.next();
                    if(this.socket != client){

                        dos = Server.list.get(client);
                        dos.writeUTF(msg);
                        dos.flush();

                    }
                }
            }

        } catch (IOException e) {
            Server.list.remove(socket);
            e.printStackTrace();
        } finally {
//            try {
//                dos.close();
//                dis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        } //finally 종료
    } // run 메소드 종료
}//class 종료
