package Web;


import java.net.URL;
import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetNBbike {
	public Object[][] getbike() throws Exception{
		
		String url ="https://data.ntpc.gov.tw/api/datasets/010e5b15-3823-4b20-b401-b1cf000550c5/json?size=100";
		
		// 網頁抓取必定使用 InputStream
		InputStream is = new URL(url).openStream();
		
		Object[][] data = null;
		
		try {
			// 物件使用 BufferedReader 在裡面進行編碼
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			int cp;
			// 使用StringBuilder 方便進行修改
			StringBuilder sb = new StringBuilder();
			while ((cp = br.read()) != -1)
				sb.append((char)cp);// 使用append 新增資料
//			System.out.println(sb.toString());
			JSONArray arr = new JSONArray(sb.toString());//放入陣列
			data = new Object[arr.length()][4];// 確認需要的長度
			// 使用迴圈解析
			for(int i=0 ; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				data[i][0] = obj.getString("sna");// 地點
				data[i][1] = obj.getString("tot");// 總數量
				data[i][2] = obj.getString("sbi");// 可借
				data[i][3] = obj.getString("bemp");// 可停
			}
			
//			System.out.println(data[1][0].toString());
//			System.out.println(data[1][1].toString());
//			System.out.println(data[1][2].toString());
//			System.out.println(data[1][3].toString());
		}
		finally {
			// 當抓取完畢，停止搜尋
			is.close();
		}
		
		return data;
		
	}
}
