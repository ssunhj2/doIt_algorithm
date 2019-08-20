package CH05.practice;

/**
 * 배열 a의 모든 최대공약수를 구한다.
 * 두 수 이상일때 두 수의 최대공약수와 일치해야한다.
 */
public class Pr03 
{
	static int gcd(int numA, int numB)
	{
		if(numB == 0)
		{
			return numA;
		}
		else
		{
			return gcd(numB, (numA % numB));
		}
	}
	
	static int gcdArray(int arr[], int idx, int num)
	{
		if(num == 1) // 요소 개수가 1개일때
		{
			return arr[idx];
		}
		else if(num == 2) // 요소 개수가 2개일때
		{
			return gcd(arr[idx], arr[idx+1]);
		}
		else // 요소 개수가 2개 이상일때
		{
			return gcd(arr[idx], gcdArray(arr, idx+1, num-1)); // 옆에 있는것들을 차례로 구한다.
		}
	}
	
	public static void main(String[] args) 
	{
		int[] intArr = {12,3,9,9};
		
		System.out.println(intArr.length +"개 정수들의 최대공약수를 구한다.");
		
		
		System.out.println(intArr.length +"개 정수들의 최대공약수는 " + gcdArray(intArr, 0, intArr.length) + " 이다.");
	}

}
