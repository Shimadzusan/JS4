import java.sql.SQLException;
import java.util.Date;

public class Hamma {
	static String s = "uni";			//МАРКЕР
	static String alg = "a-b-c";		//АЛГОРИТМ
	
	Hamma(int b){
		
		System.out.println("Hello I am konstr Hamma: " + b);
	}
	
	public static void main(String[] args) throws SQLException {
		
		Date date = new Date();
		int year = date.getYear() + 1900;
		
		int day = date.getDate();
		int month = date.getMonth();
		String moon = "";
		
		switch(month){
		case 0: moon = "01"; break;
		case 1: moon = "02"; break;
		case 2: moon = "03"; break;
		case 3: moon = "04"; break;
		case 4: moon = "05"; break;
		case 5: moon = "06"; break;
		case 6: moon = "07"; break;
		case 7: moon = "08"; break;
		case 8: moon = "09"; break;
		case 9: moon = "10"; break;
		case 10: moon = "11"; break;
		case 11: moon = "12"; break;
		}
		
		String data_time = year + moon +day;
		System.out.println(data_time);
			
	}
	
	public static String extract(String a, String alg){			// МЕТОД ПО ЗАДАННОМУ МАРКЕРУ ИЗВЛЕКАЕТ ЦЕЛЕВОЙ ТЕКСТ
		
			char [] marker = a.toCharArray();
			
			int b = marker.length;
			
			//МЕТОД(B)
			Hamma aa = new Hamma(b);
			
			
			String facture = "";
			
			return facture;
			
	}

}


