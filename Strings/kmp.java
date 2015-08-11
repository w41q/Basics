class kmp
{
	private static int count = 0;
	private static int target = 3;
	public static void main(String[] argv)
	{
		//String s = "bbc abcdab abcdabcdabde", p = "abcdabd";
		String s = "abababab", p = "abab";
		System.out.println(function(s, p));
	}
	
	public static int function(String s, String p)
	{
		if(p.length()==0 || s.length()<p.length())
			return -1;
		int[] next = new int[p.length()+1];
		getNext(p, next);
		int i = 0, j = 0;
		while(i<s.length() && j<p.length())
		{
			while(i<s.length() && j<p.length())
			{
				if(j==-1 || s.charAt(i)==p.charAt(j))
				{
					i++;
					j++;
				}
				else
					j = next[j];
			}
			if(j==p.length())
			{
				count++;
				if(count==target)
					break;
				else
					j = next[j];
			}
			else
				break;
		}
		if(count==target)
			return i-j;
		else
			return -1;
	}
	
	public static void getNext(String p, int[] next)
	{
		int k = -1, j = 0;
		next[0] = -1;
		while(j<p.length())
		{
			if(k==-1 || p.charAt(k)==p.charAt(j))
			{
				k++;
				j++;
				next[j] = k;
			}
			else
				k = next[k];
		}
	}
	
	public static void getNext_opt(String p, int[] next)
	{
		int k = -1, j = 0;
		next[0] = -1;
		while(j<p.length())
		{
			if(k==-1 || p.charAt(k)==p.charAt(j))
			{
				k++;
				j++;
				if(p.charAt(k)!=p.charAt(j))
					next[j] = k;
				else
					next[j] = next[k];
			}
			else
				k = next[k];
		}
	}
}
