package 예외처리_확인문제;

public class ErrorMain2 {

	public static void main(String[] args) {
		Error2 e = new Error2();
		try {
			e.arr2(); //실행에러
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("main()에서 배열 인덱스 에러를 예외처리함");
		}
		System.out.println("이 부분은 실행되어야함");
	}
	

}
