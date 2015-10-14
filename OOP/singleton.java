class singleton
{
	private static volatile singleton instance; //use volatile to ensure that assignment to the instance variable completes before the instance variable can be accessed
	private singleton() {}
	public static singleton getInstance()
	{
		if(instance==null)
		{
			synchronized(singleton.class)
			{
				if(instance==null)			// Double checked locking: https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
					instance = new singleton();
			}
		}
		return instance;
	}
	public static void main(String[] argv)
	{
		singleton s1 = singleton.getInstance();
		System.out.println(s1);
		singleton s2 = singleton.getInstance();
		System.out.println(s2);
	}
}
