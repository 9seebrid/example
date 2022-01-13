package kr.co.bskoo.view;

public class MenuView3 implements MenuViewIF {
    public void menuView(){
        System.out.println("MenuView3입니다.");
        test();
    }

    @Override
    public String menuSet() {
        return null;
    }

    public void test(){
        System.out.println("asdnklsadnjkasdkjnasjnkdsadknj");
    }


    @Override
    public void instanceSetting() {

    }
}
