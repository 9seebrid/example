package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ChatVO;
import vo.MemberVO;

public class MemberDao {

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

    //Member정보 Insert하기
    public int insertMember(MemberVO mv) {

        PreparedStatement pstmt = null;
        Connection conn = jdbcInit();

        String sql = "INSERT INTO member(id, pw, name, email, nickname, profile) VALUES(?, ?, ?, ?, ?, ?)";

        int result_cnt=0;

        try {
            pstmt.getConnection().prepareStatement(sql);
            pstmt.setString(1, mv.getId());
            pstmt.setString(2, mv.getPw());
            pstmt.setString(3, mv.getName());
            pstmt.setString(4, mv.getEmail());
            pstmt.setString(5, mv.getNickname());
            pstmt.setString(6, mv.getProfile());
            result_cnt = pstmt.executeUpdate();

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
        }//finally 종료
        return result_cnt;

    }//insertMember() 종료

    public List<MemberVO> getAllMember() {

        Connection conn = null;
        conn = jdbcInit();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT id, pw, name, email, nickname, profile FROM member";
        List<MemberVO> list = new ArrayList<MemberVO>();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                MemberVO mv = new MemberVO();

                mv.setId(rs.getString(1));
                mv.setPw(rs.getString(2));
                mv.setName(rs.getString(3));
                mv.setEmail(rs.getString(4));
                mv.setNickname(rs.getString(5));
                mv.setProfile(rs.getString(6));

                list.add(mv);

            }//while 종료지점
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }//finally 종료 지점
        return list;


    }//getAllMember() 종료

    public int getLoginInfo() {
        Connection conn = null;
        conn = jdbcInit();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM member WHERE id = ?, pw = ?";
        MemberVO mv = new MemberVO();

        int resultCount = 0;
        int result_login = 0;
        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if(rs.next()) {

                resultCount = rs.getInt(1);

            }//if 종료지점


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }//finally 종료지점
        return result_login;

    }//getLoginInfo() 종료 지점

    public int idCheck() {

        Connection conn = null;
        conn = jdbcInit();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM member WHERE id = ?";
        MemberVO mv = new MemberVO();

        int resultCount = 0;
        int result_idchk = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()) {

                resultCount = rs.getInt(1);
            }//if종료 지점
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }//finally 종료 지점
        return result_idchk;

    }//idCheck() 종료 지점

}
