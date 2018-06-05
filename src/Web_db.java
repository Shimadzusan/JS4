import java.sql.SQLException;

public class Web_db {
	
public static void web_db() throws ClassNotFoundException, SQLException {
		
		
		
		Conn15.Conn();
		Conn15.CreateDB();
		Conn15.WriteDB();
		//Conn15.ReadDB();
		//Conn15.CloseDB();
	}

}
