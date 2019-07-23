package CH02.exam;

/**
 * 실습 2-6
 * 배열을 역순으로 정렬한다.
 */
public class Exam06 
{
	static void switching(int[] iArr, int index1, int index2)
	{
		int temp = iArr[index1];
		iArr[index1] = iArr[index2];
		iArr[index2] = temp;
	}
	
	static void reverseArr(int[] iArr)
	{
		int arrLength = iArr.length;
		
		for(int i=0; i<(arrLength/2); i++)
		{
			switching(iArr, i, arrLength-i-1);
		}
	}
	
	public static void main(String[] args) 
	{
		int numCnt = 6;
		
		System.out.println("요소수: " + numCnt);
		
		int[] numArr = {10, 73, 2, -5, 42, 77};
		
		for(int i=0; i<numCnt; i++)
		{
			System.out.println("numArr[" + i + "] = " + numArr[i]);
		}
		
		reverseArr(numArr);
		
		System.out.println("요소를 역순으로 정렬한다.");
		for(int i=0; i<numCnt; i++)
		{
			System.out.println("numArr[" + i + "] = " + numArr[i]);
		}
	}

}
