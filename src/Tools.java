import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tools {

/////////////////ПРИСВАЕВАЕМ ПЕРЕМЕННОЙ TARGET ДАННЫЕ ИЗ ФАЙЛА TARGET//////////////////////////////////////

	public static String Read_from_file_txt(String source){
				
		File main_text = new File(source);
		Scanner scan_main_text = null;
		
		try {
		scan_main_text = new Scanner(main_text);
		} 
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		//System.out.println("+5");
		String target = scan_main_text.nextLine();
		//System.out.println(target);
		
		return target;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void Add_to_file_txt(String source, String text_add){
		
//////////////////////////////////////////////////WRITE TO FILE////////////////////////////////////////
//////////////READ FROM TIME_FILE //////////////////////////////////////
	
	File main_text2 = new File(source);
	Scanner scan_main_text2 = null;
	
	try {
	scan_main_text2 = new Scanner(main_text2);
	} 
	
	catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	
	String s_file2 = scan_main_text2.nextLine();
	
	//System.out.println();
	//System.out.println("the number from time_file: " + s_file + " ...format <STRING>;");
	
	//////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////WRITE TO TIME_FILE////////////////////////////////////////////////////
	
	PrintWriter pww10 = null;
	
	try {
	pww10 = new PrintWriter(main_text2);
	} 
	catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	//-----------------------------------------------------------------------------------------------//
	
	
	
	
	
	String j = s_file2 + text_add;
	pww10.println(j);
	pww10.close();
	
	
	

		

	}
	
	public static String Write_to_file_txt(String a){
			
			return a;
		}

	public static int Extract_from_text(String marker, String material){
		int z = 0;
		int index = 0;
		char [] text_array = material.toCharArray();
		char [] text_array2 = marker.toCharArray();
		
		
		
		
		for(int i = 0; i < text_array.length; i++){

		//МАРКЕР <Р-Е-Б-О-В-А-Н-И-Я-:-> ОТ СЛОВА ТРЕБОВАНИЯ
			
		if(text_array[i] == text_array2[0] && text_array[i+1] == text_array2[1] && text_array[i+2] == text_array2[2] && text_array[i+3] == text_array2[3] && text_array[i+4] == text_array2[4] && text_array[i+5] == text_array2[5] && text_array[i+6] == text_array2[6] && text_array[i+7] == text_array2[7]){
		z++; //КОЛИЧЕСТВО МАРКЕРОВ
		index = i -3;
		
		//text_edge.add(i-1); //ДОБАВЛЯЕМ В МАССИВ ИНДЕКСЫ ДЛЯ РАЗГРАНИЧЕНИЙ
		//har.list.add(marker);
		}
		
		}
		
		String s = Integer.toString(z) + "ЛЯ-ЛЯ-ЛЯ";
		return index;
	}
	
	public static ArrayList to_file_txt(String a){
		
		ArrayList ar = new ArrayList();
		return ar;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList text_edge(String input){ //ВХОДНЫЕ ДАННЫЕ ТЕКСТ ДЛЯ РАЗГРАНИЧЕНИЯ
		ArrayList text_edge = new ArrayList();		//ВЫХОДНЫЕ ДАННЫЕ МАССИВ С РАЗГРАНИЧЕННМ ТЕКСТОМ
		ArrayList text = new ArrayList();			//МАРКЕР ДЛЯ РАЗГРАНИЧЕНИЯ ****
		
		char[] mass = input.toCharArray();

		String s1 = "";
		String s2 = "";
		int z = 0;
		
		//////////////////////////////////////CYCLE///////////////////////////////////////////////////
				
		for(int i = 0; i < mass.length; i++){
		//System.out.println("check point");
		//МАРКЕР <А-Ш-_-Б-Р-А-У-З> ОТ СЛОВА ВАШ БРАУЗЕР ЗАМЕНЕН НА ****
			
		if(mass[i] == '*' && mass[i+1] == '*' && mass[i+2] == '*' && mass[i+3] == '*' /*&& mass[i+4] == 'р' && mass[i+5] == 'а' && mass[i+6] == 'у' && mass[i+7] == 'з'*/){
		z++; //КОЛИЧЕСТВО МАРКЕРОВ
		
		text_edge.add(i); //ДОБАВЛЯЕМ В МАССИВ ИНДЕКСЫ ДЛЯ РАЗГРАНИЧЕНИЙ
//		System.out.println(text_edge.size());
//	
//			System.out.println(text_edge.get(z-1));
		}

		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////РАБОТА С ИНДЕКСАМИ ДЛЯ РАЗГРАНИЧЕНИЯ ТЕКСТА/////////////////////////////
String y = " ";

for(int i = 1; i < text_edge.size(); i++){	//BAG: ПРОПУСКАЕМ ПЕРВУЮ ВАКАНСИЮ ИЗ-ЗА int i = 1;
int first = (int) text_edge.get(i-1);
int second = (int) text_edge.get(i);

for(int k = first; k  <= second; k++){
//System.out.println(k);
y = y + mass[k];
}

int text_size = y.length();		
text.add(y); //НОВЫЙ МАССИВ С РАЗГРАНИЧЕННЫМ ТЕКСТОМ

y = " ";     //ОБНУЛЯЕМ ПЕРЕМЕННУЮ ДЛЯ НОВОГО ЦИКЛА ИСПОЛЬЗОВАНИЯ
//System.out.println("I am here, text №.. "+ i + " size this text: " + text_size);

}
			
			return text;
		}
	
	public static String delete_part(int heigh, int low, char[] material){
		String s = "";
		
		for(int i = 0; i < heigh; i++){
			s = s + material[i];
			
		}
		
		for(int i = low; i < material.length; i++){
			s = s + material[i];
			
		}
		
		return s;
	}
	
	public static String extract_part(int heigh, int low, char[] material){
		String s = "";
		// hi low
		for(int i = heigh; i < low +1; i++){
			s = s + material[i];
			
		}
		
		return s;
	}
	
}
