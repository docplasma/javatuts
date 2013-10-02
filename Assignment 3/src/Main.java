import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int CUSTOMERSINDAY = 100;
		final int NUMOFHOURSINDAY = 8;
		int averageCustomerArrivalRate = (int) Math.ceil( (float) NUMOFHOURSINDAY * 60 / (float) CUSTOMERSINDAY);
		LinkedBlockingQueue<Integer> line = new LinkedBlockingQueue<Integer>();
		int arrivalTime = 0;
		int tellerAvailableClock = 0;
		int sumOfWaitTimes = 0;
		int averageCustomerWaitTime;

		Random rand = new Random();
		
		//Fills the customer line with predetermined amount of customers per day at an even rate
		for (int i=0; i<CUSTOMERSINDAY; i++) {
			
			line.put(arrivalTime);
			
			arrivalTime = arrivalTime + averageCustomerArrivalRate;
		}
		
		while (line.size() != 0) {
			
			//If teller is ready before customer arrives, set teller clock to when the customer arrives
			if (line.peek() >= tellerAvailableClock) {
				
				tellerAvailableClock = line.take();
			}
			//Else add the difference in time between when the teller is available and when the next customer arrived in the queue
			else {
				sumOfWaitTimes = sumOfWaitTimes + tellerAvailableClock - line.take();
			}
			
			//Adds 2-8 min to when the teller will be available
			tellerAvailableClock = tellerAvailableClock + (rand.nextInt(6) + 2);
			
		}
		
		averageCustomerWaitTime = sumOfWaitTimes / (int) CUSTOMERSINDAY;
		
		java.lang.System.out.print("The average wait time for ");
		java.lang.System.out.print(CUSTOMERSINDAY);
		java.lang.System.out.print(" people is: ");
		java.lang.System.out.print(averageCustomerWaitTime);
		java.lang.System.out.println(" min.");
	}

}
