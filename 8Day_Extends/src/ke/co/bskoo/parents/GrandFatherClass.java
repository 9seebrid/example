package ke.co.bskoo.parents;

public class GrandFatherClass {

    public static String school = "KBS 재단"; // 다른 클래스, 다른 객체에서도 접근할 수 있도록 구성할 수 있음, 생성자를 생성하여서도 사용 가능
    private static int tel_num = 90010903; //같은 클래스 내에서만 접근 가능(상속도 안됨)
    static double fax = 3435467.123123; //default 같은 패키지 내에 상속 받은 자식 객체들은 접근 가능 다른 패키지는 불가능
    protected static boolean code = true; //protected 다른 패키지 내에서 상속 받은 객체들은 접근이 가능하다. 생성해서 접근 불가능 (new 통해서 접근 불가능)

    public static void printMenu(){
        System.out.println("다음 수행하는 작업을 입력할 수 있도록 구성해주세요");
        System.out.println("1. 학사관리 시스템 2.실적 관리 시스템 3.행정관리시스템");
    }


}
