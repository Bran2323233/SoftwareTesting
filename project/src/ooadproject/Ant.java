package ooadproject;

public class Ant {
	
	public int out;                      //���������ж������Ƿ��߳��ˣ�0Ϊ�ڸ��ڣ�1Ϊ����
	public float velocity;           //�ٶ�
	public int direction;            //����  1Ϊ��  -1Ϊ��
	public float currentPosition;       //��ǰ��λ��
	
	public Ant() {
		velocity = (float) 2.5;         //�����������ϵ��ٶ�Ϊ2.5 �����Ͳ���Ҫ�жϵ�ʱ����29 31 ��29 30 ��������
		out = 0;
	}
	
	public int getOut() {             
		return out;                 
	}
	
	public void isOut() {
		if(currentPosition>=300.0||currentPosition<=0.0) {        //ͨ����ǰλ���ж������Ƿ����
			out = 1;
		}
	}
	
	public float getPosition() {
		return currentPosition;                 //��ȡ��ǰλ��
	}
	
	public void setDirection(int direct) {
		direction = direct;                            //���÷���
	}
	
	public void changeDirection() {
		direction = direction*(-1);                //�ı䷽��
	}
	
	public void setCurrentlPosition(float current) {
		currentPosition = current;                      //���ó�ʼλ��
	}
	
	public void creeping(int  time) {                //�������еĹ���  �ɵ�ǰλ�ÿ�ʼ�ı�
		currentPosition = currentPosition + (float)velocity*direction*time;
	}
}
