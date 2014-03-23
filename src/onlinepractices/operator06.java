package onlinepractices;
public class operator06 {

	public static void main(String[] args) {
		int i = 11;
		int s = i >> 2;
		
		System.out.println("i >> 2 : " +  s);
		
		i = -11;
		s = i >> 2;
		System.out.println("-i >> 2 : " +  s);
		
		i = 11;
		s = i >>> 2;
		System.out.println("i >>> 2 : " +  s);
		
		i = -11;
		s = i >>> 2;
		System.out.println("i >>> 2 : " +  s);
		
		
		i = 11;
		s = i << 2;
		System.out.println("i << 2 : " +  s);
		
		i = -11;
		s = i << 2;
		System.out.println("i << 2 : " +  s); //음수 = 0부터 반전 + 1
		
		i =10;
		int i2 = 11;
		s = i & i2;
		System.out.println("i & i2 = "+s); //교집합은 작은수
		
		i = 10; i2 =11;
		s = i ^ i2;
		System.out.println("i ^ i2 = "+s); 
		
		i = 10; s = ~i;
		System.out.println("~i = "+s); 
	}

}
