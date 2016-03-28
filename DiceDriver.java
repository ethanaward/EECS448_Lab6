import javax.swing.JFrame;

public class DiceDriver {

	private static void createAndDisplayGUI() {
		
		JFrame frame = new JFrame("Dice Roller");
		Dice die = new Dice();
		
		frame.getContentPane().add(die.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}

}

