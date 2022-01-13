package method;

public class Overloading {
    public static void main(String[] args) {

        Overloading ol = new Overloading();
        int sum = ol.add(10,20);
        System.out.println(sum);

        int sub = ol.sub(30,20);
        System.out.println(sub);

        System.out.println(ol.add(10.232,11.233));

        System.out.println(ol.add(20.11,11.512));

        System.out.println(ol.add(11.512,20));

        System.out.println(ol.add(10,20,30,40));

    }



    //덧셈 (정수 리턴)
    int add(int num1, int num2){
//      int sum = num1 + num2
        return num1 + num2; // 위와 같음
    }

    int sub(int num1, int num2){
        return num1 - num2;
    }

    double add(double num1, double num2){
        return num1 + num2;
    }

    double add(int num1, double num2){
        return num1 + num2;
    }

    double add(double num1, int num2){
        return num1 + num2;
    }
    int add(int num1, int num2, int num3, int num4){
//      int sum = num1 + num2 + num3 + num4
        return num1 + num2 + num3 + num4; // 위와 같음
    }
}
