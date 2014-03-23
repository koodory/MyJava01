package EIPcertificatepreparation.progression;
import java.util.Scanner;

public class test05{

	public static void main(String[] args) {
		int F=1, S=1, N=1;
		System.out.print("<< Factorial 곱 구하기 >>");
		Scanner scan = new Scanner(System.in);
		System.out.print("\n마지막 항 : ");
		int freq = scan.nextInt();

		do{
			if(N==1)
				System.out.print(F);	
			N = N + 1;
			F = F * N;
			S += F;
			System.out.print("+" + F);
		}while(N != freq);
		System.out.print("\n1!부터"+ freq +"!까지의 합: "+S);
	}
}
