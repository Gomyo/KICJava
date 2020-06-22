import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RGBQuiz extends JFrame {

	private JPanel contentPane;
	private Color color;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RGBQuiz frame = new RGBQuiz();
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
	public RGBQuiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea cta = new JTextArea();
		cta.setBounds(12, 29, 288, 155);
		contentPane.add(cta);
		
		JSlider Rslider = new JSlider();
		Rslider.setPaintTicks(true);
		Rslider.setForeground(Color.RED);
		Rslider.setBackground(Color.RED);
		Rslider.setValue(0);
		Rslider.setMaximum(255);
		Rslider.setBounds(325, 45, 416, 26);
		contentPane.add(Rslider);
		
		JSlider Gslider = new JSlider();
		Gslider.setPaintTicks(true);
		Gslider.setBackground(Color.GREEN);
		Gslider.setMaximum(255);
		Gslider.setValue(0);
		Gslider.setBounds(325, 94, 416, 26);
		contentPane.add(Gslider);
		
		JSlider Bslider = new JSlider();
		Bslider.setPaintTicks(true);
		
		Bslider.setBackground(Color.BLUE);
		Bslider.setForeground(Color.BLUE);
		Bslider.setMaximum(255);
		Bslider.setValue(0);
		Bslider.setBounds(325, 147, 416, 26);
		contentPane.add(Bslider);
		
		JButton btnInit = new JButton("\uCD08\uAE30\uD654");
		btnInit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rslider.setValue(0);
				Gslider.setValue(0);
				Bslider.setValue(0);
			}
		});
		btnInit.setBounds(325, 196, 97, 23);
		contentPane.add(btnInit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 196, 288, 23);
		contentPane.add(textArea);
		
		Rslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cta.setBackground(new Color(Rslider.getValue(),Gslider.getValue(),Bslider.getValue()));
				String hex = String.format("#%02x%02x%02x", Rslider.getValue(), Gslider.getValue(), Bslider.getValue());
				textArea.setText("현재 색 : R - "+ Rslider.getValue()+" G - "+Gslider.getValue()+" B - "+Bslider.getValue() + " HexColor : "+hex);
				
			}
		});
		
		Gslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cta.setBackground(new Color(Rslider.getValue(),Gslider.getValue(),Bslider.getValue()));
				String hex = String.format("#%02x%02x%02x", Rslider.getValue(), Gslider.getValue(), Bslider.getValue());
				textArea.setText("현재 색 : R - "+ Rslider.getValue()+" G - "+Gslider.getValue()+" B - "+Bslider.getValue() + " HexColor : "+hex);
			}
		});
		
		Bslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cta.setBackground(new Color(Rslider.getValue(),Gslider.getValue(),Bslider.getValue()));
				String hex = String.format("#%02x%02x%02x", Rslider.getValue(), Gslider.getValue(), Bslider.getValue());
				textArea.setText("현재 색 : R - "+ Rslider.getValue()+" G - "+Gslider.getValue()+" B - "+Bslider.getValue() + " HexColor : "+hex);
			}
		});
	}
}
