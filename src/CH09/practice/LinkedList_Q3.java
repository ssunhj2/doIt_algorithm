package CH09.practice;

import java.util.Comparator;

/* Q3: 머리노드에 대한 참조 head에 덧붙여 꼬리노드에 대한 참조 tail을 도입한다. */	
public class LinkedList_Q3<E>
{
	// 노드
	class Node<E> {
		private E data;			// 데이터
		private Node<E> next;	// 뒤쪽 포인터(다음 노드 참조)

		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;		// 머리 노드
	private Node<E> crnt;		// 선택 노드
	private Node<E> tail;		// 꼬리 노드

	// 생성자
	public LinkedList_Q3() {
		head = tail = crnt = null;
	}

	// 노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;							// 현재 스캔중인  노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {	// 검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;							// 다음 노드를 선택
		}
		return null;								// 검색 실패
	}

	// 머리에 노드 삽입
	public void addFirst(E obj) {
		boolean empty = (tail == null);
		Node<E> ptr = head;							// 삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);
		if(empty) tail = crnt; // 노드가 1개일때만 삽입노드 추가
	}

	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head == null)							// 리스트가 비어 있으면 
			addFirst(obj);							// 머리에 삽입
		else {
			tail.next = crnt = new Node<E>(obj, null); // 꼬리 다음에 삽입
			tail = crnt;
		}
	}

	// 머리 노드 삭제
	public void removeFirst() {
		if (head != null)							// 리스트가 비어 있지 않으면
		{
			head = crnt = head.next;
			if(head == null) tail = null; // 노드가 없으면 tail도 update 해준다.
		}
		
	}

	// 꼬리 노드  삭제
	public void removeLast() {
		if (head != null) {
			if (head.next == null)					// 노드가 하나만 있으면
				removeFirst();						// 머리 노드를 삭제
			else {
				Node<E> ptr = head;					// 스캔 중인  노드
				Node<E> pre = head;					// 스캔 중인  노드의 앞쪽 노드

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;					// pre는 삭제 후의 꼬리 노드
				tail = crnt = pre; // 삭제 후 tail이 꼬리노드를 가리키게 한다.
			}
		}
	}

	// 노드 p를 삭제
	public void remove(Node p) {
		if (head != null) {
			if (p == head)							// p가 머리 노드면
			{
				removeFirst();						// 머리 노드를 삭제
			}
			else if(p == tail)
			{
				removeLast(); // p가 꼬리노드면 꼬리노드 삭제
			}
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;		// p가 리스트에 없습니다.  
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}

	// 모든 노드를 삭제
	public void clear() {
		while (head != null)						// 노드에 아무것도 없을 때까지
			removeFirst();							// 머리 노드를 삭제
		crnt = null;
	}

	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false;							// 이동할 수 없음
		crnt = crnt.next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}

	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
/* Q1: 서로 같은 노드를 찾아 가장 앞쪽의 노드를 남기고 모두 삭제한다. */
	public void purge(Comparator <? super E> c)
	{
		Node<E> ptr = head;
		
		while(ptr != null)
		{
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;
			
			while(pre.next != null)
			{
				ptr2 = pre.next;
				if(c.compare(ptr.data, ptr2.data) == 0) // 같은 노드인 경우
				{
					pre.next = ptr2.next; // 기준노드는 그대로 두고, 찾은 노드 삭제
					count++;
				}
				else
				{
					pre = ptr2;
				}
			}
			
			if(count == 0)
			{
				ptr = ptr.next;
			}
			else // 가장 앞쪽노드는 남기고 삭제하기로 했는데 가장 앞쪽노드도 삭제함
			{
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}
		
	}
	
/* ------------------------------------------------*/	
	
/* Q2: 머리에서 n개 뒤의 노드에 대한 참조를 반환하는 메서드를 작성한다. */
	public E retrieve(int n)
	{
		Node<E> ptr = head;
		
		// n이 음수거나 노드개수보다 크면 null을 반환한다.
		while(n >= 0 && ptr != null)
		{
			if(n-- == 0)
			{
				crnt = ptr; // 찾은 노드를 가리키게 한다.
				return ptr.data;
			}
			ptr = ptr.next;
		}

		return null;
		
	}

/* ------------------------------------------------*/	
	

}







