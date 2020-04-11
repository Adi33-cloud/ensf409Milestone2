package clientView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;



public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setSize(350, 400);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		setLayout(new GridLayout(6,0));
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
