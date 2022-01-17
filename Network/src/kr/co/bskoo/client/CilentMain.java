package kr.co.bskoo.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CilentMain {
    public static void main(String[] args) {
        //서버와 접속할 소켓 생성
        Socket sk = new Socket();

        //서버와 접속할 소켓 변수 설정
        Socket socket = null;

        try{
            //서버에 접속할 IP, PORT 객체 생성

            InetSocketAddress isa = new InetSocketAddress("192.168.0.106",9876);
            System.out.println("연결 전 신호 전송");
            //서버 소켓에 신호 전송
            sk.connect(isa); //연결 : 내가 접속하고자 하는 Sever 주소 정보 필요

            //socket = new Socket("192.168.0.106",9876); 과 같은 방식으로 해도 됨
            System.out.println("연결 후 신호 확인");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
