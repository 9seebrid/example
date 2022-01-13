public class ExClass {

    public static void main(String[] args) {
        ExClass ex = new ExClass(); // 객체화 ex는 변수명(임의 지정) new가 메모리에 올리는 역할 ExClass는 클래스명
        ex.usr_sum1(20, 10); //호출

    }

    public void usr_sum1(int num1, int num2) {
        int sum1 = 0;
        int sum2 = 0;

        int temp = 0; // 임시 저장 변수?

        if(num1 > num2){ // num2가 num1보다 작아질 경우 작은수부터 큰수까지의 짝수, 홀수를 구해야해서 둘의 값을 변경해주는 상황
            temp = num2; // num1이 10이고 num2가 1이면 temp에 1을 담고 둘이 순서를 바꿀 때 일단 temp에 값을 담아둔다
            num2 = num1; // num2에 num1의 값을 넣어서 num2가 10이 됨
            num1 = temp; // 그 후 temp에 있는 1의 값을 num1로 넣어줘서 결과는 num1이 1이 됨
        }

        for(int i=num1;i <=num2;i++){
            if(i % 2 ==0){
//                sum = sum +a +b; 아래와 같이 써야 프로그래밍적
                sum1 += i; //위와 같은 방식 주로 이걸 많이 씀(프로그래밍적)
            }else{// 홀수 나머지가 나오기 때문에
                sum2 += i;
            }
        }
        //결과는 for문 밖으로 넣어줘야 함
        System.out.println(num1+"부터 "+num2+"까지의 짝수의 합은 "+(sum1)+"입니다.");
        System.out.println(num1+"부터 "+num2+"까지의 홀수의 합은 "+(sum2)+"입니다.");
    }
}



