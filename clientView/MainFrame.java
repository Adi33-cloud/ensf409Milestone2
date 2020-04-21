package clientView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Vanessa Chen, Aditya Raj, Logan Boras
 * @version 1.0
 * 
 * A main JFrame for the GUI application. 
 * It implements multiple buttons to present options to the user
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton b1,b2,b3,b4,b5,b6; //buttons for the GUI
	private BufferedReader scan; 
	
	/**
	 * Constructor class that creates the frame and adds buttons
	 */
	public MainFrame() {
		
		b1= new JButton("Search catalogue courses");
		b2= new JButton("Add course to student course");
		b3 = new JButton("Remove course from student course");
		b4= new JButton("View All courses in catalogue");
		b5 = new JButton("View all courses taken by student");
		b6 = new JButton("Logout");
		
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
		
		/*b1.addActionListener((ActionEvent e)->{
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
	});*/

		
		
}
	
	
	
	public JButton getB1() {
		return b1;
	}



	public void setB1(JButton b1) {
		this.b1 = b1;
	}



	public JButton getB2() {
		return b2;
	}



	public void setB2(JButton b2) {
		this.b2 = b2;
	}



	public JButton getB3() {
		return b3;
	}



	public void setB3(JButton b3) {
		this.b3 = b3;
	}



	public JButton getB4() {
		return b4;
	}



	public void setB4(JButton b4) {
		this.b4 = b4;
	}



	public JButton getB5() {
		return b5;
	}



	public void setB5(JButton b5) {
		this.b5 = b5;
	}



	public JButton getB6() {
		return b6;
	}



	public void setB6(JButton b6) {
		this.b6 = b6;
	}



	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}*/

}
