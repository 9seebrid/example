package kr.co.bskoo.view;

public class MenuView implements MenuViewIF, GetList{ //인터페이스를 선언하는 법
    public void menuView(){
        System.out.println("메인 메뉴 출력");
        System.out.println("1. 학사관리 2. 학생 관리 3. 사업비 관리 4. 종료");
    }

    @Override
    public String menuSet() {
        return null;
    }

    @Override
    public void instanceSetting() {

    }
}
