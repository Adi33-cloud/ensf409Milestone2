package serverController;
import serverModel.*;


public class DBController {
	private CourseCatalogue cat;
	private Student student;
	
	public DBController(String studentName,int StudentId) {
		cat= new CourseCatalogue();
		student= new Student(studentName,StudentId);
	}
	
	public String searchCourse(String courseName, int courseNumber) {
		
		Course theCourse= cat.searchCat(courseName, courseNumber);
		return theCourse.toString();
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
}


