package Web;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.parser.Element;

import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class GetMovie {
	
	public Object[][] getmo() throws Exception {
		
//		while(j<5) {
			String url = "https://movies.yahoo.com.tw/movie_intheaters.html";
//			url = url + "?page=" + ++j ;
			//直接使用 Document 爬蟲
			Document doc = Jsoup.connect(url).get();
			Object[][] data = null;
			
			try {
				// 找尋該div板塊 的 classa名稱
				Elements titleLink = doc.select("div.release_info");
	//			Elements titleLink = doc.select("ul.release_list");
				data = new Object[titleLink.size()][4];
				// 進行迴圈解析
				for(int i=0 ; i < titleLink.size(); i++) {
					
					data[i][0] = titleLink.get(i).select("div.release_movie_name").select("a").text(); // 電影名稱
					data[i][1] = titleLink.get(i).select("div.release_movie_time").text(); // 上映時間
					data[i][2] = titleLink.get(i).select("div.release_text").text(); // 劇情大綱
					data[i][3] = titleLink.get(i).select("a").attr("href");// 網路地址
					
	//				System.out.println(title);
	//				System.out.println(date);
	//				System.out.println(story);
	//				System.out.println(link);
					
				}
				
			}
			finally {
//				if(j==4)
					// 當抓取完畢，停止搜尋
					doc.clone();
			}
			
		return data;
	}
	
}
