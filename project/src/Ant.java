
/**
* @author bran
*/

public class Ant {
	/**
	 * ���������ж������Ƿ��߳��ˣ�0Ϊ�ڸ��ڣ�1Ϊ����
	 */
	private int out;
	/**
	 * �ٶ�
	 */
	private float velocity;
	/**
	 * ����  1Ϊ��  -1Ϊ��
	 */
	private int direction;
	/**
	 * ��ǰ��λ��
	 */
	private float currentPosition;
	
	private float border;
	
	public Ant() {
		 //�����������ϵ��ٶ�Ϊ2.5 �����Ͳ���Ҫ�жϵ�ʱ����29 31 ��29 30 ��������
		velocity = (float) 2.5;        
		out = 0;
		border = (float) 300;
	}
	
	public int getOut() {             
		return out;                 
	}
	
	public void isOut() {
		 //ͨ����ǰλ���ж������Ƿ����
		if(currentPosition>=border||currentPosition<=0.0) {       
			out = 1;
		}
	}
	
	public float getPosition() {
		//��ȡ��ǰλ��
		return currentPosition;                 
	}
	
	public void setDirection(int direct) {
		 //���÷���
		direction = direct;                           
	}
	
	public void changeDirection() {
		//�ı䷽��
		direction = direction*(-1);                
	}
	
	public void setCurrentlPosition(float current) {
		//���ó�ʼλ��
		currentPosition = current;                      
	}
	
	public void creeping(int  time) {               
		//�������еĹ���  �ɵ�ǰλ�ÿ�ʼ�ı�
		currentPosition = currentPosition + (float)velocity*direction*time;
	}
}
