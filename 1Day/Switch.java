public class Switch {
    public static void main(String[] args) {
        int a= 1;
        switch (a){
            case 1:
                System.out.println("현재 a의 값은 1 입니다");
                break;
            case 2:
                System.out.println("현재 a의 값은 2 입니다");
            case 3:
                System.out.println("현재 a의 값은 3 입니다");
            default:
                System.out.println("기타 값을 입력하였습니다");
        }//switch문 종료
    }//main 메소드 종료
} //Class 종료
