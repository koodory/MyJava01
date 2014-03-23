package EIPcertificatepreparation;
import java.util.Scanner;

public class test06{
	static int F;
	public static int FACT(int num){
		int Fx=1, S = 0;
		for(int i=1; i<=num; i++){
		  Fx = Fx * i;
		  S += Fx;
		}
		if(num>0){			
			F = FACT(num-1) * num;  
			System.out.print(num+ "+");
		}
		return S;
	}
	public static void main(String[] args) {
    System.out.print("<< Factorial 곱 구하기(재귀호출)>>");
	Scanner scan = new Scanner(System.in);
	System.out.print("\n마지막 항 : ");
	int freq = scan.nextInt();
	FACT(freq);	
	
	System.out.print("\n1!부터"+ freq +"!까지의 합: "+F);
	}
}

