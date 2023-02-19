import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonFrame extends JFrame{
	JButton button = new JButton("Click!");
	public ButtonFrame() { //생성자
		setTitle("나 잡아봐~라! - 김예린");
		setSize(300, 300); //frame size (300,300)
		setResizable(false); //frame size 바꿀 수 없게
		JPanel panel = new JPanel();
		button.addMouseListener(new MouseListener());
		panel.add(button);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	class MouseListener extends MouseAdapter{ //inner class로 event handling
		public void mouseEntered(MouseEvent e) {//마우스가 버튼 안으로 들어 왔을 때
		int x = (int)(Math.random()*260);
		int y = (int)(Math.random()*250); //button이 화면 밖으로 나가지 않게 위치 조정
		button.setLocation(x, y);
		System.out.println("x=" + x + "\ty=" + y);
		}
		public void mouseClicked (MouseEvent e) { //마우스로 버튼을 클릭했을 때
			System.out.println("윽,,,잡혔다ㅠㅠ");
		}
	}
}

public class Week12_1_김예린 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 2171059");
		System.out.println("성명: 김예린");
		System.out.println("============");
		ButtonFrame b = new ButtonFrame();

	}

}
