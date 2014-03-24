package step01.exam04.step01;

import java.util.Scanner;

/* 메서드 분리2
 * - add, view, update, delete를 처리하는 명령어들을 분리하여 메서드로 정의
 */


public class StudentMgtSystem03 { 
	
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
