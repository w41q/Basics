public class mergesort
{
	public static void main(String[] args)
	{
		int[] a = {4,1,6,9,0,3,5,8,2,7};
		mergeSort(a, 0, a.length-1);
		for(int i : a)
			System.out.print(i+" ");
	}
	
	public static void mergeSort(int[] a, int begin, int end)
	{
		if(begin>=end)
			return;
		int mid = (begin+end)/2;
		mergeSort(a, begin, mid);
		mergeSort(a, mid+1, end);
		merge(a, begin, mid+1, end);
	}
	
	public static void merge(int[] a, int begin, int mid, int end)
	{
		if(end<=begin)
			return;
		int[] buf = new int[end-begin+1];
		int i = begin, j = mid, k = 0;
		while(i<mid && j<=end)
		{
			if(a[i]<=a[j])
			{
				buf[k] = a[i];
				i++;
			}
			else
			{
				buf[k] = a[j];
				j++;
			}
			k++;
		}
		while(i<mid)
		{
			buf[k] = a[i];
			i++;
			k++;
		}
		while(j<=end)
		{
			buf[k] = a[j];
			j++;
			k++;
		}
		for(int num : buf)
		{
			a[begin] = num;
			begin++;
		}
	}
}