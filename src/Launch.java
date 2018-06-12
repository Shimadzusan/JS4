import java.sql.SQLException;

public class Launch {
	//UTF-8!!!
	
	static String v_msk_jj = "https://hh.ru/search/vacancy?text=Java+junior&specialization=1.221&area=1&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=100&no_magic=true";
	static String v_spb_jj = "https://hh.ru/search/vacancy?text=Java+junior&specialization=1.221&area=2&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=100&no_magic=true";
	static String v_mnsk_jj = "https://hh.ru/search/vacancy?text=Java+junior&specialization=1.221&area=1002&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=100&no_magic=true";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Delta delta = new Delta();
		
		delta.get_html(v_msk_jj);
		//System.out.println(delta.html);
		delta.search();
//		delta.form_url();
		
		
		delta.get_html(v_spb_jj);
		//System.out.println(delta.html);
		delta.search();
//		delta.form_url();
//		
		
		delta.get_html(v_mnsk_jj);
		//System.out.println(delta.html);
		delta.search();
		delta.form_url();

	}

}
