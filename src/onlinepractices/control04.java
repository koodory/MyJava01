package onlinepractices;

public class control04 {
	public static void main(String[] args){		
		int index;
		for(index = 0; index < 10; index++){
			System.out.println("index = " + index);
		}
		System.out.println("마지막 index =" + index);
		
		index = 0;
		for( ; index < 10 ; index++){
			System.out.println("index = " + index);
		}
		System.out.println("마지막 index =" + index);
		
		index = 0;
		for( ; index < 10 ; ){
			System.out.println("index = " + index);
			index++;
		}
		System.out.println("마지막 index =" + index);
		
		index = 0;
		for( ;  ; ){
			if(index >= 10) 
				break;
			System.out.println("index = " + index);
			index++;
		}
		
		AAA:{
			for(int i=1; i<10; i++){
				System.out.println("구구단" + i + "단");
				for(int j=1; j<10; j++){
					if(i>5)
						break AAA; // 바깥쪽 루프까지 탈출 //레이블{ }에 명령이 해당
						System.out.println(i + "*" + j + " =" + i * j);
				}
			}
		}		
		
		for(int i=0; i<9 ; i++){
			if(i == 5)
				continue;
			System.out.println("i = " + i);
		}
		
		BBB:
			for(int i=1; i<10; i++){
				for(int j=1; j<10; j++){
					if(j == 5)
						continue BBB; //레이블로 이동
					System.out.println(i + "*" + j + " =" + i * j);
				}		
				System.out.println("****************************");
			}
	}
}
