package kr.re.kitri.run;

import kr.re.kitri.view.MenuView;

public class RunMain {
	// �ڵ��� �� �˻� ���α׷� ���� Ŭ����
	public static void main(String[] args) {
		MenuView mv = new MenuView();
		boolean mm_chk = true;

		while (mm_chk) {
			// Main Menu ����ϱ�
			mv.mainMenu();
			// �޴� ���� �� �Է¹ޱ�
			String mainMenuCode = mv.user_input();
			if(mainMenuCode.equals("0")) {
				// ���α׷� ���� ��Ű��
				// while (true -> false) ������ ��.
				mm_chk = false;				
			} // ���θ޴� "0" ������ �� ���� ���� 
			else if(mainMenuCode.equals("1")) {
				// 1. ��ü ��� ���� ���� ��ȸ ��� �����ϱ�
				
			}
			
		} // ���θ޴� while ���� ����

	} // main �޼ҵ� ���� ����

} // RunMain Ŭ���� ���� ����
