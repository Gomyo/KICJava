package Mine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx01 frame = new JFrameEx01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialogEx01 dialog = new JDialogEx01();
				// 다이얼로그는 EXIT 하면 안되고 창을 지워야 한다. 그런데 현 상태에서는 부모 창이 클릭이 된다(제어가 안 되는 중)
				// 화면 사라진다의 의미 
				// 1. 안보이는 경우 : setVisible 다시 보이게 하는건 빠르지만 메모리를 많이 먹음
				// 2. 객체가 제거된 경우 : dispose
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				System.out.println("1");
				// 이렇게 되면 다이얼로그 창이 포커스를 얻고 부모창을 클릭할 수 없게 된다.
				dialog.setModal(true);
				System.out.println("2");
				
				// JDialog 데이터 넣을 때
				dialog.setData("새로운 데이터");
				
				// JFame에 데이터 가져올 때 

				dialog.setVisible(true); // lock : 창 닫으면 sysout 3 실행
				System.out.println("3");
				System.out.println(dialog.getData());
			}
		});
		btnNewButton.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton);
	}
}
