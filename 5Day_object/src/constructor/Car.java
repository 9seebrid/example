package constructor;

public class Car {

    String brand;
    String model;
    int door;

    //Car (){} 현재 기본 생성자 숨겨져 있는 상태

//    Car(){ //이렇게 선언하게 되면 기본 생성자 없어짐
//        System.out.println("생성자 호출");
//    }

    Car(){}

    Car(String str){
        System.out.println("생성자 호출");
        System.out.println(str); // MainClass에서 실행 할 경우 MainClass 에서 입력한 문자열이 들어옴
    }

    Car(String b, String m, int d){ //("현대","소나타",4) 로 MainClass에서 입력한 값이 들어옴
        brand = b;
        model = m;
        door = d;
    }


    void method(){
        System.out.println("method");
    }

}
