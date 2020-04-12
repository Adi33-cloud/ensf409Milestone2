package serverController;
import serverModel.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerCom {
	private ServerSocket serverSocket;
	private ExecutorService pool; 
	private String courseName;
	private int courseId;
	private String studentName;
	private String studentId;
	private int option;
	
	
	public ServerCom (int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			pool= Executors.newCachedThreadPool();
		} catch (IOException e) {
			
	}
}
	
	public void communicateWithClient() {
		
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
