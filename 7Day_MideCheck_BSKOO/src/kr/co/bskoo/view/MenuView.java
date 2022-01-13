package kr.co.bskoo.view;

import kr.co.bskoo.db.CarInfoVO;
import kr.co.bskoo.run.MainRun;

import java.awt.event.MouseAdapter;
import java.util.Scanner;

public class MenuView {

    CarInfoVO car = null;
    int num;
    int i = 0;
    boolean chk = true;

    public int num() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 10까지 번호를 입력하세요");
        int num_1 = sc.nextInt();
        num = num_1;
        return num;
    }

    public void car_input() {
        CarInfoVO[] ar_name = new CarInfoVO[num];
        for (int i = 0; i < num; i++) {
            car = new CarInfoVO();
            Scanner sc = new Scanner(System.in);
            System.out.println(i + 1 + "번째 차량의 이름을 입력하세요");
            String name = sc.nextLine();
            ar_name[i] = car;
            ar_name[i].car_name = name;

            System.out.println(i + 1 + "번째 차량의 가격을 입력하세요");
            String price = sc.nextLine();
            ar_name[i].car_price = price;
        }
        System.out.println("등록한 차량의 정보는 다음과 같습니다.");
        for (int i = 0; i < num; i++) {
            System.out.println(i + 1 + "번째" + " " + "차 이름은 " + ar_name[i].car_name + " " + "가격은 " + ar_name[i].car_price);
        }
    }

    public void yn() {
        MainRun mr = new MainRun();
        // boolean chk = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("계속 하려면 Y 종료하려면 N을 누르세요");
        while (chk) {
            String name = sc.nextLine();
            if (name.equals("Y")) {
                chk = true;
            } else if (name.equals("N")) {

                chk = false;
            }
        }
    }
}
//    public void print(fdg[]) {
//       arname=fdg;
//        CarInfoVO[] ar_name=new CarInfoVO[num];
//        for (int i = 0; i < num; i++) {
//            System.out.println(i + 1 + "번째" + ar_name[i].car_name + "  " + ar_name[i].car_price);
//        }
//
//    }
//
//    public boolean re() {
//        boolean ch = false;
//        return ch;
//    }


//
//
//    public void car_name() {
//        CarInfoVO[] ar_name = new CarInfoVO[num];
//        for (int i = 0; i < num; i++) {
//            car = new CarInfoVO();
//            Scanner sc = new Scanner(System.in);
//            System.out.println(i + 1 + "번째 차량의 이름을 입력하세요");
//            String name = sc.nextLine();
//            ar_name[i] = car;
//            ar_name[i].car_name = name;
//        }
//    }
//
//    public void car_price() {
//        CarInfoVO[] ar_name = new CarInfoVO[num];
//        for (int i = 0; i < num; i++) {
//            car2 = new CarInfoVO();
//            Scanner sc = new Scanner(System.in);
//            System.out.println(i + 1 + "번째 차량의 가격을 입력하세요");
//            String price = sc.nextLine();
//            ar_name[i] = car2;
//            ar_name[i].car_price = price;
//            System.out.println(ar_name[i].car_name);
//        }
//    }
//



