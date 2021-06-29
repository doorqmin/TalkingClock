package TalkingClock;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock0 {
	private int interval;
	private boolean beep;
	public TalkingClock0(int interval, boolean beep)
	{
	      this.interval = interval;
	      this.beep = beep;
	}
	public static void main(String[] args) {
		var clock = new TalkingClock0(1000, true);
		clock.start();
	}

	public void start() { 
		var listener = new TimePrinter();
		var timer = new Timer(interval, listener);
		timer.start();
		JOptionPane.showMessageDialog(null, "You want Stop?");
		System.exit(0);
	}

	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone, the time is " 
					+ Instant.ofEpochMilli(event.getWhen()));
			if (beep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}