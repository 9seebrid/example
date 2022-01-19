package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;
import vo.MemberVO;

public class LoginFrame extends JFrame {
    MemberVO mvo = new MemberVO();
    ObjectOutputStream oos = null;
    static Socket socket = null;

    private JPanel contentPane;
    private JTextField tfUsername, tfPassword;
    private JButton loginBtn, joinBtn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            socket = new Socket("192.168.0.106",7777);
            System.out.println("서버 접속");

            LoginFrame frame = new LoginFrame();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create the frame.
     */
    public LoginFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        tfPassword = new JTextField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(157, 103, 176, 35);
        contentPane.add(tfPassword);

        setVisible(true);
        //회원가입 액션
        joinBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JoinFrame frame = new JoinFrame();
            }
        });

        //로그인 액션
        loginBtn.addActionListener(new ActionListener() {
            ObjectOutputStream oos = null;

            @Override
            public void actionPerformed(ActionEvent e) {

            String username = tfUsername.getText();
            String password = tfPassword.getText();

            MemberVO mvo = new MemberVO();
                try {
                    mvo.setCode(2);
                    mvo.setId(tfUsername.getText());
                    mvo.setPw(tfPassword.getText());

                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(mvo);
                    oos.flush();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });
    }
}


