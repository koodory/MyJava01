package EIPcertificatepreparation;
import java.util.Scanner;

public class test04{
    
	public static void main(String[] args) {
    int A=1, B=1;
    System.out.print("<< 피보나치 수열 프로그램 >>");
	Scanner scan = new Scanner(System.in);
	System.out.print("\n마지막 항 : ");
	int freq = scan.nextInt();
	int S = A+B;
	if(freq < 2){
		System.out.print(A);
	}else{
		System.out.print(A + "+" + B);	
	}
	for(int n=2; n<=freq-1; n++){	
		int C = A + B;
		S += C;
		A = B; 
		B = C;
		System.out.print("+" + C);
	}
	System.out.print("\n1부터"+ freq +"까지의 합: "+S);
	}
}
