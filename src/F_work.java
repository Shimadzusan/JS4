import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//КЛАСС ДЛЯ ОБРАЩЕНИЙ К ФАКТУРЕ В БАЗЕ ДАННЫХ
//ЗАПРОС...
//ОТВЕТ...
public class F_work {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println("I am F_work!");
		ArrayList list50 = new ArrayList();
		
		Conn20 conn = new Conn20();
		
		conn.Conn();
		conn.CreateDB();
		list50 = conn.ReadDB();
		//conn.WriteDB(time, specialization, location, enterprise, experience, text);
		conn.CloseDB();
//		System.out.println(list50.size());
//		System.out.println(list50.get(155));
		
		int x = 1;
		int z = 1;
//	//////////////////////////////////////////////////////////
//		for(int i = 0; i < list50.size(); i++){
//			String s = (String) list50.get(i);
//			
//				for(int i2 = 0; i2 < list50.size(); i2++){
//					String s2 = (String) list50.get(i2);
//						if(s.equals(s2)){
//							
//							x++;
//						}
//				}
//		}
		System.out.println(x);
		System.out.println("Begin!");
		System.out.println(list50.size());
		System.out.println();
		ArrayList <Object>list70 = new ArrayList<Object>();
		
		for(int i = 0; i < list50.size(); i++){
							String q = (String) list50.get(i);
							
								for(int i2 = list50.size()-1; i2 > 0; i2--){
									String q2 = (String) list50.get(i2);
									if(q.equals(q2)){
										x++;
										list50.remove(i2);
										
										
//											if(x > 4){
//												System.out.println(q2);
//											}
										
									}
									
								}
								//list50.remove(i);
								
								//System.out.println(x + " ... |" + q +"|  size: "+ list50.size()+ " z: " + z);
								x=0;
								z++;
								list70.add(q);
								
		}
		
		int z2 = 0;
		 for (Object i:list70) {
			 z2++;
	           System.out.println(i+" / " + z2);
	           }
/////////////////////////////////////////////////////////////////////////////////////////////
//		ArrayList list60 = new ArrayList();
//		list60 = list50;
//		for(int i = 0; i < list50.size(); i++){
//			String q = (String) list50.get(i);
//			
//				for(int i2 = 0; i2 < list60.size(); i2++){
//					String q2 = (String) list60.get(i2);
//					if(q.equals(q2)){
//						x++;
//						list50.remove(i2);
//						i = 0;
//						
//						
////							if(x > 4){
////								System.out.println(q2);
////							}
//						
//					}
//					
//				}
//				//list50.remove(i);
//				System.out.println(x + " ... |" + q +"|  size: "+ list50.size());
//				x=0;
//				
//}
		
	}

}
