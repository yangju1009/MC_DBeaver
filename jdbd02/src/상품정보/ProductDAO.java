package 상품정보;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {

	public void update(ProductVO bag) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");

			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update product set price = ? where name = ?";

			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setInt(1, bag.getPrice());
			ps.setString(2, bag.getName());

			System.out.println("3. sql문 생성 성공!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			int rowCount = ps.executeUpdate(); // insert문 실행한 row수,int
			if (rowCount == 1) {
				System.out.println("상품 추가 성공!");
			}
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} // update

	public void delete(ProductVO bag) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");

			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");

			String sql = "delete from product where name = ?";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, bag.getName()); // 물음표 번호 1번에 no에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!");

			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} // delete

	public void insert(ProductVO bag) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");

			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into product values (null, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, bag.getName());
			ps.setString(2, bag.getContent());
			ps.setInt(3, bag.getPrice());
			ps.setString(4, bag.getCompany());
			ps.setString(5, bag.getImg());

			System.out.println("3. sql문 생성 성공!");

			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");

		}

	} // insert

	public ProductVO one(String name) {
		ProductVO bag = new ProductVO();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공!!");
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공!!");
			String sql = "select * from product where name = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //
			ps.setString(1, name); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");
			ResultSet table = ps.executeQuery(); // 테이블로 mysql로 받아온다.
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			// System.out.println(table.next()); //table안에 데이터가 있으면 true

			if (table.next()) { // table안에 검색결과인 row가 있는지 체크
				String name2 = table.getString("name"); // id는 컬럼명
				String content = table.getString("content");
				int price = table.getInt("price");
				String company = table.getString("company");
				String img = table.getString("img");
				System.out.println(name2);
				System.out.println(content);
				System.out.println(price);
				System.out.println(company);
				System.out.println(img);

				bag.setName(name2);
				bag.setContent(content);
				bag.setPrice(price);
				bag.setCompany(company);
				bag.setImg(img);
			} else {
				System.out.println("검색결과가 없음.");
			}
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}
		return bag;
	} // one

}
