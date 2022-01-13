package kr.co.bskoo.run;

import kr.co.bskoo.vo.CarInfiVO;

public class test {
    public static void main(String[] args) {
        CarInfiVO civ = null;
        Exercise09 ex9 = null;

        Object civ_o = new CarInfiVO();
        Object ex9_o = new CarInfiVO[4];

        ex9_o = ex9_o[0];
        System.out.println(ex9_o[1]);



    }
}
