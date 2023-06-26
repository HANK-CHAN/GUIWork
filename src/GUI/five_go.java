package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class five_go implements ActionListener{
	
	Random random = new Random(); //亂數
	JFrame frame = new JFrame(); // 事窗
	JPanel title_panel = new JPanel(); //放置名稱
	JPanel button_panel = new JPanel(); 
	JPanel buttonRE = new JPanel();
	JLabel textfield = new JLabel(); // 文字標籤
	JButton[] buttons = new JButton[25]; // 按鈕
	boolean player1_turn;
	JButton back = new JButton("返回");

	public five_go(){
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//可關閉
		frame.setSize(1200, 1000);//視窗大小
		//用getContentPane()方法獲取JFrame的內容面版
		frame.getContentPane().setBackground(new Color(80,80,80));
		// 面板控制管理員放入 BorderLayout(邊界布局)
		/*BorderLayout 邊界佈局，共有五個區域位置配置
		在 Java 1.4 之後，新版 SDK，採用頁首、頁尾、行首、行尾和中間配置*/
		frame.setLayout(new BorderLayout()); 
		frame.setVisible(true);// 重新整理畫面
		
		textfield.setBackground(new Color(30,30,30));// 背景顏色為R.B.G
		textfield.setForeground(new Color(30,255,0));// 前景色
		textfield.setFont(new Font("Serif",Font.BOLD,80));//設定字型與顏色大小
		textfield.setHorizontalAlignment(JLabel.CENTER);//水平方向對其中間
		textfield.setText("五字棋");
		textfield.setOpaque(true);// 設定看得見背景顏色，若不要可改false
		// titile_panel 設置面板控制器
		title_panel.setLayout(new BorderLayout());
		// 設定位置與大小 (x軸,y軸,寬,高)
		title_panel.setBounds(0, 0, 800, 100);
		// 创建具有指定行数和列数的网格布局。  GridLayout()在单行中创建一个网格布局，每个组件的默认值为一列。
		button_panel.setLayout(new GridLayout(5,5));
		button_panel.setBackground(new Color(143,188,143));
		// 設置有100格的按鈕
		for(int i=0;i<25;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boil",Font.BOLD,100));
			buttons[i].setBackground(new Color(143,188,143));
			//setFocusable(boolean focusable)将此 Component 的焦点状态设置为指定值。此值覆盖 Component 的默认焦点状态。
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);// 實施監聽
		}
		
		buttonRE.setBounds(0,0,100,100);
		back.addActionListener(this);
		buttonRE.add(back);
		
		title_panel.add(textfield);// 設定好的文字放入面板
		// 再將文字面板放入設置的視窗 BorderLayout.NORTH -> 上面 (北方) 
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		frame.add(buttonRE,BorderLayout.SOUTH);
		
		firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 對100 個按鈕實施監聽
		for(int i=0; i < 25; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					// 當該選手按下按鈕時，在按鈕上加上文字
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,0));
						buttons[i].setText("0");
						player1_turn =false;// 換下一位
						textfield.setText("白棋_下");// 換人 header 換文字
						check();// 進入確認方法實作
					}
				}else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,250,240));
						buttons[i].setText("O");
						player1_turn=true;// 換下一位
						textfield.setText("黑棋_下");
						check();
					}
				}
			}
		}
		if(e.getSource() == back) {
			
		}
		
		
	}
	
	public void firstTurn() {
		// 寫下進入遊戲時 2秒後開始
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 隨機讓其中一方先下
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("黑棋_下");
		}else {
			player1_turn=false;
			textfield.setText("白旗_下");
		}
	}
	
	public void check() {
		// 如果黑棋勝利
		if(
				(buttons[0].getText()=="0")&&
				(buttons[1].getText()=="0")&&
				(buttons[2].getText()=="0")&&
				(buttons[3].getText()=="0")&&
				(buttons[4].getText()=="0")
				) {
			
			xWins(0,1,2,3,4);
		}
		if(
				(buttons[5].getText()=="0")&&
				(buttons[6].getText()=="0")&&
				(buttons[7].getText()=="0")&&
				(buttons[8].getText()=="0")&&
				(buttons[9].getText()=="0")
				) {
			
			xWins(5,6,7,8,9);
		}
		if(
				(buttons[10].getText()=="0")&&
				(buttons[11].getText()=="0")&&
				(buttons[12].getText()=="0")&&
				(buttons[13].getText()=="0")&&
				(buttons[14].getText()=="0")
				) {
			
			xWins(10,11,12,13,14);
		}
		if(
				(buttons[15].getText()=="0")&&
				(buttons[16].getText()=="0")&&
				(buttons[17].getText()=="0")&&
				(buttons[18].getText()=="0")&&
				(buttons[19].getText()=="0")
				) {
			
			xWins(15,16,17,18,19);
		}
		if(
				(buttons[20].getText()=="0")&&
				(buttons[21].getText()=="0")&&
				(buttons[22].getText()=="0")&&
				(buttons[23].getText()=="0")&&
				(buttons[24].getText()=="0")
				) {
			
			xWins(20,21,22,23,24);
		}
		if(
				(buttons[0].getText()=="0")&&
				(buttons[5].getText()=="0")&&
				(buttons[10].getText()=="0")&&
				(buttons[15].getText()=="0")&&
				(buttons[20].getText()=="0")
				) {
			
			xWins(0,5,10,15,20);
		}
		if(
				(buttons[1].getText()=="0")&&
				(buttons[6].getText()=="0")&&
				(buttons[11].getText()=="0")&&
				(buttons[16].getText()=="0")&&
				(buttons[21].getText()=="0")
				) {
			
			xWins(1,6,11,16,21);
		}
		if(
				(buttons[2].getText()=="0")&&
				(buttons[7].getText()=="0")&&
				(buttons[12].getText()=="0")&&
				(buttons[17].getText()=="0")&&
				(buttons[22].getText()=="0")
				) {
			
			xWins(2,7,12,17,22);
		}
		if(
				(buttons[3].getText()=="0")&&
				(buttons[8].getText()=="0")&&
				(buttons[13].getText()=="0")&&
				(buttons[18].getText()=="0")&&
				(buttons[23].getText()=="0")
				) {
			
			xWins(3,8,13,18,23);
		}
		if(
				(buttons[4].getText()=="0")&&
				(buttons[9].getText()=="0")&&
				(buttons[14].getText()=="0")&&
				(buttons[19].getText()=="0")&&
				(buttons[24].getText()=="0")
				) {
			
			xWins(4,9,14,19,24);
		}
		if(
				(buttons[0].getText()=="0")&&
				(buttons[6].getText()=="0")&&
				(buttons[12].getText()=="0")&&
				(buttons[18].getText()=="0")&&
				(buttons[24].getText()=="0")
				) {
			
			xWins(0,6,12,18,24);
		}
		if(
				(buttons[4].getText()=="0")&&
				(buttons[8].getText()=="0")&&
				(buttons[12].getText()=="0")&&
				(buttons[16].getText()=="0")&&
				(buttons[20].getText()=="0")
				) {
			
			xWins(4,8,12,16,20);
		}
		
		// 如果白旗勝利
		
		if(
				(buttons[0].getText()=="O")&&
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")&&
				(buttons[3].getText()=="O")&&
				(buttons[4].getText()=="O")
				) {
			
			OWins(0,1,2,3,4);
		}
		if(
				(buttons[5].getText()=="O")&&
				(buttons[6].getText()=="O")&&
				(buttons[7].getText()=="O")&&
				(buttons[8].getText()=="O")&&
				(buttons[9].getText()=="O")
				) {
			
			OWins(5,6,7,8,9);
		}
		if(
				(buttons[10].getText()=="O")&&
				(buttons[11].getText()=="O")&&
				(buttons[12].getText()=="O")&&
				(buttons[13].getText()=="O")&&
				(buttons[14].getText()=="O")
				) {
			
			OWins(10,11,12,13,14);
		}
		if(
				(buttons[15].getText()=="O")&&
				(buttons[16].getText()=="O")&&
				(buttons[17].getText()=="O")&&
				(buttons[18].getText()=="O")&&
				(buttons[19].getText()=="O")
				) {
			
			OWins(15,16,17,18,19);
		}
		if(
				(buttons[20].getText()=="O")&&
				(buttons[21].getText()=="O")&&
				(buttons[22].getText()=="O")&&
				(buttons[23].getText()=="O")&&
				(buttons[24].getText()=="O")
				) {
			
			OWins(20,21,22,23,24);
		}
		if(
				(buttons[0].getText()=="O")&&
				(buttons[5].getText()=="O")&&
				(buttons[10].getText()=="O")&&
				(buttons[15].getText()=="O")&&
				(buttons[20].getText()=="O")
				) {
			
			OWins(0,5,10,15,20);
		}
		if(
				(buttons[1].getText()=="O")&&
				(buttons[6].getText()=="O")&&
				(buttons[11].getText()=="O")&&
				(buttons[16].getText()=="O")&&
				(buttons[21].getText()=="O")
				) {
			
			OWins(1,6,11,16,21);
		}
		if(
				(buttons[2].getText()=="O")&&
				(buttons[7].getText()=="O")&&
				(buttons[12].getText()=="O")&&
				(buttons[17].getText()=="O")&&
				(buttons[22].getText()=="O")
				) {
			
			OWins(2,7,12,17,22);
		}
		if(
				(buttons[3].getText()=="O")&&
				(buttons[8].getText()=="O")&&
				(buttons[13].getText()=="O")&&
				(buttons[18].getText()=="O")&&
				(buttons[23].getText()=="O")
				) {
			
			OWins(3,8,13,18,23);
		}
		if(
				(buttons[4].getText()=="O")&&
				(buttons[9].getText()=="O")&&
				(buttons[14].getText()=="O")&&
				(buttons[19].getText()=="O")&&
				(buttons[24].getText()=="O")
				) {
			
			OWins(4,9,14,19,24);
		}
		if(
				(buttons[0].getText()=="O")&&
				(buttons[6].getText()=="O")&&
				(buttons[12].getText()=="O")&&
				(buttons[18].getText()=="O")&&
				(buttons[24].getText()=="O")
				) {
			
			OWins(0,6,12,18,24);
		}
		if(
				(buttons[4].getText()=="O")&&
				(buttons[8].getText()=="O")&&
				(buttons[12].getText()=="O")&&
				(buttons[16].getText()=="O")&&
				(buttons[20].getText()=="O")
				) {
			
			OWins(4,8,12,16,20);
		}
		
	}
	
	// 如果勝利後 ~ 該方的 按鈕 會換背景顏色並顯示 勝利
	public void xWins(int a , int b , int c , int d , int e) {
		buttons[a].setBackground(Color.BLUE);
		buttons[b].setBackground(Color.BLUE);
		buttons[c].setBackground(Color.BLUE);
		buttons[d].setBackground(Color.BLUE);
		buttons[e].setBackground(Color.BLUE);
		
		for(int i=0; i<25 ; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("黑棋勝利!!!");
	}
	
	public void OWins(int a , int b , int c , int d , int e) {
		buttons[a].setBackground(Color.RED);
		buttons[b].setBackground(Color.RED);
		buttons[c].setBackground(Color.RED);
		buttons[d].setBackground(Color.RED);
		buttons[e].setBackground(Color.RED);
		
		for(int i=0; i<25 ; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("白棋勝利!!!");
	}

}
