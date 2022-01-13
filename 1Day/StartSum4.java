import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class StartSum4 {
    static double f_val;
    static double s_val;
    static double t_val;
    static double fourth_val;

    public static void main(String[] args) throws IOException {
        // 반복문
        // 그러면 특정 조건이 발생이 된다라고 할 시에 해당 반복문을 종료시킬 수 있도록
        // 작성해보자
        //
        boolean chk = true;
        while(chk) {
            // a = 0; // 계속 실행 조건
            // a = 1; // 계속 실행 조건
            // a = 2; // 실행 중단
            Scanner sc = new Scanner(System.in);
            System.out.println("1번째 값을 입력하시기 바랍니다.");
            f_val = sc.nextDouble();
            System.out.println("2번째 값을 입력하시기 바랍니다.");
            s_val = sc.nextDouble();
            System.out.println("3번째 값을 입력하시기 바랍니다.");
            t_val = sc.nextDouble();
            System.out.println("4번째 값을 입력하시기 바랍니다.");
            fourth_val = sc.nextDouble();

            double res = usr_minus();

            System.out.println("계산 결과 값입니다.");
            System.out.print("덧셈 : ");
            usr_add();
//			System.out.println(f_val + s_val + t_val + fourth_val);
            System.out.print("뺄셈 : ");
            System.out.println(res);
            System.out.print("곱셈 : ");
            System.out.println(f_val * s_val * t_val * fourth_val);
            System.out.print("나눗셈 : ");
            System.out.println(f_val / s_val / t_val / fourth_val);
            System.out.print("나머지 값 셈 : ");
            System.out.println(f_val % s_val % t_val % fourth_val);

            // 4가지 값을 입력 받아서 처리할 수 있도록 구성을 했습니다.
            // 그러면 숫자 입력을 4가지를 받은 이 후, 계산할 연산 방식을 선택해서 해당 내용의 결과가 출력될 수 있도록 하겠습니다.
            // 5번째 입력값을 다음과 같이 받을 수 있도록 하시기 바랍니다.
            // (1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 값 셈)
            System.out.println("다음 연산 방식을 번호로 선택해 주시기 바랍니다.");
            System.out.println("1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈, 5. 나머지 값 셈, -1. 계산기 종료");
            int code = sc.nextInt();
            // code = 1; "=" 을 하나만 쓰면 산술 연산(대입연산), "==" 같다라는 논리연산
            // 조건 비교연산 시작
            // 1번째 조건. 1을 입력했을 시
            // boolean test = true;
            if (code == 1) {// code == 1 조건식이 참이면, true가 발생함. true 발생하면 if로 묶인 { }(중괄호) 내에 코드가 실행됨
                System.out.println("1을 선택하여 덧셈 연산을 수행합니다. 수행 결과값은 다음과 같습니다.");
//				System.out.println(f_val + s_val + t_val + fourth_val);
                usr_add();
            } // 1번째 조건 if문 종료

            else if (code == 2) {// code == 2 조건식이 참이면, true가 발생함. true 발생하면 if로 묶인 { }(중괄호) 내에 코드가 실행됨
                System.out.println("2를 선택하여 뺄셈 연산을 수행합니다. 수행 결과값은 다음과 같습니다.");
                System.out.println(usr_minus() - 1);
            } // 2번째 조건 if문 종료

            else if (code == 3) {// code == 2 조건식이 참이면, true가 발생함. true 발생하면 if로 묶인 { }(중괄호) 내에 코드가 실행됨
                System.out.println("3를 선택하여 곱셈 연산을 수행합니다. 수행 결과값은 다음과 같습니다.");
                System.out.println(f_val * s_val * t_val * fourth_val);
            } // 2번째 조건 if문 종료

            else if (code == 4) {// code == 2 조건식이 참이면, true가 발생함. true 발생하면 if로 묶인 { }(중괄호) 내에 코드가 실행됨
                // 만약, 입력받은 4가지 값중에서 0이 있으면 다음과 같이 출력하시오.
                if (f_val == 0 || s_val == 0 || t_val == 0 || fourth_val == 0) {
                    System.out.println("0은 나눗셈에서 제외됩니다.");
                } // "0은 나눗셈에서 제외됩니다."
                else {
                    System.out.println("4를 선택하여 나눗셈 연산을 수행합니다. 수행 결과값은 다음과 같습니다.");
                    System.out.println(f_val / s_val / t_val / fourth_val);
                }
            } // 2번째 조건 if문 종료

            else if (code == 5) {// code == 2 조건식이 참이면, true가 발생함. true 발생하면 if로 묶인 { }(중괄호) 내에 코드가 실행됨
                System.out.println("5를 선택하여 나머지셈 연산을 수행합니다. 수행 결과값은 다음과 같습니다.");
                System.out.println(f_val % s_val % t_val % fourth_val);
            } // 2번째 조건 if문 종료
            else if (code == -1) {
                System.out.println("종료버튼을 누르셨습니다.");
                chk = false;
            } else {
                System.out.println("잘못된 값을 입력하셨습니다.");
            }


        } // for문 종료

    } // main method 종료; 5. 프로그램 종료

    // 덧셈을 연산하는 연산 메소드를 작성하겠다.(더한 연산을 해야한다.!!!) -> 문장 표현상에서 동사(행동)하는 부분을 구현할 때 사용한다.
    // 1. 접근자(향 후에 알려드릴 것이니 기본은 public으로 하십시오.) 2. 해당 메소드의 리턴(메소드 실행 결과값) 타입
    // 타입 일반적인 원시 데이터 타입, 그 외의 class 타입들도 리턴이 될 수 있음.
    // 3. 메소드 명칭(이름을 선언) -> 메소드는 이름에 반드시 소문자로 시작될 수 있도록 구성해야함
    // 4. 매개변수(Parameter) -> (   ) 요 안에 들어갈 내용을 집어넣음, 괄호안에 들어갈 값은 메소드를 실행할 시에 입력할 수 있는 입력값
    // 함수 또는 메소드는 크게 4가지 방식을 갖고 있음
    // 가. 입력값이 있으면서, 출력되는 값이 있음, 나. 입력값은 있는데, 출력되는 값은 없음, 다. 입력값은 없는데, 출력 값은 있음.
    // 라. 입력값은 없으면서도, 출력값도 없다.

    //라 형식의 메소드
    public static void usr_add() {
        //System.out.println("메소드 add(덧셈) 연산 기능을 수행합니다.");
        // 입력받은 4가지 값을 모두 합하여 결과를 출력할 수 있도록 연산을 해야 한다.
        double sum = f_val + s_val + t_val + fourth_val;
        System.out.println(sum);
    }

    // 다 형식의 메소드(입력 X, 출력 O)
    public static double usr_minus() {
        double res = f_val - s_val - t_val - fourth_val;

        return res;
    }





} // Class 종료 지점
