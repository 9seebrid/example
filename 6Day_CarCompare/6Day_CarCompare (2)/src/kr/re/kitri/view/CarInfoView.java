package kr.re.kitri.view;

import kr.re.kitri.db.CarInfoVO;

public class CarInfoView {
	
	// Car Name값을 출력하도록 구성하겠음
	public void carNameView(String[] car_name) {
		//String[] car_name = {"라이트 2WD (A/T)","에어 2WD (A/T)","어스 2WD (A/T)","라이트 4WD (A/T)"};
		System.out.println("자동차 배열 값 : " + car_name);
//		System.out.println("1번째 자동차 이름 : " + car_name[0]);
//		System.out.println("2번째 자동차 이름 : " + car_name[1]);
//		System.out.println("3번째 자동차 이름 : " + car_name[2]);
//		System.out.println("4번째 자동차 이름 : " + car_name[3]);
		
		for(int i=0; i<car_name.length; i++) {
			System.out.println(i+1 + "번째 자동차 이름 : " + car_name[i]);
		}
	}	
	// OverLoad
	public void carNameView(CarInfoVO car_name) {
		//String[] car_name = {"라이트 2WD (A/T)","에어 2WD (A/T)","어스 2WD (A/T)","라이트 4WD (A/T)"};
		System.out.println("자동차 배열 값 : " + car_name);
		String[] car_name_array = car_name.car_name;
		long[] car_price_array = car_name.car_price;
		String[] car_fuel_array = car_name.car_fuel_type;
		String[] car_eco_array = car_name.car_eco_grade;
//		System.out.println("1번째 자동차 이름 : " + car_name[0]);
//		System.out.println("2번째 자동차 이름 : " + car_name[1]);
//		System.out.println("3번째 자동차 이름 : " + car_name[2]);
//		System.out.println("4번째 자동차 이름 : " + car_name[3]);
		
		for(int i=0; i<car_name_array.length; i++) {
			System.out.print(i+1 + "번째 자동차 이름 : " + car_name_array[i] + "\t");
		}
		System.out.println("");
		for(int i=0; i<car_price_array.length; i++) {
			System.out.print(i+1 + "번째 자동차 가격 : " + car_price_array[i] + "\t");
		}
		System.out.println("");
		for(int i=0; i<car_fuel_array.length; i++) {
			System.out.print(i+1 + "번째 자동차 연료 : " + car_fuel_array[i] + "\t");
		}
		System.out.println("");
		for(int i=0; i<car_eco_array.length; i++) {
			System.out.print(i+1 + "번째 자동차 친환경등급 : " + car_eco_array[i] + "\t");
		}
	}	

}








