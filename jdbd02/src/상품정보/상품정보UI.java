package 상품정보;

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

public class 상품정보UI {

	public static void main(String[] args) {
		//필요한 부품들을 RAM에 가져다놓아야한다.
		
		//JFrame
		JFrame f = new JFrame();
		f.setSize(600,1300);
		f.setTitle("나의 회원정보UI");
		//FlowLayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		//Font
		
		//JLabel 5, JTextfield 4, JButton 2
		JLabel l1 = new JLabel("이미지 들어갈곳");
		JLabel l2 = new JLabel("상품이름 : ");
		JLabel l3 = new JLabel("상품내용 : ");
		JLabel l4 = new JLabel("상품가격: ");
		JLabel l5 = new JLabel("제조회사: ");
		JLabel l6 = new JLabel("이미지: ");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);
		
		JButton b1 = new JButton("상품정보 추가");
		JButton b2 = new JButton("상품정보 삭제");
		JButton b3 = new JButton("상품가격 수정");
		JButton b4 = new JButton("상품정보 검색");
		b1.setBackground(Color.yellow);
		b1.setForeground(Color.blue);
		b2.setBackground(Color.yellow);
		b2.setForeground(Color.blue);
		b3.setBackground(Color.yellow);
		b3.setForeground(Color.blue);
		b4.setBackground(Color.yellow);
		b4.setForeground(Color.blue);
		
		
		t1.setBackground(Color.pink);
		t1.setForeground(Color.red);
		t2.setBackground(Color.pink);
		t2.setForeground(Color.red);
		t3.setBackground(Color.pink);
		t3.setForeground(Color.red);
		t4.setBackground(Color.pink);
		t4.setForeground(Color.red);
		t5.setBackground(Color.pink);
		t5.setForeground(Color.red);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 50);
		
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);
		
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		
		f.add(l1);  //이미지
		f.add(l2);	//회원ID:
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(l5);
		f.add(t4);
		f.add(l6);
		f.add(t5);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//b1을 클릭했을 때 처리 내용을 넣어줌.
				
				//1. 입력한 값을 가지고 온다.
				String name = t1.getText();
				String content = t2.getText();
				String price = t3.getText();
				String company = t4.getText();
				String img = t5.getText();
				
				//2. db처리하는 부품을 사용
				ProductDAO dao = new ProductDAO();
				
				//보내는 쪽 : 가방만들고 데이터 넣고, 전달
				ProductVO bag = new ProductVO();
				bag.setName(name);
				bag.setContent(content);
				bag.setPrice(Integer.parseInt(price));
				bag.setCompany(company);
				bag.setImg(img);
				
				//3. db처리하는 부품에 입력한 값을 삽입하면서 db해달라고 요청
				dao.insert(bag);
			}
		}); //상품등록 버튼
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//탈퇴할 id를 입력받으세요.
				String name = JOptionPane.showInputDialog("삭제할 상품의 이름을 넣어주세요");
				//DAO를 이용합니다
				ProductDAO dao = new ProductDAO();
				ProductVO bag = new ProductVO();
				bag.setName(name);
				//id를 전달하면서 delete.
				dao.delete(bag);
				
			}
		}); //회원 탈퇴버튼
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("변경할 상품을 입력해주세요");
				String price = JOptionPane.showInputDialog("변경할 가격을 입력해주세요");
				ProductDAO dao = new ProductDAO();
				ProductVO bag = new ProductVO();
				bag.setName(name);
				bag.setPrice(Integer.parseInt(price));
				dao.update(bag);
				
			}
		}); //회원정보 변경
		
		b4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // 검색하고 싶은 name을 입력받아 저장
		        String name = JOptionPane.showInputDialog("검색할 상품을 입력하세요");
		        
		        // ProductDAO를 사용
		        ProductDAO dao = new ProductDAO();
		        
		        // one() 호출
		        ProductVO bag = dao.one(name);
		        
		        // 결과를 출력
		        JOptionPane.showMessageDialog(f, bag);
		    }
		});

		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true); //설정을 보이도록 하는 명령어 이기때문에 맨끝에
	}

}
