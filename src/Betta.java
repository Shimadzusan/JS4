//ВХОДНЫЕ ДАННЫЕ: ОЧИЩЕННЫЙ ТЕКСТ, ИЗ file: omega
//ВЫХОДНЫЕ ДАННЫЕ: D.B. 

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Betta extends Tools{
	static public String alpha_text = "";
	static ArrayList material = new ArrayList();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	/*
	 * 1. ИЗВЛЕЧЬ НЕЗАПИСЫВАЕМЫЕ СИМВОЛЫ В D.B. "  ' "
	 * 2. РАЗДЕЛИТЬ ТЕКСТ НА ОТДЕЛЬНЫЕ КАТЕГОРИИ:
	 * I.D.
	 * TIME
	 * SPECIALIZATION
	 * LOCATION
	 * EXPERIENCE
	 * ENTERPRISE
	 * TEXT
	 * 3. ЗАПИСЬ В D.B.
	 * */
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		alpha_text = Read_from_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\omega.txt");
//ИЗВЛЕКАЕМ НЕЗАПИСЫВАЕМЫЕ СИМВОЛЫ " ' "
		String alpha_text2 = "";
		char [] alpha = alpha_text.toCharArray();
			for(int i = 0; i < alpha.length; i++){
					if(alpha[i] == '\''){
						alpha[i] = ' ';
						
					}
					alpha_text2 = alpha_text2 + alpha[i];
			}
		System.out.println("Извлечение символов завершено!");	
		material = text_edge(alpha_text2); //ПОЛУЧАЕМ РАЗГРАНИЧЕННЫЙ ТЕКСТ
											// И ТЕРЯЕМ ПОСЛЕДНИЙ ЭЛЕМЕНТ МАССИВА
		
		String specialization = "";
		String location = "";
		String experience = "";
		String enterprise = "";
		String text = "";
		String time = "";
		
		////
		Conn20 conn = new Conn20();
		////
		
		for(int i = 0; i  < material.size(); i++){
			String s = (String) material.get(i);
			specialization = specialization(s);
			location = location(s);
			experience = experience(s);
			enterprise = enterprise(s);
			//System.out.println(enterprise +"|||"+ i);
			text = text(s);
			time = time();
			//System.out.println("№: " + i +  "| text: " + text);
			//String i2 = Integer.toString(i + 1);
			//String s2 = i2 + " " + specialization;
			/////////////////////////////////////////////DATA BASE/////////////////////////////////////
			//String id = Integer.toString(i+1);
			conn.Conn();
			conn.CreateDB();
			conn.WriteDB(time, specialization, location, enterprise, experience, text);
			conn.CloseDB();
			//			|id|time|specialization|location|enterprise|experience|text|
			
			//Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\output_text.txt", s2);
			
//			if(i == 2){
//				break;
//			}
			
		}
		System.out.println(material.size());
		

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String specialization(String a){
		char [] marker = a.toCharArray();
		int height = 0;
		int low = 0;
//добавить эту Junior Java-разработчик Москва,
		for(int i = 0; i < marker.length; i++){//МАРКЕР: ДОБАВИТЬ ЭТУ,
			if(marker[i] == 'т' && marker[i+1] == 'ь' && marker[i+2] == ' ' && marker[i+3] == 'э' && marker[i+4] == 'т' && marker[i+5] == 'у'){
				height = i + 6;
				break;
			}
		}
		
		for(int i = height; i < marker.length; i++){//МАРКЕР: ЗАПЯТАЯ  ","
			if(marker[i] == ',' && (marker[i-1] == 'к' || marker[i-1] == 'а' || marker[i-1] == 'г' || marker[i-1] == 'g') /*&& marker[i+1] == 'ь' && marker[i+2] == ' ' && marker[i+3] == 'э' && marker[i+4] == 'т' && marker[i+5] == 'у'*/){
				low = i;
				break;
			}
		}
		
			String b = extract_part(height, low, marker);
			
			int marker2_height = 0;
			char[] marker2 = b.toCharArray();
			for(int i = marker2.length-1; i > 0; i--){
				if (marker2[i] == ' ' /*|| marker2[i] == 'С' || marker2[i] == 'S' || marker2[i] == 'M'*/){
					marker2_height = i;
					break;
				}
			}
		String c = delete_part(marker2_height, marker2.length-1, marker2);

return c;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String location(String a){
		char [] marker = a.toCharArray();
		int height = 0;
		int low = 0;
//добавить эту Junior Java-разработчик Москва,
		for(int i = 0; i < marker.length; i++){//МАРКЕР: ДОБАВИТЬ ЭТУ,
			if(marker[i] == 'т' && marker[i+1] == 'ь' && marker[i+2] == ' ' && marker[i+3] == 'э' && marker[i+4] == 'т' && marker[i+5] == 'у'){
				height = i + 6;
				break;
			}
		}
		
		for(int i = height; i < marker.length; i++){//МАРКЕР: ЗАПЯТАЯ  ","
			if(marker[i] == ',' && (marker[i-1] == 'к' || marker[i-1] == 'а' || marker[i-1] == 'г' || marker[i-1] == 'g') /*&& marker[i+1] == 'ь' && marker[i+2] == ' ' && marker[i+3] == 'э' && marker[i+4] == 'т' && marker[i+5] == 'у'*/){
				low = i;
				break;
			}
		}
		
		String b = extract_part(height, low, marker);
		
		int marker2_height = 0;
				char[] marker2 = b.toCharArray();
				for(int i = marker2.length-1; i > 0; i--){
					if (marker2[i] == 'М' || marker2[i] == 'С' || marker2[i] == 'S' || marker2[i] == 'M'){
						marker2_height = i;
						break;
					}
				}
		String c = extract_part(marker2_height, marker2.length-2, marker2);
		
		return c;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String experience(String a){
		char [] marker = a.toCharArray();
		int height = 0;
		int low = 0;
//
		for(int i = 0; i < marker.length; i++){//МАРКЕР: РАБОТЫ:
			if(marker[i] == 'а' && marker[i+1] == 'б' && marker[i+2] == 'о' && marker[i+3] == 'т' && marker[i+4] == 'ы' && marker[i+5] == ':'){
				height = i + 7;
				low = i + 9;
					//ИСКЛЮЧЕНИЕ: ДЛЯ ВАРИАНТА "БОЛЕЕ"
					if(marker[i + 7] == 'б'){
						height = i + 13;
						low = i + 14;
					}
				break;
			}
		}
		
//		for(int i = height; i < marker.length; i++){//МАРКЕР: ЗАПЯТАЯ  ","
//			if(marker[i] == ',' && (marker[i-1] == 'к' || marker[i-1] == 'а' || marker[i-1] == 'г' || marker[i-1] == 'g') /*&& marker[i+1] == 'ь' && marker[i+2] == ' ' && marker[i+3] == 'э' && marker[i+4] == 'т' && marker[i+5] == 'у'*/){
//				low = i;
//				break;
//			}
//		}
		
		String b = extract_part(height, low, marker);
		
		return b;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String enterprise(String a){
		char [] marker = a.toCharArray();
		int height = 0;
		int low = 0;
//
		for(int i = 0; i < marker.length; i++){//ПЕРВЫЙ МАРКЕР: ДЕНЬ, ИЛИ ГРАФИК, ИЛИ УДАЛЕННАЯ РАБОТА 
			if(marker[i] == ' ' && marker[i+1] == 'д' && marker[i+2] == 'е' && marker[i+3] == 'н' && marker[i+4] == 'ь' || marker[i] == 'р' && marker[i+1] == 'а' && marker[i+2] == 'ф' && marker[i+3] == 'и'&& marker[i+4] == 'к' || marker[i] == 'б' && marker[i+1] == 'о' && marker[i+2] == 'т' && marker[i+3] == 'а'&& marker[i-5] == 'а'){
				height = i + 5;
				//low = i + 9;
					
				break;
			}
		}
		
		for(int i = 0; i < marker.length; i++){//ВТОРОЙ МАРКЕР: КОМПАНИЯ ПРОШЛА ПРОВЕРКУ 
			if(marker[i] == 'о' && marker[i+2] == 'п' && marker[i+4] == 'н' && marker[i+6] == 'я' && marker[i+8] == 'п' && marker[i+9] == 'р' && marker[i+10] == 'о' && marker[i+12] == 'л' && marker[i+13] == 'а'&& marker[i+15] == 'п'){
				//height = i + 5;
				low = i - 3;
					
				break;
			}
		}
		
			String b = extract_part(height, low, marker);
		
		return b;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String text(String a){
		
		char [] marker = a.toCharArray();
		int height = 0;
		int low = 0;
//
		for(int i = 0; i < marker.length; i++){//МАРКЕР: НА САЙТЕ 
			if(marker[i] == 'н' && marker[i+1] == 'а' && marker[i+3] == 'с' && marker[i+4] == 'а' && marker[i+5] == 'й'&& marker[i+6] == 'т'&& marker[i+7] == 'е'){
				height = i + 8;
				low = marker.length-2;
					
				break;
			}
		}
		String b = extract_part(height, low, marker);
		
		return b;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String time(){
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
		return data_time;
	}
}
