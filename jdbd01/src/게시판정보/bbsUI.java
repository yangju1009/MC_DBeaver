package 게시판정보;

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

public class bbsUI {

	public static void main(String[] args) {
		//필요한 부품들을 RAM에 가져다놓아야한다.
		
		//JFrame
		JFrame f = new JFrame();
		f.setSize(400,750);
		f.setTitle("나의 게시판");
		//FlowLayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		//Font
		
		//JLabel 5, JTextfield 4, JButton 2
		JLabel l1 = new JLabel("이미지 들어갈곳");
		JLabel l2 = new JLabel("게시판 No : ");
		JLabel l3 = new JLabel("글 제목 : ");
		JLabel l4 = new JLabel("글 내용 : ");
		JLabel l5 = new JLabel("작성자 : ");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		
		JButton b1 = new JButton("게시물 작성");
		JButton b2 = new JButton("게시물 삭제");
		JButton b3 = new JButton("게시물 수정");
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
				String title = t2.getText();
				String content = t3.getText();
				String writer = t4.getText();
				
				//2. db처리하는 부품을 사용
				bbsDAO dao = new bbsDAO();
				
				//3. db처리하는 부품에 입력한 값을 삽입하면서 db해달라고 요청
				dao.insert(title, content, writer);
			}
		}); //회원가입 요청 버튼
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//삭제할 no를 입력받으세요.
				String no2 = JOptionPane.showInputDialog("삭제할 게시물 번호를 입력하세요");
				int no = Integer.parseInt(no2);
				//DAO를 이용합니다
				bbsDAO dao = new bbsDAO();
				//no를 전달하면서 delete.
				dao.delete(no);
				
			}
		}); //회원 탈퇴버튼
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String no2 = JOptionPane.showInputDialog("변경할 게시물의 no를 입력하세요");
				int no = Integer.parseInt(no2);
				String title = JOptionPane.showInputDialog("변경할 제목을 입력하세요");
				String content = JOptionPane.showInputDialog("변경할 내용을 입력하세요");
				bbsDAO dao = new bbsDAO();
				dao.update(title, content, no);
				
			}
		}); //회원정보 변경
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true); //설정을 보이도록 하는 명령어 이기때문에 맨끝에
	}

}
