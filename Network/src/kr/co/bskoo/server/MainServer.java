package kr.co.bskoo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args){
        ServerSocket ss = null;
        try{
            //서버 소켓 생성
//            ServerSocket ss = null; // 지역변수이기 때문에 전역 위에다가 전역변수로 설정
            ss = new ServerSocket(); //ss = new ServerSocket(9876); 아래와 같은 방식 생성자에 port 번호 적어서 사용가능
            ss.bind(new InetSocketAddress("192.168.0.106",9876)); //bind 대기 상태 위처럼 바로 포트 번호 적어주어도 됨
            // IP와 포트번호를 갖고 있는 객체라고 생각하면 됨

            //서버 소켓을 대기 상태로 만듦
            Socket sk = ss.accept();
            // ss.accept(); 이 방식으로 해도 됨

            //그 다음 동작이 진행되면 클라이언트와 연결됨


            System.out.println("신호 들어옴!"); //TCP는 연결 지향성이기 때문에 계속 열어놓아야한다

            ss.close(); // try에서 문제가 생기면 catch로 가기 때문에 사실 바깥에 있어야한다 안그러면 스트림 소스를 계속 사용하고 있는 상태

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close(); //중간에 에러가 발생해도 catch를 통해서 종료되어야 하기 때문에 fanally에 close를 넣어줌
            } catch (IOException e) {
                e.printStackTrace(); // 에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다

            }
        }

//        try {
//            ss.close(); //중간에 에러가 발생해도 catch를 통해서 종료되어야 하기 때문에 fanally에 close를 넣어줌
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
