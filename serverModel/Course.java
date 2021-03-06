package serverModel;

import java.util.ArrayList;

import clientModel.Student;

/**
 * 
 * @author Logan Boras, Aditya Raj, Vanessa CHen
 * 
 *         Data class for a students course
 */
public class Course {
	private String courseName;
	private int courseNum;
	private ArrayList<Course> preReq;
	private ArrayList<CourseOffering> offeringList;
	private int courseId;

	/**
	 * Constructor class for the course
	 * 
	 * @param courseName name of the course (e.g. ENSF)
	 * @param courseNum  course number
	 */
	public Course(String courseName, int courseNum, int id) {
		this.setCourseName(courseName);
		this.setCourseNum(courseNum);
		this.courseId = id;
		// Both of the following are only association
		preReq = new ArrayList<Course>();
		offeringList = new ArrayList<CourseOffering>();
	}

	/**
	 * Adds a course offering to the course
	 * 
	 * @param offering offering to be added
	 */
	public void addOffering(CourseOffering offering) {
		if (offering != null) {
			if (!offering.getTheCourse().getCourseName().equals(courseName)
					|| offering.getTheCourse().getCourseNum() != courseNum) {
				return;
			}

			offeringList.add(offering);
		}
	}

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

	@Override
	public String toString() {
		String st = "\n";
		st += getCourseName() + " " + getCourseNum();
		st += "\nAll course sections:\n";
		for (CourseOffering c : offeringList)
			st += c;
		st += "\n-------\n";
		return st;
	}

	/**
	 * Gets the course offering in the offeringList at index i.
	 * 
	 * @param i
	 * @return the course offering at index i
	 */
	public CourseOffering getCourseOfferingAt(int i) {
		if (i < 0 || i >= offeringList.size())
			return null;
		else
			return offeringList.get(i);
	}

	/**
	 * Adds pre-requisite courses to the preReq ArrayList.
	 * 
	 * @param c
	 */
	public void addPreReq(Course c) {
		preReq.add(c);
	}

	/**
	 * Checks if the Student s has completed the pre-requisites.
	 * 
	 * @param s
	 * @return
	 */
	public boolean checkPreReq(Student s) {
		int i, count = 0;
		for (i = 0; i < preReq.size(); i++) {
			for (CourseOffering c : s.getOfferingList()) {
				if (preReq.get(i) == c.getTheCourse())
					count++;
			}
		}
		if (count == i)
			return true;
		return false;
	}

	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}

	public boolean getClassSize() {
		int sum = 0;
		for (CourseOffering c : offeringList)
			sum += c.getStudentList().size();
		if (sum >= 8)
			return true;
		return false;
	}

	public ArrayList<Course> getPreReq() {
		return preReq;
	}

	public void setPreReq(ArrayList<Course> preReq) {
		this.preReq = preReq;
	}

	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int id) {
		courseId = id;
	}

}
