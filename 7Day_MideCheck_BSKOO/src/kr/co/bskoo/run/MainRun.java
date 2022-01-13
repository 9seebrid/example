package kr.co.bskoo.run;

import kr.co.bskoo.db.CarInfoVO;
import kr.co.bskoo.view.MenuView;

import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) {
    MenuView mv = new MenuView();
    //boolean chk = true;
    while(true) {
        mv.num();
        mv.car_input();
        mv.yn();
    }
    }//while문 종료
}// Main 메소드 종료 지점
//}//Class 종료 지점



//public class MainRun {
//    public static void main(String[] args) {
//
//    MenuView mv = new MenuView();
//
//    boolean ch = true;
//    int code = 0;
//
//    while (ch) {
//
//        mv.num_input();
//        }//while문 종료
//    }// Main 메소드 종료 지점
//}//Class 종료 지점


