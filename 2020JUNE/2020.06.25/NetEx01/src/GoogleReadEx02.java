import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class GoogleReadEx02 extends JFrame {

	private JPanel contentPane;
	private JTextField loc;
	private JTextField lat;
	private JTextField lng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoogleReadEx02 frame = new GoogleReadEx02();
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
	public GoogleReadEx02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 30, 411, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		loc = new JTextField();
		loc.setBounds(6, 18, 275, 21);
		panel.add(loc);
		loc.setColumns(10);
		
		JButton btnNewButton = new JButton("위치 찾기");
		
		btnNewButton.setBounds(308, 17, 97, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 121, 411, 77);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lat = new JTextField();
		lat.setEditable(false);
		lat.setBounds(6, 18, 275, 21);
		panel_1.add(lat);
		lat.setColumns(10);
		
		lng = new JTextField();
		lng.setEditable(false);
		lng.setBounds(6, 49, 275, 21);
		panel_1.add(lng);
		lng.setColumns(10);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			BufferedReader br = null;
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" +loc.getText()+ "&key=AIzaSyBCEEd5naSLLZf1nDhpToFU_9MTyt1BdsY");
					URLConnection conn = url.openConnection();
					
					br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					
					String line = null;
					String strlat = null;
					String strlng = null;
					
					while ((line = br.readLine()) != null) {
						if (line.contains("\"location\"")) {
							strlat = br.readLine().trim().substring(8).replace(",", "");
							strlng = br.readLine().trim().substring(8).replace(",", "");
						}
					}
					lat.setText(strlat);
					lng.setText(strlng);
				} catch (MalformedURLException me) {
					// TODO Auto-generated catch block
					me.printStackTrace();
				} catch (IOException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				} finally {
					if (br != null) try {br.close();} catch (IOException ie) {}
				}
			}
		});
		JButton btnNewButton_1 = new JButton("지도보기");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
//					Desktop.getDesktop().browse(new URI("https://www.google.com/maps/@"+lat.getText()+","+lng.getText()+","+"14z?hl=ko"));
					String strOption = String.format("https://www.google.com/maps/@%s,%s,%s",lat.getText(),lng.getText(),"14z?hl=ko");
					ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",strOption);
					pb.start();
				} catch (IOException e1) {
					e1.printStackTrace();
//				} catch (URISyntaxException e1) {
//					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(308, 17, 97, 53);
		panel_1.add(btnNewButton_1);
	}
}
