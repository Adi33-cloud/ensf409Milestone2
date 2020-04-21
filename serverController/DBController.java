package serverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import clientModel.Student;
import serverModel.Course;
import serverModel.CourseCatalogue;

public class DBController implements Runnable {
	private ServerCom serverCom;
	private CourseCatalogue cat;
	private Student student;
	private PrintWriter socketOut;
	private BufferedReader socketIn;

	public DBController(String studentName, int StudentId, ServerCom serverCom, BufferedReader in, PrintWriter out) {
		cat = new CourseCatalogue();
		student = new Student(studentName, StudentId);
		student.setOfferingList(cat.getOfferingList());
		this.serverCom = serverCom;
		this.socketOut = out;
		this.socketIn = in;
	}

	@Override
	public void run() {
		update();
	}

	public void update() {
		int option = -1;
		String line = "";
		String[] words;
		try {
			line = socketIn.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		words = line.split(";");
		student = cat.getDb().searchStudent(Integer.parseInt(words[1]));
		System.out.println("Welcome " + student.getStudentName());
		try {
			while (true) {
				line = socketIn.readLine();
				words = line.split(";");
				if (line != null && !line.isEmpty()) {
					try {
						option = Integer.parseInt(words[0]);
						serverCom.update(option, words);
						// theDB.update();
						String response = selection(option);
						System.out.println(response);
						socketOut.println(response);
					} catch (NumberFormatException e) {
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String selection(int option) {
		switch (option) {
		case 1:
			return searchCourse(serverCom.getCourseName(), serverCom.getCourseId());
		case 2:
			return addCourse(serverCom.getCourseName(), serverCom.getCourseId(), serverCom.getSection(),
					serverCom.getsqlId());
		case 3:
			return removeCourse(serverCom.getCourseName(), serverCom.getCourseId());
		case 4:
			return printCatalogue();
		case 5:
			return printStudentCourses(serverCom.getStudentId());

		default:
			return "Invalid input. Try again.";
		}

	}

	private String addCourse(String courseName, int courseId, int section, int sqlId) {
		String theString = student.addCourse(courseName, courseId, section, sqlId);
		String[] words = theString.split(";");
		if(words.length>1) {
			cat.getDb().addCourse(student, Integer.parseInt(words[1]));
			return words[2];
		}else return words[0];
	}

	public String searchCourse(String courseName, int courseNumber) {

		Course theCourse = cat.searchCat(courseName, courseNumber);
		if (theCourse != null)
			return theCourse.toString();
		else
			return null;
	}

	/*
	 * public String addCourse(String courseName, int courseNumber) {
	 * if(student.checkCourseAmount() == false) { return
	 * "You can only take a maximum of 6 courses, you can't take any more courses right now"
	 * ; } else { Course theCourse= cat.searchCat(courseName, courseNumber);
	 * if(theCourse!= null) { student.addCourse(theCourse); } return
	 * theCourse.getCourseName() + " " + theCourse.getCourseNum () +
	 * "has been added"; } }
	 */

	public String removeCourse(String courseName, int courseNumber) {
		String theString = student.removeCourse(courseName, courseNumber);
		String[] words = theString.split(";");
		if(words.length>1) {
			cat.getDb().removeCourse(student, words[0], Integer.parseInt(words[1]));
			return words[2];
		}else return words[0];
	}

	public String printCatalogue() {
		return cat.toString();
	}

	public String printStudentCourses(int i) {
		return cat.getDb().searchStudent(i).printCourses();
	}

	public PrintWriter getOutput() {
		return socketOut;
	}

	public void setOutput(PrintWriter output) {
		this.socketOut = output;
	}

}
