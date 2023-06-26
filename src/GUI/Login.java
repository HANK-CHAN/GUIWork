package GUI;

import javax.swing.*;
import java.awt.event.*;  // 畫面中抓event

import DB.trainSQL;

public class Login extends JFrame implements ActionListener{
	
	public static String userAcc;
	
	// 輸入框名稱
	private JLabel txtId = new JLabel("帳號");
	private JLabel txtpwd = new JLabel("密碼");
	// 輸入框
	private JTextField inputId = new JTextField();
	private JPasswordField inputPass = new JPasswordField();
	
	// 按鈕
	private JButton btnLogin = new JButton("登入");
	private JButton btnCancel = new JButton("取消");
	
	
	public Login() {
		super("資源系統");// 標題
		// 設置輸入框位置、大小 // x軸,y軸,寬,高
		txtId.setBounds(50,50,50,20);
		add(txtId);		// x軸不變, y軸下降
		txtpwd.setBounds(50,80,50,20);
		add(txtpwd);
		inputId.setBounds(110,50,100,20);
		add(inputId);
		inputPass.setBounds(110,80,100,20);
		add(inputPass);
		// 設置 按鈕位置、大小
		btnLogin.setBounds(70,120,75,20);
		// 監聽物件
		btnLogin.addActionListener(this);
		add(btnLogin);// 添加實施
		
		btnCancel.setBounds(155,120,75,20);
		btnCancel.addActionListener(this);
		add(btnCancel);
		
		setLayout(null);
		setBounds(800,400,300,200); // 大小、位置
		// setVisible(true)-> 表示畫面參數已設置好，可以開始畫圖顯示
		setVisible(true); // 設置顯示
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 設置關閉
		
		
	}
	// 監聽設置coding 處理實作事件
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnLogin) {
			
			String acc = inputId.getText();
			// 密碼使用字元，在外面包上一層string.valueOf 轉換才不會出錯
			String pwd = String.valueOf(inputPass.getPassword());
			
			boolean isCheck = false;
			try {// 使用布林判斷，如果返回true 即可登入
				trainSQL tsql = new trainSQL();
				isCheck = tsql.Login(acc, pwd);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
//			if(acc.equals("admin") && pwd.equals("lccadmin123") )
			if(isCheck){
				userAcc = acc;
				new MainContent();
				setVisible(false); //當進入新畫面，將此login畫面隱藏		
				
			}else {
				// 跳出視窗顯示訊息
				JOptionPane.showMessageDialog(null,"帳密錯誤","登入資訊:",JOptionPane.PLAIN_MESSAGE);
			}
			
			
		}
		if(event.getSource() == btnCancel ) {
			
			inputId.setText("");
			inputPass.setText("");
		}
	}
	
}
