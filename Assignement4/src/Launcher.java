import javax.swing.JFrame;

import Graphics.Circle;
import Graphics.CircleFrame;
import Graphics.CircleLoadWorker;


public class Launcher {

	
	private static final int XFRAMEDIMENSION = 500;
	private static final int YFRAMEDIMENSION = 500;
	private static final String windowTitle = "Ball Simulation";

	public static void main(String[] args) throws InterruptedException {

		Circle circle1 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		/*Circle circle2 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle3 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle4 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle5 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);*/
		
		CircleFrame frame = new CircleFrame(windowTitle, circle1/*, circle2, circle3, circle4, circle5*/);

		//JFrame frame = new JFrame("Ball Simulator");
		frame.setSize(XFRAMEDIMENSION, YFRAMEDIMENSION);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		CircleLoadWorker thread1 = new CircleLoadWorker(circle1, XFRAMEDIMENSION, YFRAMEDIMENSION);
		/*CircleLoadWorker thread2 = new CircleLoadWorker(circle2, XFRAMEDIMENSION, YFRAMEDIMENSION);
		CircleLoadWorker thread3 = new CircleLoadWorker(circle3, XFRAMEDIMENSION, YFRAMEDIMENSION);
		CircleLoadWorker thread4 = new CircleLoadWorker(circle4, XFRAMEDIMENSION, YFRAMEDIMENSION);
		CircleLoadWorker thread5 = new CircleLoadWorker(circle5, XFRAMEDIMENSION, YFRAMEDIMENSION);*/
		
		thread1.execute();
		/*thread2.execute();
		thread3.execute();
		thread4.execute();
		thread5.execute();*/
		
		while (true) {
			frame.repaint();
			System.out.println(circle1);
			/*System.out.println(circle2);
			System.out.println(circle3);
			System.out.println(circle4);
			System.out.println(circle5);*/
			Thread.sleep(1000);
		}
	}

}
