package EIPcertificatepreparation;
import java.util.Scanner;

public class test07{
	public static void main(String[] args) {
		int K = 0, SW = 0;
		float S = 0;
		System.out.print("<< '+,-' 교행 분수 수열 >>");
		System.out.print("\n마지막 항 : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		do{
			K = K + 1;
			float L = (float)K /(K+1) * (K+2);
			if(SW == 0){				
				S = S + L;
				SW = 1;
			}
			else{
				S = S - L;
				SW = 0;
			}
		}while( K != num);
		System.out.printf("\n%d까지의 교행 분수 수열 =  %.3f",num,S);
	}
}

