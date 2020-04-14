package clientController;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JTextField;

import clientModel.Student;
import clientView.*;

public class GUIController implements Runnable {
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
	private BufferedReader socketIn;
	private PrintWriter socketOut;

	public GUIController(BufferedReader in, PrintWriter out) {
		socketIn = in;
		socketOut = out;
//		login= new LoginFrame();
//		login.getLogin().addActionListener((ActionEvent a) -> {
//			student=new Student(login.getUserInputStudentName().getText(),Integer.parseInt(login.getUserInputStudentId().getText()));
//			initialize();
//		});
	}
	
	private void initialize() {
		main = new MainFrame();
		main.getB1().addActionListener((ActionEvent e)->{
			option1=new SearchCatCoursesFrame();
			JTextField theField = option1.getUserInputCourseId();
			theField.addActionListener((ActionEvent a) -> {
				option1.setCourse(option1.getuserInput().getText());
				option1.setCourseId(option1.getUserInputCourseId().getText());
				option1.getTextArea().setText("The course you entered was "+ option1.getCourse() + " " + option1.getCourseId());
				name= option1.getCourse();
				id = Integer.parseInt(option1.getCourseId()); 
				setOption("1");
				socketOut.println("1");
			});
			
		});
		
		main.getB2().addActionListener((ActionEvent e)->{
			option2=new AddCourseFrame();
			
			JButton theButton = option2.getAddButton();
			theButton.addActionListener(ae->{
				option2.setCourse(option2.getUserInputCourse().getText());
				option2.setCourseId(option2.getUserInputCourseId().getText());
				option2.setCourseSection(option2.getUserInputCourseSection().getText());
				option2.getTextArea().setText(option2.getCourse() +" "+ option2.getCourseId()+" section "+ option2.getCourseSection()+  " was added");
				name= option2.getCourse();
				id= Integer.parseInt(option2.getCourseId());
				section=Integer.parseInt(option2.getCourseSection());
				setOption("2");
				socketOut.println("2");
			});
		});
		
		main.getB3().addActionListener((ActionEvent e)->{
			option3=new RemoveCourseFrame();
			
			JButton theButton = option3.getRemoveButton();
			theButton.addActionListener(ae->{
				option3.setCourse(option3.getUserInput().getText());
				option3.setCourseId(option3.getUserInputCourseId().getText());
				option3.getTextArea().setText(option3.getCourse() +" "+ option3.getCourseId()+  " was removed");
				id= Integer.parseInt(option3.getCourseId());
				section= 0;
				setOption("3");
				socketOut.println("3");
			});
		});
		
		main.getB4().addActionListener((ActionEvent e)->{
			option4=new ViewCatalogueFrame();
			
			name=null;
			id=0;
			section=0;
			setOption("4");
			socketOut.println("4");
		});
		
		main.getB5().addActionListener((ActionEvent e)->{
			option5=new ViewStudentCoursesFrame();
			
			JButton theButton = option5.getSearchButton();
			theButton.addActionListener(ae->{
				option5.setId(option5.getUserInput().getText());
				option5.getTextArea().setText(" Default Courses\n ensf409 \n math271 \n your mom \n Logans dad (DILF)");
				name=null;
				id= Integer.parseInt(option5.getId());
				section=0;
				setOption("5");
				socketOut.println("5");
			});
			

		});
		
		main.getB6().addActionListener((ActionEvent e)->{
			System.exit(0);
			setOption("6");
			socketOut.println("6");
		});
		
	}
	
//	public static void main(String[] args) {
//		new GUIController();
//	}

	@Override
	public void run() {
		//new GUIController();
		login= new LoginFrame();
		login.getLogin().addActionListener((ActionEvent a) -> {
			student=new Student(login.getUserInputStudentName().getText(),Integer.parseInt(login.getUserInputStudentId().getText()));
			initialize();
		});
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	public PrintWriter getSocketOut() {
		return socketOut;
	}

	public void setSocketOut(PrintWriter socketOut) {
		socketOut = socketOut;
	}
	
}


