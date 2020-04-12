package clientController;
import java.awt.event.ActionEvent;

import clientView.*;

public class GUIController {
	private ClientCom clientCom; // confused as to hoe to use this to send info to the server. 
	private MainFrame main;
	private SearchCatCoursesFrame option1;
	private AddCourseFrame option2;
	private RemoveCourseFrame option3;
	private ViewCatalogueFrame option4;
	private ViewStudentCoursesFrame option5;
	private String name;
	private int id;
	private String option;

	public GUIController() {
		main = new MainFrame();
		main.getB1().addActionListener((ActionEvent e)->{
			option1=new SearchCatCoursesFrame();
			name= option1.getCourse();
			option="1";
		});
		
		main.getB2().addActionListener((ActionEvent e)->{
			option2=new AddCourseFrame();
			name= option2.getCourse();
			id= option2.getId();
			option= "2";

		});
		
		main.getB3().addActionListener((ActionEvent e)->{
			option3=new RemoveCourseFrame();
			name= option3.getCourse();
			id= option3.getCourseId();
			option="3";
		});
		
		main.getB4().addActionListener((ActionEvent e)->{
			option4=new ViewCatalogueFrame();
			option="4";
		});
		
		main.getB5().addActionListener((ActionEvent e)->{
			option5=new ViewStudentCoursesFrame();
			id= option5.getId();
			option="5";
			
		});
		
		main.getB6().addActionListener((ActionEvent e)->{
			System.exit(0);
			option="6";
		});


	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIController();
	}

	
}


