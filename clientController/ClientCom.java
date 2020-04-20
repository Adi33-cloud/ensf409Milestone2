package clientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCom {
	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader socketIn;
	private GUIController theGUI;
	
	public ClientCom(String serverName, int portNumber){
		try {
			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			theGUI = new GUIController(socketIn, socketOut);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	public void communicate() {
		theGUI.run();
		String response = "";
		boolean on = true;
		while (on) {
			try {
				while((response = socketIn.readLine()) != null)
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
	
	
	
	
	
	
	public static void main(String[] args) throws IOException  {
		ClientCom aClient = new ClientCom("localhost", 8099);
		aClient.communicate();
	}

	
	

}
