package thread;
//Thread클래스 상속 받는 방법
public class ThreadEx1 extends Thread{

    Cal cal = null;

    public ThreadEx1(Cal cal){
        this.cal = cal;
    }

    @Override
    public void run(){

//        Cal cal = new Cal();
        cal.sum(1,100);


//        for(int i=0;i<100;i++){
//            System.out.print("-");
//            try {
//                Thread.sleep(50);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


    }
}
