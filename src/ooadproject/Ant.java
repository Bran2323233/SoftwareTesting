package ooadproject;

public class Ant {
	
	public int out;                      //变量用来判断蚂蚁是否走出杆，0为在杆内，1为出杆
	public float velocity;           //速度
	public int direction;            //方向  1为右  -1为左
	public float currentPosition;       //当前的位置
	
	public Ant() {
		velocity = (float) 2.5;         //我设置了蚂蚁的速度为2.5 这样就不需要判断当时我们29 31 和29 30 的问题了
		out = 0;
	}
	
	public int getOut() {             
		return out;                 
	}
	
	public void isOut() {
		if(currentPosition>=300.0||currentPosition<=0.0) {        //通过当前位置判断蚂蚁是否出杆
			out = 1;
		}
	}
	
	public float getPosition() {
		return currentPosition;                 //获取当前位置
	}
	
	public void setDirection(int direct) {
		direction = direct;                            //设置方向
	}
	
	public void changeDirection() {
		direction = direction*(-1);                //改变方向
	}
	
	public void setCurrentlPosition(float current) {
		currentPosition = current;                      //设置初始位置
	}
	
	public void creeping(int  time) {                //蚂蚁爬行的过程  由当前位置开始改变
		currentPosition = currentPosition + (float)velocity*direction*time;
	}
}
