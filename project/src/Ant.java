
/**
* @author bran
*/

public class Ant {
	/**
	 * 变量用来判断蚂蚁是否走出杆，0为在杆内，1为出杆
	 */
	private int out;
	/**
	 * 速度
	 */
	private float velocity;
	/**
	 * 方向  1为右  -1为左
	 */
	private int direction;
	/**
	 * 当前的位置
	 */
	private float currentPosition;
	
	private float border;
	
	public Ant() {
		 //我设置了蚂蚁的速度为2.5 这样就不需要判断当时我们29 31 和29 30 的问题了
		velocity = (float) 2.5;        
		out = 0;
		border = (float) 300;
	}
	
	public int getOut() {             
		return out;                 
	}
	
	public void isOut() {
		 //通过当前位置判断蚂蚁是否出杆
		if(currentPosition>=border||currentPosition<=0.0) {       
			out = 1;
		}
	}
	
	public float getPosition() {
		//获取当前位置
		return currentPosition;                 
	}
	
	public void setDirection(int direct) {
		 //设置方向
		direction = direct;                           
	}
	
	public void changeDirection() {
		//改变方向
		direction = direction*(-1);                
	}
	
	public void setCurrentlPosition(float current) {
		//设置初始位置
		currentPosition = current;                      
	}
	
	public void creeping(int  time) {               
		//蚂蚁爬行的过程  由当前位置开始改变
		currentPosition = currentPosition + (float)velocity*direction*time;
	}
}
