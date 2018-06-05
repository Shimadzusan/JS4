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
	static ArrayList mater = new ArrayList();

	public static void main(String[] args) {
		
/////////////////ПРИСВАЕВАЕМ ПЕРЕМЕННОЙ TARGET ДАННЫЕ ИЗ ФАЙЛА TARGET//////////////////////////////////////

		target = Read_from_file_txt(place);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////РАЗГРАНИЧИВАЕМ ТЕКСТ////////////////////////////////////////////////////////
		mater = text_edge(target); //РАЗГРАНИЧЕННЫЙ ТЕКСТ
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		String s2 = "";
		String s3 = "";
		for(int i = 0; i < mater.size(); i++){
			String s = (String) mater.get(i);
			//System.out.println(s);
			/////////////////////////////////////////////////
			int a = Extract_from_text("бования:", s);
			int b = Extract_from_text("охожие в", s);
			System.out.println(a + "^" + b);
			
			
			///////////////////////////////////////////////////
			if(a > 0){
			char [] text_array = s.toCharArray();
			
					for(int i2 = a; i2 < b; i2++){
						s2 = s2 + text_array[i2];
					}
			System.out.println(s2);
			Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\requirement.txt", s2);
			s2 = "";
		}
			else{
				
				Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\requirement2.txt", s);
				
			}
		}
		
		

		

		
	}

}
