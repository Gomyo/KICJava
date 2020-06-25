import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ZipcodeDetailDialog extends JDialog {
	
	
	private final JPanel contentPanel = new JPanel();
	private JLabel zipcodeLabel;
	private JTextField textField;

	
	public JLabel getZipcodeLabel() {
		return zipcodeLabel;
	}

	public void setZipcodeLabel(String txt) {
		zipcodeLabel.setText(txt);
	}

	public static void main(String[] args) {
		try {
			ZipcodeDetailDialog dialog = new ZipcodeDetailDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ZipcodeDetailDialog() {
		setBounds(100, 100, 307, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		zipcodeLabel = new JLabel("New label");
		zipcodeLabel.setBounds(12, 29, 222, 30);
		contentPanel.add(zipcodeLabel);
		
		ZipSearchMain zm = new ZipSearchMain();
		
		zipcodeLabel.setText("우편번호 : "+getZipcodeLabel());
		{
			textField = new JTextField();
			textField.setBounds(12, 78, 152, 30);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton closeButton = new JButton("닫기");
				buttonPane.add(closeButton);
				getRootPane().setDefaultButton(closeButton);
			}
		}
		
	}

}
