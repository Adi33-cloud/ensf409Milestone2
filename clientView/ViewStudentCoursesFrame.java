package clientView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Aditya Raj, Vanessa Chen, Logan Boras
 * @version 1.0
 * 
 *          A class to display the option of viewing all of the courses in a
 *          student's list
 *
 */
public class ViewStudentCoursesFrame {
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JButton searchButton;

	private JTextField userInput;
	private JTextArea textArea;
	private String id;

	/**
	 * Constructor class to initialize the GUI frame and display it
	 */
	public ViewStudentCoursesFrame() {
		inputFrame = new JFrame("Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Please enter the ID of the student you want to see the courses for: ");
		userInput = new JTextField(20);
		textArea = new JTextArea(50, 50);
		searchButton = new JButton("SEARCH");

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);

		inputPanel.add(label);
		inputPanel.add(userInput);
		inputPanel.add(searchButton);
		inputFrame.add(inputPanel);
		inputPanel.add(scrollPane);

		inputFrame.pack();
		userInput.setVisible(true);
		inputFrame.setVisible(true);

	}

	// Getters and setters
	public String getId() {
		return id;
	}

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

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton viewButton) {
		this.searchButton = viewButton;
	}

	public JTextField getUserInput() {
		return userInput;
	}

	public void setUserInput(JTextField userInput) {
		this.userInput = userInput;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void setId(String id) {
		this.id = id;
	}

}
