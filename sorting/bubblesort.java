public class bubblesort
{
	public static void main(String[] args)
	{
		int[] a = {4,1,6,9,0,3,5,8,2,7};
		bubble(a);
		for(int i : a)
			System.out.print(i+" ");
	}
	
	public static void bubble(int[] a)
	{
		for(int i=a.length-1;i>=0;i--)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]>a[j+1])
				{
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
}