public class StartSum4Method {

    double a_1;
    double a_2;
    double a_3;
    double a_4;

    StartSum4Method(){

    }

    StartSum4Method(double a, double b, double c, double d){
        a_1 = a;
        a_2 = b;
        a_3 = c;
        a_4 = d;

    }

    //public int TEST = 0;
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
    public void usr_add(double a, double b, double c, double d) { // public (접근자) void (메소드 void는 텅 빈) usr_add (메소드 명칭)
        System.out.println("메소드 add 연산 기능을 수행합니다.");
        //입력받은 4가지 값을 모두 합하여 결과를 출력할 수 있도록 연산을 해야한다
        double sum = a + b + c + d;
        System.out.println(sum);
//        usr_add(); 여기서 자신을 다시 불러오면 계속 반복되다가 스택오버플로우 현상 나타남
    }

    //다. 형식의 메소드(입력 X, 출력 O)
    public void usr_minus(double a, double b, double c, double d) { // public (접근자) void (메소드 void는 텅 빈) usr_add (메소드 명칭)
        System.out.println("메소드 minus 연산 기능을 수행합니다.");
        double res = a - b - c - d;
//        return res = a - b - c - d;
        System.out.println(res);

    }
    //나. 입력값(Parameter)은 있고, 출력은 없는 형식의 메소드 (은근 많이 사용되는 방식)
    public void usr_muti(double a, double b, double c, double d){
        System.out.println("메소드 multi 연산 기능을 수행합니다.");
        System.out.println(a*b*c*d);
    }

    // 가. 형식의 메소드 (입력 O, 출력 O)
    public void usr_divide(double a, double b, double c, double d){
        System.out.println("메소드 divide 연산 기능을 수행합니다.");
//        double test = usr_minus();
        double res = a/b/c/d;
//        return res;
        System.out.println(res);
        //return = a/b/c/d; 이런 식으로 쓰면 한줄로 가능

    }

    public void usr_mod(){
        System.out.println(a_1%a_2%a_3%a_4);
    }

}
