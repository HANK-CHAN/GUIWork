package GUI;

import javax.swing.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import DB.trainSQL;
import Web.GetNBbike;

public class trainContent implements ActionListener{
	
	
	Container contentArea;
	JPanel panel = new JPanel();// 換畫面的方
	JScrollPane scroll; // 戶面可拖(卷軸)
	JPanel mainPanel;
	JTable table;
	Object[][] data;
	JButton back = new JButton("返回");
	
	public trainContent(Container contentArea,JPanel mainPanel) throws SQLException {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		trainSQL train = new trainSQL();
		
		try {
			ResultSet rs = train.queryall();
			
			data = new Object[383][4];
			int i =0;
			while(rs.next()) {
				data[i][0] = rs.getInt("id");
				data[i][1] = rs.getString("stname");
				data[i][2] = rs.getString("estname");
				data[i][3] = rs.getString("staddress");
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 製作表格
		String[] columns = {"編號","車站名稱","車站英文名","車站地址"};
		// 二維陣列，須將資料&欄位放進去
		table = new JTable(data,columns);
		// 使用滾軸↓，放入表格
		scroll = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
				,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table.setRowHeight(50);// 表格內的高度
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setFont(new Font("楷體",Font.PLAIN,18));
		back.addActionListener(this);// 反迴
		panel.add(back);
		
		// 將前面的設置加入到容器裡面
		contentArea.add(panel);
		contentArea.add(scroll);
		contentArea.repaint();// 重新整理
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == back) {
			// 離開物件移除
			contentArea.remove(scroll);
			contentArea.remove(panel);
			// 重新整理畫面
			contentArea.revalidate();
			contentArea.repaint();
			
			//替換成原畫面
			contentArea.add(mainPanel);
			contentArea.repaint();
		}
		
	}


}
