package onlinepractices;

public class array01 {

	public static void main(String[] args) {
		int[] Subject = null;
		Subject = new int[19];
		
		for(int i =0; i<10; i++){
			Subject[i] = 10 * i;
		}
		
		for(int i =0; i<10; i++){
			System.out.println("Subject[" + i + "] = " + Subject[i]);
		}
		
		Subject = new int[10]; // 선언 즉시 초기화
			
		for(int i = 0 ; i < 10 ; i++)
			Subject[i] = 100 * i;
			
		for(int i=0 ; i < 10; i++)
			System.out.println("Subject[" + i + "] = " + Subject[i]);
		
	}

}
