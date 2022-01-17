package thread;
//Runnable 인터페이스 구현 받는 방법
public class ThreadEx2 implements Runnable{

    Cal cal = null;

    public ThreadEx2(Cal cal){
        this.cal = cal;
    }

    @Override
    public void run() {

//        Cal cal = new Cal();
        cal.sum(1,1000);

//        for(int i=0;i<100;i++){
//            System.out.print("+");
//
//            try {
//                Thread.sleep(50);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


    }
}
