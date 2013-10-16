package Graphics;

import javax.swing.SwingWorker;

public class CircleLoadWorker extends SwingWorker {

	private Circle circle;

	CircleLoadWorker() {
		
		circle = new Circle();
		
	}

	@Override
	protected Circle doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void done() {
		
		//TODO call paint funciton
	}
}
