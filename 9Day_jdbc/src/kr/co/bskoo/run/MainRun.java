package kr.co.bskoo.run;

import kr.co.bskoo.dao.EmpDao;
import kr.co.bskoo.data.EmpVO;
import kr.co.bskoo.view.EmpView;

public class MainRun {

    public static void main(String[] args) {
        // 사용자에게서부터 값을 받아 DB에 연결하여 값을 입력하기
        // View라고 하는 객체를 통해 메뉴별로 관리할 수 있게 구성
        EmpView ev = new EmpView();
        EmpDao ed = new EmpDao();

        while (true) {
            // 메인 메뉴 출력
            ev.mainMenu();
            // 메뉴 번호 입력 선택하기
            String menu_code = ev.usr_input_ad();
            // 1번 메뉴 : 사원 추가 기능 구현
            if (menu_code.equals("1")) {
                // 추가할 사원 정보 입력
                EmpVO evo = ev.usrEmpInput();
                // 추가할 사원 정보를 Database에 연결해서 전달할 수 있도록 구성하기
                //EmpDao ed = new EmpDao(); // Dao = Data Access Object -> DB연결을 통한 데이터 처리 역할 객체
                int[] result_cnt = ed.insertEmp(evo);
                ev.resultView(result_cnt);

            } else if (menu_code.equals("2")) {
                //사원 수정하기
                EmpVO evo = ev.usrEmpInput(); // 새롭게 갱신할 사원 정보(수정할 사원 정보)
                //수정되기 전 사원 정보를 저장하기
                EmpVO evo_old = ed.getUserInfo(evo.getEmpno());
                // evo_old 값에 있는 것을 MariaDB에 Update하기
                int result_cnt_maria = ed.updateEmpMaria(evo_old); //결과값이 1이면 -> 마리아 DB에 기존 자료 업데이트 완료!
                // 결과값이 0이면 -> 업데이트 실패했다. 수정이 안된다!

                // Oracle에 업데이트 하는 단계
                int result_cnt = 0;
                if (result_cnt_maria == 1) {
                    //결과값이 1이면 -> 마리아 DB에 기존 자료 업데이트 완료!
                    result_cnt = ed.updateEmp(evo);
                }
                ev.resultView(result_cnt);

            } else if (menu_code.equals("3")) {
                //사원 삭제하기
                String empno = ev.usrEmpnoInput();
                int result_cnt = ed.deleteEmp(empno);
                ev.resultView(result_cnt);

            } else if (menu_code.equals("4")) {
                // 사원 전체 조회하기
                ev.empAllView(ed.getAllEmp());
                //ed.getAllEmp();
            } else if (menu_code.equals("99")) {
                // Oracle DB -> Maria DB 강제 저장 시키기
                ev.resultSyncView(ed.syncDB());

            } else if(menu_code.equals("7")){
                System.out.println("사원번호를 입력하세요. ");
                String empno = ev.usrEmpnoInput();
                int empno_int = Integer.parseInt(empno);
                ev.empView(ed.getUserInfo_Map(empno_int));
            }

            }


        }

}