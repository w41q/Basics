// http://www.geeksforgeeks.org/find-two-rectangles-overlap/
class rectangleOverlap
{
	public static void main(String[] args)
	{
		Point l1 = new Point(0, 10), r1 = new Point(10, 0);
		Point l2 = new Point(5, 5), r2 = new Point(15, 0);
		System.out.println(overlap(l1, r1, l2, r2));
	}
	
	public static boolean overlap(Point l1, Point r1, Point l2, Point r2)
	{
		// Left or Right
		if(l1.x>r2.x || l2.x>r1.x)
			return false;
		// Up or Down
		if(l1.y<r2.y || l2.y<r1.y)
			return false;
		return true;
	}
}

class Point
{
	public double x, y;
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}
