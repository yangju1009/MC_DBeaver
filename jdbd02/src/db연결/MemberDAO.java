package db연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 회원정보.MemberVO;

public class MemberDAO { // member테이블에 crud를 하고 싶으면 MemberDAO를 사용하면 된다
	// DAO : db access object
	// db에 접근해서 처리하는 객체
	public void update(String id, String tel) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update member set tel =? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, tel); 
			ps.setString(2, id); 
			System.out.println("3. sql문 생성 성공!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} //update
	
	public void delete(MemberVO bag) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");

			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");

		
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, bag.getId()); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!");

			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} // delete

	public int insert(MemberVO bag) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");
			// 패키지.대표클래스
			// 외부자원연결(db, network, cpu, file,...)
			// 너무 위험한 상황!
			// 상황이 발생했을 때 어떻게 대처할지를 반드시 써주어야 함.
			// 2. 1번 설정을 커넥터로 db연결하고 승인
			// 1) url - ip + port + db명
			// 2) id, pw
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into member values (?,?,?,?)";
			// String site = "http://www.naver.com";
			// 해당부품으로 만들어줘야 한다.
			// sql ==> PreparedStatment
			// site ==> URL
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, bag.getId()); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			ps.setString(2, bag.getPw()); // 물음표 번호 2번에 pw에 저장한 변수값을 넣어줘!
			ps.setString(3, bag.getName()); // 물음표 번호 3번에 name에 저장한 변수값을 넣어줘!
			ps.setString(4, bag.getTel()); // 물음표 번호 3번에 tel에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			result = ps.executeUpdate(); //int
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			con.close();
			ps.close();
			//table.close();
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}
		return result;

	} // insert
	
	public void one(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. 커넥터 연결 성공!!");
            String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
            String user = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("2. shop db연결 성공!!");
            String sql = "select * from member where id = ? ";
            PreparedStatement ps = con.prepareStatement(sql); //
            ps.setString(1, id); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
            System.out.println("3. sql문 생성 성공!!");
            ResultSet table = ps.executeQuery(); //테이블로 mysql로 받아온다. 
            
            System.out.println("4. SQL문 mySQL로 전송 성공!!");
            //System.out.println(table.next()); //table안에 데이터가 있으면 true
            if (table.next()) { //table안에 검색결과인 row가 있는지 체크
				String id2 = table.getString("id");  //id는 컬럼명
				String pw = table.getString("pw");
				String name = table.getString("name");
				String tel = table.getString("tel");
				System.out.println(id2);
				System.out.println(pw);
				System.out.println(name);
				System.out.println(tel);
			}else {
				System.out.println("검색결과가 없음.");
			}
            
        } catch (Exception e) { // Exception == Error
            e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
            System.out.println("에러발생함.!!!!");
        }
    } // one
}
