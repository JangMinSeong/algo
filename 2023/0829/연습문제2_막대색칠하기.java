package w0829;

public class 연습문제2_막대색칠하기 {
	public static void main(String[] args) {
		System.out.println(f(6));
	}
	
	public static int f(int n) {
		if( n == 1) return 2;
		if( n == 2) return 5;
		return f(n-2) + (f(n-1) * 2);
	}
}
