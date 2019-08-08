package CH04.practice;

import java.util.Scanner;

import CH04.queue.GenericQueue;
import CH04.queue.IntQueue;
/**
 * 임의의 데이터를 검색하는 메서드 추가
 */
public class Pr06 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		GenericQueue gQue = new GenericQueue(64);
		
		while(true)
		{
			System.out.println("현재 데이터수 : " + gQue.getSize() + " / " + gQue.dataSize());
			
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
						gQue.enque(x);
					}
					catch(GenericQueue.overflowIntQueException e)
					{
						System.out.println("큐가 가득찼다.");
					}
					break;
				case 2:
					try
					{
						x = (int)gQue.deque();
						System.out.println("dequeue 한 Data는 "+ x + " 이다.");
					}
					catch(GenericQueue.EmptyIntQueException e)
					{
						System.out.println("큐가 비었다.");
					}
					break;
				case 3:
					try
					{
						x = (int)gQue.peek();
						System.out.println("peek 한 Data는 " + x + " 이다.");
					}
					catch(GenericQueue.EmptyIntQueException e)
					{
						System.out.println("큐가 비었다.");
					}
					break;
				case 4:
					gQue.dump();
					break;
			}
		}
	}

}
