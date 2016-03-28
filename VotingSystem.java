import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class VotingSystem {

	private JLabel label;
	private JTextField firstName;
	private JTextField lastName;
	private JButton button;
	private JPanel panel;
	private JRadioButton choice1;
	private JRadioButton choice2;
	private JRadioButton choice3;
	private JRadioButton choice4;
	private ButtonGroup group;
	private String choice;
	private HashMap<String, Integer> map;
	
	public VotingSystem() {
		
		//Initialize the various J components
		panel = new JPanel();
		label = new JLabel("Enter your first and last name: ");
		firstName = new JTextField(13);
		lastName = new JTextField(13);
		button = new JButton("Cast your vote");
		group = new ButtonGroup();
		map = new HashMap<String, Integer>();
		choice = "";
		
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader("voters.txt"));
			String l;
			while((l = inputStream.readLine()) != null) {
				map.put(l, 0);
			}
			inputStream.close();
		} catch(IOException ex) {
			
		}
		
		//Set the radio buttons to their desired values
		choice1 = new JRadioButton("Hillary Clinton");
		choice1.setActionCommand("Hillary Clinton");
		choice2 = new JRadioButton("Bernie Sanders");
		choice1.setActionCommand("Bernie Sanders");
		choice3 = new JRadioButton("Donald Trump");
		choice1.setActionCommand("Donald Trump");
		choice4 = new JRadioButton("Ted Cruz");
		choice1.setActionCommand("Ted Cruz");
		
		//Group the radio buttons so that only one can be checked at a time.
		group.add(choice1);
		group.add(choice2);
		group.add(choice3);
		group.add(choice4);
		
		//Add listeners for all of the buttons
		button.addActionListener(buttonListener());
		choice1.addActionListener(choiceListener());
		choice2.addActionListener(choiceListener());
		choice3.addActionListener(choiceListener());
		choice4.addActionListener(choiceListener());		
		
		//Add each component to the panel
		panel.add(label);
		panel.add(firstName);
		panel.add(lastName);
		panel.add(button);
		panel.add(choice1);
		panel.add(choice2);
		panel.add(choice3);
		panel.add(choice4);
		
	}
	
	public Component getContent() {
		
		return panel;
	}
	
	private ActionListener buttonListener() {
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				//Make sure the user has voted for someone
				if(choice == "") {
					label.setText("Please select someone to vote for");
				}
				//Checks if the user has already voted
				else if(map.containsKey(lastName.getText() + "_" + firstName.getText())) {
					label.setText("This person has already voted.");
				}
				
				else {
					map.put(lastName.getText() + "_" + firstName.getText(), 0);
			
					FileWriter outputStream = null;
					FileWriter voterStream = null;
					
					try {
						
						outputStream = new FileWriter(lastName.getText() + "_" + firstName.getText() + "_ballot.txt");
						voterStream = new FileWriter("voters.txt", true);
						
						outputStream.write(choice);
						voterStream.write(lastName.getText()+ "_" + firstName.getText()+"\n");
						outputStream.close();
						voterStream.close();
						
					} catch(IOException ex) {
					
					}
					
					label.setText("Your ballot has been cast, " + firstName.getText() + " " + lastName.getText());
					
				}
			}
		};
		
		return listener;
		
	}
	
	private ActionListener choiceListener() {
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				//Set the choice to the command of the pressed button
				choice = e.getActionCommand();
			}
		};
		
		return listener;
		
	}
}
