package ooadproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayRoom {
	
	public int [][]input;                //维护方向数组
	
	public int maxTime;

	public  int minTime;
	
	public int getMaxTime() {          //最大时间
		return maxTime;
	}
	
	public int getMinTime() {          //最小时间
		return minTime;
	}
	
	public PlayRoom() {
		input = new int[32][5];       //初始化
		maxTime = 0;
		minTime = 10000;
	}
	
	public void buildDirections() {
		int i,b;                                                //设置方向数组
		for( i=0 ;i<32;i++) {
			char []binaryStr = new char[5];
			String a = Integer.toBinaryString(i);
			while(a.length()<5) {
				a = "0"+ a;
			}
			binaryStr = a.toCharArray();
			for (b=0;b<5;b++) {
				if(binaryStr[b]=='0'){
					input[i][b]=-1;
				}
				else {
					input[i][b]=1;
				}
			}
		}
		/*for(i=0;i<32;i++) {
			System.out.println(input[i][0]+""+input[i][1]+""+input[i][2]+""+input[i][3]+""+input[i][4]);
		}*/
	}
	
	public void playGames() {
		int tmpTime=0;      //将数组读入进游戏并通过多次循环进行多次游戏并选取最大最小时间
		int i;
		for(i=0;i<32;i++) {
			//System.out.println(input[i][0]+""+input[i][1]+""+input[i][2]+""+input[i][3]+""+input[i][4]);
			CreepingGame cg = new CreepingGame();
			tmpTime = cg.playGame(input[i][0],input[i][1],input[i][2],input[i][3],input[i][4]);
			//System.out.println(tmpTime);
			if(tmpTime>maxTime) {
				maxTime = tmpTime;
			}
			if(tmpTime<minTime) {
				minTime = tmpTime;
			}
		}
		/*System.out.println("所需要最大的时间为"+maxTime);
		System.out.println("所需要的最小的时间为"+minTime);*/
	}
	
	
	public static void main(String[] args) {
		String output;
		JTextArea jt =new JTextArea(10,20);
		JFrame jf = new JFrame("蚂蚁爬杆");
		FlowLayout fl = new FlowLayout();
		jf.setLayout(fl);
		JButton jb = new JButton("游戏开始");
		jf.add(BorderLayout.WEST,jb);
		jf.add(BorderLayout.CENTER,jt);
		jf.setSize(600, 300); 
		jf.setLocation(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jb.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayRoom pr = new PlayRoom();
		        pr.buildDirections();
		        pr.playGames();
		        jt.setText("游戏所需最大时间为"+String.valueOf(pr.getMaxTime())+"\n"+"游戏所需最小时间为"+String.valueOf(pr.getMinTime()));
			}
		});
		
	}
}
