class gcd
{
	public static void main(String[] args)
	{
		int[] a = {123456, 7890, 12, 24, 60};
		System.out.println(function(a));
	}
	
	public static int function(int[] a)
	{
		if(a.length==0)
			return 0;
		int gcd = a[0];
		for(int i=1;i<a.length;i++)
		{
			gcd = gcd(gcd, a[i]);
		}
		return gcd;
	}
	
	// Euclidean Algorithm
	public static int gcd(int a, int b)
	{
		if(a==0 || b==0)
			return 0;
		while(b>0)
		{
			int c = a%b;
			a = b;
			b = c;
		}
		return a;
	}
}
