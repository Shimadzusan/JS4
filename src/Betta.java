import java.sql.SQLException;

public class Betta {
	
	static String sss;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
		String form_table = "'1' text,'2' text, '3' text,";
		String s = "'1' text,";
		String t;
		
		for(int i = 2; i < 6; i++){
			t = Integer.toString(i);
			//System.out.println(i);
			
			
			if(i == 5){
				
				s = s + " '" + t + "' text";
				break;
			}
			
			s = s + " '" + t + "' text,";
			
		}
System.out.println(s);
sss = s;

Web_db base = new Web_db();
base.web_db(); 
	}

}
