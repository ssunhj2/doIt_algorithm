package CH04.stack;

public class GenericStack<E> 
{
	private int max;
	private int pointer;
	private E [] stkArr;
	
	public static class EmptyStackException extends RuntimeException
	{
		public EmptyStackException(){}
	}
	
	public static class OverflowStackException extends RuntimeException
	{
		public OverflowStackException(){}
	}
	
	public GenericStack(int cap)
	{
		pointer = 0;
		max = cap;
		
		try
		{
			stkArr = (E[]) new Object[max];
		}
		catch(OutOfMemoryError e)
		{
			max = 0;
		}
		
	}
	
	// push
	public E push(E x) throws OverflowStackException
	{
		if(pointer >= max)
		{
			throw new OverflowStackException();
		}
		
		return stkArr[pointer++] = x;
	}
	
	// pop
	public E pop() throws EmptyStackException
	{
		if(pointer <= 0)
		{
			throw new EmptyStackException();
		}
		
		return stkArr[--pointer];
	}
	
	// peek
	public E peek() throws EmptyStackException
	{
		if(pointer <= 0)
		{
			throw new EmptyStackException();
		}
		
		return stkArr[pointer-1];
	}
	
	public int indexOf(E x)
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
