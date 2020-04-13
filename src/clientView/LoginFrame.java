package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	public String getStudentName() {
		return studentName;
	}

	public String getStudentId() {
		return studentId;
	}
	

}
