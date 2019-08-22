package common.stack;

public class PubIntStack 
{
	private int max;
	private int pointer;
	private int[] stkArr;
	
	public class EmptyStackException extends RuntimeException
	{
		public EmptyStackException(){}
	}
	
	public class OverflowStackException extends RuntimeException
	{
		public OverflowStackException(){}
	}
	
	public PubIntStack(int cap)
	{
		pointer = 0;
		max = cap;
		
		try
		{
			stkArr = new int[max];
		}
		catch(OutOfMemoryError e)
		{
			max = 0;
		}
		
	}
	
	// push
	public int push(int x) throws OverflowStackException
	{
		if(pointer >= max)
		{
			throw new OverflowStackException();
		}
		
		return stkArr[pointer++] = x;
	}
	
	// pop
	public int pop() throws EmptyStackException
	{
		if(pointer <= 0)
		{
			throw new EmptyStackException();
		}
		
		return stkArr[--pointer];
	}
	
	// peek
	public int peek() throws EmptyStackException
	{
		if(pointer <= 0)
		{
			throw new EmptyStackException();
		}
		
		return stkArr[pointer-1];
	}
	
	public int indexOf(int x)
	{
		for (int i = pointer-1; i >= 0; i--) 
		{
			if(stkArr[i] == x) return i;
		}
		return -1;
	}
	
	public void clear()
	{
		pointer = 0;
	}
	
	public int getSize()
	{
		return max;
	}
	
	public int dataSize()
	{
		return pointer;
	}
	
	public boolean isEmpty()
	{
		return (pointer <= 0);
	}
	public boolean isFull()
	{
		return (pointer >= max);
	}
	
	// 스택안의 모든 데이터를 bottom ~ top 순으로 출력
	public void dump()
	{
		if(pointer <= 0)
		{
			System.out.println("스택이 비어있다.");
		}
		else
		{
			for (int i = 0; i < pointer; i++)
			{
				System.out.print(stkArr[i] + " ");
			}
			System.out.println();
		}
	}
}
