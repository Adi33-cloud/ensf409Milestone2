package serverModel;

import java.util.ArrayList;

/**
 * 
 * @author Logan Boras, Vanessa Chen, Aditya Raj
 *
 */
public class CourseCatalogue {
	private ArrayList<Course> courseList;
	private ArrayList<CourseOffering> offeringList;
	private DBManager db;

	public CourseCatalogue() {
		loadFromDataBase();
	}

	/**
	 * Loads the courses and offerings from the database.
	 */
	private void loadFromDataBase() {
		db = new DBManager();
		courseList = db.getCourseList();
		offeringList = db.getCourseOfferingList();
	}

	/**
	 * Creates a new course offering.
	 * 
	 * @param c
	 * @param secNum
	 * @param secCap
	 */
	public void createCourseOffering(Course c, int secNum, int secCap) {
		if (c != null) {
			CourseOffering theOffering = new CourseOffering(secNum, secCap, c.getCourseId());
			c.addOffering(theOffering);
		}
	}

	/**
	 * Searches the catalogue for the course with the specified name and number from
	 * the parameters.
	 * 
	 * @param courseName
	 * @param courseNum
	 * @return
	 */
	public Course searchCat(String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) && courseNum == c.getCourseNum()) {
				return c;
			}
		}
		displayCourseNotFoundError();
		return null;
	}

	// Typically, methods that are called from other methods of the class
	// are private and are not exposed for use by other classes.
	// These methods are referred to as helper methods or utility methods
	private void displayCourseNotFoundError() {
		System.err.println("Course was not found!");

	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public DBManager getDb() {
		return db;
	}

	public void setDb(DBManager db) {
		this.db = db;
	}

	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}

	@Override
	public String toString() {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			if (c.getClassSize() == true) {
				st += c; // This line invokes the toString() method of Course
				st += "\n";
			} else
				st += c;
		}
		return st;
	}

}
