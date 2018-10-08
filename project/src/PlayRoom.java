
/**
 * 
 * @author Bran
 *
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayRoom {
	
	/**
	 * ά����������
	 */
	private int [][]input;
	
	private int maxTime;

	private   int minTime;
	
	public int getMaxTime() {          //���ʱ��
		return maxTime;
	}
	
	public int getMinTime() {          //��Сʱ��
		return minTime;
	}
	
	public PlayRoom() {
		//��ʼ��
		input = new int[32][5];       
		maxTime = 0;
		minTime = 10000;
	}
	
	public void buildDirections() {
		 //���÷�������
		int i,b,c,d;           
		c = 32;
		d = 5;

		for( i=0 ;i<c;i++) {
			char []binaryStr = new char[5];
			StringBuilder a = new StringBuilder(Integer.toBinaryString(i));
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<d-a.toString().length();j++){
			    sb.append("0");
            }
            sb.append(a.toString());
            binaryStr = sb.toString().toCharArray();

			for (b=0;b<d;b++) {
				if(binaryStr[b]=='0'){
					input[i][b]=-1;
				}
				else {
					input[i][b]=1;
				}
			}
		}
		binaryStr.
		/*for(i=0;i<32;i++) {
			System.out.println(input[i][0]+""+input[i][1]+""+input[i][2]+""+input[i][3]+""+input[i][4]);
		}*/
	}
	
	public void playGames() {
	    this.buildDirections();
		//������������Ϸ��ͨ�����ѭ�����ж����Ϸ��ѡȡ�����Сʱ��
		int tmpTime=0;      
		int i,c;
		c = 32;
		for(i=0;i<c;i++) {
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
		/*System.out.println("����Ҫ����ʱ��Ϊ"+maxTime);
		System.out.println("����Ҫ����С��ʱ��Ϊ"+minTime);*/
	}
	
	
	public static void main(String[] args) {
		String output;
		JTextArea jt =new JTextArea(10,20);
		JFrame jf = new JFrame("��������");
		FlowLayout fl = new FlowLayout();
		jf.setLayout(fl);
		JButton jb = new JButton("��Ϸ��ʼ");
		jf.add(BorderLayout.WEST,jb);
		jf.add(BorderLayout.CENTER,jt);
		jf.setSize(600, 300); 
		jf.setLocation(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jb.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayRoom pr = new PlayRoom();
		        pr.buildDirections();
		        pr.playGames();
		        jt.setText("��Ϸ�������ʱ��Ϊ"+String.valueOf(pr.getMaxTime())+"\n"+"��Ϸ������Сʱ��Ϊ"+String.valueOf(pr.getMinTime()));
			}
		});
		
	}
}
