package globalVariable;

public class MainClass { //동작하는 클래스

    public static void main(String[] args) {

        Car vCar = new Car();

        System.out.println(vCar.brand);
        System.out.println(vCar.model);
        System.out.println(vCar.door);
        System.out.println(vCar.gear);

        System.out.println("-----------------------");
        //전역변수 수정

        vCar.brand ="기아";
        vCar.model = "K5";
        vCar.door = 2;
        vCar.gear = "스틱";

        System.out.println(vCar.brand);
        System.out.println(vCar.model);
        System.out.println(vCar.door);
        System.out.println(vCar.gear);

        vCar.run();

        /*
        - 전역 변수
        1. 선언 방법
            - Class 아래에 작성
            예) Class Car{
                String brand="현대"; //전역
                }
        2. 사용 방법
        1) 같은 클래스 내에서 사용
            - 지역변수와 동일하게 사용
            예) Class Car{
                String brand="현대"; //전역

                void method(){
                    brand = "기아";
                    String local = "지역"; // 지역변수
                }
            }
        2) 다른 클래스에서 사용
            - 객체화 진행 후 사용
            예) Class main(){
                main(){
                    Car vCar = new Car(); // 객체화 진행
                    vCar.brand = "기아"; //전역변수 사용
                }
            }
        */

    }

}
