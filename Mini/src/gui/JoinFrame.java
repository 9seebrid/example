package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import model.Member;
import vo.MemberVO;

public class JoinFrame extends JFrame {

    MemberVO mvo = new MemberVO();
    ObjectOutputStream oos = null;
    static Socket socket = null;


    private JPanel contentPane;
    private JLabel lblJoin;
    private JButton joinCompleteBtn;

    private JTextField tfUserid;
    private JTextField tfPassword;
    private JTextField tfPassword2;
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfNickName;
    private JTextField tfProfile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            socket = new Socket("192.168.0.106",7777);
            System.out.println("서버 접속");

        JoinFrame frame = new JoinFrame();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create the frame.
     */
    public JoinFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 590);
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

        tfPassword = new JTextField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(190, 156, 186, 35);
        contentPane.add(tfPassword);

        tfPassword2 = new JTextField();
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


                MemberVO mvo = new MemberVO();
                try {
                    mvo.setCode(1);
                    mvo.setId(tfUserid.getText());
                    mvo.setPw(tfPassword.getText());
                    mvo.setName(tfName.getText());
                    mvo.setEmail(tfEmail.getText());
                    mvo.setNickname(tfNickName.getText());
                    mvo.setProfile(tfProfile.getText());

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

