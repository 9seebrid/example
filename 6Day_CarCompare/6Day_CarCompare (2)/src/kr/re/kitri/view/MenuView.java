package kr.re.kitri.view;

import java.util.Scanner;

public class MenuView {
	// ������ ���α׷��� �޴��� ����ϰ� �������ִ� ���� ����
	
	// Main �޴��� ��µ� �� �ֵ��� ������ ��
	public void mainMenu() {
		System.out.println("�������� �� ���� ���α׷��� ���Ű��� ȯ���մϴ�.");
		System.out.println("���ϴ� �޴���ȣ�� �Է��� �ּ���.");
		System.out.println("1. ��ü ��� ���� ���� ��ȸ");
		System.out.println("0. ���α׷� ����");
	}
	
	// ��������� ���� �Է� ���� �� �ֵ��� �ϱ�
	public String user_input() {
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		return result;
	}

}
