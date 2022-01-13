package kr.co.bskoo.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import kr.co.bskoo.data.EmpVO;

public class EmpDao {

    // Database 연결하기 위한 작업 시작
    // 1. JDBC 사용을 위한 JDBC Driver 호출, Connection 생성해줌
    private Connection jdbcInit() {
        Connection conn = null;
        //properties 값 호출하기
        Properties pt = new Properties();
        //Properties 파일 위치를 찾아야함
        // 파일 위치 접근 방법 2가지(1. 절대경로(시스템경로) 2.상대경로(프로젝트 단위 경로)
        //절대경로 프로퍼티 : D:\보안개발3기 자료\2.JAVA\intelliJ\example\9Day_jdbc\src\DB.properties

        try {
//            pt.load(new FileReader("D:\\보안개발3기 자료\\2.JAVA\\intelliJ\\example\\9Day_jdbc\\src\\DB.properties")); //절대 경로
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DB.properties"); // 상대경로로 불러오기 문자열 버퍼 방식
            pt.load(inputStream); // 버퍼를 변수로 지정 후 pt.load에 입력
//            String dbDriver = pt.getProperty("driver"); 변수에 저장하지 않고 직접 세팅
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName(pt.getProperty("driver"));
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
            conn = DriverManager.getConnection(pt.getProperty("url"),pt.getProperty("username"),pt.getProperty("password"));
//			Class.forName("org.mariadb.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/scott", "scott", "tiger");
            System.out.println("Connection 생성 여부 확인 : " + conn);
            // getConnection 매개변수에 들어가야할 내용
            // Oracle 접속 주소, 계정명, 암호
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
        } catch (FileNotFoundException e) { // 파일에 대한 exception
            e.printStackTrace();
        } catch (IOException e) { // properties에 대한 exception
            e.printStackTrace();
        }
        return conn;
    } // jdbcInit() 메소드 종료문

    private Connection jdbc_mariadb_Init() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/scott", "scott", "tiger");
            System.out.println("Connection mariadb 생성 여부 확인 : " + conn);
            // getConnection 매개변수에 들어가야할 내용
            // Oracle 접속 주소, 계정명, 암호
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

    // 2. Connection 통해 SQL문을 실행 할 수 있는 메소드 구현하기. EMP 정보 Insert하기
    public int[] insertEmp(EmpVO ev) {
        // SQL문을 실행시킬 수 있게 하기위해서 인터페이스를 제공 해줌
        // Statement, PreparedStatement
        PreparedStatement pstmt = null;
        PreparedStatement pstmt_mysql = null;
        Connection conn = jdbcInit();
        Connection conn1 = jdbc_mariadb_Init();
        String sql = "INSERT INTO emp(empno, ename, mgr, job, hiredate, sal, comm, deptno) VALUES(?,?,?,?,TO_DATE(?),?,?,?)";
        String sql1 = "INSERT INTO emp(empno, ename, mgr, job, hiredate, sal, comm, deptno) VALUES(?,?,?,?,STR_TO_DATE(?,'%Y-%c-%d'),?,?,?)";
        // pstmt.executeQuery(); // 결과값이 있는 SQL문 실행시 사용 -> Select문을 사용할 시에 사용
        int result_cnt = 0;
        int result_cnt2 = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ev.getEmpno());
            pstmt.setString(2, ev.getEname());
            pstmt.setInt(3, ev.getMgr());
            pstmt.setString(4, ev.getJob());
            // [ex. 2021-01-01]
            pstmt.setString(5, ev.getHiredate());
            pstmt.setDouble(6, ev.getSal());
            pstmt.setDouble(7, ev.getComm());
            pstmt.setInt(8, ev.getDeptno());
            result_cnt = pstmt.executeUpdate();
//			pstmt.clearParameters();

            pstmt_mysql = conn1.prepareStatement(sql1);
            pstmt_mysql.setInt(1, ev.getEmpno());
            pstmt_mysql.setString(2, ev.getEname());
            pstmt_mysql.setInt(3, ev.getMgr());
            pstmt_mysql.setString(4, ev.getJob());
            // [ex. 2021-01-01]
            pstmt_mysql.setString(5, ev.getHiredate());
            pstmt_mysql.setDouble(6, ev.getSal());
            pstmt_mysql.setDouble(7, ev.getComm());
            pstmt_mysql.setInt(8, ev.getDeptno());
            result_cnt2 = pstmt_mysql.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 결과값이 select문을 통해서 가져올 db값이 없는 경우 -> DB에다가 DML문을
        // 실행시킬 시에 사용한다!
        finally {
            try {
                pstmt.close();
                pstmt_mysql.close();
                conn.close();
                conn1.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } // finally 종료지점
        int[] result_ar = {result_cnt, result_cnt2};

        return result_ar;

    }

    public int updateEmp(EmpVO ev) {
        PreparedStatement pstmt = null;
        Connection conn = jdbcInit();
        String sql = "UPDATE emp SET ename=?, mgr=?, job=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno=?";
        // pstmt.executeQuery(); // 결과값이 있는 SQL문 실행시 사용 -> Select문을 사용할 시에 사용
        int result_cnt = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ev.getEname());
            pstmt.setInt(2, ev.getMgr());
            pstmt.setString(3, ev.getJob());
            // [ex. 2021-01-01]
            pstmt.setString(4, ev.getHiredate());
            pstmt.setDouble(5, ev.getSal());
            pstmt.setDouble(6, ev.getComm());
            pstmt.setInt(7, ev.getDeptno());
            pstmt.setInt(8, ev.getEmpno());
            result_cnt = pstmt.executeUpdate();
//			pstmt.clearParameters();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 결과값이 select문을 통해서 가져올 db값이 없는 경우 -> DB에다가 DML문을
        // 실행시킬 시에 사용한다!
        finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } // finally 종료지점
        return result_cnt;
    }

    public int deleteEmp(String empno) {
        // EmpView에서부터 입력받은 사원 번호를 통하여 데이터를 삭제할 수있도록 기능 수행
        Connection con = jdbcInit();
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement("DELETE FROM emp WHERE empno = ?");
            pstmt.setInt(1, Integer.parseInt(empno));
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return result;
    }

    public List<EmpVO> getAllEmp() {
        // 전체 사원 정보 출력 기능 구현 리스트
        Connection conn = null;

        conn = jdbcInit();

        // 쿼리문을 세팅하고 수행될 수 있도록 PreparedStatement
        PreparedStatement pstmt = null;
        // Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT empno, ename, job, mgr, TO_CHAR(hiredate,'YYYY-MM-DD'), sal, comm, deptno FROM emp";
        List<EmpVO> list = new ArrayList<EmpVO>(); // <> 제너릭 타입, 사용자가 리스트를 만들건데 규격의 객체 유형 설정
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                EmpVO ev = new EmpVO();
                // ev = Java에서 관리할 데이터 객체, rs = Database MS 가져올수 있는 데이터 세트(Set)
                ev.setEmpno(rs.getInt(1));
                ev.setEname(rs.getString(2));
                ev.setJob(rs.getString("job"));
                ev.setMgr(rs.getInt(4));
                ev.setHiredate(rs.getString(5));
                ev.setSal(rs.getDouble(6));
                ev.setComm(rs.getDouble(7));
                ev.setDeptno(rs.getInt(8));
                list.add(ev);
            }
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
        }

        return list;

    } // getAllEmp() 종료지점

    public int syncDB() {

        List<EmpVO> list = getAllEmp();
        Connection ma_con = jdbc_mariadb_Init();
        PreparedStatement ma_pstmt = null;
        int[] result_batch_cnt = null;
        int result_total_cnt = 0;

        try {
            ma_con.setAutoCommit(false);
            ma_pstmt = ma_con.prepareStatement(
                    "INSERT INTO emp_backup(empno, ename, mgr, job, hiredate, sal, comm, deptno) VALUES(?,?,?,?,STR_TO_DATE(?,'%Y-%c-%d'),?,?,?)");

            for (int i = 0; i < list.size(); i++) {
                ma_pstmt.setInt(1, list.get(i).getEmpno());
                ma_pstmt.setString(2, list.get(i).getEname());
                ma_pstmt.setInt(3, list.get(i).getMgr());
                ma_pstmt.setString(4, list.get(i).getJob());
                ma_pstmt.setString(5, list.get(i).getHiredate());
                ma_pstmt.setDouble(6, list.get(i).getSal());
                ma_pstmt.setDouble(7, list.get(i).getComm());
                ma_pstmt.setInt(8, list.get(i).getDeptno());

                // SQL 작업 영역 저장
                ma_pstmt.addBatch();
                // ma_pstmt 저장 파라미터 초기화(setInt, setString 등)
                ma_pstmt.clearParameters();

                if (i % 10 == 0) {
                    // 10개 단위로 작업시 마다

                    // addBatch로 저장된 작업 실행
                    result_batch_cnt = ma_pstmt.executeBatch();
                    for (int j = 0; j < result_batch_cnt.length; j++) {
                        result_total_cnt += result_batch_cnt[j];
                    }
                    System.out.println("10 단위 배치 실행");
                    // 작업 후 Batch 초기화
                    ma_pstmt.clearBatch();
                }

            } // for문 종료

            // 잔여 작업 쿼리문 실행
            result_batch_cnt = ma_pstmt.executeBatch();
            for (int j = 0; j < result_batch_cnt.length; j++) {
                result_total_cnt += result_batch_cnt[j];
            }
            // 작업 후 Batch 초기화
            ma_con.commit();
            ma_con.setAutoCommit(true);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                ma_con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally {
                try {
                    ma_pstmt.close();
                    ma_con.close();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

        return result_total_cnt;
    }

    public EmpVO getUserInfo(int empno) {
        // 사원번호로 사원 개별 정보 DB에서 가져오기
        Connection conn = null;

        conn = jdbcInit();

        // 쿼리문을 세팅하고 수행될 수 있도록 PreparedStatement
        PreparedStatement pstmt = null;
        // Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT empno, ename, job, mgr, TO_CHAR(hiredate,'YYYY-MM-DD'), sal, comm, deptno FROM emp WHERE empno = ?";
        EmpVO ev = new EmpVO();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empno);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                ev = new EmpVO();
                // ev = Java에서 관리할 데이터 객체, rs = Database MS 가져올수 있는 데이터 세트(Set)
                ev.setEmpno(rs.getInt(1));
                ev.setEname(rs.getString(2));
                ev.setJob(rs.getString("job"));
                ev.setMgr(rs.getInt(4));
                ev.setHiredate(rs.getString(5));
                ev.setSal(rs.getDouble(6));
                ev.setComm(rs.getDouble(7));
                ev.setDeptno(rs.getInt(8));
            }
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
        }

        return ev;
    }

    public EmpVO getUserInfo_Map(int empno) {
        // 사원번호 사원 개별 정보 DB에서 가져오기
        // 전체사원 정보를 조회한 List<EmpVO> --> DB에서 조회한 전체 사원 정보가 들어있다.
        // 이 list<EmpVO>에서 Map을 통해 저장을 하고, 사용자가 Map의 Key값(사원번호로)에 부합되는 정보 전체를 EmpVO로 세팅해서 Return해줌
        Map<Integer, EmpVO> map_list = new HashMap<Integer, EmpVO>();

        List<EmpVO> list = getAllEmp();
        //map_list.put(7369,list.get(0);
        for(int i=0;i<list.size();i++){
            int list_empno = list.get(i).getEmpno(); // 첫번째 조회된 사원 번호 7369(SMITH)
            map_list.put(list_empno,list.get(i));
        }
        //map을 통해 모든 사원 정보가 저장이 되어 있음
        // getUserInfo_Map 매개변수인 empno를 저장된 Map의 키값과 매핑(비교)하여 Map에 저장된 EmpVO 값을 가져온다.

        map_list.get(empno); //--> EmpView에서부터 사용자가 입력한 사원번호 값(현재 나는 없기 때문에 7369)을 map_list에 Key값으로 불러올 수 있도록 함


        return map_list.get(empno);
    }


    public int updateEmpMaria(EmpVO ev) {
        // MariaDB에 update 실행하기
        PreparedStatement pstmt = null;
        Connection conn = jdbc_mariadb_Init();
        String sql = "UPDATE emp_backup SET ename=?, mgr=?, job=?, hiredate=STR_TO_DATE(?,'%Y-%c-%d'), sal=?, comm=?, deptno=? WHERE empno=?";
        // pstmt.executeQuery(); // 결과값이 있는 SQL문 실행시 사용 -> Select문을 사용할 시에 사용
        int result_cnt = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ev.getEname());
            pstmt.setInt(2, ev.getMgr());
            pstmt.setString(3, ev.getJob());
            // [ex. 2021-01-01]
            pstmt.setString(4, ev.getHiredate());
            pstmt.setDouble(5, ev.getSal());
            pstmt.setDouble(6, ev.getComm());
            pstmt.setInt(7, ev.getDeptno());
            pstmt.setInt(8, ev.getEmpno());
            result_cnt = pstmt.executeUpdate();
//			pstmt.clearParameters();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 결과값이 select문을 통해서 가져올 db값이 없는 경우 -> DB에다가 DML문을
        // 실행시킬 시에 사용한다!
        finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } // finally 종료지점
        return result_cnt;
    }
}
