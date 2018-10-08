package ooadproject;

public class CreepingGame {
	
	public int currentTime;            //总共进行的时间
	public int gameover;               //判断游戏是否结束，0为结束，初始值为1
	
	public CreepingGame() {
		currentTime = 0;                  
		gameover = 1;
	}

	
	public void addCurrentTime() {
		currentTime++;                       //进行的时间自动增长1
	}
	
	public int getCurrentTime() {
		return (int)(currentTime/2);               //因为速度为2.5，所以所花时间为1倍，所以要/2
	}
	
	public void collision(Ant ant1,Ant ant2) {
		float position1,position2;
		position1 = ant1.getPosition();
		position2 = ant2.getPosition();              //判断是否碰撞，如果位置相同则产生碰撞，爬行的方向也改变
		if(position1 == position2) {
			ant1.changeDirection();
			ant2.changeDirection();
		}
	}
	
	public int playGame(int d1,int d2,int d3,int d4,int d5) {
		Ant a1 = new Ant();                               //设置方向d1d2d3d4d5来进行单次游戏并返回相对应的时间
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
			a1.creeping(1);                    //爬行
			a2.creeping(1);            
			a3.creeping(1);             
			a4.creeping(1); 
			a5.creeping(1);                     
			this.collision(a1, a2);          //判断碰撞
			this.collision(a2, a3);
			this.collision(a3, a4);
			this.collision(a4, a5); 
			a1.isOut();                           //判断是否爬出
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
		//System.out.println("游戏结束，共花了"+this.getCurrentTime()+"秒");
		return this.getCurrentTime();
	}
	/*public static void main(String[] args) {
		CreepingGame cg = new CreepingGame();
		cg.playGame(1, 1, 1, -1, -1);
	}*/
	
}
