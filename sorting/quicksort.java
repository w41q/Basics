public class quicksort
{
	public static void main(String[] args)
	{
		int[] a = {4,1,6,9,0,3,5,8,2,7};
		qs(a, 0, a.length-1);
		for(int i : a)
			System.out.print(i+" ");
	}
	
	public static void qs(int[] a, int begin, int end)
	{
		if(begin>=end)
			return;
		int pivot = partition(a, begin, end);
		qs(a, begin, pivot-1);
		qs(a, pivot+1, end);
	}
	
	public static int partition(int[] a, int begin, int end)
	{
		int pivot = a[(begin+end)/2];
		System.out.println(pivot);
		int left = begin, right = end;
		while(left<right)
		{
			while(a[left]<pivot)
				left++;
			while(a[right]>pivot)
				right--;
			if(left<right)
			{
				int tmp = a[left];
				a[left] = a[right];
				a[right] = tmp;
			}
		}
		if(left!=right)
			System.out.println(left+" "+right);
		return right;
	}
}