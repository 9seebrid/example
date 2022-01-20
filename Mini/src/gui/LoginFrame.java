package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import host.Host;
import vo.ClientVO;
import vo.MemberVO;

public class LoginFrame extends JFrame {
    MemberVO mvo = new MemberVO();
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;

    Host host = new Host(); // 생성자 초기화
    Socket socket = host.socket(); //Host 소켓을 로그인으로 불러옴


    private JPanel contentPane;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton loginBtn, joinBtn;


    /**
     * Create the frame.
     */
    public LoginFrame() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("username");
        lblLogin.setBounds(41, 52, 69, 35);
        contentPane.add(lblLogin);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(41, 103, 69, 35);
        contentPane.add(lblPassword);

        tfUsername = new JTextField();
        tfUsername.setBounds(157, 52, 176, 35);
        contentPane.add(tfUsername);
        tfUsername.setColumns(10);

        joinBtn = new JButton("회원가입");
        joinBtn.setBounds(229, 154, 104, 29);
        contentPane.add(joinBtn);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(108, 154, 106, 29);
        contentPane.add(loginBtn);

        tfPassword = new JPasswordField("");
        tfPassword.setColumns(10);
        tfPassword.setBounds(157, 103, 176, 35);
        contentPane.add(tfPassword);

        ClientVO cvo = new ClientVO(); //클라이언트 VO 선언

        try {
            cvo.setSocket(socket);
            cvo.setDis(new DataInputStream(socket.getInputStream()));
            cvo.setDos(new DataOutputStream(socket.getOutputStream()));
            cvo.setOos(new ObjectOutputStream(socket.getOutputStream()));
//            cvo.setOis(new ObjectInputStream(socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }


        setVisible(true);
        //회원가입 액션
        joinBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JoinFrame frame = new JoinFrame(cvo);
//                frame.setSocket(socket);
            }
        });

        //로그인 액션
        loginBtn.addActionListener(new ActionListener() { // 로그인 버튼 눌렀을 때 서버로 ID, PW 보내기
//            ObjectOutputStream oos = null;

            @Override
            public void actionPerformed(ActionEvent e) {

                String username = tfUsername.getText();
                String password = tfPassword.getText();


                MemberVO mvo = new MemberVO();

                mvo.setCode(2);
                mvo.setId(username);
                mvo.setPw(password);

                try {
                    cvo.getOos().writeObject(mvo);
                    cvo.getOos().flush();

                } catch (IOException ex) {
                    ex.printStackTrace();
                } // 서버로 정보 보내기 끝

                try {
                    String code = cvo.getDis().readUTF();
                    System.out.println(code);

                    if(code.equals("S")){
                        JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
                    }else if(code.equals("F")){
                        JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }

            });
        }

}


