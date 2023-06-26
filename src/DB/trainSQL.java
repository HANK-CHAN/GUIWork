package DB;

import java.sql.*;


public class trainSQL {

	private Connection conn = null;
	private Statement stem = null;
	
	// 與資料庫進行連線
	public trainSQL() throws SQLException {
		conn = DriverManager.getConnection(DbConig.url,DbConig.user,DbConig.pwd);
		
	}
	// 解析後的json輸入進資料庫裡
	public void insert(String station,String ename,String address) throws SQLException {
		String sql = "insert into twtrainall(stname,estname,staddress) values('"+station+"','"+ename+"','"+address+"')";
		stem = conn.createStatement();
		
		stem.execute(sql);
	}
	// 設定更新方法
	public void updata(int id,String station,String ename,String address) throws SQLException {
		String sql = "update twtrainall set stname='"+station+",estname="+ename+",staddress="+address+"' where id="+id;
		stem = conn.createStatement();
		
		stem.executeUpdate(sql);
	}
	// 設定刪除方法
	public void delete(int id) throws SQLException {
		String sql = "delete from twtrainall where id="+id;
		stem = conn.createStatement();
		
		stem.executeUpdate(sql);
	}
	// 設定查詢方法
	public ResultSet queryall() throws SQLException {
		String sql = "select * from twtrainall";
		stem = conn.createStatement();
		stem.executeQuery(sql);
		ResultSet rs = stem.getResultSet();
		return rs;
	}
	
	public boolean Login(String acc,String pwd) throws SQLException{
		
		pwd = AccountMD5.getMD5(pwd);// 輸入的密碼先加密才查詢
		
		String sql = "select * from admin where account='"+acc+"'and password='"+pwd+"'";
		System.out.println(sql);
		stem = conn.createStatement();
		stem.executeQuery(sql);
		ResultSet rs = stem.getResultSet();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void UpdatePwd(String acc , String pwd) throws SQLException{
		pwd = AccountMD5.getMD5(pwd);
		
		String sql = "update admin set password='"+pwd+"' where account='"+acc+"'";
		stem = conn.createStatement();
		stem.execute(sql);
	}
	
	public void AddUser(String acc , String pwd) throws SQLException{
		pwd = AccountMD5.getMD5(pwd);
		// 判斷資料庫內的user 是否有重複
		String sql = "select * from admin where account='"+acc+"'";
		
		stem = conn.createStatement();
		stem.executeQuery(sql);
		
		ResultSet rs = stem.getResultSet();
		
		if(!rs.next()) {// 如果沒有找到，才可新增
			sql = "insert into admin(account,password) values('"+acc+"','"+pwd+"')";
			stem = conn.createStatement();
			stem.execute(sql);
		}	
	}
	
}
