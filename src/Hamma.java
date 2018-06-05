import java.sql.SQLException;

public class Hamma {
	static String s = "uni";			//МАРКЕР
	static String alg = "a-b-c";		//АЛГОРИТМ
	
	Hamma(int b){
		
		System.out.println("Hello I am konstr Hamma: " + b);
	}
	
	public static void main(String[] args) throws SQLException {
		
		extract("usaas","abc");
		
		
			
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


