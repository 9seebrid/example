package ke.co.bskoo.parents;

public class FatherClass extends GrandFatherClass { //final이 붙으면 자신이 마지막 상속자다 되겠다 그 밑으로는 상속을 안해줌
    public static void main(String[] args) {
        System.out.println("학사관리 시스템 클래스 동작");
        printMenu();
        System.out.println(school + "1번 지역 지점");
        //System.out.println(tel_num); 부모객체에서 private라 사용할 수 없음
        System.out.println(fax);
    }

    public static void test(){
        System.out.println("아빠 테스트 아ㅡ나으나으ㅏㅏ");
    }

}
