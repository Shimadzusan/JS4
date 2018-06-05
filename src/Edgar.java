import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edgar extends Conn5{
	
	static String file_text;
	static ArrayList text_edge = new ArrayList();
	static ArrayList text = new ArrayList();
	
	static int i3 = 0;
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{

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
		
		System.out.println(file_text.length());
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		char[] mass = file_text.toCharArray();

		String s1 = "";
		String s2 = "";
		int z = 0;
		
		//////////////////////////////////////CYCLE///////////////////////////////////////////////////
				
		for(int i = 0; i < mass.length; i++){
			
			////////////////////////ЗАМЕНЯЕМ СИМВОЛ ' //////////////////////////////
			if(mass[i] == '\''){
				mass[i] = '.';
			}
			////////////////////////////////////////////////////////////////////////
		
		//МАРКЕР <А-Ш-_-Б-Р-А-У-З> ОТ СЛОВА ВАШ БРАУЗЕР
		if(mass[i] == 'а' && mass[i+1] == 'ш' && mass[i+2] == ' ' && mass[i+3] == 'б' && mass[i+4] == 'р' && mass[i+5] == 'а' && mass[i+6] == 'у' && mass[i+7] == 'з'){
		z++; //КОЛИЧЕСТВО МАРКЕРОВ
		
		text_edge.add(i-1); //ДОБАВЛЯЕМ В МАССИВ ИНДЕКСЫ ДЛЯ РАЗГРАНИЧЕНИЙ
		
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
		
		
//////////////////////////////END OF CYCLE////////////////////////////////////////////////////////////		
		}
		
		System.out.println("Количество искомых маркеров: " + z);
		System.out.println("********************************");
		
//		for(int i = 0; i < text_edge.size(); i++){
//			System.out.println(text_edge.get(i));
//		}
//		
//		String y = "";
//		for(int i = 72; i < 2277; i++){
//		y = y + mass[i];	
//			
//		}
//		System.out.println(y);
//		
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
			System.out.println("I am here, text №.. "+ i + " size this text: " + text_size);
			
		}
		
////////////////////////////РАБОТА С МАССИВОМ ГДЕ ТЕКСТ РАЗГРАНИЧЕН///////////////////////////////////
																//ЗАДАЧА:
	/*															// ЛЯ-ЛЯ-ЛЯ.
		for(int i = 0; i < text.size(); i++){
			boolean bl = true;
			String xx = (String) text.get(i);
			
			char[] mass150 = xx.toCharArray();
			
						for(int i2 = 0; i2 < mass150.length; i2++){
							
							
									if(mass150[i2] == '='){
										
										//!!!ВЫЗЫВАЕМ МЕТОД ОЧИСТКИ!!!
										
										i3++;
										System.out.println("number of text for to clean: " + i);
										bl = false;
										break;
									}
							
							//String g = mass150.toString();
							
									if(bl == true){
										
									}	
						}
		}
		*/
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println(i3 + " * " + text.size());
///////////////////////////////////ПОПЫТКА ЗАГРУЗИТЬ В БАЗУ РАЗГРАНИЧЕННЫЙ ТЕКСТ ИЗ ФАЙЛА/////////////
		String a = "";
		for(int i = 1; i < text.size(); i++){
			
			String xxx = (String) text.get(i);
			
			a = Integer.toString(i);
			Conn();
			WriteDB(a, xxx);// To Write in DB
			
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		}

	
	}
