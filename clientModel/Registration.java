package clientModel;

/**
 * 
 * @author Vanessa CHen, Aditya Raj, Logan Boras
 * Class to hold a students registration data
 */
public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	/*void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}*/
	
	/*private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}*/
	
	/**
	 * converts the class data into a string to be printed
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}
	
	//getters and setters
	public Student getTheStudent() {
		return theStudent;
	}
	
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}

}
