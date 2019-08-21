package CH05.practice;

/**
 * move 메소드를 재귀를 사용하지 않고 구현한다.
 */
public class Pr07 
{
	static void move(int num, int a, int b)
	{
		while(num > 1)
		{
			move(num-1, a, 6-a-b);
			
			num--;
		}
		
		System.out.println("원반[" + num + "]을 " + a + " 기둥에서 " + b + " 기둥으로 옮겼다.");
		
		if(num > 1)
		{
			move(num-1, 6-a-b, b);
		}
	}
	public static void main(String[] args) 
	{
		int disk = 3;
		System.out.println("하노이의 탑 원반개수: " + disk);

		move(disk, 1, 3);

	}

}
