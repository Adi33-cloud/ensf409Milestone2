package clientView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Vanessa Chen, Aditya Raj, Logan Boras
 * @version 1.0
 * 
 *          A class to display the adding course screen for the user
 *
 */
public class AddCourseFrame extends JFrame {
	private String course;
	private String courseId;
	private String courseSection;
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JButton addButton;
	private JTextField userInputCourse;
	private JTextField userInputCourseId;
	private JTextField userInputCourseSection;
	private JTextArea textArea;

	/**
	 * constructor method for the class, initializes GUI frame and displays it
	 */
	public AddCourseFrame() {

		inputFrame = new JFrame("Add Course To Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the Course you want to add: ");
		label2 = new JLabel("Please enter the Course number");
		label3 = new JLabel("Please enter the Course section you want to add");
		addButton = new JButton("ADD");
		userInputCourse = new JTextField(20);
		userInputCourseId = new JTextField(20);
		userInputCourseSection = new JTextField(20);
		textArea = new JTextArea(10, 25);

		inputPanel.add(label);
		inputPanel.add(userInputCourse);
		inputPanel.add(label2);
		inputPanel.add(userInputCourseId);
		inputPanel.add(label3);
		inputPanel.add(userInputCourseSection);
		inputPanel.add(addButton);
		inputPanel.add(textArea);
		inputFrame.add(inputPanel);

		inputFrame.setSize(300, 300);
		userInputCourse.setVisible(true);
		userInputCourseId.setVisible(true);
		userInputCourseSection.setVisible(true);
		inputFrame.setVisible(true);

	}

	// getters and setters
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

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

	public JTextField getUserInputCourse() {
		return userInputCourse;
	}

	public void setUserInputCourse(JTextField userInputCourse) {
		this.userInputCourse = userInputCourse;
	}

	public JTextField getUserInputCourseId() {
		return userInputCourseId;
	}

	public void setUserInputCourseId(JTextField userInputCourseId) {
		this.userInputCourseId = userInputCourseId;
	}

	public JTextField getUserInputCourseSection() {
		return userInputCourseSection;
	}

	public void setUserInputCourseSection(JTextField userInputCourseSection) {
		this.userInputCourseSection = userInputCourseSection;
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

	public void setCourseSection(String courseSection) {
		this.courseSection = courseSection;
	}

	public String getCourse() {
		return course;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseSection() {
		return courseSection;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

}
