package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.ChatVO;

public class ChatDao {

    private Connection jdbcInit() {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DB", "mini");
            System.out.println("Connection 생성 여부 확인 : " + conn);
            //getConnection 매개변수에 들어가야할 내용
            //Oracle 접속주소, 계정 암호
        } catch (ClassNotFoundException e) {
            try {
                conn.close();

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (SQLException sqle) {
            try {
                conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            sqle.printStackTrace();
        }
        return conn;
    } // jdbcInit() 메소드 종료문

    public int insertChat(ChatVO cv) {

        PreparedStatement pstmt = null;
        Connection conn = jdbcInit();

        String sql = "INSERT INTO chat(num, sendname, receivename, message, state, filelink, time) VALUES(?, ?, ?, ?, ?, ?, TO_DATE(?))";

        int result_cnt=0;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cv.getNum());
            pstmt.setString(2, cv.getSendName());
            pstmt.setString(3, cv.getReceiveName());
            pstmt.setString(4, cv.getMessage());
            pstmt.setInt(5, cv.getState());
            pstmt.setString(6, cv.getFilelink());
            //[ex. 2021-01-01 hh:mm]
            pstmt.setString(7, cv.getTime());


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return result_cnt;
    }//insertChat() 종료

}
