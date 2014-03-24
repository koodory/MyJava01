package step01.exam04.step03;

/* StudentScore 클래스의 개선
 * - 콤마(,)를 포함하는 문자열로부터 StudentScore 인스턴스를 생성하기
 * - static 메서드(클래스 메서드)를 활용법 소개 
 */
import java.util.Scanner;
public class StudentMgtSystem { 
	
	static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand(){
		System.out.print("명령>");
		String input = scanner.nextLine(); // 키보드로 들어온 값을 익는다 엔터를 만날떄까지..
	
		return input.split(" ");
	}
	
	private static void excuteAdd(String value) {
	  String input;

	  StudentScore score = StudentScore.fromCSV(value);
	  
	  System.out.println("이름 : " + score.name);
	  System.out.println("국어 : " + score.kor);
	  System.out.println("영어 : " + score.eng);
	  System.out.println("수학 : " + score.math);
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
