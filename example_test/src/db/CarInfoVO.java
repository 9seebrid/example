package db;

public class CarInfoVO {
    private String car_name;
    private int car_price;

    //setter
    //private에 선언된 변수를 setter라고 하는 메소드를 통해서 간접적으로 private에 선언된 전역 변수의 값을 넣을 수 있도록 구성해줌

    public void setCar_name(String car_name){
        //car_name. 보안관련 처리 문 실행
        this.car_name = car_name;
    }

    public void setCar_price(int car_price){
        this.car_price = car_price;
    }

    //getter
    //private에 선언되고 setter를 통해서 setting된 변수를 불러올 수 있도록 하는 메소드

    public String getCar_name() {
        return car_name;
    }

    public int getCar_price() {
        return car_price;
    }

}
