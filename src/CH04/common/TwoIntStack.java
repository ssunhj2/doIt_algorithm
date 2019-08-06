package CH04.common;

public class TwoIntStack 
{
	private int max;
	private int ptrA;
	private int ptrB;
	private int[] stkArr;
	
	public class EmptyStackException extends RuntimeException
	{
		public EmptyStackException(){}
	}
	
	public class OverflowStackException extends RuntimeException
	{
		public OverflowStackException(){}
	}
	
	public TwoIntStack(int cap)
	{
		max = cap;
		ptrA = 0;
		ptrB = max-1;
		
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
	public int push(String stkType, int x) throws OverflowStackException
	{
		if((ptrA - 1) >= ptrB)
		{
			throw new OverflowStackException();
		}
		
		if("stkA".equals(stkType))
		{
			stkArr[ptrA++] = x;
		}
		else if("stkB".equals(stkType))
		{
			stkArr[ptrB--] = x;
		}
		return x;
	}
	
	
	// pop
	public int popOne(String stkType) throws EmptyStackException
	{
		int result = 0;
		
		if("stkA".equals(stkType))
		{
			if(ptrA <= 0)
			{
				throw new EmptyStackException();
			}
			result = stkArr[--ptrA];
		}
		else if("stkB".equals(stkType))
		{
			if(ptrB >= (max-1))
			{
				throw new EmptyStackException();
			}
			result = stkArr[++ptrB];
		}
		return result;
	}
	
	// peek
	public int peek(String stkType) throws EmptyStackException
	{
		int result = 0;
		
		if("stkA".equals(stkType))
		{
			if(ptrA <= 0)
			{
				throw new EmptyStackException();
			}
			result = stkArr[ptrA-1];
		}
		else if("stkB".equals(stkType))
		{
			if(ptrB >= (max-1))
			{
				throw new EmptyStackException();
			}
			result = stkArr[ptrB +1];
		}
		return result;
	}
	
	
	
	public int indexOf(String stkType, int x)
	{
		if("stkA".equals(stkType))
		{
			if(ptrA <= 0)
			{
				throw new EmptyStackException();
			}
			
			for (int i = ptrA-1; i >= 0; i--) 
			{
				if(stkArr[i] == x) return i;
			}
			
		}
		else if("stkB".equals(stkType))
		{
			if(ptrB >= (max-1))
			{
				throw new EmptyStackException();
			}
	
			for (int i = ptrB+1; i < max; i++) 
			{
				if(stkArr[i] == x) return i;
			}
		}
		
		return -1;
	}
	
	public void clear(String stkType)
	{
		if("stkA".equals(stkType))
		{
			ptrA = 0;
		}
		else if("stkB".equals(stkType))
		{
			ptrB = max-1;
		}
	}
	
	public int getSize()
	{
		return max;
	}
	
	public int dataSize(String stkType)
	{
		int result = 0;
		if("stkA".equals(stkType))
		{
			result = ptrA;
		}
		else if("stkB".equals(stkType))
		{
			result = max - (ptrB-1);
		}
		return result;
	}
	
	/*public boolean isEmpty()
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
	}*/
}
