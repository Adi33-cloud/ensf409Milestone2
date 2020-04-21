package clientController;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JTextField;

import clientModel.Student;
import clientView.AddCourseFrame;
import clientView.LoginFrame;
import clientView.MainFrame;
import clientView.RemoveCourseFrame;
import clientView.SearchCatCoursesFrame;
import clientView.ViewCatalogueFrame;
import clientView.ViewStudentCoursesFrame;

/**
 * 
 * @author Logan Boras, Aditya Raj, Vanessa Chen
 * 
 *         The purpose of this class is to implement a GUI for the user, in
 *         order for the user to be able to navigate the application easily.
 */
public class GUIController implements Runnable {
	private ClientCom clientCom; // need this?
	private Student student; // need this?
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
	private BufferedReader socketIn; // need this?
	private PrintWriter socketOut;

	/**
	 * 
	 * @param in  the input reader to be initialized
	 * @param out the output writer to be initialized
	 */
	public GUIController(BufferedReader in, PrintWriter out) {
		socketIn = in;
		socketOut = out;
	}

	/**
	 * Initialization function,creates different buttons and panes and opens the GUI
	 * for the user.
	 */
	private void initialize() {
		main = new MainFrame();
		main.getB1().addActionListener((ActionEvent e) -> {
			option1 = new SearchCatCoursesFrame();
			JTextField theField = option1.getUserInputCourseId();
			theField.addActionListener((ActionEvent a) -> {
				option1.setCourse(option1.getuserInput().getText());
				option1.setCourseId(option1.getUserInputCourseId().getText());
				option1.getTextArea()
						.setText("The course you entered was " + option1.getCourse() + " " + option1.getCourseId());
				name = option1.getCourse();
				id = Integer.parseInt(option1.getCourseId());
				setOption("1");
				socketOut.println("1" + ";" + name + ";" + id);
			});

		});

		main.getB2().addActionListener((ActionEvent e) -> {
			option2 = new AddCourseFrame();

			JButton theButton = option2.getAddButton();
			theButton.addActionListener(ae -> {
				option2.setCourse(option2.getUserInputCourse().getText());
				option2.setCourseId(option2.getUserInputCourseId().getText());
				option2.setCourseSection(option2.getUserInputCourseSection().getText());
				name = option2.getCourse();
				id = Integer.parseInt(option2.getCourseId());
				section = Integer.parseInt(option2.getCourseSection());
				setOption("2");
				socketOut.println("2;" + name + ";" + id + ";" + section);
			});
		});

		main.getB3().addActionListener((ActionEvent e) -> {
			option3 = new RemoveCourseFrame();

			JButton theButton = option3.getRemoveButton();
			theButton.addActionListener(ae -> {
				option3.setCourse(option3.getUserInput().getText());
				option3.setCourseId(option3.getUserInputCourseId().getText());
				id = Integer.parseInt(option3.getCourseId());
				section = 0;
				name = option3.getCourse();
				setOption("3");
				socketOut.println("3;" + name + ";" + id + ";" + section);
			});
		});

		main.getB4().addActionListener((ActionEvent e) -> {
			option4 = new ViewCatalogueFrame();

			name = null;
			id = 0;
			section = 0;
			setOption("4");
			socketOut.println("4");
		});

		main.getB5().addActionListener((ActionEvent e) -> {
			option5 = new ViewStudentCoursesFrame();

			JButton theButton = option5.getSearchButton();
			theButton.addActionListener(ae -> {
				option5.setId(option5.getUserInput().getText());
				option5.getTextArea().setText("");
				name = null;
				id = Integer.parseInt(option5.getId());
				section = 0;
				setOption("5");
				socketOut.println("5;" + id);
			});

		});

		main.getB6().addActionListener((ActionEvent e) -> {
			main.dispose();
			LoginFrame login = new LoginFrame();
			login.getLogin().addActionListener(ae -> initialize());
			setOption("6");
			socketOut.println("6");
		});

	}

	/**
	 * 
	 * @param theData a display function that is implemented differently depending
	 *                on the button pressed by the user.
	 */
	public void display(String theData) {
		switch (Integer.parseInt(option)) {
		case 1:
			option1.getTextArea().append(theData + "\n");
			break;
		case 2:
			option2.getTextArea().append(theData + "\n");
			break;
		case 3:
			option3.getTextArea().append(theData + "\n");
			break;
		case 4:
			option4.getTextArea().append(theData + "\n");
			System.out.println(theData.length());
			break;
		case 5:
			option5.getTextArea().append(theData + "\n");
			break;
		case 6:

		default:
			System.out.println("oops");

		}
	}

	@Override
	public void run() {
		login = new LoginFrame();
		login.getLogin().addActionListener((ActionEvent a) -> {
			initialize();
			socketOut.println(login.getUserInputStudentName().getText() + ";"
					+ Integer.parseInt(login.getUserInputStudentId().getText()));
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
		this.socketOut = socketOut;
	}

}
