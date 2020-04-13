package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddCourseFrame extends JFrame {
		private String course;
		private String id;
		private JFrame inputFrame;
		private JPanel inputPanel;
		private JLabel label;
		private JTextField userInput;
		private JTextArea textArea;
		
		public AddCourseFrame() {
			
			inputFrame= new JFrame("Add Course To Student Courses");
			inputPanel = new JPanel();
			label = new JLabel("Please enter the Course you want to add: ");
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
				course=userInput.getText();
				textArea.setText(userInput.getText() + " was added");
	});


	}

		public String getCourse() {
			return course;
		}

		public String getId() {
			return id;
		}

		
}
