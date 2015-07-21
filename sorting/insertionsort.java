public class insertionsort
{
	public static void main(String[] args)
	{
		int[] a = {4,1,6,9,0,3,5,8,2,7};
		insertionSort(a);
		for(int i : a)
			System.out.print(i+" ");
	}
	
	public static void insertionSort(int[] a)
	{
		if(a.length<=1)
			return;
		for(int i=1;i<a.length;i++)
		{
			int value = a[i], idx = i-1;
			while(idx>=0 && a[idx]>value)
			{
				a[idx+1] = a[idx];
				idx--;
			}
			a[idx+1] = value;
		}
	}
}