package vo;

import java.io.*;
import java.net.Socket;

public class Client1 {

    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    ObjectOutputStream oos;
    ObjectInputStream ois;


    {
        try {
            socket = new Socket("localhost",7777);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
