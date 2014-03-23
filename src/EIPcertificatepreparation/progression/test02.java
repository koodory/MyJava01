package EIPcertificatepreparation.progression;
import java.util.Scanner;

public class test02{

	public static void main(String[] args) {
		int A=2, D=6, S=A, N=2;
		System.out.print("<< 등차 수열 프로그램 >>\n");
		Scanner scan = new Scanner(System.in);
		System.out.print("더할 마지막 순번 : ");
		int freq = scan.nextInt();
		System.out.print(A);
		do{
			int AN = A+(N-1)*D;
			S += AN;
			N = N + 1;
			System.out.print("+" + AN);
		}while(N<=freq);
		System.out.print("\n등차수열(공차:6) - 2부터"+ freq +"까지의 합: "+S);
	}
}
