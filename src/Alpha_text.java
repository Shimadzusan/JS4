import java.util.ArrayList;

//ВХОДНЫЕ ДАННЫЕ: ПЕРВИЧНЫЙ ТЕКСТ, FILE: main_super_text
//ВЫХОДНЫЕ ДАННЫЕ: ТЕКСТ ОБРАБОТАННЫЙ(ОЧИСТКА ОТ МУСОРА) В ДАННОМ КЛАССЕ И ГОТОВЫЙ К ЗАПИСИ В D.B., file: omega

public class Alpha_text extends Tools {

	static public String alpha_text = "";
	static ArrayList material = new ArrayList();
	//omega_text output*
	
	public static void main(String[] args) {
		
		alpha_text = Read_from_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\main_super_text.txt");
		material = text_edge(alpha_text); //ПОЛУЧАЕМ РАЗГРАНИЧЕННЫЙ ТЕКСТ
		
		for(int i = 0; i < material.size(); i++){
			String s = (String) material.get(i);
			
			char [] text_array = s.toCharArray();
				for(int i2 = 0; i2 < text_array.length; i2++){
					if(text_array[i2] == '='){
						String s2 = remove_html_trash(s);//!START METHOD OF REMUVE HTML-TRASH
						material.set(i, s2);
						break;
					}
				}
		}		
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String s4 = "";
		for(int i = 0; i < material.size(); i++){
			String s = (String) material.get(i);
			s4 = remove_text_trash(s);//!МЕТОД УДАЛЕНИЯ ЛИШНЕЙ ФАКТУРЫ
			material.set(i, s4);
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//		
//		String s5 = "";
//		for(int i = 0; i < material.size(); i++){
//			String s = (String) material.get(i);
///////////////////////!!!!!!!!!!!!!!!
////	if(i == 0){
////		Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\target.txt", s);
////		System.out.println("cherck");
////	}
////	/////!!!!!!!!!!!!!!!!
//			s5 = remove_text_trash_last(s);//!МЕТОД222 УДАЛЕНИЯ ЛИШНЕЙ ФАКТУРЫ СВЕРХУ И СНИЗУ!!!
//			material.set(i, s5);
//		}
		
		String omega = material.toString();
		Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\omega.txt", omega);	
	}
////////////////////////////////////////////***//////////////////////////////////////////////////////////
	
	public static String remove_html_trash(String a){

		char [] search_marker = a.toCharArray();
		int heigh = 0;
		int low = 0;
		
			for(int i = 0; i < search_marker.length; i++){
				if(search_marker[i] == '='){
					heigh = i;
					break;
				}
			}
			
			for(int i = search_marker.length-1; i > 0; i--){
				if(search_marker[i] == '='){
					low = i;
					break;
				}
			}
			
			String b = delete_part(heigh, low, search_marker);
		return b;
	}
	
	public static String remove_text_trash(String a){
		
		char [] marker = a.toCharArray();
		int heigh = 0;
		int low = marker.length-1;
		
			for(int i = marker.length - 1; i > 0; i--){//ОТ "ПОДЕЛИТЬСЯ"
				if(marker[i] == 'я' && marker[i-1] == 'с' && marker[i-2] == 'ь' && marker[i-3] == 'т' && marker[i-4] == 'и' && marker[i-5] == 'л'){
					heigh = i-23;
					break;
				}
			}
	
			String b = delete_part(heigh, low, marker);
		return b;
	}
////////////////////////////////////////////////////???//////////////////////////////////////////////////
	
	public static String remove_text_trash_last(String a){
		char [] marker = a.toCharArray();
		int height = 0;
		int low = 0;
			for(int i = 0; i < marker.length; i++){//МАРКЕР: ДОБАВИТЬ ЭТУ, ВЕРХНЯЯ ГРАНИЦА
				if(marker[i] == 'т' && marker[i+1] == 'ь' && marker[i+2] == ' ' && marker[i+3] == 'э' && marker[i+4] == 'т' && marker[i+5] == 'у'){
					height = i + 6;
					break;
				}
			}
			String b = delete_part(0, height, marker);
			//System.out.println(marker[0]+ "  * " + height);
			char [] marker2 = b.toCharArray();
			
			for(int i = marker2.length-1; i > 0; i--){//МАРКЕР: ОТКЛИКНУТЬСЯ, НИЖНЯЯ ГРАНИЦА
				if(marker2[i] == 'л' && marker2[i-1] == 'к' && marker2[i-2] == 'т' && marker2[i-3] == 'О'){
					low = i - 4;
					break;
				}
			}
			
			
			String c = delete_part(low, marker2.length, marker2);
		return c;
	}
}
