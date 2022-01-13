package kr.co.bskoo.view;

public interface MenuViewIF extends GetList{

    int a = 0;

    public abstract void menuView(); //클래스는 내부에 구현을 시킬 수 있지만 인터페이스는 구현을 하지 못한다
    //이름만 선언해 놓은 상태
    public String menuSet();


}
