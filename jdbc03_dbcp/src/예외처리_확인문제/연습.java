package 예외처리_확인문제;

public class 연습 {
	public static void main(String[] args) {
		// 1.
		String account = "01-123-456";

		// 2.
		int balance = 0;

		// 3.
		int deposit = 0;

		// 4.
		int widthdraw = 0;

		// 5.
		double rate = 3.3;

		// 6.
		double interest = 0.0;

		//7.
		deposit = 500000;
		//8.
		balance +=deposit;
		//9.
		widthdraw=200000;
		balance-=widthdraw;
		interest=balance*rate;
		System.out.println(balance);
		
	}
	
}
