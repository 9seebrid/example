package example;

public class Car { //전역 변수
    String brand;
    String model;
    String gear;
    int door;

    Car(){  // 기본 생성자 생성
//        this("기아차","K5","오토",4); 생성자 안에서 다른 생성자를 불러올 때 쓰는 것 this()는 무조건 생성자 안에서만 사용
// this가 주석된 상태에선 현재 null값이 나오지만 주석을 해제하면 입력한 값이 맞는 생성자를 찾아 초기화를 시켜줌
    }

    Car(String b, String m, String g, int d) { //("현대","소나타",4) 로 MainClass에서 입력한 값이 들어옴
        brand = b;
        model = m;
        gear = g;
        door = d;
    }


    public static void main(String[] args) {
        Car vCar = new Car();

        System.out.println(vCar.brand);
        System.out.println(vCar.model);
        System.out.println(vCar.gear);
        System.out.println(vCar.door);


    }

    void run(){
        System.out.println(brand + "자동차가 달린다");
    }

    void stop(){
        System.out.println(brand + "자동차가 멈춘다");
    }
}