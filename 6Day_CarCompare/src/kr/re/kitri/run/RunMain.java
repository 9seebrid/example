package kr.re.kitri.run;
import kr.re.kitri.db.CarInfoVO;
import kr.re.kitri.db.CarInfoVO2;
import kr.re.kitri.db.DataExample;
import kr.re.kitri.view.CarInfoView;
import kr.re.kitri.view.MenuView; // 다른 패키지에 있는 클래스를 사용하려면 import 해주어야 사용 가능. 정확하게 명시해 주어야 함


public class RunMain {
    //자동차 비교 검색 프로그램 구동 클래스
    public static void main(String[] args) {
        //Data 샘플 자료 가져오기(가상적으로 Database에 있는 자료 가져오기)
        DataExample de = new DataExample(); // 가져와서 쓸 수 있도록 객체화
        CarInfoVO car_info_vo = de.setDataExample();
        CarInfoVO2 car_info_vo2 = de.setData2Example();


        MenuView mv = new MenuView(); // 객체는 object타입이라고 생각하면 됨 object라는 객체를 상속받아서 사용한다고 생각하면 된다

        boolean mm_chk = true;
        while(mm_chk) {
                // Main Menu 출력하기
                mv.mainMenu();
                // 메뉴 선택 후 입력받기
                String mainMenuCode = mv.user_input();
                if(mainMenuCode.equals("0") ) {//equals String에서 비교할 수 있는 메소드
                    // 프로그램 종료 시키기
                    //while의 True값을 Flase로 바꿔야함
                    mm_chk = false;
                }// 메인메뉴 "0" 입력시 종료 지점
                else if(mainMenuCode.equals("1")){
                    //1. 전체 등록 차량 정보 조회 기능 구현하기
                    // car_name -> CarInfoView 라고 하는 곳에서 출력되어 볼 수 있도록 설정
                CarInfoView civ = new CarInfoView();
                civ.carNameView(car_info_vo);
                civ.carNameView(car_info_vo2);



                }//1번 메뉴 종료 지점
            }// 메인 메뉴 while 종료 지점
        }//main 메소드 종료 지점
}//RunMain 클래스 종료 지점
