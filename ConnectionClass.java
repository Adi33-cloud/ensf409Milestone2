import java.sql.*;
public class ConnectionClass {
	public static void main(String[] args) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courseregistration","root","L40532734b?");
		
			Statement myStatement = myConn.createStatement();
			
			ResultSet myRs = myStatement.executeQuery("select * from Student");
			
			while(myRs.next())
				System.out.println(myRs.getString("id"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}