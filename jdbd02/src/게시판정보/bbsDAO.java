package 게시판정보;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bbsDAO { // member테이블에 crud를 하고 싶으면 MemberDAO를 사용하면 된다
	// DAO : db access object
	// db에 접근해서 처리하는 객체
	Connection con = null;
	
	public bbsDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 파일을 찾을 수 없음.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("mySQL 연결할 때 문제가 생김.");
			e.printStackTrace();
		}
	}
	
	public void update(String title, String content, int no) {
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update bbs set title = ?, content = ? where no = ?";
			
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, title); 
			ps.setString(2, content); 
			ps.setInt(3, no); //values ('ddd', 'ddd') where no = '3'
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
	
	public void delete(int no) {
		try {
			String sql = "delete from bbs where no = ?";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setInt(1, no); // 물음표 번호 1번에 no에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!");

			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} // delete

	public void insert(String title, String content, String writer) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into bbs values (null, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, title); // 물음표 번호 1번에 title에 저장한 변수값을 넣어줘!
			ps.setString(2, content); // 물음표 번호 2번에 content에 저장한 변수값을 넣어줘!
			ps.setString(3, writer); // 물음표 번호 3번에 writer에 저장한 변수값을 넣어줘!
		
			System.out.println("3. sql문 생성 성공!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} // insert
	
	public BbsVO one(int no) {
		BbsVO bag = new BbsVO();
		try {
			String sql = "select * from bbs where no = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setInt(1, no); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			ResultSet table = ps.executeQuery(); //테이블로 mysql로 받아온다. 
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			//System.out.println(table.next()); //table안에 데이터가 있으면 true
			if(table.next()) { //table안에 검색결과인 row가 있는지 체크 
				int no2 = table.getInt("no");
				String title = table.getString("title");
				String content = table.getString("content");
				String writer = table.getString("writer");
				//JOptionPane.showMessageDialog(null, title + " " + "");
				System.out.println(no2);
				System.out.println(title);
				System.out.println(content);
				System.out.println(writer);
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
			}else {
				System.out.println("검색결과가 없음.");
			}
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}
		return bag;
	} // one

}
