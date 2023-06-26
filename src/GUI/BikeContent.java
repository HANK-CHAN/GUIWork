package GUI;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Web.GetNBbike;

public class BikeContent implements ActionListener{

	Container contentArea;
	JPanel panel = new JPanel();// 換畫面的方
	JScrollPane scroll; // 戶面可拖(卷軸)
	JPanel mainPanel;
	JTable table;
	TableColumnModel tcm;
	Object[][] data;
	JButton back = new JButton("返回");
	
	public BikeContent(Container contentArea,JPanel mainPanel) {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		GetNBbike bike = new GetNBbike();
		try {
			data = bike.getbike();
		}catch(Exception e) {
			e.printStackTrace();
		}
		// 製作表格
		String[] columns = {"站名","總數","可借","可停"};
		// 二維陣列，須將資料&欄位放進去
		table = new JTable(data,columns);
		// 使用滾軸↓，放入表格
		scroll = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
				,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table.setRowHeight(50);// 表格內的高度
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
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
