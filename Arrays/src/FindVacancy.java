import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class FindVacancy {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		Scanner diskScanner = new Scanner(new File("src/resources/GuestList.txt"));
		int guests[] = new int [10];
		int roomNum;
		for (roomNum=0; roomNum<10; roomNum++)	{
			guests[roomNum] = diskScanner.nextInt();
		}
		roomNum=0;
		while (roomNum<10 && guests[roomNum] != 0) {
			roomNum++;
		}
		if (roomNum == 10) {
			out.println("Sorry, no vcancy");
			
		} else {
			out.print("How many people for room ");
			out.print(roomNum);
			out.print("?");
			guests[roomNum] = keyboard.nextInt();
			PrintStream listOut = new PrintStream("src/resources/GuestList.txt");
			for (roomNum=0; roomNum<10;roomNum++) {
				listOut.print(guests[roomNum]);
				listOut.print(" ");
			}
			
		}

	}

}
