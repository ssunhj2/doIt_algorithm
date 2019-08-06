package CH04.practice;

import java.util.Scanner;

import CH04.common.GenericStack;
import CH04.common.IntStack;
/**
 * 제네릭 스택을 구현한다.
 *
 */
public class Pr02 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		GenericStack stk = new GenericStack(64);
		
		while(true)
		{
			System.out.println("현재 데이터수 : " + stk.getSize() + " / " + stk.dataSize());
			
			System.out.println("\n아래 목록을 보고 수행할 번호를 입력한다.");
			System.out.print("(1)push  (2)pop  (3)peek  (4)dump  (5)clear  (6)indexOf  (7)isEmpty  (8)isFull  (0)exit : ");
			
			int menuNum = in.nextInt();
			if(menuNum == 0) break;
			
			System.out.println();
			
			Object x;
			switch(menuNum)
			{
				case 1:
					System.out.print("푸시 할 데이터: ");
					x = in.nextInt();
					try
					{
						stk.push(x);
					}
					catch(IntStack.OverflowStackException e)
					{
						System.out.println("스택이 가득찼다.");
					}
					break;
				case 2:
					try
					{
						x = stk.pop();
						System.out.println("pop 한 Data는 "+ x + " 이다.");
					}
					catch(IntStack.EmptyStackException e)
					{
						System.out.println("스택이 비었다.");
					}
					break;
				case 3:
					try
					{
						x = stk.peek();
						System.out.println("peek 한 Data는 " + x + " 이다.");
					}
					catch(IntStack.EmptyStackException e)
					{
						System.out.println("스택이 비었다.");
					}
					break;
				case 4:
					stk.dump();
					break;
				case 5:
					stk.clear();
					break;
				case 6:
					x = in.nextInt();
					int result = stk.indexOf(x);
					
					if(result == -1)
					{
						System.out.println("데이터 " + x + "(을)를 찾을 수 없다.");
					}
					else
					{
						System.out.println("데이터는 " + result +"번째에 있다.");
					}
					break;
				case 7:
					if(stk.isEmpty())
					{
						System.out.println("스택이 비어있다.");
					}
					else
					{
						System.out.println("스택이 비어있지 않다.");
					}
					break;
				case 8:
					if(stk.isFull())
					{
						System.out.println("스택이 가득찼다.");
					}
					else
					{
						System.out.println("스택이 가득차지 않았다.");
					}
					break;
					
				
			}
		}
	}

}
