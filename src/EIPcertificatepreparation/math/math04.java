package EIPcertificatepreparation.math;

import java.util.Scanner;

public class math04 {

	public static void main(String[] args) {
		System.out.println("< 소수 판별 >");
		System.out.print("가장 큰 수 입력:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int P = 2,  N = 3;
		do{
			int M = (int) Math.sqrt(N); //어떤 수의 제곱근보다 소수가 클수는 없음
			for(int i=2; i<M+1; i++){
				int R = N % i;
				if(R == 0){ //나누어 떨어질 경우
					break;
				 }
				if(i == M)
					P = N;
			}
			N++;
		}while(N <= num);
		System.out.printf("\n* 2 ~ %d 중 가장 큰 소수 :  %d", num, P);
	}
}
