class knapsackProblem
{
	public static void main(String[] argv)
	{
		int[] a = {2, 3, 5, 7};
		int[] v = {1, 5, 2, 4};
		int m = 11;
		System.out.println(subsetsum(a, m));
		System.out.println(knapsack(a, v, m));
	}
	
	public static int subsetsum(int[] a, int m)
	{
		if(a.length==0 || m<=0)
			return 0;
		int n = a.length;
		int[][] val = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0 || j==0)
					val[i][j] = 0;
				else
				{
					if(a[i-1]>j)
						val[i][j] = val[i-1][j];
					else
						val[i][j] = Math.max(val[i-1][j], val[i-1][j-a[i-1]]+a[i-1]);
				}
			}
		}
		return val[n][m];
	}
	
	public static int knapsack(int[] a, int[] v, int m)
	{
		if(a.length==0 || a.length!=v.length || m<=0)
			return 0;
		int n = a.length;
		int[][] val = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0 || j==0)
					val[i][j] = 0;
				else
				{
					if(a[i-1]>j)
						val[i][j] = val[i-1][j];
					else
						val[i][j] = Math.max(val[i-1][j], val[i-1][j-a[i-1]]+v[i-1]);
				}
			}
		}
		return val[n][m];
	}
}
