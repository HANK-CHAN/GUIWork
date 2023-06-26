package Web;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;
import DB.trainSQL;

// 將json 檔 寫入SQL 並顯示
public class TWtrain {
	
	public static void main(String[] arg) throws Exception{
		
			trainSQL train  = new trainSQL();
			
			FileInputStream  fis = null;
			BufferedReader br = null;
			String fileName = "train.json";
		
			
			try {
				
				fis = new FileInputStream(fileName);
				// 檔案使用 InputStreamReader 在裡面進行編碼
				InputStreamReader reader = new InputStreamReader(fis,"utf-8");
				
				br = new BufferedReader(reader);
				
				// 使用StringBuilder 方便進行修改
				StringBuilder sb = new StringBuilder();
				String data;
				while ((data = br.readLine()) != null)
					sb.append(data);// 使用append 新增資料
				
				JSONArray arr = new JSONArray(sb.toString());//放入陣列
				
				String stationname;
				String ename,estationname;
				String staddress,address;
				
				// 使用迴圈解析
				for(int i=0 ; i < arr.length(); i++) {
					JSONObject obj = arr.getJSONObject(i);
					stationname = obj.getString("stationName");
					ename= obj.getString("stationEName");
					address = obj.getString("stationAddrTw");
					// 去除資料裡的所有標點符號 -> .replaceAll("\\p{Punct}","")
					estationname = ename.replaceAll("\\p{Punct}", "");
					staddress= address.replaceAll("\\p{Punct}","");
					train.insert(stationname, estationname,staddress);
//					System.out.println("第 "+ i +" 筆");
//					System.out.println(stationname);
//					System.out.println(estationname);
//					System.out.println(staddress);
//					System.out.println();
					
				}
			}
			finally {
				// 當抓取完畢，停止搜尋
				br.close();
			}
		}
}
