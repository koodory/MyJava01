package EIPcertificatepreparation.math;

import java.util.Scanner;

public class math01 {

	public static void main(String[] args) {
		System.out.println("< Count 알고리즘 >");
		int num = 10;
		int[] JUMSU = { 80, 81, 32, 100, 5, 78, 65 , 10 , 90 , 72 };
		int CNT = 0, i = 0;
		System.out.printf("\n JUMSU = {"); 
		do{
			if(JUMSU[i] >= 80){
				CNT = CNT + 1;
			}
			if(i == num -1)
				System.out.printf("%d }",JUMSU[i]);
			else
				System.out.printf("%d, ",JUMSU[i]);
			i = i +1;
		}while(i < num);
		System.out.println("\n80점 이상인 학생의 수 = " + CNT);
	}
}
