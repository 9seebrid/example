package example;

public class MainClass {
    public static void main(String[] args) {

        Car vCar = new Car("기아","K5","오토",4); // 생성자 초기화

        System.out.println(vCar.brand);
        System.out.println(vCar.model);
        System.out.println(vCar.gear);
        System.out.println(vCar.door);
        System.out.println("------------------------");

        vCar = new Car(); // 전역변수 초기화 Car를 앞에 안적으면 결국 vCar는 변수이기 때문에 현재 값으로 덮어 씌우는 것이기 때문에 vCar를 또 사용할 수 있음
        vCar.brand = "현대";
        vCar.model = "그랜저";
        vCar.gear = "오토";
        vCar.door = 4;

        System.out.println(vCar.brand);
        System.out.println(vCar.model);
        System.out.println(vCar.gear);
        System.out.println(vCar.door);
        System.out.println("-------------------------");

        System.out.println("-------------------------");
        vCar.run();
        vCar.stop();
        System.out.println("-------------------------");

    }
}
