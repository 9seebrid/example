package kr.re.kitri.db;

public class DataExample {	
	// [����] ����
	// ����
	// ģȯ��
	public CarInfoVO setDataExample() {
		// ���� �̸�
		String[] car_name = {"����Ʈ 2WD (A/T)","���� 2WD (A/T)","� 2WD (A/T)","����Ʈ 4WD (A/T)"};
		// String[] car_name = String[4];
		// car_name[0] = "����Ʈ 2WD (A/T)";
		// car_name[1] = "���� 2WD (A/T)";
		//.
		// car_name[3] = "����Ʈ 4WD (A/T)";
		// ���� ����
		long[] car_price = {46300000, 47300000, 51550000, 49120000};
		// ����
		String[] car_fuel_type = {"����","����","����","����"};
		// ģȯ�� ���
		String[] car_eco_grade = {"������1��", "������1��", "������1��", "������1��"};
		
		CarInfoVO civ = new CarInfoVO();
		civ.car_name = car_name;
		civ.car_price = car_price;
		civ.car_fuel_type = car_fuel_type;
		civ.car_eco_grade = car_eco_grade;
		
		return civ;
	}
	
	public CarInfoVO2 setData2Example() {
		// ���� �̸�	
		CarInfoVO2 civ2 = new CarInfoVO2();
		
		return civ2;
	}
	
	
	
	
	
	
	
	
	
	

}
