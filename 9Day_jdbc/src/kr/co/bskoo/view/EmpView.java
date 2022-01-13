package kr.co.bskoo.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import kr.co.bskoo.data.EmpVO;

public class EmpView {

    // EmpView로 사용자 입력 및 메뉴 출력할 수 있도록 구성하기
    // 1. 메인 메뉴 출력하기
    public void mainMenu() {
        System.out.println("EMP 관리 시스템입니다. 다음 메뉴를 선택하세요.");
        System.out.println("-------------------------------------");
        System.out.println("1. 사원 추가, 2. 사원 수정, 3. 사원 삭제, 4. 사원 조회, 5. 종료, 7. 사원 조회(사번검색 Map방식), 99. 자료백업");
    }

    // 사용자 입력 메소드 만들기
    public String usr_input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public EmpVO usrEmpInput() {
        // 추가할 사원 정보 입력하기
        // 입력해야 할 값들 : 1. 사원번호, 2. 사원이름, 3. 사수번호, 4.직무, 5. 입사일, 6. 급여, 7. 성과급, 8. 부서번호
        EmpVO ev = new EmpVO();
        System.out.println("사원번호를 입력하세요. ");
        ev.setEmpno(Integer.parseInt(usr_input_ad()));
        System.out.println("사원이름을 입력하세요. ");
        ev.setEname(usr_input_ad());
        System.out.println("사수번호를 입력하세요. ");
        ev.setMgr(Integer.parseInt(usr_input_ad()));
        System.out.println("직무를 입력하세요. ");
        ev.setJob(usr_input_ad());
        System.out.println("입사일을 입력하세요.[ex. 2021-01-01]");
        ev.setHiredate(usr_input_ad());
        System.out.println("급여를 입력하세요. ");
        ev.setSal(Double.parseDouble(usr_input_ad()));
        System.out.println("성과급을 입력하세요. ");
        ev.setComm(Double.parseDouble(usr_input_ad()));
        System.out.println("부서번호를 입력하세요. ");
        ev.setDeptno(Integer.parseInt(usr_input_ad()));
        // 세팅된(자바로 입력한 사원 입력값)을 리턴
        return ev;
    }

    public void resultView(int result_cnt) {
        // DML문을 통해서 나온 결과 갯수를 출력하는 기능 구현
        System.out.println(result_cnt + "개의 데이터가 반영되었습니다.");
    }

    public void resultView(int[] result_cnt) {
        // DML문을 통해서 나온 결과 갯수를 출력하는 기능 구현
        System.out.println(result_cnt[0] + "개의 데이터가 Oracle DB에 반영되었습니다.");
        System.out.println(result_cnt[1] + "개의 데이터가 Maria DB에 반영되었습니다.");
    }

    public String usrEmpnoInput() {
        // 사원번호 입력받기 기능 메소드
        return usr_input_ad();
    }

    public void empAllView(List<EmpVO> allEmp) {
        // Database에서 부터 받아온 전체 사원의 정보를 출력할 수 있도록 구성한다.
        // allEmp.get(0).getEmpno(); // - 0x0001(첫번째 db값을 세팅한 EmpVO)
        System.out.println("총 " + allEmp.size() + " 명의 사원 정보를 검색하였습니다.");
        for (int i = 0; i < allEmp.size(); i++) {
            System.out.println(i + 1 + "번째 사원 정보입니다.");
            System.out.println("사원번호 : " + allEmp.get(i).getEmpno());
            System.out.println("사원이름 : " + allEmp.get(i).getEname());
            System.out.println("사수번호 : " + allEmp.get(i).getMgr());
            System.out.println("직무 : " + allEmp.get(i).getJob());
            System.out.println("입사일 : " + allEmp.get(i).getHiredate());
            System.out.println("급여 : " + allEmp.get(i).getSal());
            System.out.println("상여급 : " + allEmp.get(i).getComm());
            System.out.println("부서번호 : " + allEmp.get(i).getDeptno());
            System.out.println("===========================================");
        }

    }

    public void resultSyncView(int syncDB) {
        // Sync 된 DB 갯수 표시
        System.out.println(syncDB + "개의 데이터가 백업 되었습니다.");

    }

    public String usr_input_ad() {
        Reader rd = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(rd);
        String usr_input = null;
        try {
            usr_input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usr_input;
    }

    public void empView(EmpVO userInfo_map) {
        System.out.println(userInfo_map.getEname()+ "사원 정보입니다.");
        System.out.println("사원번호 : " + userInfo_map.getEname());
        System.out.println("사원이름 : " + userInfo_map.getEname());
        System.out.println("사수번호 : " + userInfo_map.getEname());
        System.out.println("직무 : " + userInfo_map.getEname());
        System.out.println("입사일 : " + userInfo_map.getEname());
        System.out.println("급여 : " + userInfo_map.getEname());
        System.out.println("상여급 : " + userInfo_map.getEname());
        System.out.println("부서번호 : " + userInfo_map.getEname());
        System.out.println("===========================================");
    }
}