package GUI;


import javax.swing.*;

import DB.trainSQL;
import Web.GetNBbike;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminContent implements ActionListener{
	
	Container contentArea;
	JPanel panel = new JPanel();// 換畫面的方
	
	JPanel mainPanel;

	JLabel jpwd = new JLabel("新密碼");
	JPasswordField inputPass = new JPasswordField();
	
	JLabel juser = new JLabel("使用者帳號");
	JLabel jnewpwd = new JLabel("密碼");
	
	JTextField user = new JTextField();
	JPasswordField pass = new JPasswordField();
	
	
	JButton add = new JButton("新增使用者");
	JButton update = new JButton("修改密碼");
	JButton back = new JButton("返回");
	
	public AdminContent(Container contentArea,JPanel mainPanel) {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		
		// 密碼修改欄位設定
		jpwd.setBounds(0, 0, 50, 20);
		inputPass.setBounds(0, 0, 100, 20);
		inputPass.setColumns(20);
		update.addActionListener(this);// 修改密碼
		panel.add(update);
		
		update.setBounds(0, 0, 75, 25);
		
		
		// 新增使用者
		juser.setBounds(400,400,50,20);
		jnewpwd.setBounds(400,500,50,20);
		
		user.setBounds(460, 400, 100, 20);
		user.setColumns(30);
		
		pass.setBounds(460, 500, 100, 20);
		pass.setColumns(30);
		
		add.setBounds(500, 520, 75, 20);
		
		// 添加位置有所區別，要根據添加順序擺放
		panel.add(jpwd);
		panel.add(inputPass);
		panel.add(update);
		
		panel.add(juser);
		panel.add(user);
		
		panel.add(jnewpwd);
		panel.add(pass);
		
		
		
		add.addActionListener(this);// 新增使用者
		panel.add(add);
		
		back.addActionListener(this);// 反迴
		panel.add(back);
		
		
		panel.setLayout(new GridBagLayout());
		// 將前面的設置加入到容器裡面
		
		contentArea.add(panel);
		contentArea.repaint();// 重新整理
		
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == back) {
			// 離開物件移除
			contentArea.remove(panel);
			// 重新整理畫面
			contentArea.revalidate();
			contentArea.repaint();
			
			//替換成原畫面
			contentArea.add(mainPanel);
			contentArea.repaint();
		}
		
		if(event.getSource() == add) {
			String acc = user.getText();
			String pwd= String.valueOf(pass.getPassword());
			try {
				trainSQL ts = new trainSQL();
				ts.AddUser(acc,pwd);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(event.getSource() == update) {
			String newP = String.valueOf(inputPass.getPassword());
			try {
				trainSQL ts = new trainSQL();
				ts.UpdatePwd(Login.userAcc,newP);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
