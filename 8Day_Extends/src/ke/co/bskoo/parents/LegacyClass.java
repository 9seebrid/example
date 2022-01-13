package ke.co.bskoo.parents;

public abstract class LegacyClass {

    public static void main(String[] args) {
        System.out.println("test");

    }

    public abstract void run(); // 추상적이기 때문에 절대 구현이 이루어지면 안됨

    public void test(){
        System.out.println("test 메소드 실행");
    }
}
