package serverModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class DBManager {
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<CourseOffering> courseOfferingList;
	
	Connection myConn;
	Statement myStat;
	Statement myStatCourse;
	Statement myStatCourseOffering;
	
	ResultSet myStudentListRs;
	ResultSet myCourseListRs;
	ResultSet myCourseOfferingRs;
	
	public DBManager() {
		studentList= new ArrayList<Student>();
		courseList= new ArrayList<Course>();
		courseOfferingList= new ArrayList<CourseOffering>();
		
		
		connect();
		loadStudentList();
		loadCourseList();
	}

	private void loadCourseList() {
		// TODO Auto-generated method stub
		try {
			myCourseListRs= myStatCourse.executeQuery("select * from Course");
			myCourseOfferingRs= myStatCourseOffering.executeQuery("select * from CourseOffering");
			int i=-1;
			
			while(myCourseListRs.next()) {
				courseList.add(new Course(myCourseListRs.getString("name"),myCourseListRs.getInt("number")));
								
			}
			while(myCourseOfferingRs.next()) {
				courseOfferingList.add(new CourseOffering(myCourseOfferingRs.getInt("secnum"),myCourseOfferingRs.getInt("seccap")));
				i+=1;
				courseOfferingList.get(i).setTheCourse(new Course(myCourseOfferingRs.getString("name"),myCourseOfferingRs.getInt("number")));
			}
			
			for(Course c: courseList) {
				for(CourseOffering co: courseOfferingList) {
					c.addOffering(co);
				}
			}
			
			//for(CourseOffering co: courseOfferingList) {
			//	System.out.println(co.toString());
			//}
			
			for(Course c: courseList) {
				System.out.println(c.toString());
			}
			
//			myCourseListRs.close();
//			myCourseOfferingRs.close();
			
			

		
		
		
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	private void loadStudentList() {
		// TODO Auto-generated method stub
		try {
			myStudentListRs= myStat.executeQuery("select * from Student");
		
		
		while(myStudentListRs.next()) {
			studentList.add(new Student(myStudentListRs.getString("name"),myStudentListRs.getInt("id")));
			
		}
		for(Student s: studentList) {
			System.out.println(s.toString());
		}
//		myStudentListRs.close();
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

	private void connect() {
		// TODO Auto-generated method stub
		try {
			 myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courseregistration?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","L40532734b?");
			
			 myStat= myConn.createStatement();
			 myStatCourse= myConn.createStatement();
			 myStatCourseOffering= myConn.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addCourse(Student s, Course c, int sec) {
		s.addRegistration(new Registration());
		for(CourseOffering theCourseOffering: courseOfferingList)
			if(theCourseOffering.getTheCourse().getCourseName() == c.getCourseName() && theCourseOffering.getTheCourse().getCourseNum() == c.getCourseNum()
			&& theCourseOffering.getSecNum() == sec) {
				theCourseOffering.addStudent(s);
				s.getOfferingList().add(theCourseOffering);
			}
		int offeringId = -1;
		try {
			while(myCourseOfferingRs.next()) {
				if(myCourseOfferingRs.getString("name")==c.getCourseName()&&myCourseOfferingRs.getInt("number")==c.getCourseNum()
				&& myCourseOfferingRs.getInt("secnum")==sec) {
					offeringId = myCourseOfferingRs.getInt("id");
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int courseSet = 3;
		for(CourseOffering Offering: s.getOfferingList())
			courseSet++;
		
        try {
			PreparedStatement updateId = myConn.prepareStatement("UPDATE courseregistration SET student = ? WHERE "+s.getStudentId()+" = ?");
			updateId.setInt(courseSet, offeringId);
			updateId.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        System.out.println("Insert complete.");
	}
	
	public void removeCourse(Student s, Course c, int sec) {
		s.removeCourse(c.getCourseName(), sec);
		for(CourseOffering theCourseOffering: courseOfferingList)
			if(theCourseOffering.getTheCourse().getCourseName() == c.getCourseName() && theCourseOffering.getTheCourse().getCourseNum() == c.getCourseNum()
			&& theCourseOffering.getSecNum() == sec) {
				theCourseOffering.removeStudent(s);
				s.getOfferingList().remove(theCourseOffering);
			}
		int offeringId = -1;
		try {
			while(myCourseOfferingRs.next()) {
				if(myCourseOfferingRs.getString("name")==c.getCourseName()&&myCourseOfferingRs.getInt("number")==c.getCourseNum()
				&& myCourseOfferingRs.getInt("secnum")==sec) {
					offeringId = myCourseOfferingRs.getInt("id");
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int courseSet = 3;
		for(CourseOffering Offering: s.getOfferingList())
			courseSet++;
		
        try {
			PreparedStatement updateId = myConn.prepareStatement("UPDATE courseregistration SET student = ? WHERE "+s.getStudentId()+" = ?");
			updateId.setInt(courseSet, -1);
			updateId.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        System.out.println("Remove complete.");
	}
	
	public static void main(String[] args) {
		new DBManager();
	}
	

}
