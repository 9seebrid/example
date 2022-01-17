package network;

import javax.print.attribute.standard.Severity;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Cilent {
    //클라이언트
    public static void main(String[] args) {

       //소켓 선언
       Socket socket = null;
       DataOutputStream dos = null;
       DataInputStream dis = null;
//       BufferedOutputStream bos = null;
        try {
            // 소켓 생성 ip. port
            socket = new Socket("localhost",7777); //127.0.0.1 루프백

            System.out.println("서버 연결 완료");

            OutputStream os = socket.getOutputStream(); // 클라이언트에서 서버로 보내기 위함이기 때문에 OutputStream을 사용
//            bos = new BufferedOutputStream(os); //버퍼스트림으로 아웃풋스트림을 감쌈 한글을 보내기엔 부적합하여 변경
            dos = new DataOutputStream(os);

            String data = "서버 안녕!!";

            // 서버로 데이터 전송
//            bos.write(data.getBytes()); // 서버쪽으로 String 데이터를 보냄
//            bos.flush(); //데이터가 남아있지 않게 한번에 보내는 것 찌꺼기 없이 보내라는 뜻 두개는 세트라고 생각하는게 편함
//            // bos.close(); close를 하게 되면 close안에 flush도 들어가있음
            dos.writeUTF(data); // 서버쪽으로 String 데이터를 보냄 UTF-8 형식으로 변경
            dos.flush(); //데이터가 남아있지 않게 한번에 보내는 것 찌꺼기 없이 보내라는 뜻 두개는 세트라고 생각하는게 편함

            InputStream is = socket.getInputStream();
            dis = new DataInputStream(is); // UTF-8로 받음

            String receiveData = dis.readUTF();
            System.out.println(receiveData);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//                bos.close();
                dis.close();
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
