package kr.re.kitri.view;

import kr.re.kitri.db.CarInfoVO;
import kr.re.kitri.db.CarInfoVO2;

public class CarInfoView {

    //Car Name 값을 출력하도록 구성
    public void carNameView(String[] car_name){ //RunMain에서 car_name을 전달 받을 수 있도록 하였음
        System.out.println("자동차 배열 값 : " + car_name);
//        System.out.println("1번째 자동차 이름 : " + car_name[0] );
//        System.out.println("1번째 자동차 이름 : " + car_name[1] );
//        System.out.println("1번째 자동차 이름 : " + car_name[2] );
//        System.out.println("1번째 자동차 이름 : " + car_name[3] );

        for(int i = 0;i<car_name.length;i++){
            System.out.println(i+1+"번째 자동차 이름 : " + car_name[i]);
        }//car_name 배열 for문 종료 지점
    }//CarNameView 메소드 종료 지점


    //Overload
    public void carNameView(CarInfoVO car_name){ //RunMain에서 car_name을 전달 받을 수 있도록 하였음
        System.out.println("자동차 배열 값 : " + car_name);

        String[] car_name_array = car_name.car_name;
        long[] car_price_array = car_name.car_price;
        String[] car_fuel_array = car_name.car_fuel_type;
        String[] car_eco_array = car_name.car_eco_grade;


        for(int i = 0;i<car_name_array.length;i++){
            System.out.print(i+1+"번째 자동차 이름 : " + car_name_array[i] + "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<car_price_array.length;i++){
            System.out.print(i+1+"번째 자동차 가격 : " + car_price_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<car_fuel_array.length;i++){
            System.out.print(i+1+"번째 자동차 연료 : " + car_fuel_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<car_eco_array.length;i++){
            System.out.print(i+1+"번째 자동차 친환경 : " + car_eco_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
    }//carNameView 메소드 종료 지점

    public void carNameView(CarInfoVO2 car_name) { //RunMain에서 car_name을 전달 받을 수 있도록 하였음
        String[] car_bt_type_array = car_name.bt_type;
        double[] car_bt_volt_array = car_name.bt_volt;
        double[] car_bt_vol_array = car_name.bt_vol;
        double[] bt_charge_vol_array = car_name.bt_charge_vol;
        int[] motor_max_power_array = car_name.motor_max_power;
        double[] motor_max_torque_array = car_name.motor_max_torque;

        for(int i = 0;i<car_bt_type_array.length;i++){
            System.out.print(i+1+"번째 자동차 배터리 : " + car_bt_type_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<car_bt_volt_array.length;i++){
            System.out.print(i+1+"번째 자동차 전력 : " + car_bt_volt_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<car_bt_vol_array.length;i++){
            System.out.print(i+1+"번째 자동차 vol : " + car_bt_vol_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<bt_charge_vol_array.length;i++){
            System.out.print(i+1+"번째 자동차 charge : " + bt_charge_vol_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<motor_max_power_array.length;i++){
            System.out.print(i+1+"번째 자동차 최대 출력 : " + motor_max_power_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
        for(int i = 0;i<motor_max_torque_array.length;i++){
            System.out.print(i+1+"번째 자동차 최대 토크 : " + motor_max_torque_array[i]+ "  " );
        }//car_name 배열 for문 종료 지점
        System.out.println("");
    }

} // CarInfoView 클래스 종료 지점


//package kr.re.kitri.view;
//
//public class CarInfoView {
//
//    //Car Name 값을 출력하도록 구성
//    public void carNameView(String[] car_name){ //RunMain에서 car_name을 전달 받을 수 있도록 하였음
////        System.out.println("자동차 배열 값 : " + car_name);
////        System.out.println("1번째 자동차 이름 : " + car_name[0] );
////        System.out.println("1번째 자동차 이름 : " + car_name[1] );
////        System.out.println("1번째 자동차 이름 : " + car_name[2] );
////        System.out.println("1번째 자동차 이름 : " + car_name[3] );
//
//        for(int i = 0;i<car_name.length;i++){
//            System.out.println(i+1+"번째 자동차 이름 : " + car_name[i]);
//        }//car_name 배열 for문 종료 지점
//    }//carNameView 메소드 종료 지점
//} // CarInfoView 클래스 종료 지점