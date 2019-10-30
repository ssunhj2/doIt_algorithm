package CH09.practice;

import java.util.Comparator;

import CH09.practice.LinkedList_Q1.Node;

/**
 * 연결리스트
 * 커서(인덱스)로 연결리스트 만들기
 */
public class ArrLinkedList_Q4<E> 
{
	class Node<E>
	{
		private E data;
		private int next;
		private int dnext;
		
		void set(E data, int next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E>[] n;
	private int size;
	private int max;
	private int head;
	private int crnt;
	private int deleted;
	private static final int NULL = -1;

	// 생성자
	public ArrLinkedList_Q4(int capacity)
	{
		head = crnt = max = deleted = NULL;
		try 
		{
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++)
			{
				n[i] = new Node<E>();
			}
			size = capacity;
		}
		catch (OutOfMemoryError e) 
		{				// 배열 생성에 실패
			size = 0;
		}
	}
	
	// 다음에 삽입하는 record의 인덱스를 구함
	private int getInsertIndex()
	{
		if (deleted == NULL) 
		{
			if (max < size)
			{
				return ++max;
			}
			else
			{
				return NULL;
			}
		} 
		else 
		{
			int rec = deleted; // free 리스트의 머리노드를 가져온다.
			deleted = n[rec].dnext; // free 리스트의 머리노드를 꺼냈으므로 다음 노드를 가리키게 한다.
			return rec;
		}
	}

	// record idx를 free 리스트에 등록
	private void deleteIndex(int idx) 
	{
		if (deleted == NULL) // 삭제할게 없다.
		{
			deleted = idx; // 
			n[idx].dnext = NULL;
		} 
		else 
		{
			int rec = deleted;
			deleted = idx; // free의 머리노드가 이전노드가 아니라 idx를 가리키도록 한다.(삽입)
			n[rec].dnext = rec; // free 리스트에 삽입 이전에 deleted가 가리키던 index를 가리키도록 한다.
		}
	}

	// 노드를 검색
	public E search(E obj, Comparator<? super E> c) 
	{
		int ptr = head;	

		while (ptr != NULL)
		{
			if (c.compare(obj, n[ptr].data) == 0) 
			{
				crnt = ptr;
				return n[ptr].data;	
			}
			ptr = n[ptr].next; // 찾지 못한경우 다음 노드를 검사하도록 한다.
		}
		return null;
	}

	// 머리에 노드를 삽입
	public void addFirst(E obj) 
	{
		int ptr = head; // head가 이전에 가리키던 노드 저장
		int rec = getInsertIndex(); // 삽입을 위해 index를 구한다.
		if (rec != NULL)
		{
			head = crnt = rec; // 머리, 선택노드가 삽입을 위한 index를 가리키게 한다.
			n[head].set(obj, ptr); // prt: head가 이전에 가리키던 커서를 next로 가르키도록 한다.
		}
	}

	// 꼬리에 노드를 삽입
	public void addLast(E obj)
	{
		if (head == NULL)	
		{
			addFirst(obj); // 노드가 없는경우 머리에 노드를 삽입한다.
		}
		else 
		{
			int ptr = head; // head가 이전에 가리키던 노드
			while (n[ptr].next != NULL) // 가장 끝 노드를 찾는다.
			{
				ptr = n[ptr].next; // next 노드를 찾는다.
			}
			int rec = getInsertIndex(); // 삽입 할 index를 받아온다.
			if (rec != NULL) 
			{	
				n[ptr].next = crnt = rec; // 끝노드의 다음노드(빈노드)에 index를 넣는다.
				n[rec].set(obj, NULL); // 다음노드의 커서를 null로 하여 삽입한다.
			}
		}
	}

	// 머리 노드를 삭제
	public void removeFirst() 
	{
		if (head != NULL) // 삭제할 노드가 존재하면
		{	
			int ptr = n[head].next; // 머리노드의 다음노드 index
			deleteIndex(head); // 머리노드를 삭제한다.
			head = crnt = ptr; // head가 삭제한 노드의 다음노드를 커서로 가지도록 한다.
		}
	}

	// 꼬리 노드를 삭제
	public void removeLast()
	{
		if (head != NULL) // 삭제할 노드가 있으면 
		{
			if (n[head].next == NULL) // 노드가 딱 한개 있는 경우
			{
				removeFirst(); // 머리노드를 삭제
			}
			else 
			{
				int ptr = head;	
				int pre = head;

				while (n[ptr].next != NULL) // 끝노드를 찾는다.
				{
					pre = ptr; // 끝노드를 찾는다.
					ptr = n[ptr].next; // 현재 노드의 다음노드 커서를 찾는다.
				}
				// while 문이 끝나면
				// pre: 마지막노드 / ptr: 마지막 노드의 다음 커서
				n[pre].next = NULL;	// 끝노드의 다음 커서는 null이다.
				deleteIndex(pre); // 마지막노드 삭제한다.
				crnt = pre;
			}
		}
	}

	// record p를 삭제
	public void remove(int p) 
	{
		if (head != NULL)
		{
			if (p == head)	
			{
				removeFirst(); // 머리노드 삭제
			}
			else 
			{
				int ptr = head; // 머리노드 저장

				while (n[ptr].next != p) 
				{
					ptr = n[ptr].next; // 다음커서 찾기
					if (ptr == NULL) return; // 없는 경우
				}
				n[ptr].next = NULL; // 지울 노드를 next로 가지고 있는 next 삭제
				deleteIndex(ptr); // 찾은 노드 삭제
				n[ptr].next = n[p].next; // 지울 노드의 next를 지울노드의 다음노드를 가리키게 한다.
				crnt = ptr;
			}
		}
	}

	// 선택 노드를 삭제
	public void removeCurrentNode()
	{
		remove(crnt);
	}

	// 모든 노드를 삭제
	public void clear()
	{
		while (head != NULL)
		{
			removeFirst(); // 머리노드부터 차례로 삭제
		}
		crnt = NULL;
	}

	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() 
	{
		if (crnt == NULL || n[crnt].next == NULL)
		{
			return false;
		}
		crnt = n[crnt].next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode()
	{
		if (crnt == NULL)
		{
			System.out.println("선택 노드가 없습니다.");
		}
		else
		{
			System.out.println(n[crnt].data);
		}
	}

	// 모든 노드를 출력
	public void dump() 
	{
		int ptr = head;

		while (ptr != NULL) 
		{
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}

/* Q4: 서로 같은 노드를 찾아 가장 앞쪽의 노드를 남기고 모두 삭제한다. */	
	public void purge(Comparator <? super E> c)
	{
		int ptr = head;
		
		while(ptr != NULL)
		{
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;
			
			while(n[pre].next != NULL)
			{
				ptr2 = n[pre].next;
				if(c.compare(n[ptr].data, n[ptr2].data) == 0) // 같은 노드인 경우
				{
					remove(ptr2);
					count++;
				}
				else
				{
					pre = ptr2;
				}
			}
			
			if(count == 0)
			{
				ptr = n[ptr].next;
			}
			else
			{
				int temp = ptr;
				remove(ptr);
				ptr = temp;
			}
		}
		crnt = head;
	}
	
/* ------------------------------------------------*/	
	
}
