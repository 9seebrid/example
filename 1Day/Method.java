import java.util.Scanner;
import java.io.IOException;

public class Method { //Main Method 선언하여 실행할 수 있도록 한다
    static double num1;
    static double num2;
    static double num3;
    static double num4;

    //public static void main(String[] args) {}
    public static void main(String[] args) throws IOException {
        // 반복문
        //그러면 특정 조건이 발생이 된다라고 할 시에 반복문을 종료시킬 수 있도록 작성해보자
        //while문으로 반복을 돌리고 -1을 입력했을 때 종료되도록 설정

        boolean chkpoint = true;
        while (chkpoint) {

            Scanner sc = new Scanner(System.in); // sc에 사용자가 값을 입력

            System.out.println("첫번 째 수를 입력하세요");
            num1 = sc.nextDouble();
            System.out.println("두번째 수를 입력하세요");
            num2 = sc.nextDouble();
            System.out.println("세번째 수를 입력하세요");
            num3 = sc.nextDouble();
            System.out.println("네번째 수를 입력하세요");
            num4 = sc.nextDouble();

            double a_num1 = num1;
            double a_num2 = num2;
            double a_num3 = num3;
            double a_num4 = num4;


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
//                System.out.println(num1 + num2 + num3 + num4);
                usr_add();
            } // 첫번째 조건 if문 종료

            else if (code == 2) {//code == 2 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                System.out.println("2를 선택하여 뺄셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                System.out.println(usr_minus());
            } // 두번째 조건 if문 종료

            else if (code == 3) {//code == 3 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                System.out.println("3을 선택하여 곱셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                System.out.println(num1 * num2 * num3 * num4);
                //usr_muti(double a,double b,double c,double d); a_num1 = double a로 2는 b로 3은 c로 4는 d로 들어간다.
                usr_muti(a_num1,a_num2,a_num3,a_num4);
            } // 세번째 조건 if문 종료

            else if (code == 4) {//code == 4 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                //만약 입력 받은 네가지 값 중에서 0이 있을 경우 다음과 같이 출력하시오.
                // "0은 나눗셈에서 제외됩니다."
                if (num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
                    System.out.println("0은 나눗셈에서 제외 됩니다.");
                } else {
                    System.out.println("4를 선택하여 나눗셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
//                    System.out.println(num1 / num2 / num3 / num4);
//                    System.out.println(usr_divide(a_num1,a_num2,a_num3,a_num4));
                    System.out.println(usr_divide(num1,num2,num3,num4));
                }
            } // 네번째 조건 if문 종료

            else if (code == 5) {//code == 5 조건식이 참이면, true가 발생함 true가 발생하면 if로 묶인 {} < 중괄호 내에 코드가 실행 됨
                System.out.println("5를 선택하여 나머지셈을 수행 합니다. 수행 결과 값은 다음과 같습니다.");
                System.out.println(num1 % num2 % num3 % num4);
            } else if (code == -1) {//code == -1 조건식이 참이면, chkpoint가 false;로 종료
                chkpoint = false;
                System.out.println("종료합니다.");
            } else {
                System.out.println("잘못된 값을 입력했습니다.");
            } // 선택지 값을 입력하지 않고 다른 입력값을 넣었을 때 조건 // 다섯번째 조건 if문 종료


            //종료 연산 처리 지점

        }//while문 종료
    }// main method 종료, 5. 프로그램 종료

    // StartSum4에 만들었던 연산 메소드를 싸그리 다 여기에 넣어 관리하려고 한다
    // 이유는 다른 프로그램에서도 StatSum4Method를 활용해서 연산할 수 있을 가능성을 대비하기 위해서
    // 또한, 기존 StartSum4의 코드가 지저분하기 때문에 분리해서 관리
    // 또, 소스를 분리해서 개발하면, 여러 사람들이 한 소스를 가지고 개발하는 부분에 있어서 용이하기 때문

// 덧셈을 연산하는 연산 메소드를 작성(더한 연산을 해야한다) -> 문장 표현상에서 동사(행동)부분을 구현할 때 사용한다
    // 1. 접근자(향후에 배울 것이니 기본은 public으로 선언) 2.해당 메소드의 리턴(메소드 실행 결과값) 타입
    // 타입 일반적인 원시 데이터 타입, 그 외의 class 타입들도 리턴이 될 수 있음
    // 3. 메소드 명칭(이름을 선언) -> 메소드는 이름에 반드시 소문자로 시작될 수 있도록 구성해야함
    // 4. 매개변수(Parameter) -> ( ) 괄호 안에 들어갈 내용을 집어 넣음. 괄호 안에 들어갈 값은 메소드를 실행할 시에 입력할 수 있는 입력값
    // 함수 또는 메소드는 크게 4가지 방식을 갖고 있다
    // 가. 입력값이 있으면서 출력값이 있음 / 나.입력값은 있지만 출력되는 값은 없음 / 다. 입력값은 없는데 출력값이 있음 / 라. 입력값은 없으면서 출력값도 없음(가장 안쓰기는 함)

    //라. 형식의 메소드
    public void usr_add() { // public (접근자) void (메소드 void는 텅 빈) usr_add (메소드 명칭)
        System.out.println("메소드 add 연산 기능을 수행합니다.");
        //입력받은 4가지 값을 모두 합하여 결과를 출력할 수 있도록 연산을 해야한다
        double sum = num1 + num2 + num3 + num4;
        System.out.println(sum);
//        usr_add(); 여기서 자신을 다시 불러오면 계속 반복되다가 스택오버플로우 현상 나타남
    }

    //다. 형식의 메소드(입력 X, 출력 O)
    public double usr_minus() { // public (접근자) void (메소드 void는 텅 빈) usr_add (메소드 명칭)
        System.out.println("메소드 minus 연산 기능을 수행합니다.");
        double res = num1 - num2 - num3 - num4;

        return res;

    }
    //나. 입력값(Parameter)은 있고, 출력은 없는 형식의 메소드 (은근 많이 사용되는 방식)
    public void usr_muti(double a, double b, double c, double d){
        System.out.println("메소드 multi 연산 기능을 수행합니다.");
        System.out.println(a*b*c*d);
    }

    // 가. 형식의 메소드 (입력 O, 출력 O)
    public double usr_divide(double a, double b, double c, double d){
        System.out.println("메소드 divide 연산 기능을 수행합니다.");
        double test = usr_minus();
        double res = a/b/c/d;
        return res;
        //return = a/b/c/d; 이런 식으로 쓰면 한줄로 가능

    }

} // Class 종료 지점
