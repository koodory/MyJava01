package onlinepractices;

public class operator03 {
	public static void main(String[] args){
		int a = 10;
		a = a + 1;
		System.out.println("a = " + a);
		
		a++;
		System.out.println("a = " + a);
		
		++a;
		System.out.println("a = " + a);
		
		a = 10;
		int s = 0;
		s = a++;
	  
		System.out.println("s = " + s + ",a = " + a);
		
		a = 10;
		a = a++;
		System.out.println("a = " + a);
		
		a = 10;
		s = 0;
		s= a++ + a++ + a++; // s= 10 + 11 +12 --> a= 13
		System.out.println("s =" + s + ", a =" + a );
		
		a = 10;
		s = 0;
		s = ++a + ++a + ++a; // s= 11 + 12 + 13 -- > a = 13 
		System.out.println("s =" + s + ", a =" + a );
		
		a= 5;
		int b = 6;
		s = 0;
	  s= a++ + ++b + ++a + b++;
	  System.out.println("s =" + s + ", a =" + a + ", b =" + b );
	}
}
