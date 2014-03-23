package EIPcertificatepreparation.math;

import java.util.Scanner;

public class math02 {

	public static void main(String[] args) {
		System.out.println("< 최대값과 최소값 >");
		int M =0 , num = 10;
		int[] ENG = { 80, 81, 32, 100, 32, 78, 65 , 100 , 90 , 100 };
		int[] MATH = { 85, 83, 55, 88, 25, 95, 89 , 75 , 92 , 95 };
		int CNT = 0, i = 0;
		System.out.printf("\nMATH = {"); 
		do{
			if(ENG[i] == 100){
				if(MATH[i] > M)
					M = MATH[i];
			}
			if(i == num -1)
				System.out.printf("%d }",MATH[i]);
			else
				System.out.printf("%d, ",MATH[i]);
			i = i +1;
		}while(i < num);
		System.out.println("\n* 학생의 최고 수학 점수 = " + M);
	}
}
