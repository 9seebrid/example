package kr.co.bskoo.run;

public class MainRun {
    public static void main(String[] args) {
        //배열을 생성하고, 해당 배열을 복사하는 방법에 대해서 확인해보기
        int a = 5;
        int b = 0;

        //b값에 a값을 복사하여 넣는다
        b = a;
        System.out.println(b);

        int[] ar_a = new int[5];
        ar_a[0] = 10;
        ar_a[1] = 15;
        ar_a[2] = 20;
        ar_a[3] = 30;
        ar_a[4] = 40;
        System.out.println(ar_a);

        int[] ar_b = new int[10];//new 로 생성하게 되면 아무리 같은 형식이어도 주소값은 다르다
        System.out.println(ar_b);
        System.out.println(ar_b == ar_a); // 복제 하기 이전 주소값 다르기 때문에 false
//        ar_b = ar_a; //복사 이후에는 a와 b가 주소값이 같아진다 a값이 변하면 b값에도 영향을 줌
        System.arraycopy(ar_a,0,ar_b,0,ar_a.length);//ar_a에 있는 값을 ar_b에 0번째부터 ar_b에 ar_a에 length만큼 복사할 것이다.
        //System.arraycopy(복사할 원본 배열, 복사 시작할 원본 배열 시작점, 복사 대상 배열, 복사 대상 배열 index값, 원본 배열의 어디까지 복사할 지 정함)
        //
        System.out.println(ar_b == ar_a); // 복제 후 주소값 같기 때문에 true
        System.out.println("복사 이후 ar_a 주소 값 : " + ar_a);
        System.out.println("복사 이후 ar_b 주소 값 : " + ar_b);
        //ar_b[0] = ar_a[0]; ar_b에 ar_a를 복사하는 법

        //call by reference는 주소값을 복사해와서 링크 복사를 하기 때문에 원본 데이터가 변하면 복사 데이터도 변경
        //call by value는 순수하게 값만 복사해 와서 복사한 후의 값은 원본 데이터가 변해도 영향이 없음

        for(int i=0;i< ar_a.length;i++){
            System.out.println(ar_a[i]);
        }
        System.out.println("");

        for(int i=0;i< ar_b.length;i++){
            System.out.println(ar_b[i]);
        }

        System.out.println("새롭게 배열 변경 하기");
        ar_a[0] = 100;
        System.out.println(ar_a);
        System.out.println(ar_b);

        for(int i=0;i< ar_a.length;i++){
            System.out.println(ar_a[i]);
        }
        System.out.println("");
        for(int i=0;i< ar_b.length;i++){
            System.out.println(ar_b[i]);
        }
    }
}
