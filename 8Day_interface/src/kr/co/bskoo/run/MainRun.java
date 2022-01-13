package kr.co.bskoo.run;

import kr.co.bskoo.view.*;

import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) {
        MenuViewIF mv = null;


//        MenuViewIF mv_i1 = new MenuView();
//        MenuViewIF mv_i2 = new MenuView2();
//        mv_i1 = mv_i2; //인터페이스로 묶었기 때문에 데이터 타입이 같아서 가능
//        mv_i1.menuView();
//        mv_i2.menuView();
        //인터페이스가 나오게 된 이유 - 윈도우즈 안에서 하드웨어 장치를 사용하기 위해선 os에서 드라이버 설치
        //하드웨에 있는 것을 os단으로 제어할 수 있도록 하기 위한 절차
        //드라이버를 만들기 위해서는 윈도우즈 소스를 알아야하지만 공개를 하지 않기 때문에 하드웨어 동작 영역에서 필요한 값을 넘겨줄 수 있도록 폼을 제공
        //인터페이스는 서로 연결해도 연동할 수 있게 하기 위한 규약체계라고 한다

//       mv = mv2; 불가능
//        String setting = "test";
//         스캐너를 통해서 사용자에게 입력을 받은 후에 1을 입력 받으면 mv 실행
//         2를 입력 받으면 mv2 실행

        Scanner sc = new Scanner(System.in);
        System.out.println("번호를 입력하세요 : 1.메뉴1 2.메뉴2 3.메뉴3");
        int code = sc.nextInt();
        if(code == 1){
//            mv.menuView();
            //code 1번을 입력하면 MenuView()를 통해서 실행되도록 하기
            mv = new MenuView();
            GetList gl = new MenuView();
            gl.instanceSetting();

        }else if(code == 2){
//            mv2.menuView();
            //code 2번을 입력하면 MenuView2()를 통해서 실행되도록 하기
            mv = new MenuView2();
        }else if(code ==3){
            mv = new MenuView3();
        }else if(code == 4){
            mv = new MenuViewTest();
            mv.instanceSetting();
        }
        mv.menuView();
    }
}
