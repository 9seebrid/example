package kr.co.bskoo.view;

public class MenuViewTest implements MenuViewIF{
    @Override //어노테이션 annotation
    public void menuView() {
        System.out.println("테스트 메뉴 입니다.");
    }

    @Override
    public String menuSet() {
        return null;
    }

    @Override
    public void instanceSetting() {

    }
}

