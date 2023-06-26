package GUI;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Web.GetMovie;

public class MovieContent implements ActionListener{

	Container contentArea;
	JPanel panel = new JPanel();
	JScrollPane scroll;
	JPanel mainPanel;
	JTable table;
	Object[][] data;
	JButton back = new JButton("返回");
	private TableColumn tableco;
	
	public MovieContent(Container contentArea,JPanel mainPanel) {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		GetMovie movie = new GetMovie();
		try {
			data = movie.getmo();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 製作表格
		String[] columns= {"電影名稱","上映日期","劇情大綱","網站鏈接"};

		table = new JTable(data,columns);
		
		table.setFont(new Font("楷體",Font.PLAIN,18));
		table.setRowHeight(100);
//		table.getColumnModel().getColumn(0).setPreferredWidth(100);
//		table.getColumnModel().getColumn(1).setPreferredWidth(100);
//		table.getColumnModel().getColumn(2).setPreferredWidth(1000);
//		table.getColumnModel().getColumn(3).setPreferredWidth(1000);
		
		scroll = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
				,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		contentArea.add(panel);
		contentArea.add(scroll);
		contentArea.repaint();
		
		back.addActionListener(this);
		panel.add(back);
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == back) {
			contentArea.remove(scroll);
			contentArea.remove(panel);
			
			contentArea.revalidate();
			contentArea.repaint();
			
			contentArea.add(mainPanel);
			contentArea.repaint();
			
		}
		
		
		
		
	}
	
	
	
}
