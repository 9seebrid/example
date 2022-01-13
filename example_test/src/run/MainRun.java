package run;

import view.MenuView;

public class MainRun {
    public static void main(String[] args) {
        //MainRun -> 메인 메소드를 생성 후 반복문을 통해 MenuView에 메뉴 및 입력, 입력 결과를 출력할 수 있도록 구성
        MenuView mv = new MenuView();
        boolean chk = true;
        while(chk){
            //1. MenuView를 통해 각 내용을 출력되도록 해야함
            //1단계 내용 출력시키키(차량 등록 수를 정하세요(1~10))
            int car_count = mv.setCarCount(); // 배열 공간 갯수 = 입력할 수 있는 차량 수
            for(int i=0;i<car_count;i++) {
                mv.setCarName(i);
                mv.setCarPrice(i);
            }// for문 종료 배열에 입력 값 넣는 부분
            mv.printAllCar();
            chk = mv.setContinue();

        }// while문 종료 지점
    }// main 메소드 종료 지점
}//Class 종료 지점
