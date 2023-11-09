package 예외처리;

public class 문제발생클래스2 {

	public static void main(String[] args) {
		System.out.println("1. 나는 실행됨.");

		try {
			System.out.println("2. 0으로 나누기>> " + 10 / 0);
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[3]); // 0~2
		} catch (ArithmeticException e1) { //import java.lang.*;
			e1.printStackTrace();
			System.out.println("수학연산 에러 발생함.");
		} catch (ArrayIndexOutOfBoundsException e2) {
			e2.printStackTrace();
			System.out.println("배열 인덱스 에러 발생함.");
		} catch (Exception e) { //수학연산, 배열에러를 제외한 에러
			System.out.println("기타 에러 발생함.");
		}

		System.out.println("3. 여기는 프린트 될까요");

	}

}
