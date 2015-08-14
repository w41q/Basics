public class randomShuffle
{
	// Fisher-Yates shuffle aka Knuth shuffle
	// Time: O(n), Space: O(1)
	public static void main(String[] argv)
	{
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		function(a);
		for(int i : a)
			System.out.print(i+" ");
		System.out.println();
		int[] b = randCopy(a);
		for(int i : b)
			System.out.print(i+" ");
	}
	
	public static void function(int[] a)	// Randomly shuffle source array
	{
		for(int i=a.length-1;i>=0;i--)
		{
			int idx = (int)(Math.random()*(i+1));	// Generate a integer 0<=idx<=i
			int tmp = a[idx];
			a[idx] = a[i];
			a[i] = tmp;
		}
	}
	
	public static int[] randCopy(int[] a)	// Generate a randomly shuffled copy of source array
	{
		int[] result = new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			int idx = (int)(Math.random()*(i+1));
			result[i] = result[idx];
			result[idx] = a[i];
		}
		return result;
	}
}
