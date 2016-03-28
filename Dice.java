import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.util.Random;

public class Dice {

	private JPanel panel;
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private JLabel display;
	
	public Dice() {
		
		panel = new JPanel();
		button = new JButton("Roll");
		textField = new JTextField(3);
		label = new JLabel("Enter the number of sides for the die:  ");
		display = new JLabel("                                ");
		//display.setVerticalTextPosition(JLabel.BOTTOM);
		
		button.addActionListener(buttonListener());
		
		panel.add(label);
		panel.add(textField);
		panel.add(button);
		panel.add(display);
	}
	
	public Component getContent() {
		
		return(panel);
	}
	
	private ActionListener buttonListener() {
		
		ActionListener listener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String input = textField.getText();
				int value = Integer.parseInt(input);
				Random generator = new Random();
				String result = "Your result: " + (generator.nextInt(value) + 1);
				
				display.setText(result);
				
			}
		};
		
		return listener;
	}
	
}
