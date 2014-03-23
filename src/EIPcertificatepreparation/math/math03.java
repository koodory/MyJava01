package EIPcertificatepreparation.math;

import java.util.Scanner;

public class math03 {

	public static void main(String[] args) {
		System.out.println("< 합계와 평균 >");
		int N = 0, Sum = 0, i = 0;
		int[] T = { 60, 650, 132, 100, 322, 738, 65 , 200 , 350 , 100,
				        60, 78, 83, 280, 32, 38, 65 , 20 , 383 , 120,
				        60, 10, 132, 110, 322, 73, 55 , 120 , 208 , 30};
		do{
			if(T[i] > 200){
				Sum += T[i];
				N++;
			}
			i++;
		}while(i < 30);
		float Avg = Sum/N;
		int min = (int) Math.floor(Avg/60);
		System.out.printf("\n* 200초 이상 평균 통화시간(초) : %d 분 %.1f 초 ", min, 
				(Avg/60 - min)*60);
	}
}
