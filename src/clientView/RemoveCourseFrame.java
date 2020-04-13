package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RemoveCourseFrame {
	private String course;
	private String studentId;
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JTextField userInput;
	private JTextArea textArea;
	
	public RemoveCourseFrame() {
		
		inputFrame= new JFrame("Remove Course To Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the Course you want to remove: ");
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
			course= userInput.getText();
			textArea.setText(userInput.getText() + " was removed");
			
});


}

	public String getCourse() {
		return course;
	}

	public String getStudentId() {
		return studentId;
	}

	
}
