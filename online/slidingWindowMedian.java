import java.util.TreeMap;

class slidingWindowMedian
{
	public static void main(String[] argv)
	{
		//int[] a = {1,2,3,3,3,0,4,-3,2,-1,6,9};
		//int[] a = {142,38,100,53,22,84,168,50,194,136,111,13,47,45,151,164,126,47,106,124,183,8,87,38,91,121,102,46,82,195,53,18,11,165,61};
		int[] a = {1,2,7,7,2,10,3,4,5};
		int k = 2;
		double[] result_d = function_double(a, k);
		for(double d : result_d)
			System.out.println(d+" ");
		System.out.println();
		int[] result_i = function_int(a, k);
		for(int i: result_i)
			System.out.print(i+" ");
	}
	
	// Returns the k/2 th number in the window
	public static int[] function_int(int[] a, int k)
	{
		int[] result = new int[a.length-k+1];
		TreeMap<Integer, Integer> small = new TreeMap<Integer, Integer>(), big = new TreeMap<Integer, Integer>();
		int median = 0, smallcount = 0, bigcount = 0;
		for(int i=0;i<a.length;i++)
		{
			if(i>=k)
			{
				result[i-k] = median;
				if(small.containsKey(a[i-k]))
				{
					remove(small, a[i-k]);
					smallcount--;
				}
				else
				{
					remove(big, a[i-k]);
					bigcount--;
				}
			}
			if(a[i]<median)
			{
				add(small, a[i]);
				smallcount++;
				if(smallcount>bigcount+1)
				{
					int key = small.lastKey();
					remove(small, key);
					add(big, key);
					smallcount--;
					bigcount++;
				}
			}
			else
			{
				add(big, a[i]);
				bigcount++;
				if(bigcount>smallcount+1)
				{
					int key = big.firstKey();
					remove(big, key);
					add(small, key);
					bigcount--;
					smallcount++;
				}
			}
			median = smallcount>=bigcount?small.lastKey():big.firstKey();
		}
		result[result.length-1] = median;
		return result;
	}
	
	// Returns the double median(average if k is even)
	public static double[] function_double(int[] a, int k)
	{
		double[] result = new double[a.length-k+1];
		TreeMap<Integer, Integer> small = new TreeMap<Integer, Integer>(), big = new TreeMap<Integer, Integer>();
		double median = 0.0;
		int smallcount = 0, bigcount = 0;
		for(int i=0;i<a.length;i++)
		{
			if(i>=k)
			{
				result[i-k] = median;
				if(small.containsKey(a[i-k]))
				{
					remove(small, a[i-k]);
					smallcount--;
				}
				else
				{
					remove(big, a[i-k]);
					bigcount--;
				}
			}
			if(a[i]<median)
			{
				add(small, a[i]);
				smallcount++;
				if(smallcount>bigcount+1)
				{
					int key = small.lastKey();
					remove(small, key);
					add(big, key);
					smallcount--;
					bigcount++;
				}
			}
			else
			{
				add(big, a[i]);
				bigcount++;
				if(bigcount>smallcount+1)
				{
					int key = big.firstKey();
					remove(big, key);
					add(small, key);
					bigcount--;
					smallcount++;
				}
			}
			if(smallcount==bigcount)
				median = (small.lastKey()+big.firstKey())/2.0;
			else
				median = smallcount>bigcount?small.lastKey():big.firstKey();
		}
		result[result.length-1] = median;
		return result;
	}
	
	public static void add(TreeMap<Integer, Integer> m, int key)
	{
		if(m.containsKey(key))
			m.put(key, m.get(key)+1);
		else
			m.put(key, 1);
	}
	
	public static void remove(TreeMap<Integer, Integer> m, int key)
	{
		int val = m.get(key);
		if(val>1)
			m.put(key, val-1);
		else
			m.remove(key);
	}
}
