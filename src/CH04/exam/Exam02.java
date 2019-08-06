package CH04.exam;

import java.util.Scanner;

import CH04.common.IntStack;
/**
 * 실숩 4-2
 *
 */
public class Exam02 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		IntStack stk = new IntStack(64);
		
		while(true)
		{
			System.out.println("현재 데이터수 : " + stk.getSize() + " / " + stk.dataSize());
			
			System.out.println("아래 목록을 보고 수행할 번호를 입력한다.");
			System.out.print("(1)push  (2)pop  (3)peek  (4)dump  (0)exit : ");
			
			int menuNum = in.nextInt();
			if(menuNum == 0) break;
			
			int x;
			
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
			}
		}
	}

}
