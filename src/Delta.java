//ВХОДНЫЕ ДАННЫЕ: 3 URL FROM LAUNCH.CLASS
//ВЫХОДНЫЕ ДАННЫЕ: TOTAL TEXT IN FILE, main_super_text.txt
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Delta extends Tools{
	
	static String html;
	static ArrayList list5 = new ArrayList();
	static String result100 = "";
	static String result200 = "";
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void get_html(String url){
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String title = doc.html(); // ...ПРИСВАИВАЕМ TITLE HTML-КОД
		//System.out.println(title.length());
		html = title;
		//return html;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void search(){
		
			
			
			char[] mass = html.toCharArray();

			String s1 = "";
			String s2 = "";
			int z = 0;
			
////////////////////////////////////////CYCLE///////////////////////////////////////////////////
			
			for(int i = 0; i < mass.length; i++){
				//System.out.println("Im SYRIA");
				
					//МАРКЕР <Т-К-Л-И-К-Н> ОТ СЛОВА ОТКЛИКНУТЬСЯ
					if(mass[i] == 'т' && mass[i+1] == 'к' && mass[i+2] == 'л' && mass[i+3] == 'и' && mass[i+4] == 'к' && mass[i+5] == 'н'){
						z++;
					//ИЗВЛЕКАЕМ ФАКТУРУ
						s1 = "" + mass[i-12] + mass[i-11] + mass[i-10] + mass[i-9] + mass[i-8]+ mass[i-7] + mass[i-6] + mass[i-5] + mass[i-4] + mass[i-3];
					//System.out.println(s1);
					//ОЧИЩАЕМ, ИЗВЛЕКАЯ ТОЛЬКО ЧИСЛО, VAR S2
						
						char[] mass5 = s1.toCharArray();
						
						for(int k = 0; k < mass5.length; k++) {
							if(Character.isDigit(mass5[k])){
								//System.out.println(text30[i]);
							
							s2 = s2 + Character.toString(mass5[k]);
							}
							
						//sir++;
					
				}
						//System.out.println("case: " + z + " number: " + s2);//..ВЫВОД ЧИСЕЛ ДЛЯ ССЫЛКИ
						
						list5.add(s2);
						
						s2 = ""; //ОБНУЛЯЕМ
					
					
					
				}
			}
//////////////////////////////END OF CYCLE/////////////////////////////////////////////////////
			
			//System.out.println(s1);
			System.out.println(z);
			
			//symb = s1;
			
			//СОЗДАЕМ КОЛЛЕКЦИЮ СТРИНГ
			//ИЗВЛЕКАЕМ ИЗ КОЛЛЕКЦИИ ЗНАЧЕНИЯ, ФОРМИРУЕМ URL, И СОХРАНЯЕМ ТЕКСТ
			
					
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void form_url() throws SQLException, ClassNotFoundException{
		String s;
		//String result;
		
		//Conn5 con = new Conn5();
		
		for(int i = 0; i < list5.size(); i++){
			
			s = "https://hh.ru/vacancy/" + list5.get(i) + "?query=Java%20junior";
			//list5.remove(i);
			System.out.println(s+ " .number: " + i);
			
//////////////////////////ЗАХОДИМ НА СТРАНИЦУ ПО СФОРМИРОВАНОМУ URL///////////////////////////
			
			Document doc2 = null;
			try {
				doc2 = Jsoup.connect(s).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//String title2 = doc.html();
			////////+++/////////////////////
			
			result100 = doc2.text(); //result --->РЕЗУЛЬТАТ ЗАХОДА НА СТРАНИЦУ
			
//			char[] mass200 = result100.toCharArray();
//
//			String s1 = "";
//			String s2 = "";
//			int z = 0;
//			
//			//////////////////////////////////////CYCLE///////////////////////////////////////////////////
//					
//			for(int i2 = 0; i2 < mass200.length; i2++){
//				
//				////////////////////////ЗАМЕНЯЕМ СИМВОЛ ' //////////////////////////////
//				if(mass200[i2] == '\''){
//					mass200[i2] = '.';
//				}
//				result200 = result200 + mass200[i2];
//			}
//				
//			
////////////////////////////////////////////////////////////////////////////////////////////////////////
//			
//			//DATA BASE//
//			int xy = i + 1;
//			
//			
//			String a = Integer.toString(xy);// The number of iteration
//			String b = result200;// The value from Web_scaner
//			Conn();
//			//CreateDB();
//			
//			
//				WriteDB(a, b);// To Write in DB
//		
//		
////			if(i == list.size() - 1){
////					
////				break;
////			}
//			CloseDB();
			
//////////////////////////////////////////////////////////////////////////////////////////////////////
			
///////////////////////////////////////////////////////////////////////////////////
//////////////READ FROM TIME_FILE //////////////////////////////////////
///*
File main_text = new File("C:\\Users\\Stalin\\workspace\\JS4\\main_super_text.txt");
Scanner scan_main_text = null;

try {
scan_main_text = new Scanner(main_text);
} 

catch (FileNotFoundException e) {
e.printStackTrace();
}

String s_file = scan_main_text.nextLine();

//System.out.println();
//System.out.println("the number from time_file: " + s_file + " ...format <STRING>;");

//////////////////////////////////////////////////////////////////////////////////////
////////////////////////////WRITE TO TIME_FILE////////////////////////////////////////////////////

PrintWriter pww7 = null;

try {
pww7 = new PrintWriter(main_text);
} 
catch (FileNotFoundException e) {
e.printStackTrace();
}
//-----------------------------------------------------------------------------------------------//


//ФОРМИРУЕМ МАРКЕР В ОБЩЕМ ТЕКСТЕ: ****_***
String number = Integer.toString(i+1);
String result200 = "****" + number + "***" + result100;

String j = s_file + result200;
pww7.println(j);
pww7.close();

//*/		
			
	///////////////////////TO WRITE////////////////////////////////////////
		
	}
//	ЗАВЕРШАЮЩИЙ МАРКЕР ДЛЯ ИЗВЛЕЧЕНИЯ ПОСЛЕДНЕЙ ВАКАНСИИ "****"
		Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\main_super_text.txt", "****000***Hello Universe!!! ");
	}}


