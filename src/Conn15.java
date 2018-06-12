

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Date;


	public class Conn15 {
		public static Connection conn;
		public static Statement statmt;
		public static ResultSet resSet;
		//public  static String s = "INSERT INTO 'users' ('time', 'syria', 'russia', 'usa') VALUES ('12:48','Masha', 'Pascha', 'Jok'); ";
		 private static final String SQL = "DELETE FROM users WHERE id = \"3\"";
		
		// --------����������� � ���� ������--------
		public static void Conn() throws ClassNotFoundException, SQLException 
		   {
			   conn = null;
			   
			   Class.forName("org.sqlite.JDBC");			//������� (java-class) ������� �� ���������� ---> "org.sqlite.JDBC"
			   
			   
			   conn = DriverManager.getConnection("jdbc:sqlite:TEST61.s3db", "root", "123"); //...
			   
			   //�������� �������� � ����������� � ���� ������ � ���� URL-������ ����������� "jdbc:sqlite:TEST5.s3db"
			   
			   
			   System.out.println("���� ����������!");
		   }
		
		// --------�������� �������--------
		public static void CreateDB() throws ClassNotFoundException, SQLException
		   {
			//conn.
			
			/////////////////////////////////////////////////////////////////////////////
			String table = "";//Betta.sss;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String form_table = "CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, " + table;
			
			/////////////////////////////////////////////////////////////////////////////
			statmt = conn.createStatement();
			//!!!!!!!!!!!!!!!!!!
			statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, '1' text, '2' text, '3' text, '4' text, '5' text);");
			
			System.out.println("������� ������� ��� ��� ����������.");
		   }
		
		// --------���������� �������--------
		
		public static void WriteDB() throws SQLException
		{
			
			
			
			//////////////////////////////////////////////////////////////////////////////////////
			
			//Begin begin = new Begin();
			
			//////////////////////////////////////////////////////////////////////////////////////
			
			Date date = new Date();
			int hours = date.getHours();
			int min = date.getMinutes();
			
			int day = date.getDate();
			int month = date.getMonth();
			String moon = "";
			
			switch(month){
			case 0: moon = "January"; break;
			case 1: moon = "February"; break;
			case 2: moon = "March"; break;
			case 3: moon = "April"; break;
			case 4: moon = "May"; break;
			case 5: moon = "June"; break;
			case 6: moon = "July"; break;
			case 7: moon = "August"; break;
			case 8: moon = "September"; break;
			case 9: moon = "October"; break;
			case 10: moon = "November"; break;
			case 11: moon = "December"; break;
			}
			
			
			//String data_time = hours + ":"+ min;
			String data_time = day + " "+ moon;
			
			///////////////////////////////////////////////////////////////////////////////////////
			
			System.out.println("I am Last!!!");
			//Sar sar = new Sar();
			//sar.main(null);
			
			//VACANCY
			
			String v_mnsk_j = "1";
			String v_mnsk_c = "2";
			String v_mnsk_jj = "3";
			
			String v_msk_j = "4";
			String v_msk_c = "5";
			String v_msk_jj = "6";
			
			String v_spb_j = "7";
			String v_spb_c = "8";
			String v_spb_jj = "9";
			
			
			//RESUME
			
			
			String r_mnsk_j = "10";
			String r_mnsk_c = "11";
			String r_mnsk_jj = "12";
			
			String r_msk_j = "13";
			String r_msk_c = "14";
			String r_msk_jj = "15";
			
			String r_spb_j = "16";
			String r_spb_c = "17";
			String r_spb_jj = "18";
			
			
			System.out.println();
			System.out.println("*************************************");
			//System.out.println(a + " " + b + " " + c + " " + d);
			
			//String write = "Syria: " + a + "Russia: " + b + "USA: " + c + "America: " + d;
			
			//////////////////////////////////////////////////////////////////////////////////////
			
			String s = "INSERT INTO 'users' ('time', '1', '2', '3', '4', '5') VALUES ('" + data_time + "','" + v_mnsk_j + "', '" + v_mnsk_c + "', '" + v_mnsk_jj + "', '" + v_msk_j + "', '" + v_msk_c + "'); ";
			
			
			//////////////////////////////////////////////////////////////////////////////////////
			
			//statmt.executeUpdate( "DELETE FROM users WHERE user_id = \"1\"");
			//   "DELETE FROM users WHERE user_id = \"1\""
			 //statmt.executeUpdate(SQL);
				//resSet.deleteRow();
//				String f = "INSERT INTO 'users' ('name', 'adress', 'phone') VALUES ('Petya', 'NY', 4568);";
//			   statmt.execute(f);
//			   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
			   //statmt.execute("INSERT INTO 'users' ('syria', 'russia', 'usa') VALUES ('Masha', 'Pascha', 'Jok'); ");
			   statmt.execute(s);
//			  
			   System.out.println("������� ���������");
		}
		
		
		// -------- ����� �������--------
		public static void ReadDB() throws ClassNotFoundException, SQLException
		   {
			// statmt.executeUpdate(SQL);
			resSet = statmt.executeQuery("SELECT * FROM users");
			
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
		         
//		         if (id ==5) {
//		        	 resSet.deleteRow();
//		         }
			}	
			
			System.out.println("������� ��������");
		    }
		
			// --------��������--------
			public static void CloseDB() throws ClassNotFoundException, SQLException
			   {
				conn.close();
				statmt.close();
				resSet.close();
				
				System.out.println("���������� �������");
			   }

	}



