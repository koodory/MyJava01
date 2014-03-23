package EIPcertificatepreparation;
import java.util.Scanner;

public class test05{
    
	public static void main(String[] args) {
    int F=1, S=0;
    System.out.print("<< Factorial 곱 구하기 >>");
	Scanner scan = new Scanner(System.in);
	System.out.print("\n마지막 항 : ");
	int freq = scan.nextInt();

	for(int N=1; N<=freq; N++){	
		F = F * N;
		S += F;
		if(N > 1)
		 System.out.print("+" + F);
		else 
		  System.out.print(F);	
	}
	System.out.print("\n1!부터"+ freq +"!까지의 합: "+S);
	}
}
