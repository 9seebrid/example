public class While {
    public static void main(String[] args) {
        //while 특정 조건이 만족될 시에 지속해서 내부 {} 내용을 실행한다.
        //while () <- boolean(true,false)
        //논리적 비교 연산을 통해 특정 조건에 따라 반복 수행을 하고 싶을 시 까지
        //조건 + 반복을 함께 구현할 때 사용한다.
        //1부터 100까지 더하는 것을 while을 통해서 수행해보자
        int a = 1;
        int sum = 0;
        boolean chkpoint = true;
        while(chkpoint){
            sum = sum + a;

            // a가 만약 100이 되면, chkpoint를 flase로 설정해서 반복 실행을 중단시킨다.
            if(a==100){
                chkpoint = false;
            }
            //a = a+1;
            a++;
            System.out.println(sum);
        }

        //while문 사용
        //보통 특정 조건 까지 무한 반복을 실행하다가 종료되게 하려면 while문을 사용
        int a_1 = 1;
        int sum_1 = 0;
        while(a_1 <= 100){
            sum_1 = sum_1 + a_1;
            System.out.println("현재값" + a_1++);
            if(a_1 % 2 == 0){
                continue;
            }
            System.out.println(sum_1);
        }

        //do while은 do에 있는 것은 무조건 한번 실행 시킨다
        //false여도 while전에 한번 실행되는 것을 볼 수 있음
        boolean chk = false;
        do{
            System.out.println("do while 실행");
            chk = false;
        }while(chk);

    }
}
