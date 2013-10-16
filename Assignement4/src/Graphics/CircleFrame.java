package Graphics;

import javax.swing.JFrame;

public class CircleFrame extends JFrame {

	private static final int XFRAMEDIMENSION = 500;
	private static final int YFRAMEDIMENSION = 500;
	
	CircleFrame() {
		
		JFrame frame = new JFrame("Ball Simulator");
		frame.setSize(XFRAMEDIMENSION, YFRAMEDIMENSION);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
