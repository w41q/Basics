class countingSort
{
	public static void main(String[] argv)
	{
		int[] a = {1, 4, 1, 2, 7, 5, 2};
		function(a, 1, 7);
		for(int i : a)
			System.out.print(i+" ");
		System.out.println();
		String str = "geeksforgeeks";
		char[] cha = str.toCharArray();
		function_char(cha);
		for(char c : cha)
			System.out.print(c+" ");
	}
	
	public static void function(int[] a, int min, int max)
	{
		int[] count = new int[max-min+1];
		for(int i : a)
			count[i-min]++;
		int idx = 0;
		for(int i=0;i<count.length;i++)
		{
			while(count[i]!=0)
			{
				a[idx] = min+i;
				count[i]--;
				idx++;
			}
		}
	}
	
	public static void function_char(char[] cha)
	{
		int[] count = new int[256];
		for(char c : cha)
			count[c-'0']++;
		int idx = 0;
		for(int i=0;i<count.length;i++)
		{
			while(count[i]!=0)
			{
				cha[idx] = (char)('0'+i);
				count[i]--;
				idx++;
			}
		}
	}
}
