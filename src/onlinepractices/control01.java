package onlinepractices;

public class control01 {

	public static void main(String[] args) {
		 int a = 3;
		 if(a > 4){
			 System.out.println("a > 4");
			 System.out.println("End!");
		 }
		 
		 a = 5;
		 if( a > 0 ){
			 System.out.println(" a > 0");
			 a = -5;
		 }
		if(a<0){
			System.out.println(" a < 0 ");
			a = 0;
		}
		
		a = 5;
		if(a > 0){
			System.out.println(" a > 0");
		}else{
			System.out.println(" a <= 0");
		}
		
		a = 0;
		if (a>0){
			System.out.println(" a > 0");
		}else if(a < 0){
				System.out.println(" a < 0");
		}else if(a == 0){
				System.out.println(" a == 0");
		}else{
					System.out.println("헐~~ 음수도 양수도 아니네");
		}
		
		a= 5;
		if(a>=0){
			if(a==0)
				System.out.println(" a == 0");
			else
				System.out.println(" a < 0 ");
		}
	}
}
