import java.util.NoSuchElementException;

public class myheap
{
	public static void main(String[] args)
	{
		int[] a = new int[3];
		for(int i=0;i<a.length;i++)
			a[i] = 9-i;
		myHeap heap = new myHeap(3);
		for(int i:a)
			heap.insert(i);
		//myHeap heap = new myHeap(a);
		System.out.println("print heap");
		heap.printHeap();
		System.out.println("extract heap");
		int size = heap.heapsize;
		for(int i=0;i<size;i++)
			System.out.println(heap.extractMin());
		System.out.println("print heap");
		heap.printHeap();
	}
	
	public static class myHeap
	{
		private int[] array;
		private int heapsize;
		
		public myHeap(int size)
		{
			this.array = new int[size];
			heapsize = 0;
		}
		
		public myHeap(int[] arr)
		{
			this.array = new int[arr.length];
			//System.arraycopy(arr, 0, this.array, 0, arr.length);
			heapsize = 0;
			for(int i : arr)
			{
				insert(i);
			}
		}
		
		public void heapifyDown(int pos)
		{
			int length = this.heapsize;
			if(pos>=length || pos<0)
				return;
			while(pos<length)
			{
				int childIdx = pos*2+1;
				if(childIdx>=length)
					return;
				int minChild = this.array[childIdx];
				int minChildIdx = childIdx;
				if(childIdx+1<length)
				{
					if(this.array[childIdx+1]<this.array[childIdx])
					{
						minChild = this.array[childIdx+1];
						minChildIdx = childIdx+1;
					}
				}
				if(minChild<this.array[pos])
				{
					int tmp = this.array[pos];
					this.array[pos] = minChild;
					this.array[minChildIdx] = tmp;
					pos = minChildIdx;
				}
				else
					break;
			}
		}
		
		public void heapifyUp(int pos)
		{
			int length = this.heapsize;
			if(pos>=length || pos<0)
				return;
			while(pos>0)
			{
				int pIdx = (pos-1)/2;
				if(pIdx>=0 && this.array[pIdx]>this.array[pos])
				{
					int tmp = this.array[pos];
					this.array[pos] = this.array[pIdx];
					this.array[pIdx] = tmp;
					pos = pIdx;
				}
				else
					break;
			}
		}
		
		public int findMin()
		{
			if(this.heapsize>0)
				return this.array[0];
			else
				throw new NoSuchElementException("Underflow Exception");
		}
		
		public void insert(int x)
		{
			if(this.heapsize==this.array.length)
				throw new NoSuchElementException("Overflow Exception");
			this.array[this.heapsize] = x;
			this.heapsize++;
			heapifyUp(this.heapsize-1);
		}
		
		public int extractMin()
		{
			if(this.heapsize==0)
				throw new NoSuchElementException("Underflow Exception");
			else
			{
				int result = this.array[0];
				this.array[0] = this.array[this.heapsize-1];
				this.heapsize--;
				heapifyDown(0);
				return result;
			}
		}
		
		public void printHeap()
		{
			for(int i=0;i<this.heapsize;i++)
				System.out.println(this.array[i]);
		}
	}
}