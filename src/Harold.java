import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//
//ИЗВЛЕКАЕМ ИЗ ТЕКСТОВОГО ФАЙЛА: *3. ТРЕБОВАНИЯ
// ВХОДННЫЕ ДАННЫЕ: target (ВАКАНСИИ ГДЕ ОПЫТ НЕ ТРЕБУЕТСЯ)
// ВЫХОДНЫЕ ДАННЫЕ: requirement

public class Harold extends Tools {
	
	static String target = "";
	static String place = "C:\\Users\\Stalin\\workspace\\JS4\\target.txt";
	static ArrayList list = new ArrayList();
	static ArrayList text_edge = new ArrayList();
	static ArrayList text = new ArrayList();
	static ArrayList mater = new ArrayList();

	public static void main(String[] args) {
		
/////////////////ПРИСВАЕВАЕМ ПЕРЕМЕННОЙ TARGET ДАННЫЕ ИЗ ФАЙЛА TARGET//////////////////////////////////////
		
//		File main_text = new File("C:\\Users\\Stalin\\workspace\\JS4\\target.txt");
//		Scanner scan_main_text = null;
//
//		try {
//		scan_main_text = new Scanner(main_text);
//		} 
//
//		catch (FileNotFoundException e) {
//		e.printStackTrace();
//		}
//
//		target = scan_main_text.nextLine();	
		target = Read_from_file_txt(place);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////РАЗГРАНИЧИВАЕМ ТЕКСТ////////////////////////////////////////////////////////
		mater = text_edge(target);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		char[] mass = target.toCharArray();

		String s1 = "";
		String s2 = "";
		int z = 0;
		
		//////////////////////////////////////CYCLE///////////////////////////////////////////////////
				
		for(int i = 0; i < mass.length; i++){
		
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
*/

	for(int i = 0; i < mater.size(); i++){
		//System.out.println(i + "*//*" + mater.get(i));
		
		
	}
	String s = mater.toString();
	System.out.println(s);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		String abc = "Hello Moscow!";
	Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\exemple.txt", s);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		char [] text_array = target.toCharArray();
//		int z = 0;
//		
//		for(int i = 0; i < text_array.length; i++){
//
//		//МАРКЕР <Р-Е-Б-О-В-А-Н-И-Я-:-> ОТ СЛОВА ТРЕБОВАНИЯ
//			
//		if(text_array[i] == 'б' && text_array[i+1] == 'о' && text_array[i+2] == 'в' && text_array[i+3] == 'а' && text_array[i+4] == 'н' && text_array[i+5] == 'и' && text_array[i+6] == 'я' && text_array[i+7] == ':'){
//		z++; //КОЛИЧЕСТВО МАРКЕРОВ
//		//text_edge.add(i-1); //ДОБАВЛЯЕМ В МАССИВ ИНДЕКСЫ ДЛЯ РАЗГРАНИЧЕНИЙ
//		}
//		
//		}
		
		
		
//		System.out.println(Extract_from_text("бования:", target));
////		Georg g = new Georg();
////	
////		
//		for(int i = 0; i < list.size(); i++){
//			System.out.println("789");
//		System.out.println(list.get(i));
//		}
		
	}

}
