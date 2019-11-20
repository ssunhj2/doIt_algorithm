package CH07.practice;

/**
 * 연습문제 Q5
 * IntSet의 요소가 항상 오름차순이 되도록 클래스를 수정한다.
 */
public class IntSortedSet_Q5 
{
	private int max;
	private int num;
	private int[] set;
	
	public IntSortedSet_Q5(int cap)
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
	/*public int indexOf(int n)
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
	*/
	
	// 이진 탐색으로 위치를 찾는다.
	public int indexOf(int n)
	{
		int left = 0; // 검색범위 맨 앞의 index
		int right = n - 1; // 〃 맨 뒤의 index
		
		do
		{
			int mid = (left+right)/2;
			
			if(n == set[mid])
			{
				return mid;
			}
			else if(n > set[mid]) // 오른쪽에서 검색
			{
				left = mid + 1;
			}
			else if(n < set[mid]) // 왼쪽에서 검색
			{
				right = mid - 1; 
			}
		}while(left <= right);
		
		return -1; // 위치를 못찾은 경우
	}

	
	
	// 집합에서 n이 있는지 체크한다.
	public boolean contains(int n)
	{	
		return (indexOf(n) >= 0) ? true : false;
	}
	
	// 집합에 요소 n을 추가한다.
	public boolean add(int n)
	{
		int idx;
		if(num >= max || (idx = indexOf(n)) >= 0) // 집합이 가득 찼거나 n이 이미 존재하는 경우
		{
			return false;
		}
		else
		{
			idx = -1;
			num++;
			for (int i = num-1; i > idx; i--) 
			{
				set[i] = set[i-1];
			}
			set[idx] = n;
			return true;
		}
	}
	
	// 집합에서 요소 n을 제거한다.
	public boolean remove(int n)
	{
		int idx;
		
		if(num <= 0 || (idx = indexOf(n)) == -1) // 집합에 값이 없거나 요소값이 없는경우
		{
			return false;
		}
		else
		{
			num--;
			for (int i = idx; i < num; i++) // set[idx]를 삭제하고 다음 요소부터 한 칸 앞으로 이동시킨다.
			{
				set[i] = set[i + 1];
			}
			return true;
		}
	}
	
	// 집합 s의 값을 집합배열에 복사한다.
	public void copyTo(IntSortedSet_Q5 s)
	{
		int n = (s.max < num) ? s.max : num; // 복사 할 요소의 개수를 정한다.
		
		for (int i = 0; i < n; i++) 
		{
			s.set[i] = set[i];
		}
		num = n;
	}
	
	// 집합 s에 집합배열을 복사한다.
	public void copyFrom(IntSortedSet_Q5 s)
	{
		int n = (max < s.num) ? max : s.num; // 복사 할 요소의 개수를 정한다.
		
		for (int i = 0; i < n; i++) 
		{
			set[i] = s.set[i];
		}
		num = n;
	}
	
	// 집합과 집합s가 같은지 검사한다.
	public boolean equalTo(IntSortedSet_Q5 s)	
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
	public void unionOf(IntSortedSet_Q5 s1, IntSortedSet_Q5 s2)
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
	public boolean add(IntSortedSet_Q5 s)
	{
		boolean result = false;
		
		for (int i = 0; i < num; i++) 
		{
			if(add(set[i]) == true) result = true;
		}
		
		return result;
	}
	
	// 집합 s와의 교집합을 구한다.
	public boolean retain(IntSortedSet_Q5 s)
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
	public boolean remove(IntSortedSet_Q5 s)
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
	
	// 집합이 집합 s의 부분집합인지 확인한다.
	// 집합 ( s
	public boolean isSubsetOf(IntSortedSet_Q5 s)
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
	public boolean isProperSubsetOf(IntSortedSet_Q5 s)
	{
		if(num >= s.num) return false;
		
		return s.isSubsetOf(s);
	}

// Q5 ------------------------------------------------------//	
	//집합에 집합 s1과 s2의 교집합을 복사한다.
	public void intersectionOf(IntSortedSet_Q5 s1, IntSortedSet_Q5 s2)
	{
		clear();
		for (int i = 0; i < s1.num; i++) 
		{
			if(s2.contains(s1.set[i]))
			{
				add(s1.set[i]);
			}
		}
	}

	//집합에 집합 s1과 s2의 차집합을 복사하는 메소드를 복사한다.
	public void differenceOf(IntSortedSet_Q5 s1, IntSortedSet_Q5 s2)
	{
		clear();
		for (int i = 0; i < s1.num; i++) 
		{
			if(!s2.contains(s1.set[i]))
			{
				add(s1.set[i]);
			}
		}
	}
//----------------------------------------------------------//
}
