package serverController;
import serverModel.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import clientController.GUIController;


public class ServerCom {
	private ServerSocket serverSocket;
	private ExecutorService pool; 
	private String courseName;
	private int courseId;
	private String studentName;
	private String studentId;
	private int option;
	private GUIController theGUI;
	
	
	public ServerCom (int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			pool= Executors.newCachedThreadPool();
		} catch (IOException e) {
			
		}
	}
	
	public void communicateWithClient() {
		try {
			while (true) {
				System.out.println("Waiting to begin...");
				serverSocket.accept();
				theGUI = new GUIController();
				System.out.println("Connection Accepted");
				pool.execute(theGUI);
			}
		} catch (Exception e) {
			//threadPool.shutdown();
			e.printStackTrace();
		}
	}
	
	

	public GUIController getTheGUI() {
		return theGUI;
	}

	public void setTheGUI(GUIController theGUI) {
		this.theGUI = theGUI;
	}

	public static void main(String[] args) throws IOException{
		ServerCom server = new ServerCom(8099);
		System.out.println("Server is now running.");
		server.communicateWithClient();
	}

	public String getCourseName() {
		return courseName;
	}

	

	public int getCourseId() {
		return courseId;
	}

	

	public String getStudentName() {
		return studentName;
	}

	
	public String getStudentId() {
		return studentId;
	}

	

	public int getOption() {
		return option;
	}

	


}
