package EIPcertificatepreparation.progression;
import java.util.Scanner;

public class test03{

	public static void main(String[] args) {
		int A=2, R=3, S=A, N=2;
		System.out.print("<< 등비 수열 프로그램 >>\n");
		Scanner scan = new Scanner(System.in);
		System.out.print("더할 마지막 항 : ");
		int freq = scan.nextInt();
	  System.out.print(A);
		do{	
			A = A * R;
			S = S + A;
			N = N + 1;
			System.out.print("+" + A);
		}while(N <= freq);
		System.out.print("\n등비수열(공비:3) - 2부터"+ freq +"까지의 합: "+S);
	}
}
