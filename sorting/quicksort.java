public class quicksort
{
	public static void main(String[] args)
	{
		int[] a = {4,1,6,9,0,3,5,8,2,7};
		//int[] a = {-1,2,0,2};
		qs2(a, 0, a.length-1);
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
		int pivot = a[begin];
		int idx = begin, next = begin;
		while(idx<=end)
		{
			if(a[idx]<pivot)
			{
				int tmp = a[idx];
				a[idx] = a[next];
				a[next] = tmp;
				next++;
			}
			idx++;
		}
		if(a[next]!=pivot)
		{
			for(int i=next;i<=end;i++)
			{
				if(a[i]==pivot)
				{
					int tmp = a[i];
					a[i] = a[next];
					a[next] = tmp;
				}
			}
		}
		return next;
	}
	
	public static void qs2(int[] a, int begin, int end)
	{
		if(begin>=end)
			return;
		int pivot = a[(begin+end)/2];
		int left = begin, right = end;
		while(left<=right)
		{
			while(a[left]<pivot)
				left++;
			while(a[right]>pivot)
				right--;
			if(left<=right)	// = is to prevent infinite loop when left=right && num[left]==pivot
			{
				int tmp = a[left];
				a[left] = a[right];
				a[right] = tmp;
				left++;
				right--;
			}
		}
		if(begin<right)
			qs2(a, begin, right);
		if(left<end)
			qs2(a, left, end);
	}
}
