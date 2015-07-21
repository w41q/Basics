public class selectionsort
{
	public static void main(String[] args)
	{
		int[] a = {4,1,6,9,0,3,5,8,2,7};
		selection(a);
		for(int i : a)
			System.out.print(i+" ");
	}
	
	public static void selection(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int idx = i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[idx])
					idx = j;
			}
			int tmp = a[i];
			a[i] = a[idx];
			a[idx] = tmp;
		}
	}
}