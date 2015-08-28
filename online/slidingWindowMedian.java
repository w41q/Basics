import java.util.TreeMap;

class slidingWindowMedian
{
	public static void main(String[] argv)
	{
		int[] a = {1,2,3,3,3,0,4,-3,2,-1,6,9};
		int k = 3;
		double[] result = function(a, k);
		for(double i: result)
			System.out.print(i+" ");
	}
	
	public static double[] function(int[] a, int k)
	{
		double[] result = new double[a.length-k+1];
		TreeMap<Integer, Integer> small = new TreeMap<Integer, Integer>(), big = new TreeMap<Integer, Integer>();
		double median = 0.0;
		int smallcount = 0, bigcount = 0;
		for(int i=0;i<k;i++)
		{
			if(small.isEmpty() || a[i]<median)
			{
				if(smallcount<=bigcount)
				{
					add(small, a[i]);
					smallcount++;
				}
				else
				{
					int key = small.lastKey();
					remove(small, key);
					add(big, key);
					add(small, key);
					bigcount++;
				}
			}
			else
			{
				if(bigcount<=smallcount)
				{
					add(big, a[i]);
					bigcount++;
				}
				else
				{
					int key = big.firstKey();
					remove(big, key);
					add(small, key);
					add(big, a[i]);
					smallcount++;
				}
			}
			if(smallcount==bigcount)
				median = (small.lastKey()+big.firstKey())/2.0;
			else
				median = smallcount>bigcount?small.lastKey():big.firstKey();
		}
		for(int i=k;i<a.length;i++)
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
			if(a[i]<median)
			{
				if(smallcount<=bigcount)
				{
					add(small, a[i]);
					smallcount++;
				}
				else
				{
					int key = small.lastKey();
					remove(small, key);
					add(big, key);
					add(small, a[i]);
					bigcount++;
				}
			}
			else
			{
				if(bigcount<=smallcount)
				{
					add(big, a[i]);
					bigcount++;
				}
				else
				{
					int key = big.firstKey();
					remove(big, key);
					add(small, key);
					add(big, a[i]);
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
