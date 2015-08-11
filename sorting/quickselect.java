public class quickselect
{
	public static void main(String[] args)
	{
		//int[] a = {4,1,6,9,0,3,5,8,2,7};
		//int[] a = {-1,2,0};
		int[] a = {2,1};
		System.out.println(qs2(a, 1));
	}
	
	public static int qs(int[] a, int k)
	{
		return qs(a, 0, a.length-1, a.length-k);
	}
	
	public static int qs(int[] a, int begin, int end, int k)
	{
		int pivot = partition(a, begin, end);
		if(pivot==k)
			return a[k];
		else if(pivot>k)
			return qs(a, begin, pivot-1, k);
		else
			return qs(a, pivot+1, end, k);
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
	
	public static int qs2(int[] nums, int k)
	{
		int begin = 0, end = nums.length-1;
        k = nums.length-k;
        while(begin<end)
        {
            int left = begin, right = end;
            int val = nums[(left+right)/2];
            while(left<right)
            {
                if(nums[left]>=val)
                {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    right--;
                }
                else
                    left++;
            }
            if(nums[left]>val)
                left--;
            if(k<left)
                end = left;
            else
                begin = left+1;
        }
        return nums[k];
	}
}
