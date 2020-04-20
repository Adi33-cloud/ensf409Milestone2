package serverController;
import serverModel.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import clientController.GUIController;


public class ServerCom {
	private ServerSocket serverSocket;
	private ExecutorService pool; 
	private String courseName;
	private int courseId;
	private int section;
	private String studentName;
	private String studentId;
	private int option;
	private Socket aSocket;
	private BufferedReader socketIn;
	private PrintWriter socketOut;
	private int sqlId;
	
	
	public ServerCom (int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			aSocket = new Socket();
			System.out.println("Waiting to begin...");
			aSocket = serverSocket.accept();
			System.out.println("Connection Accepted");
			pool= Executors.newCachedThreadPool();
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);
		} catch (IOException e) {
			
		}
	}
	
	public void communicateWithClient() {
		try {

			DBController theDB = new DBController("Logan", 101, this);
			String line = "";
			String[] words;
			while (true) {
				line = socketIn.readLine();
				words = line.split(";");
				if(line!=null && !line.isEmpty()) {
					try {
					option = Integer.parseInt(words[0]);
					update(option, words);
					//System.out.println(line);
					theDB.update();
					socketOut.println(theDB.getOutput());
					//System.out.println(theDB.getOutput());
					}catch(NumberFormatException e) {
						//System.out.println(line);
					}
				}
			}
		} catch (Exception e) {
			//threadPool.shutdown();
			e.printStackTrace();
		}
	}
	
	


	private void update(int option, String[] words) {
		switch(option) {
		case 1:
			courseName = words[1];
			courseId = Integer.parseInt(words[2]);
			break;
		case 2:
			courseName = words[1];
			courseId = Integer.parseInt(words[2]);
			setSection(Integer.parseInt(words[3]));
			setSqlId(Integer.parseInt(words[0]));
			break;
		case 3:
			courseName = words[1];
			courseId = Integer.parseInt(words[2]);
			break;
		case 4:
//			courseName = words[1];
//			courseId = Integer.parseInt(words[2]);
			break;
		case 5:
//			courseName = words[1];
			courseId = Integer.parseInt(words[1]);
			break;
		case 6:
			return;
		default:
			System.out.println("oops");
		}
		
	}

	private void setSqlId(int id) {
		this.sqlId = id;
		
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

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getsqlId() {
		return sqlId;
	}

	


}
