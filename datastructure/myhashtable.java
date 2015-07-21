public class myhashtable
{
	public static void main(String[] args)
	{
		int[] a = {1,2,129,257,258,3};
		myHashTable ht = new myHashTable();
		int result = ht.find(0);
		ht.put(1, 1);
		ht.put(2, 2);
		ht.put(129, 129);
		ht.put(257, 257);
		ht.put(258, 258);
		ht.put(3, 3);
		result = ht.find(1);
		result = ht.find(2);
		result = ht.find(129);
		result = ht.find(257);
		result = ht.find(258);
		result = ht.find(3);
		ht.put(3, 33);
		result = ht.find(3);
		ht.remove(258);
		result = ht.find(258);
		ht.remove(1);
		ht.remove(257);
		result = ht.find(129);
	}
	
	public static class myHashTable
	{
		private int tableSize = 128;
		private hashEntry[] table;
		public myHashTable()
		{
			table = new hashEntry[tableSize];
			for(int i=0;i<tableSize;i++)
				table[i] = null;
		}
		public int find(int key)
		{
			int hash = key%tableSize;
			if(table[hash]==null)
				return -1;
			else
			{
				hashEntry e = table[hash];
				while(e!=null && e.key!=key)
					e = e.next;
				if(e==null)
					return -1;
				else
					return e.value;
			}
		}
		public void put(int key, int value)
		{
			int hash = key%tableSize;
			if(table[hash]==null)
				table[hash] = new hashEntry(key, value);
			else
			{
				hashEntry e = table[hash];
				while(e.next!=null && e.key!=key)
					e = e.next;
				if(e.key==key)
					e.value = value;
				else
					e.next = new hashEntry(key, value);
			}
		}
		public void remove(int key)
		{
			int hash = key%tableSize;
			if(table[hash]!=null)
			{
				hashEntry e = table[hash], prev = null;
				while(e.key!=key && e.next!=null)
				{
					prev = e;
					e = e.next;
				}
				if(e.key==key)
				{
					if(prev==null)
						table[hash] = e.next;
					else
						prev.next = e.next;
				}
			}
		}
	}
	
	public static class hashEntry
	{
		public int key;
		public int value;
		public hashEntry next;
		public hashEntry(int key, int value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
}