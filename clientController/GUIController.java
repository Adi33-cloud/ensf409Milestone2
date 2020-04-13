package clientController;
import java.awt.event.ActionEvent;

import clientModel.Student;
import clientView.*;

public class GUIController {
	private ClientCom clientCom; // confused as to hoe to use this to send info to the server. 
	private Student student;
	private LoginFrame login;
	private MainFrame main;
	private SearchCatCoursesFrame option1;
	private AddCourseFrame option2;
	private RemoveCourseFrame option3;
	private ViewCatalogueFrame option4;
	private ViewStudentCoursesFrame option5;
	private String name;
	private int id;
	private int section;
	private String option;

	public GUIController() {
		login= new LoginFrame();
		login.getLogin().addActionListener((ActionEvent a) -> {
			student=new Student(login.getUserInputStudentName().getText(),Integer.parseInt(login.getUserInputStudentId().getText()));
			initialize();
		});
	}
	
	private void initialize() {
		main = new MainFrame();
		main.getB1().addActionListener((ActionEvent e)->{
			option1=new SearchCatCoursesFrame();
			name= option1.getCourse();
			id = Integer.parseInt(option1.getCourseId()); 
			option="1";
		});
		
		main.getB2().addActionListener((ActionEvent e)->{
			option2=new AddCourseFrame();
			name= option2.getCourse();
			id= Integer.parseInt(option2.getCourseId());
			section=Integer.parseInt(option2.getCourseSection());
			option= "2";

		});
		
		main.getB3().addActionListener((ActionEvent e)->{
			option3=new RemoveCourseFrame();
			name= option3.getCourse();
			id= Integer.parseInt(option3.getCourseId());
			section= 0;
			option="3";
		});
		
		main.getB4().addActionListener((ActionEvent e)->{
			option4=new ViewCatalogueFrame();
			name=null;
			id=0;
			section=0;
			option="4";
		});
		
		main.getB5().addActionListener((ActionEvent e)->{
			option5=new ViewStudentCoursesFrame();
			name=null;
			id= Integer.parseInt(option5.getId());
			section=0;
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


