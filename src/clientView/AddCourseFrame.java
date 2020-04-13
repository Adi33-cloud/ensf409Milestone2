package clientView;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddCourseFrame extends JFrame {
		private String course;
		private String courseId;
		private String courseSection;
		private JFrame inputFrame;
		private JPanel inputPanel;
		private JLabel label;
		private JLabel label2;
		private JLabel label3;
		private JTextField userInputCourse;
		private JTextField userInputCourseId;
		private JTextField userInputCourseSection;
		private JTextArea textArea;
		
		public AddCourseFrame() {
			
			inputFrame= new JFrame("Add Course To Student Courses");
			inputPanel = new JPanel();
			label = new JLabel("Please enter the Course you want to add: ");
			label2= new JLabel("Please enter the Course number");
			label3= new JLabel("Please enter the Course section you want to add");
			userInputCourse = new JTextField(20);
			userInputCourseId= new JTextField(20);
			userInputCourseSection= new JTextField(20);
			textArea= new JTextArea(1,50);
			
			inputPanel.add(label);
			inputPanel.add(userInputCourse);
			inputPanel.add(label2);
			inputPanel.add(userInputCourseId);
			inputPanel.add(label3);
			inputPanel.add(userInputCourseSection);
			inputPanel.add(textArea);
			inputFrame.add(inputPanel);
			
			inputFrame.pack();
			userInputCourse.setVisible(true);
			userInputCourseId.setVisible(true);
			userInputCourseSection.setVisible(true);
			inputFrame.setVisible(true);
			
			userInputCourse.addActionListener((ActionEvent a) -> {
				course=userInputCourse.getText();
				courseId = userInputCourseId.getText();
				courseSection= userInputCourseSection.getText();
				
				textArea.setText(course +" "+ courseId+" section "+ courseSection+  " was added");
	});


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

		
}
