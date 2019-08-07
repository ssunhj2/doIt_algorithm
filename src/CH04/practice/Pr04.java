package CH04.practice;

public class Pr04 
{
	private int max; // 큐 용량
	private int dataNum; // 현재 데이터 개수
	private int[] que;
	
	public class EmptyIntQueException extends RuntimeException
	{
		public EmptyIntQueException(){}
	}
	
	public class overflowIntQueException extends RuntimeException
	{
		public overflowIntQueException(){}
	}
	
	
	public Pr04(int cap)
	{
		dataNum = 0;
		max = cap;
		
		try
		{
			que = new int[cap];
		}
		catch(OutOfMemoryError e)
		{
			max = 0;
		}
		
	}
}
