package step01.exam04;

import java.util.Scanner;

/* System.in, System.out
 * System.out: 표준 출력장치(기본 모니터)
 * System.in: 표준 입력장치(키보드)
 * 
 * java.lang package
 * - Programming 핵심 클래스들이 있는 팩키지
 * - 팩키지 이름을 적지 않아도 된ㄴ다.
 * - 자동으로 찾는다.
 * - String, Integer, System..
 * - 나머지 모든 패키지의 클래스는 반드시 패키지의 이름을 적어야한다.
 * 
 * import
 * - 사용할 클래스가 있는 팩키지 이름을 컴파일러에게 알려줌
 * - import 패키지명.클래스 명;
 * - import로 선언된 패키지의 클래스는 팩키지명 없이 클래스 이름만으로 사용가능
 * - import 패키지명. *;
 *   패키지명만 선언해도 된다. 단 자바 컴파일러가 해당 클래스를 찾는데 시간이 걸린다.
 *   유지 패키지명만 선언되어 있으면 나중에 사용한 클래스가 어떤 팩키지에 있는지 즉시 파악할 수 없다.
 */

public class StudentMgtSystem {

	public static void main(String[] args) {
	  System.out.print("명령>");
	  
	  //java.util.Scanner scanner = new java.util.Scanner(System.in);
    Scanner scanner = new Scanner(System.in);    
    String input = scanner.nextLine(); // 키보드로 들어온 값을 익는다 엔터를 만날떄까지..
    System.out.println("==>" + input);
	}

}
