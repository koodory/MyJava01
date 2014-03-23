package EIPcertificatepreparation;
import java.util.Scanner;

public class test04{

	public static void main(String[] args) {
		int A=1, B=1, S=A+B, N =2;
		System.out.print("<< 피보나치 수열 프로그램 >>");
		Scanner scan = new Scanner(System.in);
		System.out.print("\n마지막 항 : ");
		int freq = scan.nextInt();
		System.out.print(A + "+" + B);	
		do{	
			int C = A + B;
			S += C;
			A = B; 
			B = C;
			N = N + 1;
			System.out.print("+" + C);
		}while(N != freq);
		System.out.print("\n1부터"+ freq +"까지의 합: "+S);
	}
}
