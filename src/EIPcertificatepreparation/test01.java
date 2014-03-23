package EIPcertificatepreparation;
import java.util.Scanner;


public class test01 {
    
	public static void main(String[] args) {
	int SUM =0 , N = 1;
	System.out.print("<< 기본 수열 프로그램 >>\n");
	Scanner scan = new Scanner(System.in);
	System.out.print("더할 마지만 순번 : ");
	int freq = scan.nextInt();
	do{
		SUM = SUM + N;
		N = N + 1;
	}while(N <= freq);
		System.out.println("1부터"+freq+ "까지의 합: "+ SUM);
	}
}
