package constructor;

public class MainClass {

    public static void main(String[] args) {
        /*
          생성자
            - 객체화 진행시 호출됨 (new Car() 명령어 통해 호출)
            - 딱 한번만 호출 됨
            - 기본 생성자 존재 (Car(){} 숨겨져 있는 상태 생성자는 클래스에 반드시 하나 이상 있어야 하기 때문에)
            - 생성자를 하나라도 선언하면 기본 생성자는 없어짐

        */


//        Car vCar = new Car(); // 객체화

        Car vCar1 = new Car();
        Car vCar2 = new Car("생성자의 매개변수");

        Car vCar3 = new Car("현대","소나타",4); // Car(brand, model, door)

        System.out.println("| 브랜드 : " + vCar3.brand + " | 모델 : " + vCar3.model + " | 문 갯수 : " + vCar3.door);
//        System.out.println(vCar3.brand);
//        System.out.println(vCar3.model);
//        System.out.println(vCar3.door);
        System.out.println("-------------------------");
        vCar1.method();
        System.out.println("-------------------------");
        vCar2.method();
        System.out.println("-------------------------");
        //현대, 아반떼, 4
        //현대, 제네시스, 2
        //기아, K8, 4

        Car vCar4 = new Car("현대","아반떼",4); // Car(brand, model, door)
        System.out.println("| 브랜드 : " + vCar4.brand + " \t| 모델 : " + vCar4.model + " | 문 갯수 : " + vCar4.door);
        System.out.println("-------------------------");
        Car vCar5 = new Car("현대","제네시스",2); // Car(brand, model, door)
        System.out.println("| 브랜드 : " + vCar5.brand + " \t| 모델 : " + vCar5.model + " | 문 갯수 : " + vCar5.door);
        System.out.println("-------------------------");
        Car vCar6 = new Car("기아","K8",4); // Car(brand, model, door)
        System.out.println("| 브랜드 : " + vCar6.brand + " \t| 모델 : " + vCar6.model + " | 문 갯수 : " + vCar6.door);


    }

}
