import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Alpha extends Conn5{
	
	static String v_msk_jj = "https://hh.ru/search/vacancy?text=Java+junior&specialization=1.221&area=1&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=100&no_magic=true";
	static String html_text;
	static ArrayList list = new ArrayList();
	static public String result;
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String bbb = v_msk_jj;
		Document doc = null;
		try {
			doc = Jsoup.connect(bbb).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String title = doc.html(); // Присваиваем title html-код
		
		//System.out.println(title);
		System.out.println(title.length());
		html_text = title;
		
////////////////////////////////////////////////////////////////////////////////////////////////
		
///////////////////////////////////////////////////////////////////////////////////
//////////////READ FROM TIME_FILE //////////////////////////////////////

File time_file = new File("C:\\Users\\Stalin\\workspace\\JS4\\link.txt");
Scanner scan_time_file = null;

try {
scan_time_file = new Scanner(time_file);
} 

catch (FileNotFoundException e) {
e.printStackTrace();
}

String s = scan_time_file.nextLine();

System.out.println();
System.out.println("the number from time_file: " + s + " ...format <STRING>;");

//////////////////////////////////////////////////////////////////////////////////////
////////////////////////////WRITE TO TIME_FILE////////////////////////////////////////////////////

PrintWriter pww6 = null;

try {
pww6 = new PrintWriter(time_file);
} 
catch (FileNotFoundException e) {
e.printStackTrace();
}
//-----------------------------------------------------------------------------------------------//





String j = title;
pww6.println(j);
pww6.close();
		
	search();
	form_url();
	}
	
	public static void search(){
		{
			
			
			char[] mass = html_text.toCharArray();

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
						System.out.println("case: " + z + " number: " + s2);
						
						list.add(s2);
						
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
		
	}
	public static void form_url() throws SQLException, ClassNotFoundException{
		String s;
		//String result;
		
		//Conn5 con = new Conn5();
		
		for(int i = 1; i < list.size(); i++){
			
			s = "https://hh.ru/vacancy/" + list.get(i) + "?query=Java%20junior";
			System.out.println(s);
			
	//////////////////////////////////////////////////////////////////////
			
			Document doc2 = null;
			try {
				doc2 = Jsoup.connect(s).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//String title2 = doc.html();
			////////+++/////////////////////
			
			result = doc2.text(); //result ---> �������� �����
			
	///////////////////////TO WRITE////////////////////////////////////////
			
///////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////30-05-2018/////////////////////////////////////////////////
								//DATA BASE//
			String a = Integer.toString(i);// The number of iteration
			String b = result;// The value from Web_scaner
			Conn();
			CreateDB();
			
			if(result.length()<10000){
				WriteDB(a, b);// To Write in DB
			}
		
			if(i == list.size() - 1){
					
				break;
			}
			//CloseDB();
			
//////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
			
			
///////////////////////////////////////////////////////////////////////////////////
//////////////READ FROM TIME_FILE //////////////////////////////////////
/*
File main_text = new File("C:\\Users\\Stalin\\workspace\\JS4\\main_text.txt");
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





String j = s_file + result;
pww7.println(j);
pww7.close();
	
	*/		
		}
		
	}

}
