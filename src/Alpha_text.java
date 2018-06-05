import java.util.ArrayList;

//ВХОДНЫЕ ДАННЫЕ: ПЕРВИЧНЫЙ ТЕКСТ, FILE: main_super_text
//ВЫХОДНЫЕ ДАННЫЕ: ТЕКСТ ОБРАБОТАННЫЙ В ДАННОМ КЛАССЕ И ГОТОВЫЙ К ЗАПИСИ В D.B., file: omega

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
						String s2 = remuve_html_trash(s);//!START METHOD OF REMUVE HTML-TRASH
						material.set(i, s2);
						break;
					}
				}
		}		
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String s4 = "";
		for(int i = 0; i < material.size(); i++){
			String s = (String) material.get(i);
			s4 = remuve_text_trash(s);//!МЕТОД УДАЛЕНИЯ ЛИШНЕЙ ФАКТУРЫ
			material.set(i, s4);
		}
		
		String omega = material.toString();
		Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\omega.txt", omega);	
	}
////////////////////////////////////////////***//////////////////////////////////////////////////////////
	
	public static String remuve_html_trash(String a){

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
	
	public static String remuve_text_trash(String a){
		
		char [] marker = a.toCharArray();
		int heigh = 0;
		int low = marker.length-1;
		
			for(int i = 0; i < marker.length; i++){//ОТ "ПОДЕЛИТЬСЯ"
				if(marker[i] == 'л' && marker[i+1] == 'и' && marker[i+2] == 'т' && marker[i+3] == 'ь' && marker[i+4] == 'с' && marker[i+5] == 'я'){
					heigh = i;
					break;
				}
			}
	
			String b = delete_part(heigh, low, marker);
		return b;
	}
}
