public class longestPalindromicSubstring
{
	public static void main(String[] args)
	{
		//String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		//String s = "abcdecba";
		//String s = "bb";
		//String s = "babcbabcbaccba";
		String s = "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";
		System.out.println(lps_manacher(s));
	}
	
	// Manacher Algorithm
	// Time: O(n) Space: O(n)
	public static String lps_manacher(String s)
	{
		if(s.length()<=1)
			return s;
		char[] cha = preprocess(s);
		int[] p = new int[cha.length];
		int c = 0, r = 0;
		p[0] = 0;
		for(int i=0;i<p.length;i++)
		{
			int l = 2*c-r;
			p[i] = r<=i?0:Math.min(r-i, p[l]);
			while(i+1+p[i]<p.length && i-1-p[i]>=0 && cha[i+1+p[i]]==cha[i-1-p[i]])
				p[i]++;
			if(i+p[i]>r)
			{
				r = i+p[i];
				c = i;
			}
		}
		int center = 0, rad = 0;
		for(int i=0;i<p.length;i++)
		{
			if(p[i]>rad)
			{
				center = i;
				rad = p[i];
			}
		}
		String result = s.substring((center-rad)/2, (center+rad)/2);
		return result;
	}
	
	public static char[] preprocess(String s)
	{
		char[] result = new char[s.length()*2+1];
		int idx = 0;
		for(int i=0;i<s.length();i++)
		{
			result[idx++] = '\0';
			result[idx++] = s.charAt(i);
		}
		result[idx] = '\0';
		return result;
	}
	
	// Shifting Center
	// Time: O(n^2) Space: O(1)
	public static String lps_center(String s)
	{
		if(s.length()==0)
            return "";
        int max = 0, begin = 0, end = 0;
        for(int i=0;i<s.length()-1;i++)
        {
            int len = expand(s, i, i);
            if(len>max)
            {
                begin = i-len/2;
                end = i+len/2;
                max = len;
            }
            len = expand(s, i, i+1);
            if(len>max)
            {
                begin = i-len/2+1;
                end = i+len/2;
                max = len;
            }
        }
        return s.substring(begin, end+1);
	}
	
	public static int expand(String s, int begin, int end)
    {
        int left = begin, right = end;
        while(left>=0 && right<s.length())
        {
            if(s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }
            else
                break;
        }
        return right-left-1;
    }
	
	// DP
	// Time: O(n^2) Space: O(n^2)
	public static String lps_dp(String s)
	{
		char cha[] = s.toCharArray();
		boolean palindrom[][] = new boolean[s.length()][s.length()];
		// default is false
//		for(int i=0;i<s.length();i++)
//		{
//			for(int j=0;j<s.length();j++)
//			{
//				palindrom[i][j] = false;
//			}
//		}
		
		int max_length = 1;
		int max_index[] = new int[2];
		for(int i=0;i<s.length()-1;i++)
		{
			palindrom[i][i] = true;
			if(cha[i]==cha[i+1])
			{
				palindrom[i][i+1] = true;
				max_length = 2;
				max_index[0] = i;
				max_index[1] = i+1;
			}
		}
		palindrom[s.length()-1][s.length()-1] = true;;
		
		for(int len=2;len<s.length();len++)
		{
			for(int i=0;i<s.length()-len;i++)
			{
				if(cha[i]==cha[i+len] && palindrom[i+1][i+len-1])
				{
					palindrom[i][i+len] = true;
					max_length = len;
					max_index[0] = i;
					max_index[1] = i+len;
				}
			}
		}
        return s.substring(max_index[0], max_index[1]+1);
    }
}
