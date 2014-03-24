package step01.exam04.step02;

/* Entity 클래스 분리
 * - 데이터의 정보를 다루는 명령어를 분리
 * - 데이터를 표현하는 객체 : Value Object = Data Transfer Object
 * - 데이터의 지속성을 다루는 객체 : Data Access Object
 * - 데이터 지속성(Data Persistence)
 *  =>  애플리케이션을 종료했다 다시 시작해도 기존에 작업한 데이터는 그대로 유지
 *  => 외부 저장장치에 보관해야 한다. => File
 * - 
 */

import java.util.Scanner;체
public class StudentMgtSystem { 
	
	static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand(){
		System.out.print("명령>");
		String input = scanner.nextLine(); // 키보드로 들어온 값을 익는다 엔터를 만날떄까지..
	
		return input.split(" ");
	}
	
	private static void excuteAdd(String value) {
	  String input;
	  String[] data = value.split(",");
	  System.out.println("이름 : " + data[0]);
	  System.out.println("국어 : " + data[1]);
	  System.out.println("영어 : " + data[2]);
	  System.out.println("수학 : " + data[3]);
	  System.out.print("등록하시겠습니까?(y/n)");
	  input = scanner.nextLine();
	  if("y".equals(input.toLowerCase())){
	  	System.out.println("등록되었습니다.");
	  }else{
	  	System.out.println("등록 취소되었습니다.");
	  }
  }
	
	public static void main(String[] args) {
		String input = null; //로컬 변수는 항상 null로 초기화 한다.
		
		do{
			String[] values = promptCommand();
			
			if("add".equals(values[0])){ 
				excuteAdd(values[1]);
			}else if("quit".equals(values[0])){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}while(true);
		scanner.close();
	}
}
