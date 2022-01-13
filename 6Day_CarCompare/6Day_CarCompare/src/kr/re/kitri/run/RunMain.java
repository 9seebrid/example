package kr.re.kitri.run;

import kr.re.kitri.view.MenuView;

public class RunMain {
	// 자동차 비교 검색 프로그램 구동 클래스
	public static void main(String[] args) {
		MenuView mv = new MenuView();
		boolean mm_chk = true;

		while (mm_chk) {
			// Main Menu 출력하기
			mv.mainMenu();
			// 메뉴 선택 후 입력받기
			String mainMenuCode = mv.user_input();
			if(mainMenuCode.equals("0")) {
				// 프로그램 종료 시키기
				// while (true -> false) 만들어야 함.
				mm_chk = false;				
			} // 메인메뉴 "0" 눌렀을 시 종료 지점 
			else if(mainMenuCode.equals("1")) {
				// 1. 전체 등록 차량 정보 조회 기능 구현하기
				
			}
			
		} // 메인메뉴 while 종료 지점

	} // main 메소드 종료 지점

} // RunMain 클래스 종료 지점
