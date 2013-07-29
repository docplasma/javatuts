import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

@SuppressWarnings("serial")

public class TeamFrame extends JFrame {
	
	public TeamFrame() throws IOException {
		PlayerPlus player;
		Scanner keyboard = new Scanner(new File("src/resources/Hankees.txt"));
		for (int i=0; i<=8; i++)	{
			player = new PlayerPlus(keyboard.nextLine(), keyboard.nextDouble());
			keyboard.nextLine();
			addPlayerInfo(player);
		}
		add(new JLabel());
		add(new JLabel("----------"));
		add(new JLabel("Team Batting Average:"));
		add(new JLabel(PlayerPlus.findTeamAverageString()));
		setTitle("The Hankees");
		setLayout(new GridLayout(11,2,20,3));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	void addPlayerInfo(PlayerPlus player)	{
		add(new JLabel(" " + player.getName()));
		add(new JLabel(player.getAverageString()));
	}

}
