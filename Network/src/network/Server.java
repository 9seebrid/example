package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //서버
    public static void main(String[] args) {

        //서버소켓 선언
        ServerSocket serverSocket = null;
        DataInputStream dis = null; //클라이언트에서 보낸 데이터 받음
        Socket socket = null;
        DataOutputStream dos = null; // 클라이언트로 데이터 전송
//        BufferedInputStream bis = null;

        try {
            //서버소켓 생성
            serverSocket = new ServerSocket(7777); //포트번호만 적어서 생성성

            System.out.println("서버 대기 중...");

            //서버소켓 accept (대기상태)
            socket = serverSocket.accept();

            System.out.println("클라이언트 연결 완료");

            InputStream is = socket.getInputStream();
//            bis = new BufferedInputStream(is); //보조스트림을 닫으면 그 안에 스트림도 다 같이 닫힘
            dis = new DataInputStream(is); // UTF-8로 받음

            String receiveData = dis.readUTF();
            System.out.println(receiveData);

//            int data = 0;
//            while((data = bis.read()) != -1){ // 1byte이기 때문에 글이 잘려서 while문으로 계속 1바이트씩 읽어서 data에 담고 담긴 값을 다시 캐릭터로 변환
//                System.out.print((char)data);
//            }

            OutputStream os = socket.getOutputStream(); // 서버에서 다시 클라이언트로 보내기 위함이기 때문에 OutputStream을 사용
            dos = new DataOutputStream(os);
//            dos = new DataOutputStream(socket.getOutputStream()); 이런식으로 한번에 넣어줘도 됨
            String data = "클라이언트 안녕!! 응답 완료!!!";

            dos.writeUTF(data); // 서버쪽으로 String 데이터를 보냄 UTF-8 형식으로 변경
            dos.flush(); //데이터가 남아있지 않게 한번에 보내는 것 찌꺼기 없이 보내라는 뜻 두개는 세트라고 생각하는게 편함


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { //클로즈는 맨 밑에 받은 것 부터 닫아주는게 좋음
//                bis.close();
                dos.close();
                dis.close();
                socket.close();
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
