package clientModel;

import java.util.ArrayList;

/**
 * 
 * @author Logan Boras, Aditya Raj, Vanessa CHen
 * 
 * Data class for a students course
 */
public class Course {
	private String courseName;
	private int courseNum;
	private ArrayList<Course> preReq;
	private ArrayList<CourseOffering> offeringList;
	
	/**
	 * constructor class for the course
	 * @param courseName name of the course (e.g. ENSF) 
	 * @param courseNum course number
	 */
	public Course(String courseName, int courseNum) {
		this.setCourseName(courseName);
		this.setCourseNum(courseNum);
		// Both of the following are only association
		preReq = new ArrayList<Course>();
		offeringList = new ArrayList<CourseOffering>();
	}
	
	/**
	 * adds a course offering to the course
	 * @param offering offering to be added
	 */
	public void addOffering(CourseOffering offering) {
		if (offering != null && offering.getTheCourse() == null) {
			offering.setTheCourse(this);
			if (!offering.getTheCourse().getCourseName().equals(courseName)
					|| offering.getTheCourse().getCourseNum() != courseNum) {
				System.err.println("Error! This section belongs to another course!");
				return;
			}
			
			offeringList.add(offering);
		}
	}
	
	/**
	 * Converts the course data into a string to be printed
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += getCourseName() + " " + getCourseNum ();
		st += "\nAll course sections:\n";
		for (CourseOffering c : offeringList)
			st += c;
		st += "\n-------\n";
		return st;
	}
	
	/**
	 * checks if a student has all needed prerequisites
	 * @param s student whose prerequisites are to be checked
	 * @return returns true if the student has the prerequisite
	 */
	public boolean checkPreReq(Student s) {
		int i, count = 0;
		for(i = 0; i < preReq.size(); i++) {
			for(CourseOffering c: s.getOfferingList()) {
				if(preReq.get(i) == c.getTheCourse())
					count++;
			}
		}
		if(count == i)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return returns the amount of students in the class
	 */
	public boolean getClassSize() {
		int sum = 0;
		for(CourseOffering c : offeringList)
			sum += c.getStudentList().size();
		if(sum >= 8)
			return true;
		return false;
	}
	
	// getters and setters
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public ArrayList<Course> getPreReq() {
		return preReq;
	}

	public void setPreReq(ArrayList<Course> preReq) {
		this.preReq = preReq;
	}

	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}

	public CourseOffering getCourseOfferingAt(int i) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= offeringList.size() )
			return null;
		else
			return offeringList.get(i);
	}
	
	public void addPreReq(Course c) {
		preReq.add(c);
	}
	

}
