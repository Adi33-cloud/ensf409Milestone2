package clientView;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SearchCatCoursesFrame extends JFrame {
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JTextField userInput;
	private JTextArea textArea;
	
	public SearchCatCoursesFrame() {
		
		inputFrame= new JFrame("Search Course Catalouge");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the Course: ");
		userInput = new JTextField(20);
		textArea= new JTextArea(1,50);
		
		inputPanel.add(label);
		inputPanel.add(userInput);
		inputPanel.add(textArea);
		inputFrame.add(inputPanel);
		
		inputFrame.pack();
		userInput.setVisible(true);
		inputFrame.setVisible(true);
		
		userInput.addActionListener((ActionEvent a) -> {
			textArea.setText("The course you entered was "+ userInput.getText());
});


	}
}

 