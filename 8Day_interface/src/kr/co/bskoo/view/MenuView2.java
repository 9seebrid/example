package kr.co.bskoo.view;

public class MenuView2 implements MenuViewIF {
    public void menuView(){
        System.out.println("메인 메뉴 출력");
        System.out.println("여기는 메인 메뉴2번 입니다.");
    }

    @Override
    public String menuSet() {
        return null;
    }

    @Override
    public void instanceSetting() {

    }
}
