package re.kr.kitri.data.run;

import re.kr.kitri.data.db.CarInfoVO;

public class MainRun {
    public static void main(String[] args) {
        // 정수형 데이터 3개를 입력 받을 배열을 할당하여 해당 배열에 10,20,30의 값을 넣을 수 있도록 구성하시오
        //int[] a_ar = {10,20,30};
        int[] a_ar = new int[3];
        a_ar[0] = 10;
        a_ar[1] = 20;
        a_ar[2] = 30;
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + "번째 배열 값: " + a_ar[i]);
        }

        //자동차 정보를 다음과 같이 설정해서 활용해 봅시다.
        //자동차 2개의 값을 입력
        //자동차 정보로 출력하는 항목은 다음과 같다(1. 자동차 이름(String), 2. 자동차 가격(int))
        //2개의 값 출력
        //1번째 자동차 : 테슬라, 700000
        //2번째 자동차 : 페라리, 1000000

//        CarInfoVO car1 = new CarInfoVO("테슬라",70000);
//        CarInfoVO car2 = new CarInfoVO("페라리",1000000);

        //두개의 값을 담기위한 ar_Car 배열
        CarInfoVO[] ar_car = new CarInfoVO[2];
        ar_car[0] = new CarInfoVO("테슬라",70000);
        ar_car[1] = new CarInfoVO("페라리",100000);

        for(int i=0;i<ar_car.length;i++){
            System.out.println(ar_car[i].car_name);
            System.out.println(ar_car[i].car_price);
        }



    }
}
