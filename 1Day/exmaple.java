import java.util.Scanner;

public class exmaple {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1;i<=100;i++){
            if(i % 3 == 0){
                sum = sum + i;
            }//if문 종료
        } // for문 종료
        System.out.println("3의 배수의 합:" + sum);

        //while과 Scanner 이용하여 예금, 출금, 조회, 종료 기능 제공

        boolean run = true;

        int balance = 0; //전역변수

        Scanner scanner = new Scanner(System.in);

        while(run){
            System.out.println("----------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------");
            System.out.print("선택> ");

            int code = scanner.nextInt();

            if(code == 1){
                //예금액을 입력 받을 수 있도록 구성
                //예금액 저장할 수 있도록 변수 구성
                System.out.print("예금액 입력 ");
                int deposit = scanner.nextInt(); // 지역변수
                balance = balance + deposit;
                System.out.println(deposit + "원이 입금 되었습니다");
            }else if(code == 2){
                //출금액을 입력 받을 수 있도록 구성
                //출금액 저장할 수 있도록 변수 구성
                System.out.print("출금액 입력 ");
                int withdraw = scanner.nextInt();
                //입력한 출금액을 잔액에서 빼는 연산을 실행 시켜라
                //단, 잔액보다 많은 금액을 뺄 수 없음
                //잔액이 출금 금액보다 낮은 경우 => 뺄 수 없는 상황(경고장 날려야함)
                if(balance < withdraw){
                    System.out.print("잔액이 부족합니다.");
                    System.out.println("현재 잔액은 " + balance + "원 입니다");
                }else{
                    //잔액이 출금액 보다 많아 출금 처리 진행
                    balance = balance - withdraw;
                    System.out.println(withdraw +"원이 출금 되었습니다");
                }

            }else if(code == 3){
                //잔액을 입력 받을 수 있도록 구성
                //잔액 저장할 수 있도록 변수 구성
                System.out.print("현재 잔액 정보");
                System.out.println(balance);
                System.out.println("현재 잔액은 " + balance + "원 입니다");
            }else if(code == 4){
                run = false;
                System.out.println("프로그램 종료");
            }else{
                //그 외 번호 입력시 오류 출력
                System.out.println("잘못된 번호를 입력하셨습니다");
            }


        }//while문 종료


    } //main 메소드 종료
} //Class종료
