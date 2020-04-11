package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewStudentCoursesFrame {
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JTextField userInput;
	private JTextArea textArea;
	
	public ViewStudentCoursesFrame() {
		
		inputFrame= new JFrame("Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the ID of the student you want to see the courses for: ");
		userInput = new JTextField(20);
		textArea= new JTextArea(50,50);
		
		inputPanel.add(label);
		inputPanel.add(userInput);
		inputPanel.add(textArea);
		inputFrame.add(inputPanel);
		
		inputFrame.pack();
		userInput.setVisible(true);
		inputFrame.setVisible(true);
		
		userInput.addActionListener((ActionEvent a) -> {
			textArea.setText(" Default Courses\n ensf409 \n math271 \n your mom \n Logans dad (DILF)");
});


}


}
