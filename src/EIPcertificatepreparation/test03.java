package EIPcertificatepreparation;
import java.util.Scanner;

public class test03{
    
	public static void main(String[] args) {
    int A=2, R=3, S=2;
    System.out.print("<< 등비 수열 프로그램 >>");
	Scanner scan = new Scanner(System.in);
	System.out.print("더할 마지막 순번 : ");
	int freq = scan.nextInt();
	System.out.print(S);
	for(int n=2; n<=freq; n++){	
		A = A*R;
		S += A;
		System.out.print("+" + A);
	}
	System.out.print("\n등비수열(공비:3) - 2부터"+ freq +"까지의 합: "+S);
	}
}
