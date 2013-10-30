import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;

import Graphics.Circle;
import Graphics.CircleLoadWorker;
import Graphics.CirclePanel;


public class Launcher {

	//-----Constant Data members
	private static final int XFRAMEDIMENSION = 500;
	private static final int YFRAMEDIMENSION = 500;
	private static final String windowTitle = "Ball Simulation";

	public static void main(String[] args) throws InterruptedException {

		
		//Constructs Circles in relation to how big the frame will be
		Circle circle1 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle2 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle3 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle4 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		Circle circle5 = new Circle(XFRAMEDIMENSION, YFRAMEDIMENSION);
		
		
		//Stores circles in an arraylist to pass to the panel
		ArrayList<Circle> circles = new ArrayList<Circle>();
		
		circles.add(circle1);
		circles.add(circle2);
		circles.add(circle3);
		circles.add(circle4);
		circles.add(circle5);
		
		//Passes arraylist and frame dimensions to the panel
		CirclePanel panel = new CirclePanel(circles, XFRAMEDIMENSION, YFRAMEDIMENSION);
		
		JFrame frame = new JFrame(windowTitle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		//Main simulation loop
		while (true) {
			//Creates a new thread to update each respective circle's position
			CircleLoadWorker thread1 = new CircleLoadWorker(circle1, XFRAMEDIMENSION, YFRAMEDIMENSION);
			CircleLoadWorker thread2 = new CircleLoadWorker(circle2, XFRAMEDIMENSION, YFRAMEDIMENSION);
			CircleLoadWorker thread3 = new CircleLoadWorker(circle3, XFRAMEDIMENSION, YFRAMEDIMENSION);
			CircleLoadWorker thread4 = new CircleLoadWorker(circle4, XFRAMEDIMENSION, YFRAMEDIMENSION);
			CircleLoadWorker thread5 = new CircleLoadWorker(circle5, XFRAMEDIMENSION, YFRAMEDIMENSION);
			
			//Executes each thread
			thread1.execute();
			thread2.execute();
			thread3.execute();
			thread4.execute();
			thread5.execute();
			
			//Waits until the physics update is complete for each thread
			try {
				thread1.get();
				thread2.get();
				thread3.get();
				thread4.get();
				thread5.get();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
			
			//Repaints the panel with the updated position of each ball
			panel.repaint();
			
			//Outputs to the console statistics of each ball
			System.out.println(circle1);
			System.out.println(circle2);
			System.out.println(circle3);
			System.out.println(circle4);
			System.out.println(circle5);
			Thread.sleep(15);
		}
	}

}
