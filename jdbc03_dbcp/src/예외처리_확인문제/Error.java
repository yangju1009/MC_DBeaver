package 예외처리_확인문제;

public class Error {
	public void arr() {
		try {
			int[] array = {10, 20, 30};
			array[3] = 100;
		} catch (Exception e) {
			System.out.println("배열 인덱스 에러가 발생함");
		}
	}
	
}
