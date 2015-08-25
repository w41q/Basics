/* Reference: http://articles.leetcode.com/2011/01/sliding-window-maximum.html
			  http://bookshadow.com/weblog/2015/07/18/leetcode-sliding-window-maximum/
			  http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
*/

import java.util.Deque;
import java.util.LinkedList;

class slidingWindowMinMax
{
	public static void main(String[] argv)
	{
		int[] a = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] max = max(a, k);
		for(int i : max)
			System.out.print(i+" ");
		System.out.println();
		int[] min = min(a, k);
		for(int i : min)
			System.out.print(i+" ");
	}
	
	public static int[] max(int[] a, int k)
	{
		int[] result = new int[a.length-k+1];
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<k;i++)
		{
			while(!q.isEmpty() && a[q.peekLast()]<=a[i])
				q.pollLast();
			q.offerLast(i);
		}
		for(int i=k;i<a.length;i++)
		{
			result[i-k] = a[q.peekFirst()];
			while(!q.isEmpty() && a[q.peekLast()]<=a[i])
				q.pollLast();
			while(!q.isEmpty() && q.peekFirst()<=i-k)
				q.pollFirst();
			q.offerLast(i);
		}
		result[result.length-1] = a[q.peekFirst()];
		return result;
	}
	
	public static int[] min(int[] a, int k)
	{
		int[] result = new int[a.length-k+1];
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<k;i++)
		{
			while(!q.isEmpty() && a[q.peekLast()]>=a[i])
				q.pollLast();
			q.offerLast(i);
		}
		for(int i=k;i<a.length;i++)
		{
			result[i-k] = a[q.peekFirst()];
			while(!q.isEmpty() && a[q.peekLast()]>=a[i])
				q.pollLast();
			while(!q.isEmpty() && q.peekFirst()<=i-k)
				q.pollFirst();
			q.offerLast(i);
		}
		result[result.length-1] = a[q.peekFirst()];
		return result;
	}
	
	// Stack: Wrong solution
	// 5 3 3 2, k = 3 ==> 5 2 (Correct: 5 3)
	public static int[] max2(int[] a, int k)
	{
		int[] result = new int[a.length-k+1];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<k;i++)
		{
			if(st.isEmpty() || a[i]>=st.peek())
				st.push(a[i]);
		}
		for(int i=k;i<a.length;i++)
		{
			result[i-k] = st.peek();
			if(a[i-k]==st.peek())
				st.pop();
			if(st.isEmpty() || a[i]>=st.peek())
				st.push(a[i]);
		}
		result[result.length-1] = a[st.peek()];
		return result;
	}
}
