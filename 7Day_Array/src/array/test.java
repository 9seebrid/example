package array;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {


        // 필요 변수 선언
        Scanner sc = new Scanner(System.in);
        int num;
        String[] name;
        String[] price;


        // 입력받은 수 만큼 배열 선언
        name = new String[num];
        price = new String[num];

        // 배열 채우기
        for(int i=0;i<num;i++) {
            System.out.printf("이름 : ", (i+1));
            name[i] = sc.next();
        }
        for(int i=0;i<num;i++) {
            System.out.printf("가격 : ", (i+1));
            price[i] = sc.next();
        }

        // 출력하기
        System.out.println();
        System.out.println("---------------------------------");
        System.out.printf("전체 수 : %d명\n", num);
        System.out.println("---------------------------------");
        System.out.println("이름 \t 가격");
        for(int i=0;i<num;i++){
            System.out.println(name[i]+" "+price[i]);
        }
        System.out.println("---------------------------------");

    }

}
