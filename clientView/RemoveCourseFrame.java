package clientView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Aditya Raj, Vanessa Chen, Logan Boras
 * @version 1.0
 * 
 *          A class to display the option of removing a course from the
 *          student's list
 *
 */
public class RemoveCourseFrame {
	private String course;
	private String courseId;
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JLabel label2;
	private JButton removeButton;
	private JTextField userInput;
	private JTextField userInputCourseId;
	private JTextArea textArea;

	/**
	 * constructor method for the class, initializes GUI frame and displays it
	 */
	public RemoveCourseFrame() {

		inputFrame = new JFrame("Remove Course To Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the Course name you want to remove: ");
		userInput = new JTextField(10);
		label2 = new JLabel("Please enter the Course ID number");
		userInputCourseId = new JTextField(10);
		textArea = new JTextArea(1, 30);
		removeButton = new JButton("REMOVE");

		inputPanel.add(label);
		inputPanel.add(userInput);
		inputPanel.add(label2);
		inputPanel.add(userInputCourseId);
		inputPanel.add(removeButton);
		inputPanel.add(textArea);
		inputFrame.add(inputPanel);

		inputFrame.pack();
		userInput.setVisible(true);
		userInputCourseId.setVisible(true);
		inputFrame.setVisible(true);

	}

	// getters and setters for the class
	public JFrame getInputFrame() {
		return inputFrame;
	}

	public void setInputFrame(JFrame inputFrame) {
		this.inputFrame = inputFrame;
	}

	public JPanel getInputPanel() {
		return inputPanel;
	}

	public void setInputPanel(JPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}

	public JTextField getUserInput() {
		return userInput;
	}

	public void setUserInput(JTextField userInput) {
		this.userInput = userInput;
	}

	public JTextField getUserInputCourseId() {
		return userInputCourseId;
	}

	public void setUserInputCourseId(JTextField userInputCourseId) {
		this.userInputCourseId = userInputCourseId;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourse() {
		return course;
	}

	public String getCourseId() {
		return courseId;
	}

}
