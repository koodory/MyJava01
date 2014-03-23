package EIPcertificatepreparation;
import java.util.Scanner;


public class test01 {
    
	public static void main(String[] args) {
	int n, sum=0;
	System.out.print("<< 기본 수열 프로그램 >>");
	Scanner scan = new Scanner(System.in);
	System.out.print("더할 마지만 순번 : ");
	int freq = scan.nextInt();
	for(n=1; n<=freq; n++){
		sum += n;
	}
		System.out.println("1부터"+freq+ "까지의 합: "+sum);
	}
}
