
public class Main {

	public static void main(String[] args) {
		ThreeDVector test = new ThreeDVector(4,5,4);
		ThreeDVector add = new ThreeDVector(6,5,3);
		ThreeDVector sum = test.add(add);
		System.out.println(sum.getX());
		System.out.println(sum.getY());
		System.out.println(sum.getZ());
		
		TwoDvector test2 = new TwoDvector(316.9,126.1);
		TwoDvector add2 = new TwoDvector(5,3);
		TwoDvector sum2 = test2.add(add2);
		System.out.println(sum2.getX());
		System.out.println(sum2.getY());
		System.out.println(test2.magnitude());
		System.out.println(add2.magnitude());

	}

}
