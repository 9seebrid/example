package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import dao.ChatDao;
import dao.MemberDao;
import vo.ChatVO;
import vo.MemberVO;

public class ServerEcho implements Runnable {

    private Socket socket;

    public ServerEcho(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        String file = "C:\\Messenger\\download.jpg";

        try {
            ois = new ObjectInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            MemberDao md = new MemberDao();

            while (true) {
                Object obj = ois.readObject();


                if (obj instanceof MemberVO) {
                    MemberVO mv = (MemberVO) obj;
                    // 회원가입 정보 받기
                    System.out.println(mv.getCode() + "서버");
                    if (mv.getCode() == 1) {
                        dos.writeUTF("S");
						System.out.println(mv.getId());
						System.out.println(mv.getPw());
						System.out.println(mv.getName());
						System.out.println(mv.getEmail());
						System.out.println(mv.getNickname());
						System.out.println(mv.getProfile());

//                        //DB에 INSERT
//                        int result_1 = md.insertMember(mv);
//                        //결과 통지(S/F)
//                        if(result_1 == 1) {
//                            dos.writeUTF("S");
//                        } else {
//                            dos.writeUTF("F");
//                        }
//
//                        // 로그인 정보 받고 신호뿌리기
                    } else if (mv.getCode() == 2) {
                        System.out.println("로그인 값 들어옴");
                        System.out.println(mv.getId());
                        System.out.println(mv.getPw());
                        dos.writeUTF("F");
//                        int result_2 = md.getLoginInfo();
//                        if(result_2 == 1) {
//                            dos.writeUTF("S");
//                        } else {
//                            dos.writeUTF("F");
//                        }

                        //id중복체크
                    } else if (mv.getCode() == 3) {
                        System.out.println("ID 중복체크 값 들어옴");
                        System.out.println(mv.getId());
                        System.out.println(mv.getPw());
                        dos.writeUTF("S");
//                        int result_3 = md.idCheck();
//                        if(result_3 == 0) {
//                            dos.writeUTF("S");
//                        } else {
//                            dos.writeUTF("F");
//                        }
                    }
                    //메시지 받기
                } else if (obj instanceof ChatVO) {
                    System.out.println("test3");
                    ChatVO cv = (ChatVO) obj;


//						System.out.println(vo.getNum());
//						System.out.println(vo.getSendName());
//						System.out.println(vo.getReceiveName());
//						System.out.println(vo.getMessage());
//						System.out.println(vo.getState());
//						System.out.println(vo.getTime());

                    ChatDao cd = new ChatDao();
                    cd.insertChat(cv);

                    dis = new DataInputStream(socket.getInputStream());


                    fos = new FileOutputStream(file);


                }



            } // while종료 지점
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
