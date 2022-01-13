package method;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainClass {


    public static void main(String[] args) {

        MainClass mc = new MainClass();
        //반환 X, 입력 X
        mc.method1();

        //반환 O, 입력 X
        String mcStr = mc.method2(); // str을 갖고 있는 -> "반환 O, 입력 X"
        //System.out.println(mcStr);
        System.out.println(mc.method2()); //위와 같은 내용 String이기 때문에 가능

        //반환 X, 입력 O
        mc.method3("반환 X, 입력 O 메소드");

        //반환 O, 입력 O
        int sum = mc.method4(11,10.34);
        System.out.println(sum);
        System.out.println(mc.method4(11,102.2));

    }


    //반환 X, 입력 X
    void method1(){
        System.out.println("반환 X, 입력 X 메소드");
    }
    //반환 O, 입력 X
    String method2(){ // String 타입을 반환해 줄것이기 때문에 void가 아닌 String
        String str="반환 O, 입력 X 메소드";
        return str; // str 값을 반환할 것 이기 때문에 str
    }
    //반환 X, 입력 O
    void method3(String str){
        System.out.println(str);
    }

    //반환 O, 입력 O
     int method4(int i, double d){
        int sum = i + (int)d;
        return sum;
    }
}
