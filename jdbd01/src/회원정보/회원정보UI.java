package 회원정보;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db연결.MemberDAO;

public class 회원정보UI {

	public static void main(String[] args) {
		//필요한 부품들을 RAM에 가져다놓아야한다.
		
		//JFrame
		JFrame f = new JFrame();
		f.setSize(400,700);
		f.setTitle("나의 회원정보UI");
		//FlowLayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		//Font
		
		//JLabel 5, JTextfield 4, JButton 2
		JLabel l1 = new JLabel("이미지 들어갈곳");
		JLabel l2 = new JLabel("회원ID : ");
		JLabel l3 = new JLabel("회원PW : ");
		JLabel l4 = new JLabel("회원이름: ");
		JLabel l5 = new JLabel("회원TEL: ");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		
		JButton b1 = new JButton("회원가입 요청");
		JButton b2 = new JButton("회원탈퇴 요청");
		JButton b3 = new JButton("회원정보 변경");
		b1.setBackground(Color.yellow);
		b1.setForeground(Color.blue);
		b2.setBackground(Color.yellow);
		b2.setForeground(Color.blue);
		b3.setBackground(Color.yellow);
		b3.setForeground(Color.blue);
		
		
		t1.setBackground(Color.pink);
		t1.setForeground(Color.red);
		t2.setBackground(Color.pink);
		t2.setForeground(Color.red);
		t3.setBackground(Color.pink);
		t3.setForeground(Color.red);
		t4.setBackground(Color.pink);
		t4.setForeground(Color.red);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 35);
		
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		
		f.add(l1);  //이미지
		f.add(l2);	//회원ID:
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(l5);
		f.add(t4);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//b1을 클릭했을 때 처리 내용을 넣어줌.
				
				//1. 입력한 값을 가지고 온다.
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				
				//2. db처리하는 부품을 사용
				MemberDAO dao = new MemberDAO();
				
				//3. db처리하는 부품에 입력한 값을 삽입하면서 db해달라고 요청
				dao.insert(id, pw, name, tel);
			}
		}); //회원가입 요청 버튼
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//탈퇴할 id를 입력받으세요.
				String id = JOptionPane.showInputDialog("탈퇴할 id를 입력하세요.");
				//DAO를 이용합니다
				MemberDAO dao = new MemberDAO();
				//id를 전달하면서 delete.
				dao.delete(id);
				
			}
		}); //회원 탈퇴버튼
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("정보를 변경할 id를 입력하세요.");
				String tel = JOptionPane.showInputDialog("변경할 전화번호를 입력하세요.");
				MemberDAO dao = new MemberDAO();
				dao.update(id, tel);
				
			}
		}); //회원정보 변경
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true); //설정을 보이도록 하는 명령어 이기때문에 맨끝에
	}

}
