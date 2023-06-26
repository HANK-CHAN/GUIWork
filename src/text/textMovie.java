package text;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import Web.List;

public class textMovie {
	
	static ArrayList<List> movieitem = new ArrayList<>();

	public static void main(String[] arg) throws IOException {
		
		int j = 1;
		while(j<5) {
			String url = "https://movies.yahoo.com.tw/movie_intheaters.html";
			url = url + "?page=" + ++j ;
			//直接使用 Document 爬蟲
			Document doc = Jsoup.connect(url).get();
			Object[][] data = null;
			
			try {
				// 找尋該div板塊 的 classa名稱
				Elements titleLink = doc.select("div.release_info");
		//			Elements titleLink = doc.select("ul.release_list");
				data = new Object[movieitem.size()][4];
				// 進行迴圈解析
				for(int i=0 ; i < titleLink.size(); i++) {
					
					String title = titleLink.get(i).select("div.release_movie_name").select("a").text(); // 電影名稱
					String date = titleLink.get(i).select("div.release_movie_time").text(); // 上映時間
					String story = titleLink.get(i).select("div.release_text").text(); // 劇情大綱
					String link = titleLink.get(i).select("a").attr("href");// 網路地址
					
					movieitem.add(new List(title,date,story,link));
					
				}
				
			}
			finally {
				if(j == 4)
					doc.clone();
			}
		}
		
	}
	
	
}
