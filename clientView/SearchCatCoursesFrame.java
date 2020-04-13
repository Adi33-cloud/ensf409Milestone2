package clientView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SearchCatCoursesFrame extends JFrame {
	private String course;
	private String courseId;
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JLabel label2;
	private JTextField userInput;
	private JTextField userInputCourseId;
	private JTextArea textArea;
	
	public SearchCatCoursesFrame() {
		
		inputFrame= new JFrame("Search Course Catalouge");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the Course name: ");
		label2 = new JLabel("Please enter the Course Id: ");
		userInput = new JTextField(20);
		userInputCourseId= new JTextField(20);
		textArea= new JTextArea(1,50);
		inputPanel.setLayout(new FlowLayout());
		
		inputPanel.add(label);
		inputPanel.add(userInput);
		inputPanel.add(label2);
		inputPanel.add(userInputCourseId);
		inputPanel.add(textArea);
		inputFrame.add(inputPanel);
		
		inputFrame.pack();
		userInput.setVisible(true);
		userInputCourseId.setVisible(true);
		inputFrame.setVisible(true);
		
		userInput.addActionListener((ActionEvent a) -> {
			course=userInput.getText();
			courseId= userInputCourseId.getText();
			textArea.setText("The course you entered was "+ course + " " + courseId);
			
});


	}

	public String getCourse() {
		return course;
	}
	
	public String getCourseId() {
		return courseId;
	}

}

 
