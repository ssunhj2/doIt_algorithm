package CH02.exam;

/**
 * 실습 2-7
 * 두 배열의 모든요소가 동일한지 체크한다.
 */
public class Exam07
{
	static boolean checkEquals(int[] iArr1, int[] iArr2)
	{
		if(iArr1.length != iArr2.length) return false;

		for (int i = 0; i < iArr1.length; i++)
		{
			if(iArr1[i] != iArr2[i]) return false;
		}

		return true;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("배열 iArr의 요소");
		
		int[] iArr1 = {10, 73, 2, 5, 42, 77};
		
		for(int i=0; i<iArr1.length; i++)
		{
			System.out.println("iArr1[" + i + "] = " + iArr1[i]);
		}

		System.out.println("배열 iArr2의 요소");
		int[] iArr2 = {10, 73, 2, -5, 42, 77};

		for(int i=0; i<iArr2.length; i++)
		{
			System.out.println("iArr2[" + i + "] = " + iArr2[i]);
		}

		System.out.println("배열 iArr1과 iArr2는 " + (checkEquals(iArr1, iArr2)==true?"같다": "다르다"));
	}

}
