package Mine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDialogEx01 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private String data;
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	// Test
	/*
	public static void main(String[] args) {
		try {
			JDialogEx01 dialog = new JDialogEx01();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	 */
	

	/**
	 * Create the dialog.
	 */
	public JDialogEx01() {
		System.out.println("data : "+this.data);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("New button");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// data 속에 든 data를 가져오고 싶으면
					System.out.println(JDialogEx01.this.data);
				}
			});
			btnNewButton.setBounds(12, 10, 97, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 얘는 inner 클래스이기 때문에 this를 안쓰면 MouseAdapter로 명령이 들어감. 
						JDialogEx01.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
