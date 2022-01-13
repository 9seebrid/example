import java.util.Scanner;
import java.io.IOException;

public class StartSum {
    //Main Method 선언하여 실행할 수 있도록 한다

    //public static void main(String[] args) {}
    public static void main(String[] args) throws IOException {
        // 반복문
        //그러면 특정 조건이 발생이 된다라고 할 시에 반복문을 종료시킬 수 있도록 작성해보자
        //while문으로 반복을 돌리고 -1을 입력했을 때 종료되도록 설정

        boolean chkpoint = true;
        while (chkpoint) {

                Scanner sc = new Scanner(System.in); // sc에 사용자가 값을 입력

                System.out.println("첫번 째 수를 입력하세요");
                double num1 = sc.nextDouble();
                System.out.println("두번째 수를 입력하세요");
                double num2 = sc.nextDouble();
                System.out.println("세번째 수를 입력하세요");
                double num3 = sc.nextDouble();
                System.out.println("네번째 수를 입력하세요");
                double num4 = sc.nextDouble();

                System.out.println("첫번 째 값은 : " + num1);
                System.out.println("두번 째 값은 : " + num2);
                System.out.println("세번 째 값은 : " + num3);
                System.out.println("네번 째 값은 : " + num4);

                double c = num1 + num2 + num3 + num4; // 덧셈
                double d = num1 - num2 - num3 - num4; // 뺄셈
                double e = num1 * num2 * num3 * num4; // 곱셈
                double f = num1 / num2 / num3 / num4; // 나눗셈
                double g = num1 % num2 % num3 % num4; // 나머지

                //각각의 값을 출력
                System.out.println(c);
                System.out.println(d);
                System.out.println(e);
                System.out.println(f);
                System.out.println(g);
                System.out.println(Double.toString(c) + "," + Double.toString(d) + "," + Double.toString(e) + "," + Double.toString(f) + "," + Double.toString(g));

                // 4가지 값을 입력 받아서 처리할 수 있도록 구성하였다
                // 그러면 숫자 입력을 4가지를 받은 이 후 계산할 연산 방식을 선택해서 해당 내용에 결과가 출력될 수 있도록 처리하라
                // 5번째 입력 값을 다음과 같이 받을 수 있도록 하시오
                // (1. 덧셈, 2.뺄셈, 3.곱셈, 4.나눗셈 5. 나머지 값 셈)

                System.out.println("다음 연산 방식을 번호로 선택하여 주시기 바랍니다.");
                System.out.println("1. 덧셈, 2.뺄셈, 3.곱셈, 4.나눗셈 5. 나머지 값 셈, -1. 종료");
                int code = sc.nextInt();
                // 첫번째 조건 1을 입력했을 시
                // code = 1; "=" 을 하나만 쓰면 산술 연산(대입연산), "==" 두개는 같다라는 논리연산
                //boolean test = true;
                if (code == 1) {//code == 1 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                    System.out.println("1을 선택하여 덧셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                    System.out.println(num1 + num2 + num3 + num4);
                    usr_add();
                } // 첫번째 조건 if문 종료

                else if (code == 2) {//code == 2 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                    System.out.println("2를 선택하여 뺄셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                    System.out.println(num1 - num2 - num3 - num4);
                } // 두번째 조건 if문 종료

                else if (code == 3) {//code == 3 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                    System.out.println("3을 선택하여 곱셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                    System.out.println(num1 * num2 * num3 * num4);
                } // 세번째 조건 if문 종료

                else if (code == 4) {//code == 4 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                    //만약 입력 받은 네가지 값 중에서 0이 있을 경우 다음과 같이 출력하시오.
                    // "0은 나눗셈에서 제외됩니다."
                    if (num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
                        System.out.println("0은 나눗셈에서 제외 됩니다.");
                    } else {
                        System.out.println("4를 선택하여 나눗셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                        System.out.println(num1 / num2 / num3 / num4);
                    }
                } // 네번째 조건 if문 종료

                else if (code == 5) {//code == 5 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                    System.out.println("5를 선택하여 나머지셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                    System.out.println(num1 % num2 % num3 % num4);
                }

                else if (code == -1) {//code == -1 조건식이 참이면, chkpoint가 false;로 종료
                    chkpoint = false;
                    System.out.println("종료합니다.");
                }else {
                    System.out.println("잘못된 값을 입력했습니다.");
                } // 선택지 값을 입력하지 않고 다른 입력값을 넣었을 때 조건 // 다섯번째 조건 if문 종료


            //종료 연산 처리 지점

        }//while문 종료
    }// main method 종료, 5. 프로그램 종료

} // Class 종료 지점



//
//import java.util.Scanner;
//        import java.io.IOException;
//
//public class StartSum4 {
//    //Main Method 선언하여 실행할 수 있도록 한다
//    //public static void main(String[] args) {}
//    public static void main(String[] args) throws IOException {
//        // 반복문
//        //그러면 특정 조건이 발생이 된다라고 할 시에 반복문을 종료시킬 수 있도록 작성해보자
//        //
//
//        for (; ; ) {
//            Scanner sc = new Scanner(System.in); // sc에 사용자가 값을 입력
//
//            System.out.println("첫번 째 수를 입력하세요");
//            double num1 = sc.nextDouble();
//            System.out.println("두번째 수를 입력하세요");
//            double num2 = sc.nextDouble();
//            System.out.println("세번째 수를 입력하세요");
//            double num3 = sc.nextDouble();
//            System.out.println("네번째 수를 입력하세요");
//            double num4 = sc.nextDouble();
//
//            System.out.println("첫번 째 값은 : " + num1);
//            System.out.println("두번 째 값은 : " + num2);
//            System.out.println("세번 째 값은 : " + num3);
//            System.out.println("네번 째 값은 : " + num4);
//
//            double i_a = num1;
//            double i_b = num2;
//            double i_c = num3;
//            double i_d = num4;
//
//            double c = i_a + i_b + i_c + i_d; // 덧셈
//            double d = i_a - i_b - i_c - i_d; // 뺄셈
//            double e = i_a * i_b * i_c * i_d; // 곱셈
//            double f = i_a / i_b / i_c / i_d; // 나눗셈
//            double g = i_a % i_b % i_c % i_d; // 나머지
//            //각각의 값을 출력
//            System.out.println(c);
//            System.out.println(d);
//            System.out.println(e);
//            System.out.println(f);
//            System.out.println(g);
//            System.out.println(Double.toString(c) + "," + Double.toString(d) + "," + Double.toString(e) + "," + Double.toString(f) + "," + Double.toString(g));
//
//            // 4가지 값을 입력 받아서 처리할 수 있도록 구성하였다
//            // 그러면 숫자 입력을 4가지를 받은 이 후 계산할 연산 방식을 선택해서 해당 내용에 결과가 출력될 수 있도록 처리하라
//            // 5번째 입력 값을 다음과 같이 받을 수 있도록 하시오
//            // (1. 덧셈, 2.뺄셈, 3.곱셈, 4.나눗셈 5. 나머지 값 셈)
//
//            System.out.println("다음 연산 방식을 번호로 선택하여 주시기 바랍니다.");
//            System.out.println("1. 덧셈, 2.뺄셈, 3.곱셈, 4.나눗셈 5. 나머지 값 셈, -1. 종료");
//            int code = sc.nextInt();
//            // 첫번째 조건 1을 입력했을 시
//            // code = 1; "=" 을 하나만 쓰면 산술 연산(대입연산), "==" 두개는 같다라는 논리연산
//            //boolean test = true;
//            if (code == 1) {//code == 1 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
//                System.out.println("1을 선택하여 덧셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                System.out.println(num1 + num2 + num3 + num4);
//            } // 첫번째 조건 if문 종료
//
//            else if (code == 2) {//code == 2 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
//                System.out.println("2를 선택하여 뺄셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                System.out.println(num1 - num2 - num3 - num4);
//            } // 두번째 조건 if문 종료
//
//            else if (code == 3) {//code == 3 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
//                System.out.println("3을 선택하여 곱셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                System.out.println(num1 * num2 * num3 * num4);
//            } // 세번째 조건 if문 종료
//
//            else if (code == 4) {//code == 4 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
//                //만약 입력 받은 네가지 값 중에서 0이 있을 경우 다음과 같이 출력하시오.
//                // "0은 나눗셈에서 제외됩니다."
//                if (num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
//                    System.out.println("0은 나눗셈에서 제외 됩니다.");
//                } else {
//                    System.out.println("4를 선택하여 나눗셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                    System.out.println(num1 / num2 / num3 / num4);
//                }
//            } // 네번째 조건 if문 종료
//
//            else if (code == 5) {//code == 5 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
//                System.out.println("5를 선택하여 나머지셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                System.out.println(num1 % num2 % num3 % num4);
//            } // 다섯번째 조건 if문 종료
//
//            else if (code == -1) {//code == 5 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
//                System.out.println("종료합니다.");
//
//            } // 다섯번째 조건 if문 종료
//
//            else {
//                System.out.println("잘못된 값을 입력했습니다.");
//            } // 선택지 값을 입력하지 않고 다른 입력값을 넣었을 때 조건
//            if(code == -1 ){
//                break;
//            }
//        }//for문 종료
//    }// main method 종료, 5. 프로그램 종료
//
//
//} // Class 종료 지점
//
