import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Conn20 {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	//public  static String s = "INSERT INTO 'users' ('time', 'syria', 'russia', 'usa') VALUES ('12:48','Masha', 'Pascha', 'Jok'); ";
	 private static final String SQL = "DELETE FROM users WHERE id = \"3\"";
	 static String s = "";
	 static String s2;
	
	// --------����������� � ���� ������--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   
		   Class.forName("org.sqlite.JDBC");			//������� (java-class) ������� �� ���������� ---> "org.sqlite.JDBC"
		   
		   
		   conn = DriverManager.getConnection("jdbc:sqlite:DataBase5000.s3db", "root", "123"); //...
		   
		   //�������� �������� � ����������� � ���� ������ � ���� URL-������ ����������� "jdbc:sqlite:TEST5.s3db"
		   
		   
		   System.out.println("Base is ON!");
	   }
	
	// --------�������� �������--------
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		//conn.
		/*
 String x2 = "'id' text, ";
		 
		 for(int i = 1; i < 200; i++){
			 
			 String x3 = Integer.toString(i);
			if(i == 199){
				
				x2 = x2 + "'" + x3 + "' longtext";
				break;
			}
			 
			 
			x2 = x2 + "'" + x3 + "' longtext, ";
			
			
		}
		 System.out.println(x2);
		 
		 */
		 String x = "CREATE TABLE if not exists'v_msk_jj' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' date, 'specialization' text, 'location' text, 'enterprise' text, 'experience' text, 'text' text);";
		 //System.out.println(x);
		
		statmt = conn.createStatement();
		//statmt.execute("CREATE TABLE 'v_msk_jj' ('id' text, '1' text, '2' text,'3' text, '4' text, '5' text);");
		statmt.execute(x);
		
		//System.out.println("������� ������� ��� ��� ����������.");
	   }
	
	// enterprise, experience, text
	
	public static void WriteDB(String time, String specialization, String location, String enterprise, String experience, String text) throws SQLException
	{
		statmt = conn.createStatement();
		
		Alpha alpha = new Alpha();
		
		//statmt.execute("INSERT INTO 'v_msk_jj' ('id') VALUES ('Hello SQL!');");
		//statmt.execute("INSERT INTO 'v_msk_jj' ('russia') VALUES ('Hello MSK!');");
		
		//statmt.execute("INSERT INTO 'v_msk_jj' ('id') VALUES ('1');");
		s2 = "INSERT INTO 'v_msk_jj' ('time', 'specialization', 'location', 'enterprise', 'experience', 'text') VALUES ( '"+time+"', '"+specialization+"', '"+location+"', '"+enterprise+"', '"+experience+"', '"+text+"');";
		
		
		//s2 = "UPDATE 'v_msk_jj' SET '1'='2112' WHERE id = '1';";
//		String c = "Java";
//		b = c;
		//s2 = "UPDATE 'v_msk_jj' SET '" + a + "'='"+ b +"' WHERE id = '1';";
		//s2 = "UPDATE 'v_msk_jj' SET '" + a + "'='000' WHERE id = '1';";
		
				//s2 = "UPDATE 'v_msk_jj' SET '" + a + "'='" + b + "' WHERE id = '1';";
//		System.out.println(a + ":" + alpha.result);
//		System.out.println(alpha.result.length());
		System.out.println(s2);
		
		statmt.execute(s2);
		
		
		//statmt.execute("UPDATE 'v_msk_jj' SET '2'='2112' WHERE id = '1';");
		
//		for(int i = 1; i < 4; i++){
//			
//			//Method_web
//			s = Integer.toString(i);
//			
//			s2 = "UPDATE 'v_msk_jj' SET '" + s + "'='555' WHERE id = '1';";
//			//statmt.execute(s2);
//			
//		}
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		//Sar sar = new Sar();
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		Date day = new Date();
		int hours = day.getHours();
		int min = day.getMinutes();
		
		String data_time = hours + ":"+ min;
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("I am Last!!!");
		//Sar sar = new Sar();
		//sar.main(null);
//		int a = sar.req(0); //Syria
//		int b = sar.req1(0); //Russia
//		int c = sar.req2(0); //USA
//		int d = sar.req3(0); //America
		System.out.println();
		System.out.println("*************************************");
		//System.out.println(a + " " + b + " " + c + " " + d);
		
		//String write = "Syria: " + a + "Russia: " + b + "USA: " + c + "America: " + d;
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		//String s = "INSERT INTO 'users' ('time', 'syria', 'russia', 'usa', 'america') VALUES ('" + data_time + "','" + a + "', '" + b + "', '" + c + "', '" + d + "'); ";
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		//statmt.executeUpdate( "DELETE FROM users WHERE user_id = \"1\"");
		//   "DELETE FROM users WHERE user_id = \"1\""
		 //statmt.executeUpdate(SQL);
			//resSet.deleteRow();
//			String f = "INSERT INTO 'users' ('name', 'adress', 'phone') VALUES ('Petya', 'NY', 4568);";
//		   statmt.execute(f);
//		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
		  
		  // statmt.execute(s);
//		  
		  // System.out.println(a + "***" + alpha.result);
	}
	
	
	// -------- ����� �������--------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		// statmt.executeUpdate(SQL);
		resSet = statmt.executeQuery("SELECT * FROM v_msk_jj");
		
		//int i = 0;
		while(resSet.next())
		{
			//i++;
			int id = resSet.getInt("id");
			String  time = resSet.getString("time");
			String  syria = resSet.getString("syria");
			String  russia = resSet.getString("russia");
			String  usa = resSet.getString("usa");
			String  america = resSet.getString("america");
			
			//System.out.println( "(!!!) REAL ID = " + i );
			
	         System.out.println( "ID = " + id );
	         System.out.println( "Time = " + time );
	         System.out.println( "Syria = " + syria );
	         System.out.println( "Russia = " + russia );
	         System.out.println( "USA = " + usa );
	         System.out.println( "America = " + america );
	         System.out.println();
	         
//	         if (id ==5) {
//	        	 resSet.deleteRow();
//	         }
		}	
		
		System.out.println("������� ��������");
	    }
	
		// --------��������--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			//resSet.close();
			
			System.out.println("���������� �������");
		   }

}
