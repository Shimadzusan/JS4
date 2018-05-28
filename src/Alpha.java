import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Alpha {
	
	static String v_msk_jj = "https://hh.ru/search/vacancy?text=Java+junior&specialization=1.221&area=1&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=100&no_magic=true";
	static String html_text;
	
	public static void main(String[] args) {
		
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
	}
	
	public static void search(){
		{
			
			char[] mass = html_text.toCharArray();
//			int sir = 0;
//			int rus = 0;
//			int us = 0;
//			int am = 0;
			String s1 = "";
			int z = 0;
			for(int i = 0; i < mass.length; i++){
				//System.out.println("Im SYRIA");
				
					//МАРКЕР <Т-К-Л-И-К-Н> ОТ СЛОВА ОТКЛИКНУТЬСЯ
					if(mass[i] == 'т' && mass[i+1] == 'к' && mass[i+2] == 'л' && mass[i+3] == 'и' && mass[i+4] == 'к' && mass[i+5] == 'н'){
						z++;
					//ИЗВЛЕКАЕМ ФАКТУРУ
						s1 = "" + mass[i] + mass[i+1] + mass[i+2] + mass[i+3] + mass[i+4]+ mass[i+5] + mass[i+6] + mass[i+7] + mass[i+8] + mass[i+9] + mass[i+10] + mass[i+11] + mass[i+12];
					
					//ОЧИЩАЕМ, ИЗВЛЕКАЯ ТОЛЬКО ЧИСЛО
					//СОЗДАЕМ КОЛЛЕКЦИЮ СТРИНГ
					//ИЗВЛЕКАЕМ ИЗ КОЛЛЕКЦИИ ЗНАЧЕНИЯ, ФОРМИРУЕМ URL, И СОХРАНЯЕМ ТЕКСТ
						//sir++;
					
				}
					
					
					
				}
			
			//System.out.println(s1);
			System.out.println(z);
			//����� ����� ������������� ��� ������ � �������� ��� �������� ��������� ���������� String
			//symb = s1;
			
		}
		
	}

}
