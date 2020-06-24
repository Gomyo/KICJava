package Mine;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class CardLayoutEx01 {

	public static void main(String[] args) {
		final Frame f = new Frame("CardLayoutTest");
		final CardLayout card = new CardLayout(10, 10);
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
					card.previous(f); // 이전 Panel
				} else {
					card.next(f); // 다음 패널
				}
			}
		}
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());

		f.setSize(200, 200);
		f.setLocation(200, 200);
		f.setVisible(true);
		
		// Frame에서 창 닫기
		// 윈도우 창 종료 버튼 사용 (Frame 클래스의 addWindowListener 사용)
		f.addWindowListener(new WindowAdapter() { // 내부 무명클래스
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		card.show(f, "1"); // Frame의 컴포넌트 중 이름이 1인 것을 보여준다

	}
}
