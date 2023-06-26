package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

// GetNBbike資訊的主畫面
public class MainContent extends JFrame implements ActionListener {

	
	// 當登入成功後，設計需要的資訊進入按紐
	private ImageIcon icon1 = new ImageIcon("bike.jpg");
	private ImageIcon icon2 = new ImageIcon("movie.jpg");
	private ImageIcon icon3 = new ImageIcon("go.jpg");
	private ImageIcon icon4 = new ImageIcon("train.jpg");
	private ImageIcon icon5 = new ImageIcon("user.jpg");
	
	private JButton bike = new JButton(icon1);
	private JButton movie = new JButton(icon2);
	private JButton fivego = new JButton(icon3);
	private JButton train = new JButton(icon4);
	private JButton user = new JButton(icon5);
	
	//容器
	private Container contentArea = getContentPane();
	private JPanel mainPanel = new JPanel();
	
	public MainContent() {
		bike.addActionListener(this);
		mainPanel.add(bike);
		
		movie.addActionListener(this);
		mainPanel.add(movie);
		
		fivego.addActionListener(this);
		mainPanel.add(fivego);
		
		train.addActionListener(this);
		mainPanel.add(train);
		
		user.addActionListener(this);
		mainPanel.add(user);
		
		contentArea.add(mainPanel);
		
		setLayout(new GridBagLayout());
		setVisible(true);
//		setExtendedState(JFrame.MAXIMIZED_BOTH); // 開啟全視窗
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this); // 設置視窗在中心點
		setSize(1500,1000); // 設置視窗大小
		setResizable(true); // 設置視窗大小可變
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == bike) {
			contentArea.remove(mainPanel);
			contentArea.revalidate(); // 重新整理畫面
			new BikeContent(contentArea,mainPanel);
		}
		if(event.getSource() == movie) {
			contentArea.remove(mainPanel);
			contentArea.revalidate();
			new MovieContent(contentArea,mainPanel);
		}
		if(event.getSource() == train) {
			contentArea.remove(mainPanel);
			contentArea.revalidate();
			try {
				new trainContent(contentArea,mainPanel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(event.getSource() == user) {
			contentArea.remove(mainPanel);
			contentArea.revalidate();
			new AdminContent(contentArea,mainPanel);
		}
		
		if(event.getSource() == fivego) {
			five_go go = new five_go();
			
		}
		
	}

}
