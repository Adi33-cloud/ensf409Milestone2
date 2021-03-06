package serverModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clientModel.Student;

/**
 * 
 * @author Logan Boras, Vanessa Chen, Aditya Raj
 * 
 *         This class is the database manager, so updates and changes the
 *         database as needed.
 */
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
	ResultSet myCourseListResults;
	ResultSet myCourseOfferingRs;
	ResultSet myCourseOfferingResults;

	public DBManager() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		courseOfferingList = new ArrayList<CourseOffering>();

		connect();
		loadCourseList();
		loadStudentList();

	}

	/**
	 * Loads the courses from the database into the courseList ArrayList of type
	 * Course.
	 */
	private void loadCourseList() {
		try {
			myCourseListRs = myStatCourse.executeQuery("select * from Course");
			myCourseOfferingRs = myStatCourseOffering.executeQuery("select * from CourseOffering");

			int i = -1;

			while (myCourseListRs.next()) {
				courseList.add(new Course(myCourseListRs.getString("name"), myCourseListRs.getInt("number"),
						myCourseListRs.getInt("id")));

			}
			while (myCourseOfferingRs.next()) {
				courseOfferingList.add(new CourseOffering(myCourseOfferingRs.getInt("secnum"),
						myCourseOfferingRs.getInt("seccap"), myCourseOfferingRs.getInt("id")));
				i += 1;
				courseOfferingList.get(i).setTheCourse(new Course(myCourseOfferingRs.getString("name"),
						myCourseOfferingRs.getInt("number"), myCourseOfferingRs.getInt("id")));
			}

			for (Course c : courseList) {
				for (CourseOffering co : courseOfferingList) {
					c.addOffering(co);
				}
			}

			for (Course c : courseList) {
				System.out.println(c.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Loads a list of students from the database into the studentList ArrayList of
	 * type Student.
	 */
	private void loadStudentList() {
		int k = 0;
		try {
			myStudentListRs = myStat.executeQuery("select * from Student");

			int i = 0;
			while (myStudentListRs.next()) {
				studentList.add(new Student(myStudentListRs.getString("name"), myStudentListRs.getInt("id")));
				k = 0;
				for (int j = 0; j < 6; j++) {
					k += 1;
					int courseId = myStudentListRs.getInt("course" + Integer.toString(k));
					if (courseId != 0 && courseId != -1) {
						for (CourseOffering o : courseOfferingList) {
							if (courseId == o.getOfferingId()) {
								System.out.println(courseId + " " + o.getOfferingId());
								studentList.get(i).setOfferingList(courseOfferingList);
								;
								studentList.get(i).addRegistration(new Registration(studentList.get(i), o));
								;
							}
						}
					}
				}
				i++;
			}

			for (Student s : studentList) {
				System.out.println(s.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Connects the program to the SQL database.
	 */
	private void connect() {
		try {
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/courseregistration?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "L40532734b?");

			myStat = myConn.createStatement();
			myStatCourse = myConn.createStatement();
			myStatCourseOffering = myConn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Adds a specified course to the student's registration list and to the SQL
	 * database.
	 * 
	 * @param s
	 * @param c
	 * @param sec
	 */
	public void addCourse(Student s, Course c, int sec) {
		for (CourseOffering theCourseOffering : courseOfferingList) {
			if (theCourseOffering.getTheCourse().getCourseName() == c.getCourseName()
					&& theCourseOffering.getTheCourse().getCourseNum() == c.getCourseNum()
					&& theCourseOffering.getSecNum() == sec) {
				theCourseOffering.addStudent(s);
				s.getOfferingList().add(theCourseOffering);
				s.addRegistration(new Registration(s, theCourseOffering));
				System.out.println("reg added!");
			}
		}
		int offeringId = -1;
		try {
			while (myCourseOfferingRs.next()) {
				if (myCourseOfferingRs.getString("name") == c.getCourseName()
						&& myCourseOfferingRs.getInt("number") == c.getCourseNum()
						&& myCourseOfferingRs.getInt("secnum") == sec) {
					offeringId = myCourseOfferingRs.getInt("id");
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		int courseSet = 3;
		for (CourseOffering Offering : s.getOfferingList())
			courseSet++;

		try {
			PreparedStatement updateId = myConn
					.prepareStatement("UPDATE courseregistration SET student = ? WHERE " + s.getStudentId() + " = ?");
			updateId.setInt(courseSet, offeringId);
			updateId.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Insert complete.");
	}

	/**
	 * Adds a course to the database when the user requests to add a course.
	 * 
	 * @param s
	 * @param offeringId
	 */
	public void addCourse(Student s, int offeringId) {
		System.out.println("SIZE: " + s.getStudentRegList().size());
		int courseSet = 1;
		for (int i = 1; i <= s.getStudentRegList().size(); i++) {
			try {
				Statement query = myConn.createStatement();
				String str = "select course" + courseSet + " from student where id = " + s.getStudentId();
				ResultSet rs = query.executeQuery(str);
				rs.next();
				if (rs.getInt(1) <= 0) {
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			courseSet++;
		}
		if (courseSet == 7) {
			System.out.println("already enrolled in 6 courses.");
			return;
		}
		try {
			Statement updateId = myConn.createStatement();
			String sql = "update student set course" + courseSet + " = " + offeringId + " where id = "
					+ s.getStudentId();
			updateId.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Insert complete.");
	}

	/**
	 * Removes a course from the student's registration list and in the SQL
	 * database.
	 * 
	 * @param s
	 * @param c
	 * @param sec
	 */
	public void removeCourse(Student s, Course c, int sec) {
		s.removeCourse(c.getCourseName(), sec);
		for (CourseOffering theCourseOffering : courseOfferingList)
			if (theCourseOffering.getTheCourse().getCourseName() == c.getCourseName()
					&& theCourseOffering.getTheCourse().getCourseNum() == c.getCourseNum()
					&& theCourseOffering.getSecNum() == sec) {
				theCourseOffering.removeStudent(s);
				s.getOfferingList().remove(theCourseOffering);
			}
		int offeringId = -1;
		try {
			while (myCourseOfferingRs.next()) {
				if (myCourseOfferingRs.getString("name") == c.getCourseName()
						&& myCourseOfferingRs.getInt("number") == c.getCourseNum()
						&& myCourseOfferingRs.getInt("secnum") == sec) {
					offeringId = myCourseOfferingRs.getInt("id");
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		int courseSet = 3;
		for (CourseOffering Offering : s.getOfferingList())
			courseSet++;

		try {
			PreparedStatement updateId = myConn
					.prepareStatement("UPDATE courseregistration SET student = ? WHERE " + s.getStudentId() + " = ?");
			updateId.setInt(courseSet, -1);
			updateId.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Remove complete.");
	}

	/**
	 * Removes the specified course from the SQL database using the course name and
	 * number parameters.
	 * 
	 * @param s
	 * @param name
	 * @param num
	 */
	public void removeCourse(Student s, String name, int num) {
		System.out.println("SIZE: " + s.getStudentRegList().size());
		int courseSet = 1;
		int offeringId = -1;
		for (CourseOffering o : courseOfferingList) {
			offeringId = o.getOfferingId();
			if (o.getTheCourse().getCourseName().contentEquals(name) && o.getTheCourse().getCourseNum() == num) {
				System.out.println("ID FOUND: " + offeringId);
				offeringId = offeringId / 10;
				break;
			}
		}
		for (int i = 0; i <= s.getStudentRegList().size(); i++) {
			try {
				Statement query = myConn.createStatement();
				String str = "select course" + courseSet + " from student where id = " + s.getStudentId();
				ResultSet rs = query.executeQuery(str);
				rs.next();
				System.out.println("COMPARATOR: " + rs.getInt(1));
				if (rs.getInt(1) / 10 == offeringId) {
					Statement updateId = myConn.createStatement();
					String sql = "update student set course" + courseSet + " = " + 0 + " where id = "
							+ s.getStudentId();
					updateId.executeUpdate(sql);
					System.out.println("Remove complete.");
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			courseSet++;
		}
		System.out.println("Remove failed.");

	}

	/**
	 * Searches
	 * 
	 * @param i
	 * @return
	 */
	public Student searchStudent(int i) {
		for (Student s : studentList)
			if (s.getStudentId() == i)
				return s;
		return null;
	}

	// Getters and setters
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public ArrayList<CourseOffering> getCourseOfferingList() {
		return courseOfferingList;
	}

	public void setCourseOfferingList(ArrayList<CourseOffering> courseOfferingList) {
		this.courseOfferingList = courseOfferingList;
	}

}
