package thread;

public class Cal {

    public void sum(int num1, int num2){
        int sum = 0;
        for(int i=num1;i<=num2;i++){
            sum += i;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("합계 : " + sum);

    }
}
