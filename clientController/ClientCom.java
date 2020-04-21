package clientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class communicates with the server class and sends uses the
 * GUIController class to output the response from the server.
 * 
 * @author Logan Boras, Vanessa Chen, Aditya Raj
 *
 */
public class ClientCom {
	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader socketIn;
	private GUIController theGUI;

	/**
	 * Constructor for the ClientCom class that initializes the sockets and the
	 * GUIController, and sets the serverName and portNumber for the socket.
	 * 
	 * @param serverName
	 * @param portNumber
	 */
	public ClientCom(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			theGUI = new GUIController(socketIn, socketOut);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * Method to communicate with the server via sockets. It sends the user's input
	 * to the server and outputs the server's response to the GUI.
	 */
	public void communicate() {
		theGUI.run();
		String response = "";
		boolean on = true;
		while (on) {
			try {
				while ((response = socketIn.readLine()) != null)
					theGUI.display(response);
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	/**
	 * Main method to start the client program.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClientCom aClient = new ClientCom("localhost", 8099);
		aClient.communicate();
	}
}
