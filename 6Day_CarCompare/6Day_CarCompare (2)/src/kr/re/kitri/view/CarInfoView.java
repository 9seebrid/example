package kr.re.kitri.view;

import kr.re.kitri.db.CarInfoVO;

public class CarInfoView {
	
	// Car Name���� ����ϵ��� �����ϰ���
	public void carNameView(String[] car_name) {
		//String[] car_name = {"����Ʈ 2WD (A/T)","���� 2WD (A/T)","� 2WD (A/T)","����Ʈ 4WD (A/T)"};
		System.out.println("�ڵ��� �迭 �� : " + car_name);
//		System.out.println("1��° �ڵ��� �̸� : " + car_name[0]);
//		System.out.println("2��° �ڵ��� �̸� : " + car_name[1]);
//		System.out.println("3��° �ڵ��� �̸� : " + car_name[2]);
//		System.out.println("4��° �ڵ��� �̸� : " + car_name[3]);
		
		for(int i=0; i<car_name.length; i++) {
			System.out.println(i+1 + "��° �ڵ��� �̸� : " + car_name[i]);
		}
	}	
	// OverLoad
	public void carNameView(CarInfoVO car_name) {
		//String[] car_name = {"����Ʈ 2WD (A/T)","���� 2WD (A/T)","� 2WD (A/T)","����Ʈ 4WD (A/T)"};
		System.out.println("�ڵ��� �迭 �� : " + car_name);
		String[] car_name_array = car_name.car_name;
		long[] car_price_array = car_name.car_price;
		String[] car_fuel_array = car_name.car_fuel_type;
		String[] car_eco_array = car_name.car_eco_grade;
//		System.out.println("1��° �ڵ��� �̸� : " + car_name[0]);
//		System.out.println("2��° �ڵ��� �̸� : " + car_name[1]);
//		System.out.println("3��° �ڵ��� �̸� : " + car_name[2]);
//		System.out.println("4��° �ڵ��� �̸� : " + car_name[3]);
		
		for(int i=0; i<car_name_array.length; i++) {
			System.out.print(i+1 + "��° �ڵ��� �̸� : " + car_name_array[i] + "\t");
		}
		System.out.println("");
		for(int i=0; i<car_price_array.length; i++) {
			System.out.print(i+1 + "��° �ڵ��� ���� : " + car_price_array[i] + "\t");
		}
		System.out.println("");
		for(int i=0; i<car_fuel_array.length; i++) {
			System.out.print(i+1 + "��° �ڵ��� ���� : " + car_fuel_array[i] + "\t");
		}
		System.out.println("");
		for(int i=0; i<car_eco_array.length; i++) {
			System.out.print(i+1 + "��° �ڵ��� ģȯ���� : " + car_eco_array[i] + "\t");
		}
	}	

}








