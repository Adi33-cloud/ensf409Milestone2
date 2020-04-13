package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RemoveCourseFrame {
	private String course;
	private String courseId;
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JLabel label2;
	private JTextField userInput;
	private JTextField userInputCourseId;
	private JTextArea textArea;
	
	public RemoveCourseFrame() {
		
		inputFrame= new JFrame("Remove Course To Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the Course name you want to remove: ");
		userInput = new JTextField(10);
		label2= new JLabel("Please enter the Course ID number");
		userInputCourseId= new JTextField(10);
		textArea= new JTextArea(1,30);
		
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
			course= userInput.getText();
			courseId= userInputCourseId.getText();
			textArea.setText(course +" "+ courseId+  " was removed");
			
});


}

	public String getCourse() {
		return course;
	}

	public String getCourseId() {
		return courseId;
	}

	
}
