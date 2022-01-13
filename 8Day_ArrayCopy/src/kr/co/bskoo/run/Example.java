package kr.co.bskoo.run;

public class Example {
    public static void main(String[] args) {
        int max =0;
        int[] array = {1, 5, 3, 10, 8, 2};
        //작성 위치
        //array에 들어가진 값을 전체 연산 수행

        for(int i=0;i<array.length;i++){
            //1번째 -> 1
            //2번째 -> 5
            //3번째 -> 3
            //4번째 -> 8
            //5번째 -> 2

            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println("max : " + max);
    }
}
