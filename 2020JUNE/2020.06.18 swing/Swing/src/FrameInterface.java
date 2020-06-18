import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameInterface extends JFrame {
	private JPanel contentPane;
	
	public FrameInterface() {
		this.setTitle("�� Ÿ��Ʋ");
		this.setSize(1024,768);

		// X ǥ�ÿ��� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �ٸ� �����̳ʳ� ������Ʈ �÷��� ����
		this.contentPane = new JPanel();
		this.setContentPane(contentPane);
		this.contentPane.setBackground(Color.blue);
		
		// ��ư ����
		// ���� - ���� - �߰�(add)
		this.setLayout(null);
		JButton btn1 = new JButton("����");
		btn1.setSize(200,100);
		btn1.setLocation(100,100);
		this.contentPane.add(btn1);
	}
	
	public static void main (String[] args) {
		// �ý��� �̺�Ʈ ť ����
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
