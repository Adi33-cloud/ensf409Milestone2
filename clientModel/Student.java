package clientModel;

import java.util.ArrayList;
import java.util.Scanner;

import serverModel.CourseOffering;
import serverModel.Registration;

/**
 * 
 * @author Logan Boras, Aditya Raj, Vanessa Chen
 * class to contain the data of a student
 */
public class Student {
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;
	
	/**
	 * constructor class for the student
	 * @param studentName name of the student
	 * @param studentId the student's ID number
	 */
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		offeringList = new ArrayList<CourseOffering>();
		studentRegList = new ArrayList<Registration>();
	}

	public ArrayList<Registration> getStudentRegList() {
		return studentRegList;
	}

	public void setStudentRegList(ArrayList<Registration> studentRegList) {
		this.studentRegList = studentRegList;
	}

	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}
	
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		for(Registration theReg: studentRegList)
			st += theReg.toString();
		return st;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
	}
	
	public void removeRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.remove(registration);
	}
	
	public void addCourseOffering(CourseOffering c) {
		offeringList.add(c);
	}
	
	public void removeCourseOffering(CourseOffering c) {
		offeringList.remove(c);
	}
	
	public CourseOffering searchCourse(String name, int num) {
		for(CourseOffering c: offeringList) {
			if(c.getTheCourse().getCourseName().contentEquals(name) && c.getTheCourse().getCourseNum() == num)
				return c;
		}
		return null;
	}
	
	/**
	 * Searches and returns a course registration from the students list
	 * @param name name of the registered course
	 * @param num course number
	 * @return returns course registration
	 */
	public Registration searchRegistration(String name, int num) {
		for(Registration reg : studentRegList) {
			if(reg.getTheOffering().getTheCourse().getCourseName().contentEquals(name) && 
					reg.getTheOffering().getTheCourse().getCourseNum() == num)
				return reg;
		}
		return null;
	}
	
	/**
	 * converts the course data into a string to be printed
	 * @return the string to be printed
	 */
	public String printCourses() {
		String st= "";
		if(studentRegList.size() == 0)
			return "You are not enrolled in any courses!\n";
		for(Registration r : studentRegList) {
			 st+= r.toString();
		}
		return st;
	}
	
	public String addCourse(String name, int num, int section, int courseId) {
		
		CourseOffering c = this.searchCourse(name, num);
		if(c == null) {
			return "\nCourse is not offered.";
		}
		else {
			for(Registration reg: studentRegList)
				if(reg.getTheOffering().getTheCourse().getCourseName().contentEquals(c.getTheCourse().getCourseName())
						&& reg.getTheOffering().getTheCourse().getCourseNum() == c.getTheCourse().getCourseNum())
					return "\nYou are already enrolled in this course.";
			studentRegList.add(new Registration(this, c));
			return this.studentId+";"+c.getOfferingId()+";"+"\nSuccessfully enrolled in "+c.getTheCourse().getCourseName()+".";
		}
	}
	
	public String removeCourse(String name, int num) {
		
		CourseOffering c = this.searchCourse(name, num);
		if(c == null) {
			return "You are not enrolled in this course or it does not exist.";
		}
		else {
			Registration reg = this.searchRegistration(name, num);
			this.removeRegistration(reg);
			this.removeCourseOffering(c);
			c.removeRegistration(reg);
			c.removeStudent(this);
			return "\nCourse successfully removed.";
		}
	}
	
	public boolean checkCourseAmount() {
		if(offeringList.size() < 6)
			return true;
		return false;
	}

}
