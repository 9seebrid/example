public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.run();
        System.out.println("타이어 변경 후");
        myCar.frontLeftTire = new KumhoTire();
        myCar.frontRightTire = new KumhoTire();
        myCar.backRightTire = new KumhoTire();
        myCar.backLeftTire = new KumhoTire();

        myCar.run();

        System.out.println("스페어 타이어 변경 후");

        myCar.frontLeftTire = new SpareTire();
        myCar.frontRightTire = new SpareTire();

        myCar.run();

    }
}
