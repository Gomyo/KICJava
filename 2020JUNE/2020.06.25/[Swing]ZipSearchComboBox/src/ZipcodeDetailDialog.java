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
	private JLabel sidoLabel;
	private JLabel gugunLabel;
	private JLabel dongLabel;
	private JLabel liLabel;
	private JLabel bunjiLabel;
	
	public void setZipcodeLabel(String txt) {
		zipcodeLabel.setText(txt);
	}

	public void setSidoLabel(String txt) {
		sidoLabel.setText(txt);
	}
	
	public void setGugunLabel(String txt) {
		gugunLabel.setText(txt);
	}

	public void setDongLabel(String txt) {
		dongLabel.setText(txt);
	}

	public void setLiLabel(String txt) {
		liLabel.setText(txt);
	}

	public void setBunjiLabel(String txt) {
		bunjiLabel.setText(txt);
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
		zipcodeLabel.setBounds(12, 10, 222, 30);
		contentPanel.add(zipcodeLabel);
		
		sidoLabel = new JLabel("New label");
		sidoLabel.setBounds(12, 50, 222, 30);
		contentPanel.add(sidoLabel);
		
		gugunLabel = new JLabel("New label");
		gugunLabel.setBounds(12, 90, 222, 30);
		contentPanel.add(gugunLabel);
		
		dongLabel = new JLabel("New label");
		dongLabel.setBounds(12, 130, 222, 30);
		contentPanel.add(dongLabel);
		
		liLabel = new JLabel("New label");
		liLabel.setBounds(12, 170, 222, 30);
		contentPanel.add(liLabel);
		
		bunjiLabel = new JLabel("New label");
		bunjiLabel.setBounds(12, 210, 222, 30);
		contentPanel.add(bunjiLabel);
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
