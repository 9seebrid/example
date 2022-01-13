package kr.re.kitri.view;

import java.util.Scanner;

public class MenuView {
	// 차량비교 프로그램의 메뉴를 출력하고 관리해주는 역할 수행
	
	// Main 메뉴가 출력될 수 있도록 구성해 줌
	public void mainMenu() {
		System.out.println("차량정보 비교 서비스 프로그램에 오신것을 환영합니다.");
		System.out.println("원하는 메뉴번호를 입력해 주세요.");
		System.out.println("1. 전체 등록 차량 정보 조회");
		System.out.println("0. 프로그램 종료");
	}
	
	// 사용자한테 값을 입력 받을 수 있도록 하기
	public String user_input() {
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		return result;
	}

}
