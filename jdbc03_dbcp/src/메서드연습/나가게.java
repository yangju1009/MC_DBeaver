package 메서드연습;

public class 나가게 {

	public static void main(String[] args) {
		int coffeePrice = 5000;
		int coffeeCount = 15;

		// 커피계산가격이 5만원이상이면
		// 5000원을 할인해주려한다.

		계산기 cal = new 계산기();
		int result = cal.mul(coffeePrice, coffeeCount);
		if (result >= 50000) {
			System.out.println("최종 계산금액은 " + (result - 5000));
		} else {
			System.out.println("최종 계산금액은 " + result);
		}

		// 1. array호출
		int[] arr = cal.array(); // int[]
		System.out.println(arr[0] + 100);

		// 2. get2호출
		MemberVO result2 = cal.get2("win", "1234", "win2", "010");
		result2.setPw("1111");
		System.out.println(result2);
		
		// 3. get4 호출
		String result3 = cal.get4("홍길동", 100);
		System.out.println(result3 + "세 입니다. 환영해주세요");

	}

}
