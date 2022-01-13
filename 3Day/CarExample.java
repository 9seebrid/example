public class CarExample {
    public static void main(String[] args) {

        Car myCar = new Car();
        Car myCar2 = new Car();

        System.out.println("제작회사 : " + myCar.company);
        System.out.println("모델명 : " + myCar.model);
        System.out.println("색깔 : " + myCar.color);
        System.out.println("최고속도 : " + myCar.maxSpeed);
        System.out.println("현재속도 : " + myCar.speed);

        System.out.println("--------------------------");

        myCar2.company = "삼성";
        myCar2.model = "QM6";
        myCar2.color = "흰색";
        myCar2.maxSpeed = 260;
        myCar2.speed = 60;


        System.out.println("제작회사 : " + myCar2.company);
        System.out.println("모델명 : " + myCar2.model);
        System.out.println("색깔 : " + myCar2.color);
        System.out.println("최고속도 : " + myCar2.maxSpeed);
        System.out.println("현재속도 : " + myCar2.speed);

        myCar2.color = "파랑";
        System.out.println("수정된 색상 : " + myCar2.color);

    }

}