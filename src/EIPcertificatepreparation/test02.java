package EIPcertificatepreparation;
import java.util.Scanner;

public class test02{
    
	public static void main(String[] args) {
    int a=2, d=6, s=0;
    System.out.print("<< 등차 수열 프로그램 >>");
	Scanner scan = new Scanner(System.in);
	System.out.print("더할 마지막 순번 : ");
	int freq = scan.nextInt();
	for(int n=1; n<=freq; n++){
		int an = a+(n-1)*d;
		s += an;
		if(n!=freq){
		System.out.print(an + "+");
		}else{
			System.out.print(an);
		}
	}
	System.out.print("\n등차수열(공차:6) - 2부터"+ freq +"까지의 합: "+s);
	}
}
