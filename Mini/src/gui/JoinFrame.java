package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;
import host.Host;
import vo.ClientVO;
import vo.MemberVO;

public class JoinFrame extends JFrame {

    ObjectOutputStream oos = null;
    DataInputStream dis = null;
    String code;
    boolean idCheckFlag;

    private JPanel contentPane;
    private JLabel lblJoin;
    private JButton joinCompleteBtn;
    private JButton idCheck;

    private JTextField tfUserid;
    private JPasswordField tfPassword;
    private JPasswordField tfPassword2;
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfNickName;
    private JTextField tfProfile;

//    Socket socket;

//    public void setSocket(Socket socket) {
//        this.socket = socket;
//    }

    /**
     * Create the frame.
     */
    public JoinFrame(ClientVO cvo) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(550, 590);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblJoin = new JLabel("회원가입");
        Font f1 = new Font("돋움", Font.BOLD, 20); //궁서 바탕 돋움
        lblJoin.setFont(f1);
        lblJoin.setBounds(200, 41, 101, 20);
        contentPane.add(lblJoin);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(69, 113, 69, 20);
        contentPane.add(lblId);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(69, 163, 69, 20);
        contentPane.add(lblPassword);

        JLabel lblPassword2 = new JLabel("Password 확인");
        lblPassword2.setBounds(69, 210, 100, 20);
        contentPane.add(lblPassword2);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(69, 257, 69, 20);
        contentPane.add(lblName);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(69, 304, 69, 20);
        contentPane.add(lblEmail);

        JLabel lblNickname = new JLabel("NickName");
        lblNickname.setBounds(69, 351, 69, 20);
        contentPane.add(lblNickname);

        JLabel lblProfile = new JLabel("Profile");
        lblProfile.setBounds(69, 398, 69, 20);
        contentPane.add(lblProfile);

        tfUserid = new JTextField();
        tfUserid.setColumns(10);
        tfUserid.setBounds(190, 106, 186, 35);
        contentPane.add(tfUserid);

        tfPassword = new JPasswordField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(190, 156, 186, 35);
        contentPane.add(tfPassword);

        tfPassword2 = new JPasswordField();
        tfPassword2.setColumns(10);
        tfPassword2.setBounds(190, 203, 186, 35);
        contentPane.add(tfPassword2);

        tfName = new JTextField();
        tfName.setColumns(10);
        tfName.setBounds(190, 250, 186, 35);
        contentPane.add(tfName);

        tfEmail = new JTextField();
        tfEmail.setColumns(10);
        tfEmail.setBounds(190, 297, 186, 35);
        contentPane.add(tfEmail);

        tfNickName = new JTextField();
        tfNickName.setColumns(10);
        tfNickName.setBounds(190, 344, 186, 35);
        contentPane.add(tfNickName);

        tfProfile = new JTextField();
        tfProfile.setColumns(10);
        tfProfile.setBounds(190, 391, 186, 35);
        contentPane.add(tfProfile);

        joinCompleteBtn = new JButton("회원가입완료");
        joinCompleteBtn.setBounds(206, 463, 139, 29);
        contentPane.add(joinCompleteBtn);

        idCheck = new JButton("ID 중복체크");
        idCheck.setBounds(380, 110, 100, 29);
        contentPane.add(idCheck);


        setVisible(true);
        //Id 중복 체크 액션
        idCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUserid.getText();
                MemberVO mvo = new MemberVO();
                mvo.setCode(3);
                mvo.setId(username);

                try { //ID 중복 체크 ID 데이터 서버로 보내기
                    cvo.getOos().writeObject(mvo);
                    cvo.getOos().flush();
                    System.out.println("ID체크값 보냄");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    code = cvo.getDis().readUTF();
                    System.out.println(code);

                    if(code.equals("S")){
                        JOptionPane.showMessageDialog(null, "사용가능한 ID 입니다");
                        idCheckFlag = true;
                    }else if(code.equals("F")){
                        JOptionPane.showMessageDialog(null, "이미 사용중인 ID 입니다.");
                        idCheckFlag = false;
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });


        setVisible(true);
        //회원가입완료 액션
        joinCompleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUserid.getText();
                String password = tfPassword.getText();
                String password2 = tfPassword2.getText();
                String name = tfName.getText();
                String email = tfEmail.getText();
                String nickname = tfNickName.getText();
                String profile = tfProfile.getText();


                if(username.equals("")) {
                    JOptionPane.showMessageDialog(null, "항목이 비어있습니다.");
                }else if(password.equals("")){
                    JOptionPane.showMessageDialog(null, "항목이 비어있습니다.");
                }else if(password2.equals("")){
                    JOptionPane.showMessageDialog(null, "항목이 비어있습니다.");
                }else if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "항목이 비어있습니다.");
                }else if(email.equals("")){
                    JOptionPane.showMessageDialog(null, "항목이 비어있습니다.");
                }else if(nickname.equals("")){
                    JOptionPane.showMessageDialog(null, "항목이 비어있습니다.");
                }


                if(password.equals(password2) && idCheckFlag){ // 패스워드 맞을 경우 서버로 데이터 보냄
                    try {
                        MemberVO mvo = new MemberVO();

                        mvo.setCode(1);
                        mvo.setId(username);
                        mvo.setPw(password);
                        mvo.setName(name);
                        mvo.setEmail(email);
                        mvo.setNickname(nickname);
                        mvo.setProfile(profile);
                        System.out.println(mvo.getCode());
                        cvo.getOos().writeObject(mvo);
                        cvo.getOos().flush();

                        code = cvo.getDis().readUTF();
                        System.out.println(code);

                        if(code.equals("S")){
                            JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다.");
                            dispose();
                        }else if(code.equals("F")){
                            JOptionPane.showMessageDialog(null, "회원가입에 문제가 생겼습니다.");
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else if(!password.equals(password2)) { // 패스워드 다를 경우 알림창 띄우고 다시 입력 알림 보여줌
                    JOptionPane.showMessageDialog(null, "비밀 번호가 다릅니다 확인해주세요");
                } else {
                    JOptionPane.showMessageDialog(null, "ID 체크를 해주세요");
                }
            }
        });
    }
}

