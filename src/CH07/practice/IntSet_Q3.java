package CH07.practice;

/**
 * 연습문제 Q3
 * 집합이 집합 s의 부분집합인지 판단하는 메소드를 작성한다.
 * 집합이 집합 s의 진부분집합인지 판단하는 메소드를 작성한다.
 * 메소드의 실행에 따라 집합이 변경되면 true, 아니면 false를 반환한다.
 */
public class IntSet_Q3 
{
	private int max;
	private int num;
	private int[] set;
	
	public IntSet_Q3(int cap)
	{
		num = 0;
		max = cap;
		
		try
		{
			set = new int[max];
		}
		catch(OutOfMemoryError e)
		{
			max = 0;
		}
	}
	
	// 집합의 최대 개수
	public int capacity()
	{
		return max;
	}
	
	// 현재 집합 요소의 개수
	public int size()
	{
		return num;
	}
	
	// 집합에서 n을 검색하여 index를 반환한다.
	public int indexOf(int n)
	{
		for (int i = 0; i < num; i++) 
		{
			if(set[i] == n)
			{
				return i;
			}
		}
		return -1;
	}
	
	// 집합에서 n이 있는지 체크한다.
	public boolean contains(int n)
	{	
		return (indexOf(n) >= 0) ? true : false;
	}
	
	// 집합에 요소 n을 추가한다.
	public boolean add(int n)
	{
		if(num >= max || contains(n) == true) // 집합이 가득 찼거나 n이 이미 존재하는 경우
		{
			return false;
		}
		else
		{
			set[num++] = n;
			return true;
		}
	}
	
	// 집합에서 요소 n을 제거한다.
	public boolean remove(int n)
	{
		int idx;
		
		if(num <= 0 || (idx = indexOf(n)) == -1) // 집합에 값이 없거나 요소값이 업슨경우
		{
			return false;
		}
		else
		{
			set[idx] = set[--num]; // 마지막 요소를 삭제한 index로 이동시킨다.
			return true;
		}
	}
	
	// 집합 s의 값을 집합배열에 복사한다.
	public void copyTo(IntSet_Q3 s)
	{
		int n = (s.max < num) ? s.max : num; // 복사 할 요소의 개수를 정한다.
		
		for (int i = 0; i < n; i++) 
		{
			s.set[i] = set[i];
		}
		num = n;
	}
	
	// 집합 s에 집합배열을 복사한다.
	public void copyFrom(IntSet_Q3 s)
	{
		int n = (max < s.num) ? max : s.num; // 복사 할 요소의 개수를 정한다.
		
		for (int i = 0; i < n; i++) 
		{
			set[i] = s.set[i];
		}
		num = n;
	}
	
	// 집합과 집합s가 같은지 검사한다.
	public boolean equalTo(IntSet_Q3 s)	
	{
		if (num != s.num)						// 요소 개수가 다르면 집합도 다르다.
		{
			return false;						
		}

		for (int i = 0; i < num; i++)
		{
			int j = 0;
			for ( ; j < s.num; j++)
			{
				if (set[i] == s.set[j]);
				break;
			}	
			if (j == s.num)						// set[i]는 s에 포함되지 않는다.
			{
				return false;
			}
		}
		return true;
	}

	// 집합 s1과 s2의 합집합을 복사한다.
	public void unionOf(IntSet_Q3 s1, IntSet_Q3 s2)
	{
		copyFrom(s1);								// 집합 s1을 복사한다.
		for (int i = 0; i < s2.num; i++)			// 집합 s2의 요소를 추가한다.
		{
			add(s2.set[i]);
		}
	}

	// "{ a b c }" 형식의 문자열로 표현을 바꾼다.
	public String toString() 
	{
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++)
		{
			temp.append(set[i] + " ");
		}
		temp.append("}");
		return temp.toString();
	}
	
	// 공집합인지 판단한다.
	public boolean isEmpty()
	{
		return (num <= 0);
	}
	
	// 집합이 가득찼는지 확인한다.
	public boolean isFull()
	{
		return (num >= max);
	}
	
	// 집합을 초기화 한다.
	public void clear()
	{
		num = 0;
	}

	// 집합 s와의 합집합을 구한다.
	public boolean add(IntSet_Q3 s)
	{
		boolean result = false;
		
		for (int i = 0; i < num; i++) 
		{
			if(add(set[i]) == true) result = true;
		}
		
		return result;
	}
	
	// 집합 s와의 교집합을 구한다.
	public boolean retain(IntSet_Q3 s)
	{
		boolean result = false;
		
		for (int i = 0; i < num; i++) 
		{
			if(s.contains(set[i]) == false)
			{
				// 집합 s에 들어있는 요소가 아닌경우 삭제한다.
				remove(set[i]);
				result = true;
			}
		}
		
		return result;
	}
	
	// 집합 s와의 차집합을 구한다.
	public boolean remove(IntSet_Q3 s)
	{
		boolean result = false;
		
		for (int i = 0; i < num; i++) 
		{
			if(s.contains(set[i]) == true)
			{
				// 집합 s에 들어있는 요소가 아닌경우 삭제한다.
				remove(set[i]);
				result = true;
			}
		}
		return result;
	}
	
// Q3 ------------------------------------------------------//	
	// 집합이 집합 s의 부분집합인지 확인한다.
	// 집합 ( s
	public boolean isSubsetOf(IntSet_Q3 s)
	{
		for (int i = 0; i < num; i++) 
		{
			int j = 0;
			for (; j < s.size(); j++) 
			{
				if(set[i] == s.set[j]) break;
			}
			
			if(j == s.num) return false;
		}
		
		return true;
	}
	
	// 집합이 집합 s의 진부분집합인지 확인한다.
	// 집합 ( s && 집합 != s
	public boolean isProperSubsetOf(IntSet_Q3 s)
	{
		if(num >= s.num) return false;
		
		return s.isSubsetOf(s);
	}
	
//----------------------------------------------------------//
}
