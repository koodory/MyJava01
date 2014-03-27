package test_prep.step02;

import java.util.Scanner;

public class StudentMgtSystem02 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand(){		
		System.out.print("명령>");
		String input = scanner.nextLine();

		return input.split(" ");
	}
	
	private static void executeAdd(String value) {
	  String input;
	  String[] data = value.split(",");

	  System.out.println("이름 : " + data[0]);
	  System.out.println("국어 : " + data[1]);
	  System.out.println("영어 : " + data[2]);
	  System.out.println("수학 : " + data[3]);

	  System.out.println("등록하시겠습니까?(y/n) : ");
	  input = scanner.nextLine();
	  if("y".equals(input.toLowerCase())){
	  	System.out.println("등록되었습니다.");
	  }else{
	  	System.out.println("등록이 취소되었습니다.");
	  }
  }
	
	public static void main(String[] args) {
		do{
			String[] values = promptCommand();
			if("add".equals(values[0])){
				executeAdd(values[1]);
			}else if("q".equals(values[0])){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("해당 명령어를 찾을 수 없습니다.");
			}
		}while(true);
		scanner.close();
	}

}
