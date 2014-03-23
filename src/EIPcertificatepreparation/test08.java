package EIPcertificatepreparation;
import java.util.Scanner;

public class test08{
	public static void main(String[] args) {
		int N = 0 , S = 0;
		System.out.print("<< '+,-' 교행 자연수 수열 >>");
		System.out.print("\n마지막 항 : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		do{
			N = N + 1;
			if(N % 2 == 1)
				S = S + N;
			else
				S = S - N;
		}while( N != num);
		System.out.println(num+"까지의 교행 자연수의 합 = "+ S);
	}
}

