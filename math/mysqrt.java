class mysqrt
{
	public static void main(String[] argv)
	{
		System.out.println(sqrt_int(10));
		System.out.println(sqrt_double(1.44));
		System.out.println(sqrt_newton(2.56));
	}
	
	public static int sqrt_int(int x)
	{
		if(x<=0)
			return 0;
		if(x<=3)
			return 1;
		int low = 2, high = x/2;
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			double v = 1.0*mid*mid;
			if(v==x)
				return mid;
			else if(v<x)
				low = mid+1;
			else
				high = mid-1;
		}
		return high;
	}
	
	public static double sqrt_double(double x)
	{
		if(x<=0.0)
			return 0;
		double low = 0, high = x, mid = (low+high)/2, v = mid*mid;
		while(Math.abs(v-x)>0.001)
		{
			if(v==x)
				return mid;
			else if(v>x)
				high = mid;
			else
				low = mid;
			mid = (low+high)/2;
			v = mid*mid;
		}
		return mid;
	}
	
	public static double sqrt_newton(double v)
	{
		double x = 0, nx = 1;
		while(Math.abs(nx-x)>0.0001)
		{
			x = nx;
			nx = (v/x+x)/2;
		}
		return nx;
	}
}
