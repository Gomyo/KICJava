package Mine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class UserMouseEvent implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("outerClass 마우스 클릭쿠쿠루삥뽕빵");
//		System.out.println(e.getSource());
		JButton btn = (JButton)e.getSource();
		System.out.println(btn.getText());
		
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
