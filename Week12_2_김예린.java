import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CarFrame extends JFrame{
	Color color;
	JButton pbutton = new JButton("Paint");
	JRadioButton rButton;
	JRadioButton gButton;
	JRadioButton bButton;
	ButtonGroup cBG = new ButtonGroup();
	public CarFrame() {
		setSize(500, 350);
		setTitle("MyCar - 김예린");
		color = new Color(255,0,0); //초기 색 빨간색으로 설정
		JPanel bPanel = new JPanel(); //panel
		//색 버튼 선언
		rButton = new JRadioButton("RED",true); //초기에 선택되게 함.
		gButton = new JRadioButton("GREEN");
		bButton = new JRadioButton("BLUE");
		//버튼 그룹 선언
		cBG.add(rButton);
		cBG.add(gButton);
		cBG.add(bButton);
		pbutton.addMouseListener(new MouseListener());
		//panel에 component 붙이기
		bPanel.add(rButton);
		bPanel.add(gButton);
		bPanel.add(bButton);
		bPanel.add(pbutton);
		CarPanel car = new CarPanel();
		//frame에 panel 붙이기
		add(bPanel, BorderLayout.SOUTH);
		add(car, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	class MouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(rButton.isSelected()) {
				color = new Color(255,0,0);
				repaint();
			}
			else if(gButton.isSelected()) {
				color = new Color(0,255,0);
				repaint();
			}
			else if(bButton.isSelected()){
				color = new Color(0,0,255);
				repaint();
			}
		}
	}
	class CarPanel extends JPanel{
		public void paint(Graphics g) { //차를 그릴 class
		g.setColor(color);
		g.fillRect(150, 50, 140, 60);
		g.fillRect(80, 110, 280, 100);
		g.setColor(Color.lightGray);
		g.fillOval(120, 185, 50, 50);
		g.fillOval(270, 185, 50, 50);
		g.setColor(Color.black);
		g.drawArc(250, 90, 20, 35, 0, 180);
		}
	}
}
public class Week12_2_김예린 {
	
	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171059");
		System.out.println("성명: 김예린");
		System.out.println("============");
		CarFrame f = new CarFrame();

	}

}
