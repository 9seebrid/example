package host;

import java.io.IOException;
import java.net.Socket;

public class Host {

    Socket socket = null;

    public Socket socket(){
        try {
            socket = new Socket("localhost",7777);
            System.out.println("server connection");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

}
