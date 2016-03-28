import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;

public class SafeConverter 
{
	private JPanel panel;
	private JButton FtoC;
	private JButton CtoF;
	private JButton FtoK;
	private JButton KtoF;
	private JButton CtoK;
	private JButton KtoC;
	private JTextField text;
	private JLabel label;
	
	public SafeConverter()
	{
		panel = new JPanel();
		FtoC = new JButton("Convert F to C");
		CtoF = new JButton("Convert C to F");
		FtoK = new JButton("Convert F to K");
		KtoF = new JButton("Convert K to F");
		CtoK = new JButton("Convert C to K");
		KtoC = new JButton("Convert K to C");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature: ");
		
		//Load the listener
		FtoC.addActionListener(FtoCListener());	
		CtoF.addActionListener(CtoFListener());	
		FtoK.addActionListener(FtoKListener());	
		KtoF.addActionListener(KtoFListener());	
		CtoK.addActionListener(CtoKListener());	
		KtoC.addActionListener(KtoCListener());	
		
		//load the panel
		panel.add(label);
		panel.add(text);
		panel.add(FtoC);
		panel.add(CtoF);
		panel.add(FtoK);
		panel.add(KtoF);
		panel.add(CtoK);
		panel.add(KtoC);
		
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener FtoCListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				if(input.isEmpty()) {
					label.setText("The field cannot be empty");
				} 
				
				else {
					
					try {
						double tempInF = Double.parseDouble(input);//convert String to double
						double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
						String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
												       //only display 2 places past decimal
						label.setText(newText);
					
					} catch(NumberFormatException ex) {
						label.setText("The value must be a number");
					}

				}
			}
		};
		
		return listener;
	}	
	
	private ActionListener CtoFListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				if(input.isEmpty()) {
					label.setText("The field cannot be empty");
				} 
				
				else {
					
					try {
						double tempInC = Double.parseDouble(input);//convert String to double
						double tempInF = (tempInC *(9.0/5.0)) + 32; //convert F to C
						String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
												       //only display 2 places past decimal
						label.setText(newText);
					
					} catch(NumberFormatException ex) {
						label.setText("The value must be a number");
					}

				}
			}
		};
		
		return listener;
	}	
	
	private ActionListener FtoKListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				if(input.isEmpty()) {
					label.setText("The field cannot be empty");
				} 
				
				else {
					
					try {
						double tempInF = Double.parseDouble(input);//convert String to double
						double tempInK = (tempInF + 459.67) * (5.0/9.0); //convert F to C
						String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
												       //only display 2 places past decimal
						label.setText(newText);
					
					} catch(NumberFormatException ex) {
						label.setText("The value must be a number");
					}

				}
			}
		};
		
		return listener;
	}	
	
	private ActionListener KtoFListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				if(input.isEmpty()) {
					label.setText("The field cannot be empty");
				} 
				
				else {
					
					try {
						double tempInK = Double.parseDouble(input);//convert String to double
						double tempInF = (tempInK * (9.0/5.0)) - 459.67; //convert F to C
						String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
												       //only display 2 places past decimal
						label.setText(newText);
					
					} catch(NumberFormatException ex) {
						label.setText("The value must be a number");
					}

				}
			}
		};
		
		return listener;
	}	
	
	private ActionListener CtoKListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				if(input.isEmpty()) {
					label.setText("The field cannot be empty");
				} 
				
				else {
					
					try {
						double tempInC = Double.parseDouble(input);//convert String to double
						double tempInK = tempInC + 273.15; //convert F to C
						String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
												       //only display 2 places past decimal
						label.setText(newText);
					
					} catch(NumberFormatException ex) {
						label.setText("The value must be a number");
					}

				}
			}
		};
		
		return listener;
	}	
	
	private ActionListener KtoCListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				if(input.isEmpty()) {
					label.setText("The field cannot be empty");
				} 
				
				else {
					
					try {
						double tempInK = Double.parseDouble(input);//convert String to double
						double tempInC = tempInK - 273.15; //convert F to C
						String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
												       //only display 2 places past decimal
						label.setText(newText);
					
					} catch(NumberFormatException ex) {
						label.setText("The value must be a number");
					}

				}
			}
		};
		
		return listener;
	}	
	
}