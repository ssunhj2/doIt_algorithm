package CH04.queue;

public class GenericQueue<E>
{
	private int max; // 큐 용량
	private int front; // 첫번째 요소 위치
	private int rear; // 마지막 요소 위치
	private int dataNum; // 현재 데이터 개수
	private E[] que;
	
	public static class EmptyIntQueException extends RuntimeException
	{
		public EmptyIntQueException(){}
	}
	
	public static class overflowIntQueException extends RuntimeException
	{
		public overflowIntQueException(){}
	}
	
	public GenericQueue(int cap)
	{
		dataNum = front = rear = 0;
		max = cap;
		
		try
		{
			que = (E[]) new Object[cap];
		}
		catch(OutOfMemoryError e)
		{
			max = 0;
		}
		
	}
	
	// enque
	public E enque(E data) throws overflowIntQueException
	{
		if(dataNum >= max) throw new overflowIntQueException();
		
		que[rear++] = data;
		dataNum++;
		
		if(rear == max) rear = 0;
		
		return data;
	}
	
	// deque 
	public E deque() throws EmptyIntQueException
	{
		if(dataNum <= 0) throw new EmptyIntQueException();
		
		E data = que[front++];
		dataNum--;
		
		if(front == max) front = 0;
		
		return data;
	}
	
	// deque 데이터 확인
	public E peek() throws EmptyIntQueException
	{
		if(dataNum <= 0) throw new EmptyIntQueException();
		
		return que[front];
	}
	
	public int indexof(E data)
	{
		for (int i = front; i < rear; i++)
		{
			int index = (i + front) % max;
			
			if(que[index] == data) return index;
		}
		return -1;
	}
	

	public void clear()
	{
		dataNum = front = rear = 0;
	}
	
	public int getSize()
	{
		return max;
	}
	
	public int dataSize()
	{
		return dataNum;
	}
	
	public boolean isEmpty()
	{
		return (dataNum <= 0);
	}
	public boolean isFull()
	{
		return (dataNum >= max);
	}
	
	// 큐안의 모든 데이터를 bottom ~ top 순으로 출력
	public void dump()
	{
		if(dataNum <= 0)
		{
			System.out.println("큐가 비어있다.");
		}
		else
		{
			for (int i = 0; i < dataNum; i++)
			{
				System.out.print(que[(i+front) % max] + " ");
			}
			System.out.println();
		}
	}
	
	// 실습5
	public int searchData(E data)
	{
		for (int i = 0; i < dataNum; i++) 
		{
			if(que[(i+front) % max] == data) return (i+1);
			
			front++;
		}
		
		return 0;
	}
}
