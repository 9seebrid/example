package server;

import vo.MemberVO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        MemberVO mvo = new MemberVO();
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream ois = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버 대기중....");
            socket = serverSocket.accept();
            System.out.println("클라이언트 접속 완료");

            ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                Object obj = ois.readObject();

                if (obj instanceof MemberVO) { //instanceof 객체 비교 명령어
                    MemberVO mv = (MemberVO) obj;
                    // 회원가입 정보 받기
                    if (mv.getCode() == 1) {

                        System.out.println(mv.getId());
                        System.out.println(mv.getPw());
                        System.out.println(mv.getName());
                        System.out.println(mv.getEmail());
                        System.out.println(mv.getNickname());
                        System.out.println(mv.getProfile());
                        // 로그인 정보 받기
                    } else if (mv.getCode() == 2) {

                        System.out.println(mv.getId());
                        System.out.println(mv.getPw());
                        //id중복체크 받기
                    } else if (mv.getCode() == 3) {

                        System.out.println(mv.getId());
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
