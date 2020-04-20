package serverController;
import clientModel.Student;
import serverModel.*;


public class DBController {
	private ServerCom serverCom; //don't know what to communicate
	private CourseCatalogue cat;
	private Student student;
	private String output;
	
	public DBController(String studentName,int StudentId, ServerCom serverCom) {
		cat= new CourseCatalogue();
		student= new Student(studentName,StudentId);
		student.setOfferingList(cat.getOfferingList());
		this.serverCom = serverCom;
	}
	
	public void update() {
		setOutput(selection());
	}
	
	public String selection() {
		switch(serverCom.getOption()) {
		case 1:
			return searchCourse(serverCom.getCourseName(),serverCom.getCourseId());
		case 2:
			return addCourse(serverCom.getCourseName(),serverCom.getCourseId(),serverCom.getSection(),serverCom.getsqlId());
		case 3:
			return removeCourse(serverCom.getCourseName(),serverCom.getCourseId());
		case 4:
			return printCatalogue();
		case 5:
			return printStudentCourses();
			
		default:
			return "Invalid input. Try again.";
		}
		
	}
	
	
	private String addCourse(String courseName, int courseId, int section, int sqlId) {
		// TODO Auto-generated method stub
		return student.addCourse(courseName, courseId, section, sqlId);
	}

	public String searchCourse(String courseName, int courseNumber) {
		
		Course theCourse= cat.searchCat(courseName, courseNumber);
		if(theCourse != null)
			return theCourse.toString();
		else return null;
	}
	
	/*public String addCourse(String courseName, int courseNumber) {
		if(student.checkCourseAmount() == false) {
			return "You can only take a maximum of 6 courses, you can't take any more courses right now";
		}
		else {
			Course theCourse= cat.searchCat(courseName, courseNumber);
			if(theCourse!= null) {
			student.addCourse(theCourse);
			}
			return  theCourse.getCourseName() + " " + theCourse.getCourseNum () + "has been added";
		}
	}*/
	
	public String removeCourse(String courseName, int courseNumber) {
		return student.removeCourse(courseName, courseNumber);
	}
	
	public String printCatalogue() {
		return cat.toString();
	}
	
	public String printStudentCourses() {
		return student.printCourses();
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}


