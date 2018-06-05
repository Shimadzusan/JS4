import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//ИЗВЛЕКАЕМ ИЗ ТЕКСТОВОГО ФАЙЛА: 1. ОПЫТ РАБОТЫ, 2. ФИРМА, 3. ТРЕБОВАНИЯ
// ВХОДННЫЕ ДАННЫЕ: main_super_text
// ВЫХОДНЫЕ ДАННЫЕ: target (ВАКАНСИИ ГДЕ ОПЫТ НЕ ТРЕБУЕТСЯ)

	
	
public class Georg {

	static String file_text = "";
	static ArrayList text_edge = new ArrayList();
	static ArrayList text = new ArrayList();
	static ArrayList text2 = new ArrayList(); //СПИСОК СОСТАВЛЕН ПО МАРКЕРУ ОПЫТ ОТСТУТСТ.
	
	public static void main(String[] args) {
		File main_text = new File("C:\\Users\\Stalin\\workspace\\JS4\\main_super_text.txt");
		Scanner scan_main_text = null;

		try {
		scan_main_text = new Scanner(main_text);
		} 

		catch (FileNotFoundException e) {
		e.printStackTrace();
		}

		String s_file = scan_main_text.nextLine();
		file_text = s_file;
		//System.out.println(file_text.length());
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		char[] mass = file_text.toCharArray();

		String s1 = "";
		String s2 = "";
		int z = 0;
		
		//////////////////////////////////////CYCLE///////////////////////////////////////////////////
				
		for(int i = 0; i < mass.length; i++){
		
////////////////////////ЗАМЕНЯЕМ СИМВОЛ ' //////////////////////////////
		if(mass[i] == '\''){
		mass[i] = ' ';
		}
////////////////////////////////////////////////////////////////////////
		
		//МАРКЕР <А-Ш-_-Б-Р-А-У-З> ОТ СЛОВА ВАШ БРАУЗЕР
		if(mass[i] == 'а' && mass[i+1] == 'ш' && mass[i+2] == ' ' && mass[i+3] == 'б' && mass[i+4] == 'р' && mass[i+5] == 'а' && mass[i+6] == 'у' && mass[i+7] == 'з'){
		z++; //КОЛИЧЕСТВО МАРКЕРОВ
		
		text_edge.add(i-1); //ДОБАВЛЯЕМ В МАССИВ ИНДЕКСЫ ДЛЯ РАЗГРАНИЧЕНИЙ
		
		//ИЗВЛЕКАЕМ ФАКТУРУ
		//s1 = "" + mass[i-12] + mass[i-11] + mass[i-10] + mass[i-9] + mass[i-8]+ mass[i-7] + mass[i-6] + mass[i-5] + mass[i-4] + mass[i-3];
		//System.out.println(s1);
		//ОЧИЩАЕМ, ИЗВЛЕКАЯ ТОЛЬКО ЧИСЛО, VAR S2
		
		//char[] mass5 = s1.toCharArray();
		//
		//for(int k = 0; k < mass5.length; k++) {
		//if(Character.isDigit(mass5[k])){
		////System.out.println(text30[i]);
		//
		//s2 = s2 + Character.toString(mass5[k]);
		//}
		
		//sir++;
		
		}
		//System.out.println("case: " + z + " number: " + s2);//..ВЫВОД ЧИСЕЛ ДЛЯ ССЫЛКИ
		
		//list5.add(s2);
		
		//s2 = ""; //ОБНУЛЯЕМ
		
		
		//////////////////////////////END OF CYCLE////////////////////////////////////////////////////////////		
		}
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
		
//////////////////////////////////РАБОТА С РАЗГРАНИЧЕННЫМ ТЕКСТОМ/////////////////////////////////////
		int u = 0;
		for(int ii= 0; ii < text.size(); ii++){
			String s5 = (String) text.get(ii);
			//System.out.println("control of...");
			char[] mass100 = s5.toCharArray();
			//МАРКЕР <А-Ш-_-Б-Р-А-У-З> ОТ СЛОВА ВАШ БРАУЗЕР
			for(int i = 0; i < mass100.length; i++){
			
			if(mass100[i] == 'а' && mass100[i+1] == 'б' && mass100[i+2] == 'о' && mass100[i+3] == 'т' && mass100[i+4] == 'ы' && mass100[i+5] == ':' && mass100[i+6] == ' ' && mass100[i+7] == 'н'){
			//z++; //КОЛИЧЕСТВО МАРКЕРОВ
				u++;
				System.out.println(u);
				text2.add(s5);
			}
			}
			
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		///вывод целевых вакансий
		String target = "";
		for(int i = 0; i < text2.size(); i++){
//			System.out.println("...number: " + i);
//			System.out.println(text2.get(i));
//			System.out.println();
			
			target = target + text2.get(i);
			
		}
//////////////////////////////////////////////////WRITE TO FILE////////////////////////////////////////
//////////////READ FROM TIME_FILE //////////////////////////////////////

File main_text2 = new File("C:\\Users\\Stalin\\workspace\\JS4\\target.txt");
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





String j = s_file2 + target;
pww10.println(j);
pww10.close();

	
		
		
		
	/*	
		//////////////////////////////////////CYCLE///////////////////////////////////////////////////
				
		for(int i = 0; i < mass.length; i++){
			
			////////////////////////ЗАМЕНЯЕМ СИМВОЛ '  НА ПРОБЕЛ//////////////////////////////
			if(mass[i] == '\''){
				mass[i] = ' ';
			}
			////////////////////////////////////////////////////////////////////////
		
		//МАРКЕР <А-Ш-_-Б-Р-А-У-З> ОТ СЛОВА ВАШ БРАУЗЕР
		if(mass[i] == 'а' && mass[i+1] == 'б' && mass[i+2] == 'о' && mass[i+3] == 'т' && mass[i+4] == 'ы' && mass[i+5] == ':' && mass[i+6] == ' ' && mass[i+7] == 'н'){
		z++; //КОЛИЧЕСТВО МАРКЕРОВ
		
		//text_edge.add(i); //ДОБАВЛЯЕМ В МАССИВ ИНДЕКСЫ ДЛЯ РАЗГРАНИЧЕНИЙ
		
		//ИЗВЛЕКАЕМ ФАКТУРУ
		s1 = "" + mass[i-12] + mass[i-11] + mass[i-10] + mass[i-9] + mass[i-8]+ mass[i-7] + mass[i-6] + mass[i-5] + mass[i-4] + mass[i-3];
		//System.out.println(s1);
		//ОЧИЩАЕМ, ИЗВЛЕКАЯ ТОЛЬКО ЧИСЛО, VAR S2
		
//		char[] mass5 = s1.toCharArray();
//		
//		for(int k = 0; k < mass5.length; k++) {
//		if(Character.isDigit(mass5[k])){
//			//System.out.println(text30[i]);
//		
//		s2 = s2 + Character.toString(mass5[k]);
//		}
		
		//sir++;
		
		}
		//System.out.println("case: " + z + " number: " + s2);//..ВЫВОД ЧИСЕЛ ДЛЯ ССЫЛКИ
		
		//list5.add(s2);
		
		s2 = ""; //ОБНУЛЯЕМ

	}
	*/
		System.out.println(z);
	}
}
