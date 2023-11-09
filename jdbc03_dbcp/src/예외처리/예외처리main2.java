package 예외처리;

public class 예외처리main2 {
	
	public static void main(String[] args) {
		에러발생3 error = new 에러발생3();
		//에러가 발생할 것같은 코드가 있는경우
		//Call() 메서드 만든 사람이 예외 처리를 결정할 수 있다.
		try {
			error.call();
		} catch (Exception e) {
			System.out.println("함수를 호출한 곳에서 예외처리함");
			System.out.println("관리자에게 문자를 보냄");
			e.printStackTrace();
		}
	}
}
