//package multichat;
//
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Client2 {
//
//     public static void main(String[] args) {
//            //소켓 선언
//            Socket socket = null;
//            Scanner sc = new Scanner(System.in);
//            DataOutputStream dos = null;
//            try {
//                System.out.println("ID 입력 : ");
//                String id = sc.nextLine();
//
//                //소켓 생성
//                socket = new Socket("192.168.0.106",7777); //서버 접속 완료
//
//                System.out.println("서버 접속 완료");
//
//                Thread sendThread = new ClientSend(socket, id);
//                Thread receiveThread = new ClientReceive(socket);
//
//                dos = new DataOutputStream(socket.getOutputStream());
//
//                dos.writeUTF(id + "님이 접속하였습니다");
//                dos.flush();
//
//                sendThread.start();
//                receiveThread.start();
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
