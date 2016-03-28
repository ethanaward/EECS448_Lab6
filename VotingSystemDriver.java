import javax.swing.JFrame;

public class VotingSystemDriver {

	public static void createAndShowGUI() {
		
		JFrame frame = new JFrame("Voting System");
		VotingSystem vote = new VotingSystem();
		
		frame.getContentPane().add(vote.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		createAndShowGUI();
	}
}
