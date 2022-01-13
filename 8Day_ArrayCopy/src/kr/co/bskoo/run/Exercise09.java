package kr.co.bskoo.run;

import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);

        while(run){
            System.out.println("--------------------------------------------------");
            System.out.println("1. 학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------------------");
            if(scores == null){
                System.out.println("현재 학생 수 설정이 되어있지 않기 때문에 학생 수를 먼저 입력하셔야 합니다.");
            }else {
                System.out.println("현재 등록할 수 있는 학생 수 공간은 "+scores.length+" 칸 입니다.");
            }
            System.out.print("선택 > ");

            int selectNo = scanner.nextInt();

            if(selectNo == 1){
                System.out.println("학생 수 입력");
                studentNum = scanner.nextInt(); //학생수를 입력 받는 부분
                if(studentNum <= 0 )//입력 공간 수를 잘못 할당시킬 경우 0~-n
                    {
                        System.out.println("학생 수는 적어도 1명 이상을 할당 시켜야 합니다.");
                    }else{
                    scores = new int[studentNum]; //입력받은 학생 수 만큼 배열 생성
                    }
                }

            else if(selectNo == 2){
                if(scores == null){ // 만약 1번 학생수가 입력되지 않았을 경우 다시 처음으로 돌아가도록 설정
                    System.out.println("학생 수가 입력되지 않았습니다.");
                }else{ // 1번 학생수가 입력되어 배열이 생성되었을 시 점수 입력 실행
                System.out.println("점수 입력");
                for(int i=0;i<scores.length;i++) {
                    System.out.println(i + 1 + "번째 학생 점수 입력");
                    scores[i] = scanner.nextInt();
                    }// 배열에 점수 넣는 for문 종료
                }// 배열이 생성 되었을 시 점수 넣는 else문 종료
            }// 2번 점수 입력에 대한 if문 종료

            else if(selectNo == 3){
                if(scores == null){
                    System.out.println("학생 수가 입력되지 않았습니다.");
                }else{
                for(int i=0;i<scores.length;i++) {
                    System.out.println(i + 1 + "번째 학생 점수 : " + scores[i]);
                    }
                }
            }
            else if(selectNo == 4){
                if(scores == null){
                    System.out.println("학생 수가 입력되지 않았습니다.");
                }else{
                int max = 0;
                double avg = 0;
                for(int i=0;i<scores.length;i++){
                    if(scores[i]>max) { // max에 있는 값보다 배열에 저장된 정수 값이 크게 되면 max값을 갱신
                        max = scores[i];
                        }
                    avg += scores[i];
                    }
                    System.out.println("최고 점수 : " + max);
                    System.out.println("평균 점수 : " + avg / scores.length);
                }

            }
            else if(selectNo == 5){
                run = false;
            }else{
                System.out.println("잘못된 번호를 입력했습니다");
            }
        } //while문 종료
        System.out.println("프로그램 종료");
    }// main 메소드 종료
}// Class 종료
