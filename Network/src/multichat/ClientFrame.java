package multichat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientFrame extends JFrame {

    //구성 요소를 만들고 메인메소드에서 사용
    private JPanel panel = new JPanel();
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();

    private DataOutputStream dos;
    private String id;


    public ClientFrame(){
        //프레임 세팅


        //X버튼 활성화
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 지정 안하면 종료가 안 눌림림

        //프레임의 좌표 및 크기
        this.setBounds(100,100,300,400);
        panel.setLayout(new BorderLayout());

        textArea.setFocusable(false);


        panel.add(textArea, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.SOUTH);

        this.setContentPane(panel);

        inputID();


        //프레임의 제목
        this.setTitle("채팅 프로그램 >>" + id);

        //프레임 활성화
        this.setVisible(true);


//        textField.addActionListener(null);

        //동작 2 -textField 엔터 버튼 동작
        textField.addActionListener(new ActionListener() {
            //엔터쳤을 때 동작
            @Override
            public void actionPerformed(ActionEvent e) {
//                textArea.setText(textField.getText());
//                textArea.append(textField.getText()+"\n");

//                String msg = textField.getText();

                String msg = id + " : " + textField.getText();
                appendMsg(msg);

                sendMsg(msg);

                textField.setText(""); //채팅 내용 엔터 후 내용 삭제
            }
        });
    }
    public String inputID(){

        while(true) {
            //ID입력 받기
            id = JOptionPane.showInputDialog(this, "ID를 입력해 주세요 : ", "ID 입력창 : ", JOptionPane.DEFAULT_OPTION);
            //채팅 창이 뜨기 전 ID입력창이 뜨고 입력하면 접속

            if (id != null) {
                break;
            }
        }
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void sendMsg(String msg){
        try {

            dos.writeUTF(msg); //서버로 채팅 내용 전송
            dos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void appendMsg(String msg){
        textArea.append(msg+"\n");
    }

    public DataOutputStream getDos() {
        return dos;
    }

    public void setDos(DataOutputStream dos) {
        this.dos = dos;
    }

    public static void main(String[] args) {
        new ClientFrame();

    }
}
