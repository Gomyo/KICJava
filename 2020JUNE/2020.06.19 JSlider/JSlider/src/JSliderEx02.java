 import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class JSliderEx02 extends JFrame {
	private JPanel contentPane;
	private JSlider slider1;
	private JTextArea textArea;
	private JSlider slider2;
	private JSlider slider3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					JSliderEx02 frame = new JSliderEx02();
					frame.setVisible( true );
				} catch( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}
	/**
	 * Create the frame.
	 */
	public JSliderEx02() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 555, 220 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
        
		contentPane.setLayout( null );
          

		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setMajorTickSpacing( 20 );
		slider1.setMaximum( 255 );
		slider1.addChangeListener( new ChangeListener() {
			public void stateChanged( ChangeEvent e) {
				if( textArea != null ) {
					textArea.setBackground( new Color( slider1.getValue(), slider2.getValue(), slider3.getValue() ) );
				}
			}
		} );
		slider1.setValue( 0 );
		slider1.setBounds( 12, 10, 282, 46 );
		contentPane.add( slider1 );
          
		slider2 = new JSlider();
		slider2.addChangeListener( new ChangeListener() {
			public void stateChanged( ChangeEvent e) {
				if( textArea != null ) {
					textArea.setBackground( new Color( slider1.getValue(), slider2.getValue(), slider3.getValue() ) );
				}
			}
		} );
		slider2.setPaintTicks( true );
		slider2.setValue( 0 );
		slider2.setMaximum( 255 );
		 slider2.setMajorTickSpacing( 20 );
		slider2.setBounds( 12, 66, 282, 46 );
		contentPane.add( slider2 );
          
		slider3 = new JSlider();
		slider3.addChangeListener( new ChangeListener() {
			public void stateChanged( ChangeEvent e ) {
				if( textArea != null ) {
					textArea.setBackground( new Color( slider1.getValue(), slider2.getValue(), slider3.getValue() ) );
				}
			}
		} );
		slider3.setValue( 0 );
		slider3.setPaintTicks( true );
		slider3.setMaximum( 255 );
		slider3.setMajorTickSpacing( 20 );
		slider3.setBounds( 12, 122, 282, 46 );
		contentPane.add( slider3 );
          
		textArea = new JTextArea();
		textArea.setBackground( Color.BLACK );
		textArea.setBounds( 316, 10, 211, 158 );
		contentPane.add( textArea );
	}
}
