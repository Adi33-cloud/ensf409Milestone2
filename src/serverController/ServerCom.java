package serverController;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerCom {
	private ServerSocket serverSocket;
	private ExecutorService pool; 
	
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



}
