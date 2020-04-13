package clientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCom {
	private PrintWriter socketOut;
	private Socket aSocket;
	private String stdIn;
	private BufferedReader socketIn;
	
	public ClientCom(String serverName, int portNumber){
		try {
			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
		
	}
	
	public void communicate() {
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException  {
		ClientCom aClient = new ClientCom("localhost", 8099);
		aClient.communicate();
	}

	
	

}