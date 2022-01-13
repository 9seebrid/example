package kr.re.kitri.db;

public class DataExample {

	// [제원] 엔진
	// 연료
	// 친환경
	public CarInfoVO setDataExample() {
		// 차량 이름
		String[] car_name = {"라이트 2WD (A/T)","에어 2WD (A/T)","어스 2WD (A/T)","라이트 4WD (A/T)"};
		// Sting[] car_name = Sting[4]; 와 같은 상태
		// car_name[0] = "라이트 2WD (A/T)";
		// car_name[1] = "에어 2WD (A/T)";
		// car_name[2] = "어스 2WD (A/T)";
		// car_name[3] = "라이트 4WD (A/T)";
		// 차량 가격
		long[] car_price = {46300000, 47300000, 51550000, 49120000}; // 일반 배열에서는 long 타입이 다르기 때문에 배열을 사용할 수 없다
		// 연료
		String[] car_fuel_type = {"전기","전기","전기","전기"};
		// 친환경 등급
		String[] car_eco_grade = {"저공해1종", "저공해1종", "저공해1종", "저공해1종"};
		String[] bt_type = {"리튬 이온 폴리머","리튬 이온 폴리머","리튬 이온 폴리머","리튬 이온 폴리머"};
		double[] bt_volt = {522.7, 522.7, 522.7, 522.7};
		double[] bt_vol = {111.2, 111.2,111.2,111.2};
		double[] bt_charge_vol = {58.0,58.0,58.0,58.0};
		int[] motor_max_power = {170,170,170,235};
		double[] motor_max_torque = {35.7, 35.7, 35,7, 61.7};

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

		// return car_name[0],car_name[1],car_name[2],car_name[3]; 이런식으로 리턴이 안됨;


}
