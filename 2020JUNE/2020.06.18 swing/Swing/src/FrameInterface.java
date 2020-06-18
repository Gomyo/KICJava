import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameInterface extends JFrame {
	private JPanel contentPane;
	
	public FrameInterface() {
		this.setTitle("새 타이틀");
		this.setSize(1024,768);

		// X 표시에서 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 다른 컨테이너나 텀포넌트 올려질 공간
		this.contentPane = new JPanel();
		this.setContentPane(contentPane);
		this.contentPane.setBackground(Color.blue);
		
		// 버튼 연결
		// 생성 - 설정 - 추가(add)
		this.setLayout(null);
		JButton btn1 = new JButton("벝흔");
		btn1.setSize(200,100);
		btn1.setLocation(100,100);
		this.contentPane.add(btn1);
	}
	
	public static void main (String[] args) {
		// 시스템 이벤트 큐 관리
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FrameInterface fr = new FrameInterface();
					fr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
