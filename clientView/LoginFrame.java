package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Vanessa Chen, Aditya Raj, Logan Boras
 * @version 1.0
 * 
 * A class to display the initial login screen of the GUI
 *
 */
public class LoginFrame {
	private String studentName;
	private String studentId;
	private JFrame inputFrame;
	private JPanel inputPanel;
	private JLabel label;
	private JLabel label2;
	private JTextField userInputStudentName;
	private JTextField userInputStudentId;
	private JButton login;
	
	/**
	 * constructor method for the class, initializes GUI frame and displays it
	 */
	public LoginFrame() {
		login = new JButton("Login");
		inputFrame= new JFrame("Add Course To Student Courses");
		inputPanel = new JPanel();
		label = new JLabel("Student Name: ");
		label2= new JLabel("Student ID: ");
		userInputStudentName = new JTextField(10);
		userInputStudentId= new JTextField(10);
		
		inputPanel.add(label);
		inputPanel.add(userInputStudentName);
		inputPanel.add(label2);
		inputPanel.add(userInputStudentId);
		inputPanel.add(login);
		inputFrame.add(inputPanel);
		
		inputFrame.pack();
		userInputStudentName.setVisible(true);
		userInputStudentId.setVisible(true);
		inputFrame.setVisible(true);
		
		userInputStudentName.addActionListener((ActionEvent a) -> {
			studentName= userInputStudentName.getText();
			
		});
		
		userInputStudentId.addActionListener((ActionEvent a) -> {
			studentId= userInputStudentId.getText();
			
		});
		
		login.addActionListener((ActionEvent a) -> {
			inputFrame.dispose();		
		});
		


	}
	
	//getters and setters
	public JTextField getUserInputStudentName() {
		return userInputStudentName;
	}

	public void setUserInputStudentName(JTextField userInputStudentName) {
		this.userInputStudentName = userInputStudentName;
	}

	public JTextField getUserInputStudentId() {
		return userInputStudentId;
	}

	public void setUserInputStudentId(JTextField userInputStudentId) {
		this.userInputStudentId = userInputStudentId;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentId() {
		return studentId;
	}
	

}
