package EIPcertificatepreparation.math;

import java.util.Scanner;

public class math05 {

	public static void main(String[] args) {
		System.out.println("< 소인수 분해 >");
		System.out.print("가장 큰 수 입력:");
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int A[] = new int [20];
		if (N < 2){
			System.out.println("입력오류");
		}
		int T = 0;

		while( N != 1){
			int P = 2;
			while(N % P !=0){
				P++;
			}
			T++;
			A[T] = P;
			N = N/P;
		}

		if(T == 1){
			System.out.println("소수");		 
		}else{
			for(int J=1; J<=T-1; J++){
				System.out.print(A[J]+"*");
			}
			System.out.println(A[T]);
		}
	}
}
