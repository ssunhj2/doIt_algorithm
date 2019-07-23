package CH02.practice;

/**
 * 배열 iArr2 요소를 iArr1에 역순으로 복사한다.
 */
public class Pr05
{
	// 배열 iArr2 요소를 iArr1에 역순으로 복사
	static void rCopyArray(int[] iArr1, int[] iArr2)
	{
		int tArrLength = iArr2.length;

		for (int i = 0; i < tArrLength; i++)
		{
			iArr1[i] = iArr2[tArrLength-i-1];
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("배열 iArr2의 요소");
		int[] iArr2 = {10, 73, 2, -5, 42, 77};

		for(int i=0; i<iArr2.length; i++)
		{
			System.out.println("iArr2[" + i + "] = " + iArr2[i]);
		}

		System.out.println("배열 iArr2 요소를 iArr1에 역순으로 복사한다.");

		int[] iArr1 = new int[iArr2.length];
		rCopyArray(iArr1, iArr2);

		System.out.println("배열 iArr1의 요소");
		for(int i=0; i<iArr1.length; i++)
		{
			System.out.println("iArr1[" + i + "] = " + iArr1[i]);
		}

	}

}
