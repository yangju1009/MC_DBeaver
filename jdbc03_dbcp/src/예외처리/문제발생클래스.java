package 예외처리;

public class 문제발생클래스 {

	public static void main(String[] args) {
		System.out.println("1. 나는 실행됨.");
		try {
			System.out.println("2. 0으로 나누기>> " + 10/0);
			int[] arr = {1,2,3};
			System.out.println(arr[3]); //0~2
			
		} catch (Exception e) {
			//e.printStackTrace();
			//서버관리자에게 이메일을 보내는 처리
			//서버관리자에게 문자를 보내는 처리
			//git History처리
			//Jira history처리
			System.out.println("0으로 나눈것은 실패함.");
		}
		System.out.println("3. 여기는 프린트 될까요");

	}

}
