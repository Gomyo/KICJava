package Mine;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class TCardLayoutJFrame {

	public static void main(String[] args) {
		// JFrame 사용
		// JFrame을 사용하려면 contentPane을 선언해야 한다.
		final JFrame f = new JFrame("CardLayoutTest"); 
		final JPanel contentPane = new JPanel(); 
		f.setContentPane(contentPane); 
		
		
		
		
		final CardLayout card = new CardLayout(10, 10);
		contentPane.setLayout(card);
		f.setLayout(card);

		Panel card1 = new Panel();
		card1.setBackground(Color.LIGHT_GRAY);
		card1.add(new Label("Card 1"));
		Panel card2 = new Panel();
		card2.add(new Label("Card 2"));
		card2.setBackground(Color.ORANGE);
		Panel card3 = new Panel();
		card3.add(new Label("Card 3"));
		card3.setBackground(Color.CYAN);

		f.add(card1, "1"); // Frame에 card1을 "1"이라고 이름 붙여 추가
		f.add(card2, "2");
		f.add(card3, "3");

		class Handler extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 마우스 오른쪽 버튼을 눌렀을 때
				if (e.getModifiers() == e.BUTTON3_MASK) {
					card.previous(contentPane); // 이전 Panel
				} else {
					card.next(contentPane); // 다음 패널
				}
			}
		}
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());

		f.setSize(200, 200);
		f.setLocation(200, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		card.show(contentPane, "1"); // Frame의 컴포넌트 중 이름이 1인 것을 보여준다

	}
}
