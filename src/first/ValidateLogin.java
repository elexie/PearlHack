package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidateLogin {

	static boolean valid;
	static String userName;
	static String passWord;
	
	

	public ValidateLogin(String userName, String passWord) throws ClassNotFoundException, 
	InstantiationException, IllegalAccessException, SQLException {
		this.valid=validate(userName,passWord);
	}
	
	public static boolean validate(String userName, String passWord)throws SQLException,
	ClassNotFoundException, InstantiationException,
	IllegalAccessException{
		// register the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				// create the connection
				String host = "jdbc:mySql://localhost:3306/split";
				String name = "root";
				String password = "PLINAHMUNYENEH123";
				Connection con = DriverManager.getConnection(host, name, password);

				// the java statement
				Statement st = con.createStatement();
				// ResultSet
				// rs=st.executeQuery("select * from split where username="+userName+
				// "and password="+passWord);
				ResultSet rs = st
						.executeQuery("SELECT * FROM users WHERE userName=\'"+userName+"\' "
								+ "AND passWord=\'"+passWord+"\'");
				int result = 0;// if this value is 0, the user name does not exist
				
				while (rs.next()) {
					result++;
				}

			return result==0?false:true;
	}
	
	public String getUserName(){
		return this.userName;
	}
	public String getPassword(){
		return this.passWord;
	}
	public boolean getValidity() {
		return this.valid;
	}

}
