package serverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Logan Boras, Vanessa Chen, Aditya Raj This class is the main server
 *         class to start the server. This class communicates with the client
 *         and uses DBController to execute the logic of the program.
 */
public class ServerCom {
	private ServerSocket serverSocket;
	private ExecutorService pool;
	private String courseName;
	private int courseId;
	private int section;
	private String studentName;
	private int studentId;
	private int option;
	private Socket aSocket;
	private BufferedReader socketIn;
	private PrintWriter socketOut;
	private int sqlId;

	public ServerCom(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Waiting to begin...");
			pool = Executors.newCachedThreadPool();
		} catch (IOException e) {

		}
	}

	/**
	 * Updates the member variables of this class to the user's input.
	 * 
	 * @param option
	 * @param words
	 */
	public void update(int option, String[] words) {

		switch (option) {
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
			break;
		case 5:
			studentId = Integer.parseInt(words[1]);
			break;
		case 6:
			return;
		default:
			System.out.println("oops");
		}

	}

	/**
	 * Method to run the server and execute a new thread for each new client to run
	 * multiple clients.
	 */
	public void runServer() {
		try {
			while (true) {
				aSocket = serverSocket.accept();
				System.out.println("Connection accepted by server.");
				socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				socketOut = new PrintWriter(aSocket.getOutputStream(), true);
				DBController theDB = new DBController("Logan", 101, this, socketIn, socketOut);
				pool.execute(theDB);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	/**
	 * Closes the connections of the sockets.
	 */
	private void closeConnection() {
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main method to start the program on the server side.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerCom server = new ServerCom(8099);
		System.out.println("Server is now running.");
		server.runServer();
	}

	// Getters and Setters

	private void setSqlId(int id) {
		this.sqlId = id;

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

	public int getStudentId() {
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
