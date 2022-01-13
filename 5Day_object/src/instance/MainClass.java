package instance;

public class MainClass {

    public static void main(String[] args) {

        Car vCar = new Car(); //객체화

        vCar.brand = "현대";
        vCar.model = "아반떼";
        vCar.door = 4;

        System.out.println(vCar.brand);
        System.out.println(vCar.model);
        System.out.println(vCar.door);
        System.out.println("--------------------");

        Car vCar2 = new Car(); //새로운 객체화
        //객체화를 진행 할때 마다 새로운 메모리 공간 생성
        //book 테이블을 생각하면 각 행이 하나의 객체임
        //값을 수정하지 않았기 때문에 기본값 나옴(메모리 구조 볼 것)

        System.out.println(vCar2.brand);
        System.out.println(vCar2.model);
        System.out.println(vCar2.door);


    }
}
