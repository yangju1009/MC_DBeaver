package 리펙토링;

import javax.swing.JOptionPane; 

import 리펙토링.MemberDAO;

public class 회원정보UI테스트 {
	
	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("아이디 입력");
		String pw = JOptionPane.showInputDialog("패스워드 입력");
		String name = JOptionPane.showInputDialog("이름 입력");
		String tel = JOptionPane.showInputDialog("전화번호 입력");
		
		//shop db에 member테이블에 Insert 하고 싶음.
		MemberDAO dao = new MemberDAO();
		//dao에 전달할 데이터를 가방을 만들어서 다 넣은 다음에
		//가방 하나만 전달
		
		//가방을 주는쪽 
		//1. 가방을 만들어주세요.
		MemberVO bag = new MemberVO();
		//2. 가방에 넣어주세요.
		bag.setId(id);
		bag.setPw(pw);
		bag.setName(name);
		bag.setTel(tel);
		
		//3. 가방을 전달해주세요.
		//dao.insert(id, pw, name, tel);
		dao.insert(bag);
		
	}
}
