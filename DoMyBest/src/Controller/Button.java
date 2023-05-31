package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button extends JFrame {
	JButton b1, b2, b3;
	JPanel p;
	String answer = "";

	public Button() {
		setSize(300, 200);
		setTitle("햄부거 만들기");

		p = new JPanel();
		b1 = new JButton("빵");
		b2 = new JButton("고기");
		b3 = new JButton("양상추");
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p);
		setVisible(true);
		addListner();
	}

	private void addListner() {

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {

//	            JButton clickedButton = (JButton) ae.getSource();
//	            String buttonText = clickedButton.getText();
//	            testList.add(buttonText);
//	            System.out.println(buttonText + " 추가");
				synchronized (Button.this) {
					Button.this.notify(); // solveP()에서 대기 중인 스레드를 깨웁니다.
				}

				if (b1.equals(ae.getSource())) {
					answer = "빵";
				}
				if (b2.equals(ae.getSource())) {
					answer = "고기";
				}
				if (b3.equals(ae.getSource())) {
					answer = "양상추";
				}

			}
		};

		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);

	}

	public String answerGet() {
		return answer;
	}

}