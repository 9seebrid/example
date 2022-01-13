package kr.co.bskoo.run;

import kr.co.bskoo.vo.CarInfiVO;

public class MainRunString {
    public static void main(String[] args) {
        CarInfiVO car1 = new CarInfiVO();
        CarInfiVO car2 = new CarInfiVO();

        car1.setCar_name("QM6");
        car1.setCar_price(10000);
        car1.setCar_type("SUV");

        car2.setCar_name("QM3");
        car2.setCar_price(7800);
        car2.setCar_type("소형 SUV");

        //복제 전 값
        System.out.println("복제 전 각각의 값");
        System.out.println("car1의 객체 주소값 : " + car1);
        System.out.println("car2의 객체 주소값 : " + car2);

        System.out.println("1번째 차 이름 : " + car1.getCar_name());
        System.out.println("2번째 차 이름 : " + car2.getCar_name());
        System.out.println("");
        car2 = car1;

        car2.setCar_name(car1.getCar_name()); // car2 name 에 car1 name을 넣어주는 방법
        System.out.println(car2.getCar_name());
        //car2에 car1 복제 후 주소값 변화
        System.out.println("복제 후 값");
        System.out.println("car2에 car1 복제 후 주소값 변화: " + car2);
        System.out.println("car1의 객체 주소값 : " + car1);
        System.out.println("car2의 객체 주소값 : " + car2);
        //복제 후 값을 변경하면 둘다 변경되는 것을 확인 할 수 있음
        car2.setCar_name("그랜저");
        System.out.println("1번째 차 이름 : " + car1.getCar_name());
        System.out.println("2번째 차 이름 : " + car2.getCar_name());
        //객체 같은 경우는 배열처럼 arraycopy같은게 없기 때문에 일일이 치환해주어서 사용해야 한다
        //잘못 복제하면 주소값 자체값이 복사되기 때문에 관리하거나 운영하기가 어려울 수 있다.

        String car_name_1 ="그랜저";
        String car_name_2 ="QM6";
        System.out.println("");
        System.out.println(car_name_1); // String은 원래 객체이기 때문에 둘을 비교하여도 각각의 객체를 생성하여 관리하기 때문에 둘은 다르기
        System.out.println(car_name_2);
        System.out.println(car_name_1 == car_name_2); //false가 나옴 각각은 다른 객체이기 때문에

        car_name_1 = car_name_1;
        car_name_2 = car_name_2;
        int a = 1;
        int b = 1;

        System.out.println(car_name_1 == car_name_2); //원래는 객체이기 때문에 call by reference가 되어야 하는데 현재 값을 인식하기 때문에 현재 call by value로 됨
        System.out.println(a == b); //call by value

        int c = 10;
        int d = 20;
        c += d;
        d = d+d;
        System.out.println(c);
        System.out.println(d);


//        System.out.println("car1에 car2 넣기");
//        car_name_1 = car_name_2;
//        System.out.println(car_name_1);
//        System.out.println(car_name_1 == car_name_2); //위에서 car1과 car2를 같게 했기 때문에 true




    }
}
