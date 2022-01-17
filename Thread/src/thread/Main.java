package thread;

public class Main {
    public static void main(String[] args) {

        Cal cal = new Cal();

        //Thread클래스를 상속 받은 클래스를 다향성을 이용한 선언
        Thread t1 = new ThreadEx1(cal);

        //Runnable 인터페이스를 구현받은 클래스를 쓰레드에 넣어서 선언
        Runnable r = new ThreadEx2(cal);
        Thread t2 = new Thread(r);

//        Thread t2 = new Thread(new ThreadEx2()); 위 두줄을 밑에 한줄로 쓴것

        t1.start();
        t2.start();

    }
}
