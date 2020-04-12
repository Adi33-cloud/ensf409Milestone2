package clientController;
import java.awt.event.ActionEvent;

import clientView.*;

public class GUIController {
	
	private MainFrame main;
	private String name;
	private String number;

	public GUIController() {
		main = new MainFrame();
		main.getB1().addActionListener((ActionEvent e)->{
			new SearchCatCoursesFrame();
			System.out.print("Works");
		});
		
		main.getB2().addActionListener((ActionEvent e)->{
			new AddCourseFrame();
		});
		
		main.getB3().addActionListener((ActionEvent e)->{
			new RemoveCourseFrame();
		});
		
		main.getB4().addActionListener((ActionEvent e)->{
			new ViewCatalogueFrame();
		});
		
		main.getB5().addActionListener((ActionEvent e)->{
			new ViewStudentCoursesFrame();
		});
		
		main.getB6().addActionListener((ActionEvent e)->{
			System.exit(0);
		});


	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIController();
	}

	
}


