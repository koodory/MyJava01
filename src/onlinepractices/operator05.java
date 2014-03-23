package onlinepractices;

public class operator05 {

	public static void main(String[] args) {
		boolean b =true;
		boolean b2 = false;
		
		System.out.println("b && b2 = " + (b&&b2));
		System.out.println("b || b2 = " + (b||b2));
		System.out.println("b & b2 = " + (b&b2));
		System.out.println("b | b2 = " + (b|b2));
		System.out.println("!b = " + !b);
		
		boolean r = false;
		b2 = false;
		boolean s = b2 & ( r = true);
   	
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		
		r = false;
		b= true;
		s = b | (r = true);
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		
		int i= 10, i2 =20;
	//	r = i && i2;
	 //  r = i & i2; 		
	}
}
