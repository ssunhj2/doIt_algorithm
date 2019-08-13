package CH05.practice;

/**
 * 기둥을 위치 (1, 2)가 아닌 이름(A기둥, B기둥)으로 출력되게 한다.
 */
public class Pr06 
{
	
	static void move(int num, int a, int b)
	{
		String[] pilArr = {"A기둥", "B기둥", "C기둥"};
		
		if(num > 1)
		{
			move(num-1, a, 6-a-b);
		}
		
		System.out.println("원반[" + num + "]을 " + pilArr[a-1] + "기둥에서  " + pilArr[b-1] + "기둥으로 옮겼다.");
		
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
