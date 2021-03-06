package CH04.practice;

import java.util.Scanner;

import CH04.queue.IntQueue;
/**
 * 임의의 데이터를 검색하는 메서드 추가
 */
public class Pr05 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		IntQueue que = new IntQueue(64);
		
		while(true)
		{
			System.out.println("현재 데이터수 : " + que.getSize() + " / " + que.dataSize());
			
			System.out.println("아래 목록을 보고 수행할 번호를 입력한다.");
			System.out.print("(1)enqueue  (2)dequeue  (3)peek  (4)dump  (0)exit : ");
			
			int menuNum = in.nextInt();
			if(menuNum == 0) break;
			
			int x;
			
			switch(menuNum)
			{
				case 1:
					System.out.print("enqueue 할 데이터: ");
					x = in.nextInt();
					try
					{
						que.enque(x);
					}
					catch(IntQueue.overflowIntQueException e)
					{
						System.out.println("큐가 가득찼다.");
					}
					break;
				case 2:
					try
					{
						x = que.deque();
						System.out.println("dequeue 한 Data는 "+ x + " 이다.");
					}
					catch(IntQueue.EmptyIntQueException e)
					{
						System.out.println("큐가 비었다.");
					}
					break;
				case 3:
					try
					{
						x = que.peek();
						System.out.println("peek 한 Data는 " + x + " 이다.");
					}
					catch(IntQueue.EmptyIntQueException e)
					{
						System.out.println("큐가 비었다.");
					}
					break;
				case 4:
					que.dump();
					break;
			}
		}
	}

}
