package globalVariable;

public class Car {

    //전역 변수 Class에서는 전역변수이면서 Car의 속성일 수 있음
    //실행하여면 메소드 안에서 실행해야한다 안그러면 오류남

    String brand = "현대";
    String model = "아반떼";
    int door = 4;
    String gear = "오토";

    //메소드 (기능)

    void run(){
//        String str="지역변수"; //해당 변수는 지역변수여서 run안에서만 사용 가능
        System.out.println(brand + "자동차가 달린다");
    }

    void stop(){
        System.out.println("자동차가 멈춘다");
    }
}
