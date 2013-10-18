package Graphics;

import javax.swing.SwingWorker;

public class CircleLoadWorker extends SwingWorker<Circle, Object> {

	private Circle circle;
	private int xStart, xEnd, yStart, yEnd; //Frame Bounds

	public CircleLoadWorker() {
		
		circle = new Circle();
		
		xStart = 0;
		xEnd = 500;
		yStart = 0;
		yEnd = 500;
		
	}
	
	public CircleLoadWorker(Circle circle, int xEnd, int yEnd) {
		
		
		this.circle = circle;
		
		xStart = 0;
		this.xEnd = xEnd;
		yStart = 0;
		this.yEnd = yEnd;
		
	}
	
	public CircleLoadWorker(Circle circle, int xStart, int xEnd, int yStart, int yEnd) {
		
		this.circle = circle;
		
		this.xStart = xStart;
		this.xEnd = xEnd;
		this.yStart = yStart;
		this.yEnd = yEnd;
		
	}
	
	@Override
	protected Circle doInBackground() throws Exception {
		
		circle.updatePosition(xStart, xEnd, yStart, yEnd);
		return circle;
	}
}
