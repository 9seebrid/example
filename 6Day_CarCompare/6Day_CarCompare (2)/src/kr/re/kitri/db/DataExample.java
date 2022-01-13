package kr.re.kitri.db;

public class DataExample {	
	// [제원] 엔진
	// 연료
	// 친환경
	public CarInfoVO setDataExample() {
		// 차량 이름
		String[] car_name = {"라이트 2WD (A/T)","에어 2WD (A/T)","어스 2WD (A/T)","라이트 4WD (A/T)"};
		// String[] car_name = String[4];
		// car_name[0] = "라이트 2WD (A/T)";
		// car_name[1] = "에어 2WD (A/T)";
		//.
		// car_name[3] = "라이트 4WD (A/T)";
		// 차량 가격
		long[] car_price = {46300000, 47300000, 51550000, 49120000};
		// 연료
		String[] car_fuel_type = {"전기","전기","전기","전기"};
		// 친환경 등급
		String[] car_eco_grade = {"저공해1종", "정공해1종", "저공해1종", "저공해1종"};
		
		CarInfoVO civ = new CarInfoVO();
		civ.car_name = car_name;
		civ.car_price = car_price;
		civ.car_fuel_type = car_fuel_type;
		civ.car_eco_grade = car_eco_grade;
		
		return civ;
	}
	
	public CarInfoVO2 setData2Example() {
		// 차량 이름	
		CarInfoVO2 civ2 = new CarInfoVO2();
		
		return civ2;
	}
	
	
	
	
	
	
	
	
	
	

}
