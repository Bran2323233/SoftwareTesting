package ooadproject;

public class CreepingGame {
	
	public int currentTime;            //�ܹ����е�ʱ��
	public int gameover;               //�ж���Ϸ�Ƿ������0Ϊ��������ʼֵΪ1
	
	public CreepingGame() {
		currentTime = 0;                  
		gameover = 1;
	}

	
	public void addCurrentTime() {
		currentTime++;                       //���е�ʱ���Զ�����1
	}
	
	public int getCurrentTime() {
		return (int)(currentTime/2);               //��Ϊ�ٶ�Ϊ2.5����������ʱ��Ϊ1��������Ҫ/2
	}
	
	public void collision(Ant ant1,Ant ant2) {
		float position1,position2;
		position1 = ant1.getPosition();
		position2 = ant2.getPosition();              //�ж��Ƿ���ײ�����λ����ͬ�������ײ�����еķ���Ҳ�ı�
		if(position1 == position2) {
			ant1.changeDirection();
			ant2.changeDirection();
		}
	}
	
	public int playGame(int d1,int d2,int d3,int d4,int d5) {
		Ant a1 = new Ant();                               //���÷���d1d2d3d4d5�����е�����Ϸ���������Ӧ��ʱ��
		a1.setDirection(d1);
		a1.setCurrentlPosition(30);
		Ant a2 = new Ant();
		a2.setDirection(d2);
		a2.setCurrentlPosition(80);
		Ant a3 = new Ant();
		a3.setDirection(d3);
		a3.setCurrentlPosition(110);
		Ant a4 = new Ant();
		a4.setDirection(d4);
		a4.setCurrentlPosition(160);
		Ant a5 = new Ant();
		a5.setDirection(d5);
		a5.setCurrentlPosition(250);
		while(gameover==1) {
			this.addCurrentTime();
			a1.creeping(1);                    //����
			a2.creeping(1);            
			a3.creeping(1);             
			a4.creeping(1); 
			a5.creeping(1);                     
			this.collision(a1, a2);          //�ж���ײ
			this.collision(a2, a3);
			this.collision(a3, a4);
			this.collision(a4, a5); 
			a1.isOut();                           //�ж��Ƿ�����
			a2.isOut();
			a3.isOut();
			a4.isOut();
			a5.isOut();
			/*System.out.println(a1.getPosition());
			System.out.println(a2.getPosition());
			System.out.println(a3.getPosition());
			System.out.println(a4.getPosition());
			System.out.println(a5.getPosition());*/
			if((a1.getOut()==1)&&(a1.getOut()==a2.getOut())&&(a2.getOut()==a3.getOut())&&(a3.getOut()==a4.getOut())&&(a4.getOut()==a5.getOut())) {
				gameover = 0;
			}
		}
		//System.out.println("��Ϸ������������"+this.getCurrentTime()+"��");
		return this.getCurrentTime();
	}
	/*public static void main(String[] args) {
		CreepingGame cg = new CreepingGame();
		cg.playGame(1, 1, 1, -1, -1);
	}*/
	
}
