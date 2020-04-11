package clientView;

import java.awt.BorderLayout;
import java.io.BufferedReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;



public class MainFrame extends JFrame {

	private JButton b1,b2,b3,b4,b5,b6; //buttons for the GUI
	private BufferedReader scan; 
	
	public MainFrame() {
		
		b1= new JButton("Search catalogue courses");
		b2= new JButton("Add course to student course");
		b3 = new JButton("Remove course from student course");
		b4= new JButton("View All courses in catalogue");
		b5 = new JButton("View all courses taken by student");
		b6 = new JButton("Quit");
		
		setTitle("Main Window");
		setSize(250, 250);
		
		JPanel buttonPanel= new JPanel();
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		buttonPanel.add(b5);
		buttonPanel.add(b6);

		setLayout(new BorderLayout());
		add("Center", getContentPane().add(buttonPanel));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		b1.addActionListener((ActionEvent e)->{
			new SearchCatCoursesFrame();
		});
		
		b2.addActionListener((ActionEvent e)->{
			new AddCourseFrame();
		});
		
		b3.addActionListener((ActionEvent e)->{
			new RemoveCourseFrame();
		});
		
		b4.addActionListener((ActionEvent e)->{
			new ViewCatalogueFrame();
		});
		
		b5.addActionListener((ActionEvent e)->{
			new ViewStudentCoursesFrame();
		});
		
		b6.addActionListener((ActionEvent e)->{
			System.exit(0);
	});

		
		
}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
