package w0731;

import java.util.Scanner;

public class Main_BJ_17478_����Լ��������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		f(num,"");
		
	}
	public static void f(int num, String str) {
		System.out.println(str + "\"����Լ��� ������?\"");
		if(num == 0) {
			System.out.println(str + "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(str + "��� �亯�Ͽ���.");
			return;
		}
		System.out.print(str + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n" + 
				str + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n" + 
				str + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		f(num-1, str + "____");
		System.out.println(str + "��� �亯�Ͽ���.");
	}
}
