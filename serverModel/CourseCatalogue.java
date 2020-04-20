package serverModel;

import java.util.ArrayList;

public class CourseCatalogue {
private ArrayList <Course> courseList;
private ArrayList <CourseOffering> offeringList;
private DBManager db;
	
	public CourseCatalogue () {
		loadFromDataBase ();
	}
	
	private void loadFromDataBase() {
		db = new DBManager();
		courseList = db.getCourseList();
		offeringList = db.getCourseOfferingList();
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

	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap, c.getCourseId());
			c.addOffering(theOffering);
		}
	}
	
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayCourseNotFoundError();
		return null;
	}
	
	//Typically, methods that are called from other methods of the class
	//are private and are not exposed for use by other classes.
	//These methods are refereed to as helper methods or utility methods
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");
		
	}
	
	public ArrayList <Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			if(c.getClassSize() == true) {
				st += c;  //This line invokes the toString() method of Course
				st += "\n";
			}
			else
				st += c.getCourseName()+" "+c.getCourseNum()+" is not available due to low enrolment.\n";
		}
		return st;
	}

}
