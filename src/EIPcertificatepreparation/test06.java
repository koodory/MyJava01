package EIPcertificatepreparation;
import java.util.Scanner;

public class test06{
	public static void main(String[] args) {
		int a=0, s = 0,  b = 0 , c = 0;
		System.out.print("<< 제곱의 합 >>");
		System.out.print("\n마지막 항 : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		do{
      ++a;
			b = 101 - a;
			c = a * b;
			c *= c;
			s += c;
		}while(a < num);
		System.out.println(num+"까지의 제곱의 합 = "+s);

	}
}

