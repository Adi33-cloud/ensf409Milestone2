package serverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import clientModel.Student;
import serverModel.Course;
import serverModel.CourseCatalogue;

/**
 * 
 * @author Logan Boras, Vanessa Chen, Aditya Raj
 *
 *         This class is the controller for the database.
 */

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

	/**
	 * Method to communicate via sockets with the server. Uses selection to send the
	 * output via sockets to the server, and be displayed to the client's GUI.
	 */
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

	/**
	 * Takes the selection from update to execute the user's command, and return a
	 * String to be displayed to the client's GUI.
	 * 
	 * @param option
	 * @return the response to the user's command
	 */
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

	/**
	 * Adds a course to the student's registration, and to the SQL database.
	 * 
	 * @param courseName
	 * @param courseId
	 * @param section
	 * @param sqlId
	 * @return a String as to whether or not the course was successfully added
	 */
	private String addCourse(String courseName, int courseId, int section, int sqlId) {
		String theString = student.addCourse(courseName, courseId, section, sqlId);
		String[] words = theString.split(";");
		if (words.length > 1) {
			cat.getDb().addCourse(student, Integer.parseInt(words[1]));
			return words[2];
		} else
			return words[0];
	}

	/**
	 * Searches for a course using the entered name and number of the course.
	 * 
	 * @param courseName
	 * @param courseNumber
	 * @return null if the course is not found, or the toString of the specified
	 *         course
	 */
	public String searchCourse(String courseName, int courseNumber) {

		Course theCourse = cat.searchCat(courseName, courseNumber);
		if (theCourse != null)
			return theCourse.toString();
		else
			return null;
	}

	/**
	 * Removes a course from the student's registration list and the SQL database.
	 * 
	 * @param courseName
	 * @param courseNumber
	 * @return a String as to whether or not the course was successfully removed
	 */
	public String removeCourse(String courseName, int courseNumber) {
		String theString = student.removeCourse(courseName, courseNumber);
		String[] words = theString.split(";");
		if (words.length > 1) {
			cat.getDb().removeCourse(student, words[0], Integer.parseInt(words[1]));
			return words[2];
		} else
			return words[0];
	}

	/**
	 * Calls the toString of the catalogue to print all the courses in the
	 * catalogue.
	 * 
	 * @return a String of all the courses in the catalogue
	 */
	public String printCatalogue() {
		return cat.toString();
	}

	/**
	 * Prints all the courses and sections of the course that the student is
	 * registered in.
	 * 
	 * @param i
	 * @return a String of all the courses the student is registered in
	 */
	public String printStudentCourses(int i) {
		return cat.getDb().searchStudent(i).printCourses();
	}

	// Getters and setters
	public PrintWriter getOutput() {
		return socketOut;
	}

	public void setOutput(PrintWriter output) {
		this.socketOut = output;
	}

}
