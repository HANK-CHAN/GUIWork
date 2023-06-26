package DB;
import java.security.MessageDigest;

public class AccountMD5 {
	// 密碼加密
	public static String getMD5(String msg) {
	
		// 使用16進制的加密方式
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 得到的文字進行編碼
			messageDigest.update(msg.getBytes("UTF-8"));
			
			// 使用 Hash計算方式，產生128為的長整數
			byte[] bytes = messageDigest.digest();
			
			StringBuffer sb = new StringBuffer();
			
			//使用正向行迴圈進行演算
			for (Byte b : bytes) {//一個一個做轉換
				// 將得到的文字b 右移四位,取得char 中前四位賺換
				sb.append(hexDigits[ (b >> 4 & 0x0f) ] );
				sb.append(hexDigits[b & 0x0f]);
			}
			
			// 進行傳換
			msg = sb.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		// 迴傳換好的文字
		return msg;
	}
	
}
