import java.util.Collections;
import java.util.PriorityQueue;

class medianOfIntStream
{
	private static PriorityQueue<Integer> less = new PriorityQueue<Integer>(Collections.reverseOrder());
	private static PriorityQueue<Integer> big = new PriorityQueue<Integer>();
	private static double median = 0;
	public static void main(String[] argv)
	{
		int[] stream = {5, 15, 1, 3};
		for(int i : stream)
			System.out.print(median(i)+" ");
	}
	
	public static double median(int num)
	{
		if(num<median)
		{
			if(less.size()<=big.size())
				less.offer(num);
			else
			{
				big.offer(less.poll());
				less.offer(num);
			}
		}
		else
		{
			if(big.size()<=less.size())
				big.offer(num);
			else
			{
				less.offer(big.poll());
				big.offer(num);
			}
		}
		if(less.size()==big.size())
			median = (less.peek()+big.peek())/2.0;
		else
			median = less.size()>big.size()?less.peek():big.peek();
		return median;
	}
}
