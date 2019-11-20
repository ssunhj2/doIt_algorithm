package CH09.practice;

import java.util.Comparator;

/**
 *  원형리스트를 연결리스트로 구현한다.
 *
 */
public class CircleLinkedList_Q7<E> 
{
	// 노드
	class Node<E> 
	{
		E data;
		Node<E> next;

		// 생성자
		Node(E data)
		{
			this.data = data;
			this.next = this;
		}
		
		// 생성자
		Node(E data, Node<E> next)
		{
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;
	private Node<E> tail; // 꼬리 노드
	private Node<E> crnt;

	// 생성자
	public CircleLinkedList_Q7() 
	{
		head = tail = crnt = null;
	}

	// 노드 검색
	public E search(E obj, Comparator<? super E> c) 
	{
		if (head != null) 
		{
			Node<E> ptr = head; // 현재 스캔중인 노드

			do {
				if (c.compare(obj, ptr.data) == 0) 
				{
					crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next; 
			} while (ptr != head);
		}
		return null; // 검색실패
	}

	// 머리에 노드 삽입
	public void addFirst(E obj) 
	{
		if(head == null) // 데이터가 없는경우
		{
			head = tail = crnt = new Node<E>(obj); // 한개인 경우 다음 포인터를 자기 자신으로 잡는다.
		}
		else
		{
			Node<E> ptr = head;
			head = crnt = new Node<E>(obj, ptr); // head를 추가된 노드로 변경, head가 기존에 가리키던  next 노드로 갖게한다.
			tail.next = head; // 꼬리노드의 next 노드가 head를 가리킫록 한다.
		}
		
	}

	// 꼬리에 노드 삽입
	public void addLast(E obj)
	{
		if (head == null) 
		{
			addFirst(obj);
		}
		else 
		{
			Node<E> ptr = tail;
			ptr.next = crnt = tail = new Node<E>(obj, head); // 꼬리노드가 next로 head가 가리키는 노드를 가리키도록 한다.
		}
	}

	// 머리 노드 삭제
	public void removeFirst() {
		if (head != null)
		{
			if(head == tail) // 1개만 있는경우
			{
				head = tail = crnt = null;
			}
			else
			{
				Node<E> ptr = head.next;
				head = crnt = ptr; // head가 머리노드의 다음노드를 가리키도록 한다.
				tail.next = head; // 꼬리노드가 지워진 머리노드대신 현재의 머리노드를 가리키게 한다.
			}
		}
	}

	// 꼬리 노드  삭제
	public void removeLast() 
	{
		if (head != null) 
		{
			if (head == tail) // 노드가 1개만 있는 경우
			{
				removeFirst();
			}
			else 
			{
				Node<E> ptr = head;
				Node<E> pre = head;

				while (ptr.next != head) 
				{
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = head; // 꼬리노드의 앞쪽 노드의 next가 head를 가리키도록 한다.
				tail = crnt = pre; // 꼬리노드는 삭제한 꼬리노드의 앞쪽노드가 되도록 한다.
			}
		}
	}

	// 노드 p를 삭제
	public void remove(Node p) 
	{
		if (head != null) 
		{
			if (p == head) // p가 머리노드인 경우
			{
				removeFirst();
			}
			else 
			{
				Node<E> ptr = head;

				while (ptr.next != p)
				{
					ptr = ptr.next;
					if (ptr == head) return; // p가 없는 경우
				}
				ptr.next = p.next; // p의 앞노드의 next를 p의 next로 변경
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
		// 머리노드부터 차례로 삭제한다.
		while (head != null)
		{
			removeFirst();
		}
		crnt = null;
	}

	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next()
	{
		if (crnt == null || crnt.next == null)
		{
			return false;
		}
		crnt = crnt.next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode()
	{
		if (crnt == null)
		{
			System.out.println("선택한 노드가 없습니다.");
		}
		else
		{
			System.out.println(crnt.data.toString());
		}
	}

	// 모든 노드를 출력
	public void dump()
	{
		if (head != null)
		{
			Node<E> ptr = head;

			do
			{
				System.out.println(ptr.data.toString());
				ptr = ptr.next;
			} 
			while (ptr != head);
		}
		else
		{
			System.out.println("데이터가 없습니다");
		}
	}	
}
