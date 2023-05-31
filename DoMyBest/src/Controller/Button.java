package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button extends JFrame {
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	JPanel p;
	Character answer = ' ';

	public Button() {
		setSize(300, 200);
		setLocation(500, 600);
		setTitle("햄부거 만들기");
		

		p = new JPanel();
		b0 = new JButton("빵");
		b1 = new JButton("양상추");
		b2 = new JButton("토마토");
		b3 = new JButton("마요네즈");
		b4 = new JButton("케첩");
		b5 = new JButton("불고기");
		b6 = new JButton("새우");
		b7 = new JButton("치킨");
		b8 = new JButton("치즈");
		b9 = new JButton("피클");
		p.add(b0);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		add(p);
		setVisible(true);
		addListner();
		closeAfterDelay(10000);
	}

	private void addListner() {

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				synchronized (Button.this) {
					Button.this.notify(); // solveP()에서 대기 중인 스레드를 깨웁니다.
				}

				if (b0.equals(ae.getSource())) {
					answer = '0';
				}
				if (b1.equals(ae.getSource())) {
					answer = '1';
				}
				if (b2.equals(ae.getSource())) {
					answer = '2';
				}
				if (b3.equals(ae.getSource())) {
					answer = '3';
				}
				if (b4.equals(ae.getSource())) {
					answer = '4';
				}
				if (b5.equals(ae.getSource())) {
					answer = '5';
				}
				if (b6.equals(ae.getSource())) {
					answer = '6';
				}
				if (b7.equals(ae.getSource())) {
					answer = '7';
				}
				if (b8.equals(ae.getSource())) {
					answer = '8';
				}
				if (b9.equals(ae.getSource())) {
					answer = '9';
				}

			}
		};
		b0.addActionListener(listener);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		b4.addActionListener(listener);
		b5.addActionListener(listener);
		b6.addActionListener(listener);
		b7.addActionListener(listener);
		b8.addActionListener(listener);
		b9.addActionListener(listener);

	}

	public Character answerGet() {
		return answer;
	}
	
	public void closeAfterDelay(int delay) {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				dispose();
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task, delay);
	}

}