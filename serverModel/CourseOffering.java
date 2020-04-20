package serverModel;

import java.util.ArrayList;

import clientModel.Student;


/**
 * 
 * @author Aditya Raj, VAnessa CHen, Logan Boras
 *
 */
public class CourseOffering {
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;
	private int offeringId;
	

	/**
	 * COnstructor method for the class
	 * @param secNum number of the section
	 * @param secCap maximum amount of students allowed in the section
	 */
	public CourseOffering (int secNum, int secCap, int id) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		this.offeringId=id;
		studentList = new ArrayList <Student>();
		offeringRegList = new ArrayList <Registration>();
	}
	
	//Getters and setters
	public int getSecNum() {
		return secNum;
	}
	
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	
	public int getSecCap() {
		return secCap;
	}
	
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	
	public Course getTheCourse() {
		return theCourse;
	}
	
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		//st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		for(Student s: studentList)
			st += s;
		return st;
	}
	
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}
	
	public void removeRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.remove(registration);
		
	}
	
	public void addStudent(Student s) {
		studentList.add(s);
	}
	
	public void removeStudent(Student s) {
		studentList.remove(s);
	}
	
	public int getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(int offeringId) {
		this.offeringId = offeringId;
	}


}
