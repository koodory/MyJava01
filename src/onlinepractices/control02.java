package onlinepractices;

public class control02 {

	public static void main(String[] args) {
		int a = 400;
		switch( a * 5){
		case 50:
			System.out.println("a * 5 = 50");
			System.out.println("therefore, a = 10");
			break;
		case (20 * 100):
			System.out.println("a * 5 = 2000");
		  System.out.println("therefore, a = 400");
		  break;
		default:
			System.out.println("a is 5's multifier");
			 a= 0;
		}
		
		char c = 'A';
		switch(c) {
		case 'A':
		  System.out.println("A");
		  break;
		case 'B' + 'C':
			System.out.println("B");
		  break;
		}
		
		a = 3;
		switch(a){
		case 3: 	System.out.println("He has a SCJP Certificate!");	
		case 2: 	System.out.println("He has a IFT Certificate!");
		case 1: 	System.out.println("He has a ITT Certificate!");
		default: 	System.out.println("He has a driever license!");
		}
	}
}
